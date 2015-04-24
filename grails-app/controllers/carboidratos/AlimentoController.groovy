package carboidratos

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("isFullyAuthenticated()")
class AlimentoController extends BaseController {

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	def FileUploadService
	
	@Secured('permitAll')
    def index(Integer max) {
		
		def config
		if (usuarioLogado){
			configuracaoParams
		}else{
		    params.max = Math.min(max ?: 50, 100)
		}
		
		def filtro=params.nome
		def resultado = Alimento.createCriteria().list(params) {
			if(filtro!="" && filtro!=null){
				ilike("nome" , '%'+filtro+'%')
			}
		}
        respond resultado, model:[alimentoInstanceCount: resultado.totalCount]
    }

    def show(Alimento alimentoInstance) {
		configuracaoParams
        respond alimentoInstance
    }

    def create() {
        respond new Alimento(params)
    }

    @Transactional
    def save(Alimento alimentoInstance) {
        if (alimentoInstance == null) {
            notFound()
            return
        }
		
		def f = request.getFile('arquivo')
		
		if (!f.empty) {
			def midia = FileUploadService.fileUpload(f , 'carboidratoslmdcm' , 'assets/')
			alimentoInstance.imagem = midia
		}
		
        if (alimentoInstance.hasErrors()) {
			respond alimentoInstance.errors, view:'create'
			return
		}
		
        alimentoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'alimento.label', default: 'Alimento'), alimentoInstance.id])
                redirect alimentoInstance
            }
            '*' { respond alimentoInstance, [status: CREATED] }
        }
    }

    def edit(Alimento alimentoInstance) {
        respond alimentoInstance
    }

    @Transactional
    def update(Alimento alimentoInstance) {
        if (alimentoInstance == null) {
            notFound()
            return
        }

		def f = request.getFile('arquivo')
		
		if (!f.empty) {
			def midia = FileUploadService.fileUpload(f , 'carboidratoslmdcm' , 'assets/')
			alimentoInstance.imagem = midia
		}
		
		if (alimentoInstance.hasErrors()) {
			respond alimentoInstance.errors, view:'edit'
			return
		}
		
        alimentoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Alimento.label', default: 'Alimento'), alimentoInstance.id])
                redirect alimentoInstance
            }
            '*'{ respond alimentoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Alimento alimentoInstance) {

        if (alimentoInstance == null) {
            notFound()
            return
        }

        alimentoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Alimento.label', default: 'Alimento'), alimentoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'alimento.label', default: 'Alimento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
