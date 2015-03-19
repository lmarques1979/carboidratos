package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ItensControleGlicemicoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ItensControleGlicemico.list(params), model:[itensControleGlicemicoInstanceCount: ItensControleGlicemico.count()]
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

        if (itensControleGlicemicoInstance.hasErrors()) {
            respond itensControleGlicemicoInstance.errors, view:'create'
            return
        }

        itensControleGlicemicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itensControleGlicemico.label', default: 'ItensControleGlicemico'), itensControleGlicemicoInstance.id])
                redirect itensControleGlicemicoInstance
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

        itensControleGlicemicoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ItensControleGlicemico.label', default: 'ItensControleGlicemico'), itensControleGlicemicoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
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
