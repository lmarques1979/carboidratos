package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ControleGlicemicoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
		
		def resultado = ControleGlicemico.createCriteria().list() {
			eq("mes" , mes)
			eq("ano" ,ano)
			order("dia", "asc")
			order("mes", "asc")
			order("ano", "asc")
		}
		
		respond resultado, model:[controleGlicemicoInstanceCount: resultado.size , mes:mes , ano:ano]
    }

    def show(ControleGlicemico controleGlicemicoInstance) {
        respond controleGlicemicoInstance
    }

    def create() {
        respond new ControleGlicemico(params)
    }

    @Transactional
    def save(ControleGlicemico controleGlicemicoInstance) {
        if (controleGlicemicoInstance == null) {
            notFound()
            return
        }
		
		def resultado= ControleGlicemico.executeQuery("select c.id from ControleGlicemico as c where c.dia=:dia and c.mes=:mes and c.ano=:ano and c.usuario=:usuario", [dia: params.int('dia') , mes: params.int('mes') , ano: params.int('ano') , usuario:usuarioLogado])
		
		if (resultado.size()>0){
			resultado.each{ it ->
				controleGlicemicoInstance=ControleGlicemico.get(it)
			}
		}else{
		
			controleGlicemicoInstance.usuario=usuarioLogado
			controleGlicemicoInstance.save flush:true
			if (controleGlicemicoInstance.hasErrors()) {
				respond controleGlicemicoInstance.errors, view:'index'
				return
			}
		}
			
		def ItensControleGlicemicoInstance = new ItensControleGlicemico()
		
		ItensControleGlicemicoInstance.controleglicemico=controleGlicemicoInstance
		ItensControleGlicemicoInstance.qtdinsulinelenta=params.int('qtdinsulinelenta')
		ItensControleGlicemicoInstance.valorglicemiapre=params.int('valorglicemiapre')
		ItensControleGlicemicoInstance.qtdinsulinarapidapre=params.int('qtdinsulinarapidapre')
		ItensControleGlicemicoInstance.qtdcarboidrato=params.int('qtdcarboidrato')
		ItensControleGlicemicoInstance.valorglicemiapos=params.int('valorglicemiapos')
		ItensControleGlicemicoInstance.qtdinsulinarapidapos=params.int('qtdinsulinarapidapos')
		ItensControleGlicemicoInstance.refeicao=Refeicao.get(params.int('refeicao.id'))
		
		ItensControleGlicemicoInstance.save flush:true

		if (ItensControleGlicemicoInstance.hasErrors()) {
			respond ItensControleGlicemicoInstance.errors, view:'index'
			return
		}
		
        request.withFormat {
			form multipartForm {
			flash.message = message(code: 'default.created.message', args: [message(code: 'controleGlicemico.label', default: 'ControleGlicemico'), controleGlicemicoInstance.id])
			redirect action:"index", params:[mes: controleGlicemicoInstance.mes,ano:controleGlicemicoInstance.ano ]
			}
			'*' { respond controleGlicemicoInstance, [status: CREATED] }
		}
           
    }

    def edit(ControleGlicemico controleGlicemicoInstance) {
        respond controleGlicemicoInstance
    }

    @Transactional
    def update(ControleGlicemico controleGlicemicoInstance) {
        if (controleGlicemicoInstance == null) {
            notFound()
            return
        }

        if (controleGlicemicoInstance.hasErrors()) {
            respond controleGlicemicoInstance.errors, view:'edit'
            return
        }

        controleGlicemicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ControleGlicemico.label', default: 'ControleGlicemico'), controleGlicemicoInstance.id])
                redirect controleGlicemicoInstance
            }
            '*'{ respond controleGlicemicoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ControleGlicemico controleGlicemicoInstance) {

        if (controleGlicemicoInstance == null) {
            notFound()
            return
        }

        controleGlicemicoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ControleGlicemico.label', default: 'ControleGlicemico'), controleGlicemicoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'controleGlicemico.label', default: 'ControleGlicemico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
