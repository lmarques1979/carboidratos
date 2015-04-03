package carboidratos

import java.io.Serializable;
import java.util.Date;

import seguranca.Usuario

class ControleGlicemico implements Serializable{
	
	Integer dia
	Integer mes
	Integer ano
	Usuario usuario
	Refeicao refeicao
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[itens:ItensControleGlicemico]
    static constraints = {
		 dia(nullable: false , blank: false)
		 mes(nullable: false , blank: false)
		 ano(nullable: false, blank: false)
		 usuario(nullable: false, blank: false)
		 refeicao(nullable: false, blank: false)
		 dia(unique: ['usuario','mes', 'ano','refeicao'])
		
	}
	
	static mapping = {
		sort dia: "asc" // or "asc"
		sort mes: "asc"
		sort ano: "asc"		
		itens cascade: 'all-delete-orphan'
		autoTimestamp true
	}
}
