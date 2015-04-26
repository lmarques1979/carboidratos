package seguranca

import static org.springframework.http.HttpStatus.*
import carboidratos.BaseController
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured('permitAll')
class UsuarioController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	def FileUploadService
	
	@Secured('isAuthenticated()')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Usuario.list(params), model:[usuarioInstanceCount: Usuario.count()]
    }

	def esqueceusenha() {
		 
	}
	
	@Transactional
	def enviarsenha() {
		
		def valido=1
		def mensagem=""
		flash.message = []
		def erros = []
		
		if(params.username==null || params.username==''){
			erros << message(code: 'usuarioobrigatorio.message')
			valido = 0
		}
		
		if(params.email==null || params.email==''){
			erros << message(code: 'emailobrigatorio.message')
			valido = 0
		}
		
		if (valido){
			
				def resultado = Usuario.findAllByUsernameAndEmail(params.username,params.email)
			
				resultado.each(){
					
					Random novasenha = new Random()
					
					def Usuario usuario = it
					String senha = Math.abs(novasenha.nextInt());
					usuario.password= senha
					usuario.save flush:true
					
					if (usuario.hasErrors()) {
						flash.message << usuario.errors
						redirect(controller: "usuario", action: "esqueceusenha", params: params)
					}else{
					
						//Envio E-mail
						sendMail {
							to params.email
							subject message(code: 'novasenhaemail.message')
							html message(code: 'novasenha.message', args: [senha])
						}
						flash.message = message(code: "senhaaenviadaparaemail.message", args:[params.email])
						return
					  }
			}
			if(resultado.size()==0){
				erros << message(code: 'usuarioemailnaoencontrados.message')
				flash.erros = erros
				redirect(controller: "usuario", action: "esqueceusenha", params: params)
			}
		}else{
			flash.erros = erros
			redirect(controller: "usuario", action: "esqueceusenha", params: params)
		}
	}
	 
	def show(Usuario usuarioInstance) {
		
		def erros=[]
		if(usuarioInstance!=usuarioLogado && usuarioLogado.username!='admin'){
			erros[0] = message(code: 'usuarionaopermitido.error')
			flash.erros = erros
			return
		}
		
        respond usuarioInstance
    }

	def create() {
        respond new Usuario(params)
    } 

    @Transactional
	def save(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }

		def f = request.getFile('arquivo')
		
		if (!f.empty) {
			def midia = FileUploadService.fileUpload(f , 'carboidratoslmdcm' , 'assets/')
			usuarioInstance.imagem = midia
		}
		
		usuarioInstance.save flush:true
		
        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect(action: "create")
            }
            '*' { respond usuarioInstance, [status: CREATED] }
        }
    }

	@Secured('isAuthenticated()')
    def edit(Usuario usuarioInstance) {
		
		def erros=[]
		if(usuarioInstance!=usuarioLogado && usuarioLogado.username!="admin"){
			erros[0] = message(code: 'usuarionaopermitido.error')
			flash.erros = erros
			return
		}
        respond usuarioInstance
    }

    @Transactional
	@Secured('isAuthenticated()')
    def update(Usuario usuarioInstance) {
        if (usuarioInstance == null) {
            notFound()
            return
        }
		
		def f = request.getFile('arquivo')
		
		if (!f.empty) {
			def midia = FileUploadService.fileUpload(f , 'carboidratoslmdcm' , 'assets/')
			usuarioInstance.imagem = midia
		}

		usuarioInstance.save flush:true
		
        if (usuarioInstance.hasErrors()) {
            respond usuarioInstance.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect usuarioInstance
            }
            '*'{ respond usuarioInstance, [status: OK] }
        }
    }

    @Transactional
	@Secured('isAuthenticated()')
    def delete(Usuario usuarioInstance) {

        if (usuarioInstance == null) {
            notFound()
            return
        }

        usuarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Usuario.label', default: 'Usuario'), usuarioInstance.id])
                redirect(controller: "logout", action: "index")
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuario.label', default: 'Usuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
