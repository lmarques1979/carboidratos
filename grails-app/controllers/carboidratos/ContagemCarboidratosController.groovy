package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ContagemCarboidratosController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "GET"]

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
		
		def erros=[]

        contagemCarboidratosInstance.delete flush:true
		
		if (contagemCarboidratosInstance.hasErrors()) {
			
				contagemCarboidratosInstance.errors.allErrors.each {
					erros.add(it)
				}
				flash.error=erros
				redirect (controller: "itensContagemCarboidratos" , action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ])
				return
		}
		
        flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label'), contagemCarboidratosInstance.id])
		redirect (controller: "itensContagemCarboidratos" , action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ])
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
