package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class RefeicoesContagemCarboidratosController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "GET"]

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

		def erros=[]
		def ContagemCarboidratosInstance=refeicoesContagemCarboidratosInstance.contagemcarboidratos
		
		refeicoesContagemCarboidratosInstance.delete flush:true
		
		if (refeicoesContagemCarboidratosInstance.hasErrors()) {
			refeicoesContagemCarboidratosInstance.errors.allErrors.each {
					erros.add(it)
			}
			flash.error=erros
			redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ]
			return
		}else{
		
				def resultado2 = RefeicoesContagemCarboidratos.findAllByContagemcarboidratos(ContagemCarboidratosInstance)
				if(resultado2.size()==0){
					
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
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label'), refeicoesContagemCarboidratosInstance.id])
				redirect (controller: "itensContagemCarboidratos" , action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ])
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
