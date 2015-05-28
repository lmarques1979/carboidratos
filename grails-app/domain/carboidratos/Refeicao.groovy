package carboidratos

import java.util.Date;
import seguranca.Usuario


class Refeicao {

	String descricao
	Integer ordemrefeicao
	Integer	descontoinsulina=0
	Usuario usuario
	Date dateCreated
	Date lastUpdated
	
	static hasMany=[contagem:ContagemCarboidratos , controle:ItensControleGlicemico]
    static constraints = {
		descricao(nullable: false, blank: false)
		ordemrefeicao(nullable: false, blank: false)
		descontoinsulina(nullable: true, blank: true)
		usuario(nullable: false, blank: false)
	}
	
	static mapping = {
		sort ordemrefeicao:"asc" // or "asc" 
		autoTimestamp true
		contagem cascade: 'all-delete-orphan'
		controle cascade: 'all-delete-orphan'
	}
	
	static def refeicaoUsuario(def usuariologado){
		
		def resultado = Refeicao.createCriteria().list () {
			eq("usuario",usuariologado)
		}
		return resultado
	}
}
