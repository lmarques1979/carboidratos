package carboidratos

class ContagemCarboidratosAlimento {

	Integer qtdalimento
	Integer qtdcarboidrato
	String alimentoforalista
	Alimento alimento
	ContagemCarboidratos contagemcarboidratos
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		qtdalimento(nullable: false , blank: false)
		qtdcarboidrato(nullable: true)
		alimentoforalista(nullable: true , blank: true)
		alimento(nullable:true)
		contagemcarboidratos(nullable:false)
	}
}
