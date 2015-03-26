package carboidratos
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("isAuthenticated()")
class BaseController{
   
	def springSecurityService
	
	def getConfiguracaoParams(){
		
			def resultado = Configuracao.createCriteria().list(){
				eq("usuario" , usuarioLogado) 
			}
			resultado.each() {
				params.alturaimagens 		= it.alturaimagens ? it.alturaimagens : "125"
				params.larguraimagens 		= it.larguraimagens ? it.larguraimagens : "125"
				params.alturaimagensthumbs 	= it.alturaimagensthumbs ? it.alturaimagensthumbs : "20"
				params.larguraimagensthumbs	= it.larguraimagensthumbs ? it.larguraimagensthumbs : "25"
				params.max = Math.min(it.itensporpagina ? it.itensporpagina : 20, 10000)
			}
			if (resultado.size() == 0){
				params.alturaimagens 		= "120"
				params.larguraimagens 		= "125"
				params.alturaimagensthumbs 	= "20"
				params.larguraimagensthumbs	= "25"
				params.max = Math.min(20, 10000)
			}
			params
	}
  
	
  def getUsuarioLogado(){
		  springSecurityService.currentUser
  }
 
}