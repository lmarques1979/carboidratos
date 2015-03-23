package carboidratos

import java.io.Serializable;
import java.util.Date;

import seguranca.Usuario

class ItensContagemCarboidratos {
	
	Integer qtdalimento
	Integer qtdcarboidrato
	String  alimentoforalista
	Alimento alimento
	RefeicoesContagemCarboidratos refeicoescontagemcarboidratos
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		 qtdalimento(nullable: false , blank: false)
		 qtdcarboidrato(nullable: true)
		 alimentoforalista(nullable: true , blank: true)
		 alimento(nullable:true)
		 refeicoescontagemcarboidratos(nullable:false) 
	}
	
	static mapping = {
		autoTimestamp true
	}
}
