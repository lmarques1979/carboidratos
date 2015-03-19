package carboidratos

import java.util.Date;

class Alimento {

	String nome
	String medidausual
	String peso
	String caloriaskcal
	String carboidratosg
	String carboidratoskcal
	String imagem
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		nome(nullable: false, blank: false)
		medidausual(nullable: false, blank: false)
		peso(nullable: false, blank: false)
		caloriaskcal(nullable: true, blank: true)
		carboidratosg(nullable: true, blank: true)
		carboidratoskcal(nullable: true, blank: true)
		imagem(nullable: true, blank: true)
	}
	
	static mapping = {
		sort nome: "asc" // or "asc"
		autoTimestamp true
	}
}
