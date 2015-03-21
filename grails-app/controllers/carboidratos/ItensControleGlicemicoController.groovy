package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ItensControleGlicemicoController extends BaseController{

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
		
		def resultado = ItensControleGlicemico.createCriteria().list() {
			createAlias("controleglicemico", "controleglicemico")
			createAlias("refeicao", "refeicao")
			eq("controleglicemico.mes" , mes)
			eq("controleglicemico.ano" ,ano)
			eq("controleglicemico.usuario" ,usuarioLogado)
			order("controleglicemico.dia", "asc")
			order("controleglicemico.mes", "asc")
			order("controleglicemico.ano", "asc")
			order("refeicao.ordemrefeicao", "asc")
			
		}
		
		respond resultado, model:[ItensControleGlicemicoInstanceCount: resultado.size , mes:mes , ano:ano]
    }

    def show(ItensControleGlicemico itensControleGlicemicoInstance) {
        respond itensControleGlicemicoInstance
    }

    def create() {
        respond new ItensControleGlicemico(params)
    }

    @Transactional
    def save(ItensControleGlicemico itensControleGlicemicoInstance) {
		
		if (itensControleGlicemicoInstance == null) {
			notFound()
			return
		}
		
		def controleGlicemicoInstance
		
		def resultado= ControleGlicemico.executeQuery("select c.id from ControleGlicemico as c where c.dia=:dia and c.mes=:mes and c.ano=:ano and c.usuario=:usuario", [dia: params.int('dia') , mes: params.int('mes') , ano: params.int('ano') , usuario:usuarioLogado])
		
		if (resultado.size()>0){
			resultado.each{ it ->
				controleGlicemicoInstance=ControleGlicemico.get(it)
			}
		}else{
		
			controleGlicemicoInstance= new ControleGlicemico()
			
			controleGlicemicoInstance.dia=params.int('dia')
			controleGlicemicoInstance.mes=params.int('mes')
			controleGlicemicoInstance.ano=params.int('ano')
			controleGlicemicoInstance.usuario=usuarioLogado
			controleGlicemicoInstance.save flush:true
			if (controleGlicemicoInstance.hasErrors()) {
				respond controleGlicemicoInstance.errors, view:'index' 
				return
			}
		}
			
		itensControleGlicemicoInstance.controleglicemico=controleGlicemicoInstance
		itensControleGlicemicoInstance.qtdinsulinelenta=params.int('qtdinsulinelenta')
		itensControleGlicemicoInstance.valorglicemiapre=params.int('valorglicemiapre')
		itensControleGlicemicoInstance.qtdinsulinarapidapre=params.int('qtdinsulinarapidapre')
		itensControleGlicemicoInstance.qtdcarboidrato=params.int('qtdcarboidrato')
		itensControleGlicemicoInstance.valorglicemiapos=params.int('valorglicemiapos')
		itensControleGlicemicoInstance.qtdinsulinarapidapos=params.int('qtdinsulinarapidapos')
		itensControleGlicemicoInstance.refeicao=Refeicao.get(params.int('refeicao.id'))
		itensControleGlicemicoInstance.observacao=params.observacao
		itensControleGlicemicoInstance.save flush:true

		if (itensControleGlicemicoInstance.hasErrors()) {
			respond itensControleGlicemicoInstance.errors, view:'index'
			return
		}
		
		request.withFormat {
			form multipartForm {
			flash.message = message(code: 'default.created.message', args: [message(code: 'controleGlicemico.label', default: 'ControleGlicemico'), controleGlicemicoInstance.id])
			redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano')]
			}
			'*' { respond itensControleGlicemicoInstance, [status: CREATED] }
		}
    }

    def edit(ItensControleGlicemico itensControleGlicemicoInstance) {
        respond itensControleGlicemicoInstance
    }

    @Transactional
    def update() {
		
		def idcontrole=params.list('id')
		def diaanterior , diaatual , icontrole=0
		diaanterior=null
		def erros = []
		for(int index=0 ; index < idcontrole.size() ; index++){
				
				def itensControleGlicemicoInstance
				
				itensControleGlicemicoInstance = ItensControleGlicemico.get(idcontrole[index].toInteger())
				def qtdinsulinelenta , valorglicemiapre , qtdinsulinarapidapre
				def qtdcarboidrato, valorglicemiapos , qtdinsulinarapidapos , idrefeicao
				def diatela , obs 
				
				diaatual=itensControleGlicemicoInstance.controleglicemico.dia				
				if(diaanterior!=diaatual){
					if(params.list('dia').size()>1){
						diatela=params.dia[icontrole].toInteger()
						icontrole++
					}else{
						diatela=params.dia.toInteger()
					}
				}else{
					diatela=diaanterior
				}
				
				if (idcontrole.size() > 1){
					qtdinsulinelenta 		= (params.qtdinsulinelenta[index] ? params.qtdinsulinelenta[index].toInteger() : null)
					valorglicemiapre 		= (params.valorglicemiapre[index] ? params.valorglicemiapre[index].toInteger() : null)
					qtdinsulinarapidapre 	= (params.qtdinsulinarapidapre[index] ? params.qtdinsulinarapidapre[index].toInteger() : null)
					qtdcarboidrato 			= (params.qtdcarboidrato[index] ? params.qtdcarboidrato[index].toInteger() : null)
					valorglicemiapos 		= (params.valorglicemiapos[index] ? params.valorglicemiapos[index].toInteger() : null)
					qtdinsulinarapidapos 	= (params.qtdinsulinarapidapos[index] ? params.qtdinsulinarapidapos[index].toInteger() : null)
					idrefeicao				= params.refeicao.id[index].toInteger()	
					obs 					= params.observacao[index]	
				}else{
					qtdinsulinelenta 		= (params.qtdinsulinelenta ? params.qtdinsulinelenta.toInteger() : null)
					valorglicemiapre 		= (params.valorglicemiapre ? params.valorglicemiapre.toInteger() : null)
					qtdinsulinarapidapre 	= (params.qtdinsulinarapidapre ? params.qtdinsulinarapidapre.toInteger() : null)
					qtdcarboidrato 			= (params.qtdcarboidrato ? params.qtdcarboidrato.toInteger() : null)
					valorglicemiapos 		= (params.valorglicemiapos ? params.valorglicemiapos.toInteger() : null)
					qtdinsulinarapidapos 	= (params.qtdinsulinarapidapos ? params.qtdinsulinarapidapos.toInteger() : null)
					idrefeicao				= params.refeicao.id.toInteger()
					obs						= params.observacao
				}
				itensControleGlicemicoInstance.qtdinsulinelenta=qtdinsulinelenta
				itensControleGlicemicoInstance.valorglicemiapre=valorglicemiapre
				itensControleGlicemicoInstance.qtdinsulinarapidapre=qtdinsulinarapidapre
				itensControleGlicemicoInstance.qtdcarboidrato=qtdcarboidrato
				itensControleGlicemicoInstance.valorglicemiapos=valorglicemiapos
				itensControleGlicemicoInstance.qtdinsulinarapidapos=qtdinsulinarapidapos
				itensControleGlicemicoInstance.refeicao=Refeicao.get(idrefeicao)
				itensControleGlicemicoInstance.observacao=obs
				itensControleGlicemicoInstance.save flush:true
				
				if (itensControleGlicemicoInstance.hasErrors()) {
					respond itensControleGlicemicoInstance.errors, view:'index'
					return
				}
				
				diaanterior=diaatual
				def controleGlicemicoInstance = itensControleGlicemicoInstance.controleglicemico
				controleGlicemicoInstance.dia=diatela
			
				if (controleGlicemicoInstance.validate()) {
					controleGlicemicoInstance.save flush:true
					if (controleGlicemicoInstance.hasErrors()) {
						respond controleGlicemicoInstance.errors, view:'index'
						return
					}
				}
				else {
					
					controleGlicemicoInstance.errors.allErrors.each {
						erros.add(it)  
					}
					flash.error=erros 
					redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
					return
				}
				
		}
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'controleGlicemico.label', default: 'ControleGlicemico')])
		redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
	}

    @Transactional
    def delete(ItensControleGlicemico itensControleGlicemicoInstance) {

        if (itensControleGlicemicoInstance == null) {
            notFound()
            return
        }

		def id	= itensControleGlicemicoInstance.id
		def mes = itensControleGlicemicoInstance.controleglicemico.mes
		def ano = itensControleGlicemicoInstance.controleglicemico.ano
		
        itensControleGlicemicoInstance.delete flush:true
		if (itensControleGlicemicoInstance.hasErrors()) {
			respond itensControleGlicemicoInstance.errors, view:'index'
			return
		}else{
		
			def resultado = ItensControleGlicemico.findAllById(id)
			if(resultado.size()==0){
				def ControleGlicemicoInstance = itensControleGlicemicoInstance.controleglicemico
				ControleGlicemicoInstance.delete flush:true
				if (ControleGlicemicoInstance.hasErrors()) {
					respond ControleGlicemicoInstance.errors, view:'index'
					return
				}
				
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label'), itensControleGlicemicoInstance.id])
			redirect action:"index", params:[mes:mes,ano:ano ]
		}
		
                
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itensControleGlicemico.label', default: 'ItensControleGlicemico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
