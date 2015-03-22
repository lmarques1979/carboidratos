package carboidratos

import java.io.Serializable;
import java.util.Date;

import seguranca.Usuario

class ItensContagemCarboidratos {
	
	Integer qtdalimento
	Integer qtdcarboidrato
	String  alimentoforalista
	ContagemCarboidratos contagemcarboidratos
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[alimentos:Alimento]
	
    static constraints = {
		 qtdalimento(nullable: false , blank: false)
		 qtdcarboidrato(nullable: true)
		 alimentoforalista(nullable: true , blank: true)
		 contagemcarboidratos(nullable: false)
	}
	
	static mapping = {
		sort dia: "asc" // or "asc"
		sort mes: "asc"
		sort ano: "asc"		
		autoTimestamp true
	}
}
