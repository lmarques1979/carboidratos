package carboidratos

import java.io.Serializable;
import java.util.Date;

import seguranca.Usuario

class ContagemCarboidratos {
	
	Integer dia
	Integer mes
	Integer ano
	Usuario usuario
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[refeicoes:RefeicoesContagemCarboidratos]
	
    static constraints = {
		 dia(nullable: false , blank: false)
		 mes(nullable: false , blank: false)
		 ano(nullable: false, blank: false)
		 usuario(nullable: false, blank: false)
	}
	
	static mapping = {
		sort dia: "asc" // or "asc"
		sort mes: "asc"
		sort ano: "asc"		
		refeicoes cascade: 'all-delete-orphan' 
		autoTimestamp true
	}
}
