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
    def delete() {

		def dia=params.int('dia')
		def mes=params.int('mes')
		def ano=params.int('ano')    
		def erros=[]
		
		def resultado = ContagemCarboidratos.createCriteria().list() {
			eq("dia" , dia)
			eq("mes" , mes)
			eq("ano" ,ano)
			eq("usuario" ,usuarioLogado)
		}
		
		resultado.each{ it ->
			
				it.delete flush:true
			
				if (it.hasErrors()) {
						it.errors.allErrors.each {
							erros.add(it)
						}
						flash.error=erros
						redirect (controller: "ContagemCarboidratosAlimento" , action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ])
						return
				}
		}
		
		flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label')])
		redirect (controller: "ContagemCarboidratosAlimento" , action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ])
    }
	
	@Transactional
	def deleterefeicaodia(ContagemCarboidratos contagemCarboidratosInstance) {
		
		def erros=[]
		
		def dia=contagemCarboidratosInstance.dia
		def mes=contagemCarboidratosInstance.mes
		def ano=contagemCarboidratosInstance.ano
		
		contagemCarboidratosInstance.delete flush:true 
		
		if (contagemCarboidratosInstance.hasErrors()) {
				contagemCarboidratosInstance.errors.allErrors.each {
					erros.add(it)
			}
			flash.error=erros
			redirect (controller: "ContagemCarboidratosAlimento" , action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ])
			return
		}
		flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label'), contagemCarboidratosInstance.id])
		redirect (controller: "ContagemCarboidratosAlimento" , action:"index", params:[mes:params.int('mes'),ano:params.int('ano') ])
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
