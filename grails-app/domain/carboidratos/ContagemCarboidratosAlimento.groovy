package carboidratos

class ContagemCarboidratosAlimento {

	Float qtdalimento
	Float qtdcarboidrato
	String alimentoforalista
	Alimento alimento
	ContagemCarboidratos contagemcarboidratos
	Date dateCreated
	Date lastUpdated
	
	static constraints = {
		qtdalimento(nullable: false , blank: false)
		qtdcarboidrato(nullable:true)
		alimentoforalista(nullable: true , blank: true)
		alimento(nullable:true)
		contagemcarboidratos(nullable:false)
	}
}
