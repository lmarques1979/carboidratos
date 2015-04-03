package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class RefeicaoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		
        configuracaoParams
		
		def resultado = Refeicao.createCriteria().list(params) {
			eq("usuario" , usuarioLogado)
		}
		
        respond resultado, model:[refeicaoInstanceCount: resultado.totalCount]
    }

    def show(Refeicao refeicaoInstance) {
        respond refeicaoInstance
    }

    def create() {
        respond new Refeicao(params)
    }

    @Transactional
    def save(Refeicao refeicaoInstance) {
        if (refeicaoInstance == null) {
            notFound()
            return
        }
		
		refeicaoInstance.usuario=usuarioLogado		
		
		refeicaoInstance.save flush:true	

		if (refeicaoInstance.hasErrors()) {
			respond refeicaoInstance.errors, view:'create'
			return
		}
		
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'refeicao.label', default: 'Refeicao'), refeicaoInstance.id])
                redirect(action: "create")
            }
            '*' { respond refeicaoInstance, [status: CREATED] }
        }
    }

    def edit(Refeicao refeicaoInstance) {
        respond refeicaoInstance
    }

    @Transactional
    def update(Refeicao refeicaoInstance) {
        if (refeicaoInstance == null) {
            notFound()
            return
        }

        if (refeicaoInstance.hasErrors()) {
            respond refeicaoInstance.errors, view:'edit'
            return
        }

        refeicaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Refeicao.label', default: 'Refeicao'), refeicaoInstance.id])
                redirect refeicaoInstance
            }
            '*'{ respond refeicaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Refeicao refeicaoInstance) {

        if (refeicaoInstance == null) {
            notFound()
            return
        }

        refeicaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Refeicao.label', default: 'Refeicao'), refeicaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'refeicao.label', default: 'Refeicao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
