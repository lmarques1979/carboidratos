package carboidratos

import java.io.Serializable;
import java.util.Date;

import seguranca.Usuario

class RefeicoesContagemCarboidratos implements Serializable{
	
	ContagemCarboidratos contagemcarboidratos
	Refeicao refeicao
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[itens:ItensContagemCarboidratos]
	
    static constraints = {
		 contagemcarboidratos(nullable: false)
		 refeicao(nullable: false)
	}
	
	static mapping = {
		itens cascade: 'all-delete-orphan'
		autoTimestamp true
	}
}
