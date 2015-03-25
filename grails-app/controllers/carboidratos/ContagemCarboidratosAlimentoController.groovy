package carboidratos

import org.hibernate.criterion.CriteriaSpecification

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ContagemCarboidratosAlimentoController extends BaseController{

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
		
		def resultado = ContagemCarboidratosAlimento.createCriteria().list() {
			createAlias("contagemcarboidratos", "contagemcarboidratos")
			createAlias("contagemcarboidratos.refeicao", "refeicao")
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
		
		/*def agrupamento = ItensContagemCarboidratos.executeQuery("select sum(i.qtdalimento*a.carboidratosg), "+
																 "c.mes ,"+
																"c.ano, "+
																"c.usuario.id, "+
																"rc.refeicao.id "+
																"from ItensContagemCarboidratos i , "+
																"Alimento a, "+
																"RefeicoesContagemCarboidratos rc, "+
																"ContagemCarboidratos c "+
																"where i.refeicoescontagemcarboidratos=rc.id and "+
																"i.alimento=a.id and " +
																"rc.contagemcarboidratos=c.id and "+
																"c.mes=:mes " +
																"and c.ano=:ano and "+
																"c.usuario=:usuario " +
																"group by c.mes , c.ano, c.usuario,rc.refeicao",[mes:mes,ano:ano,usuario:usuarioLogado])*/
		
		respond resultado, model:[ContagemCarboidratosAlimentoInstanceCount: resultado.size , mes:mes , ano:ano]
		
    }

    def show(ContagemCarboidratosAlimento contagemCarboidratosAlimentoInstance) {
        respond contagemCarboidratosAlimentoInstance
    }

    def create() {
        respond new ContagemCarboidratosAlimento(params)
    }

    @Transactional
    def save(ContagemCarboidratosAlimento contagemCarboidratosAlimentoInstance) {
        
		if (contagemCarboidratosAlimentoInstance == null) {
            notFound()
            return
        }

		def ContagemCarboidratosInstance
		def erros=[]
		def resultado= ContagemCarboidratos.executeQuery("select c.id from ContagemCarboidratos as c where c.dia=:dia and c.mes=:mes and c.ano=:ano and c.usuario=:usuario and refeicao=:refeicao", [dia: params.int('dia') , mes: params.int('mes') , ano: params.int('ano') , usuario:usuarioLogado , refeicao:Refeicao.get(params.int('refeicao.id'))])
		
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
				ContagemCarboidratosInstance.refeicao=Refeicao.get(params.int('refeicao.id'))
			
				ContagemCarboidratosInstance.save flush:true
				
				if (ContagemCarboidratosInstance.hasErrors()) {
					respond ContagemCarboidratosInstance.errors, view:'index'
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
		
		contagemCarboidratosAlimentoInstance.contagemcarboidratos=ContagemCarboidratosInstance
		contagemCarboidratosAlimentoInstance.qtdalimento=params.int('qtdalimento')
		contagemCarboidratosAlimentoInstance.qtdcarboidrato=params.int('qtdcarboidrato')
		contagemCarboidratosAlimentoInstance.alimentoforalista=params.alimentoforalista
		contagemCarboidratosAlimentoInstance.alimento=alimento
		
		contagemCarboidratosAlimentoInstance.save flush:true
		
		if (contagemCarboidratosAlimentoInstance.hasErrors()) {
			contagemCarboidratosAlimentoInstance.errors.allErrors.each {
					erros.add(it)  
			}
			flash.error=erros 
		}   
		redirect action:"index", params:[refeicaoid: params.int('refeicao.id'), mes:params.int('mes'),ano:params.int('ano') ]
		
    }

    def edit(ContagemCarboidratosAlimento contagemCarboidratosAlimentoInstance) {
        respond contagemCarboidratosAlimentoInstance
    }

    @Transactional
    def update() {
       
		def idcontagem=params.list('id')
		def erros = []
		
		for(int index=0 ; index < idcontagem.size() ; index++){
				
				def contagemCarboidratosAlimentoInstance
				def ContagemCarboidratosInstance
				def qtdalimento , qtdcarboidrato , alimentoforalista
				def alimentoid
				
				contagemCarboidratosAlimentoInstance=ContagemCarboidratosAlimento.get(idcontagem[index].toInteger())
				
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
				
				contagemCarboidratosAlimentoInstance.qtdalimento=qtdalimento
				contagemCarboidratosAlimentoInstance.qtdcarboidrato=qtdcarboidrato
				contagemCarboidratosAlimentoInstance.alimentoforalista=alimentoforalista
				contagemCarboidratosAlimentoInstance.alimento=Alimento.get(alimentoid)
								
				if (contagemCarboidratosAlimentoInstance.hasErrors()) {
					respond contagemCarboidratosAlimentoInstance.errors, view:'index'
					return
				}
				
		}
		
		flash.message = message(code: 'default.updated.message', args: [message(code: 'contagem.label', default: 'ControleGlicemico')])
		redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
    }

    @Transactional
    def delete(ContagemCarboidratosAlimento contagemCarboidratosAlimentoInstance) {

		def erros=[]
		def ContagemCarboidratosInstance=contagemCarboidratosAlimentoInstance.contagemcarboidratos
		
		contagemCarboidratosAlimentoInstance.delete flush:true
		
		if (contagemCarboidratosAlimentoInstance.hasErrors()) {
					contagemCarboidratosAlimentoInstance.errors.allErrors.each {
					erros.add(it)
			}
			flash.error=erros
			redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
			return
		}else{
				
			def resultado = ContagemCarboidratosAlimento.findAllByContagemcarboidratos(ContagemCarboidratosInstance)
			if(resultado.size()==0){
				
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
		flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label'), contagemCarboidratosAlimentoInstance.id])
		redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
