package carboidratos

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
@Transactional(readOnly = true)
class ConfiguracaoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured("isAuthenticated() or authentication.name=='admin'")
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def resultado = Configuracao.createCriteria().list() {
			eq("usuario" ,usuarioLogado)
		}
		
        respond resultado, model:[configuracaoInstanceCount: resultado.size]
    }

    def show(Configuracao configuracaoInstance) {
        respond configuracaoInstance
    }

    def create() {
        respond new Configuracao(params)
    }

    @Transactional
    def save(Configuracao configuracaoInstance) {
        if (configuracaoInstance == null) {
            notFound()
            return
        }
		
		configuracaoInstance.usuario=usuarioLogado
		
		configuracaoInstance.save flush:true
		
		if (configuracaoInstance.hasErrors()) {
			respond configuracaoInstance.errors, view:'create'
			return
		}
	    
		request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'configuracao.label', default: 'Configuracao'), configuracaoInstance.id])
                redirect configuracaoInstance
            }
            '*' { respond configuracaoInstance, [status: CREATED] }
        }
    }

    def edit(Configuracao configuracaoInstance) {
        respond configuracaoInstance
    }

    @Transactional
    def update(Configuracao configuracaoInstance) {
        if (configuracaoInstance == null) {
            notFound()
            return
        }

        if (configuracaoInstance.hasErrors()) {
            respond configuracaoInstance.errors, view:'edit'
            return
        }

        configuracaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Configuracao.label', default: 'Configuracao'), configuracaoInstance.id])
                redirect configuracaoInstance
            }
            '*'{ respond configuracaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Configuracao configuracaoInstance) {

        if (configuracaoInstance == null) {
            notFound()
            return
        }

        configuracaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Configuracao.label', default: 'Configuracao'), configuracaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'configuracao.label', default: 'Configuracao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
