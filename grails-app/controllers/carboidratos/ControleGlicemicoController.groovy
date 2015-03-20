package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import grails.orm.HibernateCriteriaBuilder
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ControleGlicemicoController extends BaseController{

    static allowedMethods = [save: "POST", update: "PUT" , delete: "GET"]

    def index(Integer max) {
      
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
		
		controleGlicemicoInstance.usuario=usuarioLogado
		controleGlicemicoInstance.save flush:true
		if (controleGlicemicoInstance.hasErrors()) {
				respond controleGlicemicoInstance.errors, view:'index'
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
		
		def mes = controleGlicemicoInstance.mes
		def ano = controleGlicemicoInstance.ano
        controleGlicemicoInstance.delete flush:true

       	flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label')])
        redirect (controller:"ItensControleGlicemico",action:"index", params:[mes:mes,ano:ano ])
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
