package carboidratos

import java.io.Serializable;
import java.util.Date;

import seguranca.Usuario

class ItensControleGlicemico {
	
	Integer qtdinsulinelenta
	Integer valorglicemiapre
	Integer qtdinsulinarapidapre
	Integer qtdcarboidrato
	Integer valorglicemiapos
	Integer qtdinsulinarapidapos
	ControleGlicemico controleglicemico
	Refeicao refeicao
	String observacao
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		qtdinsulinelenta(nullable: true, blank: true)	
		valorglicemiapre(nullable: true, blank: true)
		qtdinsulinarapidapre(nullable: true, blank: true)
		qtdcarboidrato(nullable: true, blank: true)
		valorglicemiapos(nullable: true, blank: true)
		qtdinsulinarapidapos(nullable: true, blank: true)
		controleglicemico(nullable:false)
		refeicao(nullable:false)
		observacao(nullable: true, blank: true)
    }
	
	static mapping = {
		autoTimestamp true
	}
}
