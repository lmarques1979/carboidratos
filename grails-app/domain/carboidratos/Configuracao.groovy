package carboidratos

import java.util.Date;
import seguranca.Usuario
class Configuracao {

	Integer alturaimagens
	Integer larguraimagens
	Integer alturaimagensthumbs
	Integer larguraimagensthumbs	
	Integer itensporpagina
	Date dateCreated
	Date lastUpdated
	Usuario	usuario
	
	static constraints = {
		alturaimagens(nullable: true, blank: true)
		larguraimagens(nullable: true, blank: true)
		alturaimagensthumbs(nullable: true, blank: true)
		larguraimagensthumbs(nullable: true, blank: true)
		itensporpagina(nullable: true, blank: true)
		usuario(nullable: false, blank: false)
	}
	
	static mapping = {
		autoTimestamp true
	}
}
