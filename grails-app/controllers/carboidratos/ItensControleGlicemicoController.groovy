package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ItensControleGlicemicoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "GET"]

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
			order("controleglicemico.mes", "asc")
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
			controleGlicemicoInstance.observacao=params.observacao
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
		
		itensControleGlicemicoInstance.save flush:true

		if (itensControleGlicemicoInstance.hasErrors()) {
			respond itensControleGlicemicoInstance.errors, view:'index'
			return
		}
		
		request.withFormat {
			form multipartForm {
			flash.message = message(code: 'default.created.message', args: [message(code: 'controleGlicemico.label', default: 'ControleGlicemico'), controleGlicemicoInstance.id])
			redirect action:"index", params:[mes: controleGlicemicoInstance.mes,ano:controleGlicemicoInstance.ano ]
			}
			'*' { respond itensControleGlicemicoInstance, [status: CREATED] }
		}
    }

    def edit(ItensControleGlicemico itensControleGlicemicoInstance) {
        respond itensControleGlicemicoInstance
    }

    @Transactional
    def update(ItensControleGlicemico itensControleGlicemicoInstance) {
        if (itensControleGlicemicoInstance == null) {
            notFound()
            return
        }

        if (itensControleGlicemicoInstance.hasErrors()) {
            respond itensControleGlicemicoInstance.errors, view:'edit'
            return
        }

        itensControleGlicemicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ItensControleGlicemico.label', default: 'ItensControleGlicemico'), itensControleGlicemicoInstance.id])
                redirect itensControleGlicemicoInstance
            }
            '*'{ respond itensControleGlicemicoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ItensControleGlicemico itensControleGlicemicoInstance) {

        if (itensControleGlicemicoInstance == null) {
            notFound()
            return
        }

		def mes = itensControleGlicemicoInstance.controleglicemico.mes
		def ano = itensControleGlicemicoInstance.controleglicemico.ano
		
        itensControleGlicemicoInstance.delete flush:true

       	flash.message = message(code: 'default.deleted.message', args: [message(code: 'ItensControleGlicemico.label', default: 'ItensControleGlicemico'), itensControleGlicemicoInstance.id])
        redirect action:"index", params:[mes:mes,ano:ano ]
         
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
