package carboidratos

import org.hibernate.criterion.CriteriaSpecification
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ItensContagemCarboidratosController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

    def index(Integer max) {
		
		Calendar cal = Calendar.getInstance()
		def mescorrente=cal.MONTH + 1
		def anocorrente=cal.get(Calendar.YEAR)
		def mes , ano
		
		if(params.mes!="" && params.mes!=null){
			mes = params.int('mes')
		}else{
			mes = mescorrente
		}
		if(params.ano!="" && params.ano!=null){
			ano = params.int('ano')
		}else{
			ano = anocorrente
		}
		
		def resultado = ItensContagemCarboidratos.createCriteria().list() {
			createAlias("refeicoescontagemcarboidratos", "refeicoescontagemcarboidratos")
			createAlias("refeicoescontagemcarboidratos.contagemcarboidratos", "contagemcarboidratos")
			createAlias("refeicoescontagemcarboidratos.refeicao", "refeicao")
			createAlias("alimento", "alimento",CriteriaSpecification.LEFT_JOIN)
			eq("contagemcarboidratos.mes" , mes)
			eq("contagemcarboidratos.ano" ,ano)
			eq("contagemcarboidratos.usuario" ,usuarioLogado)
			order("contagemcarboidratos.dia", "asc")
			order("contagemcarboidratos.mes", "asc")
			order("contagemcarboidratos.ano", "asc")
			order("refeicao.ordemrefeicao", "asc")
			order("alimento.nome" , "asc")
		}
		
		respond resultado, model:[ItensContagemCarboidratosInstanceCount: resultado.size , mes:mes , ano:ano]
    }

    def show(ItensContagemCarboidratos itensContagemCarboidratosInstance) {
        respond itensContagemCarboidratosInstance
    }

    def create() {
        respond new ItensContagemCarboidratos(params)
    }

    @Transactional
    def save(ItensContagemCarboidratos itensContagemCarboidratosInstance) {
		
        if (itensContagemCarboidratosInstance == null) {
            notFound()
            return
        }

		def ContagemCarboidratosInstance , RefeicoesContagemCarboidratosInstance
		def erros=[]
		def resultado= ContagemCarboidratos.executeQuery("select c.id from ContagemCarboidratos as c where c.dia=:dia and c.mes=:mes and c.ano=:ano and c.usuario=:usuario", [dia: params.int('dia') , mes: params.int('mes') , ano: params.int('ano') , usuario:usuarioLogado])
		
		if (resultado.size()>0){
			resultado.each{ it ->
				ContagemCarboidratosInstance=ContagemCarboidratos.get(it)
			}
		}else{
		
				ContagemCarboidratosInstance= new ContagemCarboidratos()
				
				ContagemCarboidratosInstance.dia=params.int('dia')
				ContagemCarboidratosInstance.mes=params.int('mes')
				ContagemCarboidratosInstance.ano=params.int('ano')
				ContagemCarboidratosInstance.usuario=usuarioLogado
			
				ContagemCarboidratosInstance.save flush:true
				
				if (ContagemCarboidratosInstance.hasErrors()) {
					respond ContagemCarboidratosInstance.errors, view:'index'
					return
				}
			}
		
			def resultado2= RefeicoesContagemCarboidratos.executeQuery("select rcc.id from RefeicoesContagemCarboidratos as rcc where rcc.contagemcarboidratos=:contagem and rcc.refeicao=:refeicao", [contagem:ContagemCarboidratosInstance, refeicao:Refeicao.get(params.int('refeicao.id'))])
			
			if (resultado2.size()>0){
				resultado2.each{ it ->
					RefeicoesContagemCarboidratosInstance=RefeicoesContagemCarboidratos.get(it)
				}
			}else{
					
					RefeicoesContagemCarboidratosInstance = new RefeicoesContagemCarboidratos()
					
					RefeicoesContagemCarboidratosInstance.refeicao=Refeicao.get(params.int('refeicao.id'))
					RefeicoesContagemCarboidratosInstance.contagemcarboidratos=ContagemCarboidratosInstance
					
					RefeicoesContagemCarboidratosInstance.save flush:true
					
					if (RefeicoesContagemCarboidratosInstance.hasErrors()) {
						respond RefeicoesContagemCarboidratosInstance.errors, view:'index'
						return
			}
		}

		def alimentoid=params.int('alimento.id')
		def alimento
		
		if(alimentoid==-1){
			alimento=null
		}else{
			alimento=Alimento.get(alimentoid)		
		}	
		
		itensContagemCarboidratosInstance.refeicoescontagemcarboidratos=RefeicoesContagemCarboidratosInstance
		itensContagemCarboidratosInstance.qtdalimento=params.int('qtdalimento')
		itensContagemCarboidratosInstance.qtdcarboidrato=params.int('qtdcarboidrato')
		itensContagemCarboidratosInstance.alimentoforalista=params.alimentoforalista
		itensContagemCarboidratosInstance.alimento=alimento
		
		itensContagemCarboidratosInstance.save flush:true
		
		if (itensContagemCarboidratosInstance.hasErrors()) {
			itensContagemCarboidratosInstance.errors.allErrors.each {
					erros.add(it)  
			}
			flash.error=erros 
			redirect action:"index", params:[refeicaoid: params.int('refeicao.id'), mes:params.int('mes'),ano:params.int('ano') ]
			return
		}
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itensContagemCarboidratos.label', default: 'ItensContagemCarboidratos'), itensContagemCarboidratosInstance.id])
                redirect action:"index", params:[refeicaoid: params.int('refeicao.id') , mes:params.int('mes'),ano:params.int('ano')]
            }
            '*' { respond itensContagemCarboidratosInstance, [status: CREATED] }
        }
    }

    def edit(ItensContagemCarboidratos itensContagemCarboidratosInstance) {
        respond itensContagemCarboidratosInstance
    }

    @Transactional
    def update() {
        
		def idcontagem=params.list('id')
		def erros = []
		
		for(int index=0 ; index < idcontagem.size() ; index++){
				
				def itensContagemCarboidratosInstance
				def ContagemCarboidratosInstance
				def RefeicoesContagemCarboidratosInstance
				def qtdalimento , qtdcarboidrato , alimentoforalista
				def alimentoid
				
				itensContagemCarboidratosInstance=ItensContagemCarboidratos.get(idcontagem[index].toInteger())
				
				if (idcontagem.size() > 1){
					qtdalimento 		= (params.qtdalimento[index] ? params.qtdalimento[index].toInteger() : null)
					qtdcarboidrato 		= (params.qtdcarboidrato[index] ? params.qtdcarboidrato[index].toInteger() : null)
					alimentoforalista 	= (params.alimentoforalista[index] ? params.alimentoforalista[index] : null)
					alimentoid 			= (params.alimento.id[index] ? params.alimento.id[index].toInteger() : null)
				}else{
					qtdalimento 		= (params.qtdalimento ? params.qtdalimento.toInteger() : null)
					qtdcarboidrato 		= (params.qtdcarboidrato ? params.qtdcarboidrato.toInteger() : null)
					alimentoforalista 	= (params.alimentoforalista ? params.alimentoforalista : null)
					alimentoid 			= params.alimento.id.toInteger() 
				}
				
				itensContagemCarboidratosInstance.qtdalimento=qtdalimento
				itensContagemCarboidratosInstance.qtdcarboidrato=qtdcarboidrato
				itensContagemCarboidratosInstance.alimentoforalista=alimentoforalista
				itensContagemCarboidratosInstance.alimento=Alimento.get(alimentoid)
				
				if (itensContagemCarboidratosInstance.hasErrors()) {
					respond itensContagemCarboidratosInstance.errors, view:'index'
					return
				}
				
		}
		
		flash.message = message(code: 'default.updated.message', args: [message(code: 'contagem.label', default: 'ControleGlicemico')])
		redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
    }

    @Transactional
    def delete(ItensContagemCarboidratos itensContagemCarboidratosInstance) {

        if (itensContagemCarboidratosInstance == null) {
            notFound()
            return
        }
		def erros=[]
		def RefeicoesContagemCarboidratosInstance=itensContagemCarboidratosInstance.refeicoescontagemcarboidratos
		
		itensContagemCarboidratosInstance.delete flush:true

		if (itensContagemCarboidratosInstance.hasErrors()) {
				itensContagemCarboidratosInstance.errors.allErrors.each {
						erros.add(it)  
				}
				flash.error=erros 
				redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
				return
		}else{
		
			def resultado = ItensContagemCarboidratos.findAllByRefeicoescontagemcarboidratos(RefeicoesContagemCarboidratosInstance)
			if(resultado.size()==0){
				
				def ContagemCarboidratosInstance=RefeicoesContagemCarboidratosInstance.contagemcarboidratos
				
				RefeicoesContagemCarboidratosInstance.delete flush:true
				
				if (RefeicoesContagemCarboidratosInstance.hasErrors()) {
					
						RefeicoesContagemCarboidratosInstance.errors.allErrors.each {
							erros.add(it)  
						}
						flash.error=erros 
						redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
						return
				}else{
				
					def resultado2 = RefeicoesContagemCarboidratos.findAllByContagemcarboidratos(ContagemCarboidratosInstance)
					if(resultado2.size()==0){
						
						ContagemCarboidratosInstance.delete flush:true
						
						if (ContagemCarboidratosInstance.hasErrors()) {
							
								ContagemCarboidratosInstance.errors.allErrors.each {
									erros.add(it)
								}
								flash.error=erros
								redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
								return
						}
					}
				}
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label'), itensContagemCarboidratosInstance.id])
			redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
		}
       
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itensContagemCarboidratos.label', default: 'ItensContagemCarboidratos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
