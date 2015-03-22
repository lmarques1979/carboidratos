package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ItensContagemCarboidratosController extends BaseController{

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
		
		def resultado = ItensContagemCarboidratos.createCriteria().list() {
			createAlias("contagemcarboidratos", "contagemcarboidratos")
			createAlias("contagemcarboidratos.refeicao", "refeicao")
			eq("contagemcarboidratos.mes" , mes)
			eq("contagemcarboidratos.ano" ,ano)
			eq("contagemcarboidratos.usuario" ,usuarioLogado)
			order("contagemcarboidratos.dia", "asc")
			order("contagemcarboidratos.mes", "asc")
			order("contagemcarboidratos.ano", "asc")
			order("refeicao.ordemrefeicao", "asc")
			
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

        if (itensContagemCarboidratosInstance.hasErrors()) {
            respond itensContagemCarboidratosInstance.errors, view:'create'
            return
        }

        itensContagemCarboidratosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itensContagemCarboidratos.label', default: 'ItensContagemCarboidratos'), itensContagemCarboidratosInstance.id])
                redirect itensContagemCarboidratosInstance
            }
            '*' { respond itensContagemCarboidratosInstance, [status: CREATED] }
        }
    }

    def edit(ItensContagemCarboidratos itensContagemCarboidratosInstance) {
        respond itensContagemCarboidratosInstance
    }

    @Transactional
    def update(ItensContagemCarboidratos itensContagemCarboidratosInstance) {
        if (itensContagemCarboidratosInstance == null) {
            notFound()
            return
        }

        if (itensContagemCarboidratosInstance.hasErrors()) {
            respond itensContagemCarboidratosInstance.errors, view:'edit'
            return
        }

        itensContagemCarboidratosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ItensContagemCarboidratos.label', default: 'ItensContagemCarboidratos'), itensContagemCarboidratosInstance.id])
                redirect itensContagemCarboidratosInstance
            }
            '*'{ respond itensContagemCarboidratosInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ItensContagemCarboidratos itensContagemCarboidratosInstance) {

        if (itensContagemCarboidratosInstance == null) {
            notFound()
            return
        }

        itensContagemCarboidratosInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ItensContagemCarboidratos.label', default: 'ItensContagemCarboidratos'), itensContagemCarboidratosInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
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
