package carboidratos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContagemCarboidratosController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ContagemCarboidratos.list(params), model:[contagemCarboidratosInstanceCount: ContagemCarboidratos.count()]
    }

    def show(ContagemCarboidratos contagemCarboidratosInstance) {
        respond contagemCarboidratosInstance
    }

    def create() {
        respond new ContagemCarboidratos(params)
    }

    @Transactional
    def save(ContagemCarboidratos contagemCarboidratosInstance) {
        if (contagemCarboidratosInstance == null) {
            notFound()
            return
        }

        if (contagemCarboidratosInstance.hasErrors()) {
            respond contagemCarboidratosInstance.errors, view:'create'
            return
        }

        contagemCarboidratosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contagemCarboidratos.label', default: 'ContagemCarboidratos'), contagemCarboidratosInstance.id])
                redirect contagemCarboidratosInstance
            }
            '*' { respond contagemCarboidratosInstance, [status: CREATED] }
        }
    }

    def edit(ContagemCarboidratos contagemCarboidratosInstance) {
        respond contagemCarboidratosInstance
    }

    @Transactional
    def update(ContagemCarboidratos contagemCarboidratosInstance) {
        if (contagemCarboidratosInstance == null) {
            notFound()
            return
        }

        if (contagemCarboidratosInstance.hasErrors()) {
            respond contagemCarboidratosInstance.errors, view:'edit'
            return
        }

        contagemCarboidratosInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ContagemCarboidratos.label', default: 'ContagemCarboidratos'), contagemCarboidratosInstance.id])
                redirect contagemCarboidratosInstance
            }
            '*'{ respond contagemCarboidratosInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ContagemCarboidratos contagemCarboidratosInstance) {

        if (contagemCarboidratosInstance == null) {
            notFound()
            return
        }

        contagemCarboidratosInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ContagemCarboidratos.label', default: 'ContagemCarboidratos'), contagemCarboidratosInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contagemCarboidratos.label', default: 'ContagemCarboidratos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
