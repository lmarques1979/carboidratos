package carboidratos

import java.io.Serializable;
import java.util.Date;

import seguranca.Usuario

class ContagemCarboidratos {
	
	Integer dia
	Integer mes
	Integer ano
	Integer qtdalimento
	Integer qtdcarboidrato
	String  alimentoforalista
	Alimento alimento
	Refeicao refeicao
	Usuario usuario
	Date dateCreated
	Date lastUpdated
		
    static constraints = {
		 dia(nullable: false , blank: false)
		 mes(nullable: false , blank: false)
		 ano(nullable: false, blank: false)
		 qtdalimento(nullable: false, blank: false)
		 alimento(nullable: true)
		 usuario(nullable: false, blank: false)
		 qtdcarboidrato(nullable:true)
		 alimentoforalista(nullable:true)
	}
	
	static mapping = {
		sort dia: "asc" // or "asc"
		sort mes: "asc"
		sort ano: "asc"		
		autoTimestamp true
	}
}
