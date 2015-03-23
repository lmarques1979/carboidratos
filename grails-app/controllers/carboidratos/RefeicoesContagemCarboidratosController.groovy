package carboidratos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RefeicoesContagemCarboidratosController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RefeicoesContagemCarboidratos.list(params), model:[refeicoesContagemCarboidratosInstanceCount: RefeicoesContagemCarboidratos.count()]
    }

    def show(RefeicoesContagemCarboidratos refeicoesContagemCarboidratosInstance) {
        respond refeicoesContagemCarboidratosInstance
    }

    def create() {
        respond new RefeicoesContagemCarboidratos(params)
    }

    @Transactional
    def save(RefeicoesContagemCarboidratos refeicoesContagemCarboidratosInstance) {
        if (refeicoesContagemCarboidratosInstance == null) {
            notFound()
            return
        }

        if (refeicoesContagemCarboidratosInstance.hasErrors()) {
            respond refeicoesContagemCarboidratosInstance.errors, view:'create'
            return
        }

        refeicoesContagemCarboidratosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'refeicoesContagemCarboidratos.label', default: 'RefeicoesContagemCarboidratos'), refeicoesContagemCarboidratosInstance.id])
                redirect refeicoesContagemCarboidratosInstance
            }
            '*' { respond refeicoesContagemCarboidratosInstance, [status: CREATED] }
        }
    }

    def edit(RefeicoesContagemCarboidratos refeicoesContagemCarboidratosInstance) {
        respond refeicoesContagemCarboidratosInstance
    }

    @Transactional
    def update(RefeicoesContagemCarboidratos refeicoesContagemCarboidratosInstance) {
        if (refeicoesContagemCarboidratosInstance == null) {
            notFound()
            return
        }

        if (refeicoesContagemCarboidratosInstance.hasErrors()) {
            respond refeicoesContagemCarboidratosInstance.errors, view:'edit'
            return
        }

        refeicoesContagemCarboidratosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RefeicoesContagemCarboidratos.label', default: 'RefeicoesContagemCarboidratos'), refeicoesContagemCarboidratosInstance.id])
                redirect refeicoesContagemCarboidratosInstance
            }
            '*'{ respond refeicoesContagemCarboidratosInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RefeicoesContagemCarboidratos refeicoesContagemCarboidratosInstance) {

        if (refeicoesContagemCarboidratosInstance == null) {
            notFound()
            return
        }

        refeicoesContagemCarboidratosInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RefeicoesContagemCarboidratos.label', default: 'RefeicoesContagemCarboidratos'), refeicoesContagemCarboidratosInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'refeicoesContagemCarboidratos.label', default: 'RefeicoesContagemCarboidratos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
