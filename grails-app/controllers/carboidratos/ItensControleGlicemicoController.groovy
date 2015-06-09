package carboidratos

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ItensControleGlicemicoController extends BaseController{

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]
	def pdfRenderingService
	
	def carregaCalculo(){
		
		//Busco dados configuracao
		configuracaoParams
		def dia=params.int('dia')
		def mes=params.int('mes')
		def ano=params.int('ano')
		def valorpre=params.int('valorglicemiapre')
		def valorpos=params.int('valorglicemiapos')
		def tipo=params.int('tipo')
		def metaglicose=params.int('metaglicose')
		def sensibilidadeinsulina=params.int('sensibilidadeinsulina')
		def sensibilidadecarboidrato=params.int('sensibilidadecarboidrato')
		def qtdcarboidratos=params.float('qtdcarboidratos')
		def qtdinsulinarepositorio=params.int('qtdinsulinarepositorio')
		def refeicao=Refeicao.get(params.int('refeicaoid'))
		def descontoinsulina=refeicao.descontoinsulina
		def usuario=usuarioLogado
		def totalpre, totalpos
		if(tipo==0){
			
			if(valorpre!=null){
				if(qtdcarboidratos==null){
					totalpre= (valorpre-metaglicose)/sensibilidadeinsulina - descontoinsulina
				}else{
					totalpre= ((valorpre-metaglicose)/sensibilidadeinsulina) + (qtdcarboidratos/sensibilidadecarboidrato) - descontoinsulina
				}
				
			}
		}
		
		if(tipo==1){
			if(valorpos!=null){
				totalpos= ((valorpos-metaglicose)/sensibilidadeinsulina) - qtdinsulinarepositorio
			}
			
		}
		render(status:200,contentType: "application/json"){
				[totalpre:totalpre , totalpos:totalpos]
		}
		
	}
	
	def buscatotalrefeicao(){
		
		def dia=params.int('dia')
		def mes=params.int('mes')
		def ano=params.int('ano')
		def refeicao=Refeicao.get(params.int('refeicaoid'))
		def usuario=usuarioLogado
		
		def agrupamento = ContagemCarboidratosAlimento.executeQuery(
			"SELECT CASE "+
			"WHEN cca.alimento.id IS NULL THEN "+
			"sum(cca.qtdalimento*cca.qtdcarboidrato) "+
			"ELSE "+
			"sum(cca.qtdalimento*a.carboidratosg) "+
			"END "+
			"from ContagemCarboidratosAlimento as cca LEFT JOIN cca.alimento as a "+
			"JOIN cca.contagemcarboidratos as c "+
			"where c.dia=:dia and "+
			"c.mes=:mes and "+
			"c.ano=:ano and "+
			"c.usuario=:usuario and  "+
			"c.refeicao=:refeicaoid ",[dia:dia,mes:mes,ano:ano,usuario:usuario,refeicaoid:refeicao])
		
		if(agrupamento.size() > 0 ){
			render(status:200,contentType: "application/json"){
				[total:agrupamento[0]]
			}
		}			
	}
	
	def enviarpdfemail(){
		
		def resultado = ItensControleGlicemico.createCriteria().list() {
			createAlias("controleglicemico", "controleglicemico")
			createAlias("controleglicemico.refeicao", "refeicao")
			eq("controleglicemico.mes" , params.int('mes'))
			eq("controleglicemico.ano" ,params.int('ano'))
			eq("controleglicemico.usuario" ,usuarioLogado)
			order("controleglicemico.dia", "asc")
			order("controleglicemico.mes", "asc")
			order("controleglicemico.ano", "asc")
			order("refeicao.ordemrefeicao", "asc")
		}
		
		def nome_arquivo = params.mes + "_" +  params.ano + "_" + (new Date()).getTime() + ".pdf"
		
		ByteArrayOutputStream bytes = pdfRenderingService.render(template: "/itensControleGlicemico/gerarpdf",  model: [resultado:resultado , mes: params.mes,ano:params.ano])
		def anexo = bytes.toByteArray()
		
		def assunto = message(code:'assuntoemailcontrole.label' , args: [params.mes , params.ano] )
		def mensagem = message(code:'verificaranexo.label')
		def destinatario = usuarioLogado.email
		
		//Envio E-mail
		sendMail {
			multipart true
			to destinatario
			subject assunto
			html mensagem
			attachBytes nome_arquivo,"application/pdf",anexo
		}
		
		flash.message = message(code: 'pdfenviado.label' , args: [destinatario])
		redirect action:"index", params:[mes: params.mes,ano:params.ano]
	}
	
	def imprimir(){
		
		def resultado = ItensControleGlicemico.createCriteria().list() {
			createAlias("controleglicemico", "controleglicemico")
			createAlias("controleglicemico.refeicao", "refeicao")
			eq("controleglicemico.mes" , params.int('mes'))
			eq("controleglicemico.ano" ,params.int('ano'))
			eq("controleglicemico.usuario" ,usuarioLogado)
			order("controleglicemico.dia", "asc")
			order("controleglicemico.mes", "asc")
			order("controleglicemico.ano", "asc")
			order("refeicao.ordemrefeicao", "asc")
			
		}
		
		respond resultado, model:[ItensControleGlicemicoInstanceCount: resultado.size , mes:params.int('mes') , ano:params.int('ano')]
	}
	
    def index(Integer max) {
        Calendar cal = Calendar.getInstance()
		def mescorrente=cal.get(Calendar.MONTH) + 1
		def anocorrente=cal.get(Calendar.YEAR)
		def diacorrente=cal.get(Calendar.DAY_OF_MONTH)
		def mes , ano, dia
		
		if(params.dia!="" && params.dia!=null){
			dia = params.int('dia')
		}else{
			dia = diacorrente
		}
		if(params.mes!="" && params.mes!=null){
			mes = params.int('mes')
		}else{
			mes = mescorrente
		}
		if(params.ano!="" && params.ano!=null){
			ano = params.int('ano')
		}else{
			ano = anocorrente
		}
		
		def resultado = ItensControleGlicemico.createCriteria().list() {
			createAlias("controleglicemico", "controleglicemico")
			createAlias("controleglicemico.refeicao", "refeicao")
			if(dia!=0){
				eq("controleglicemico.dia" , dia)
			}
			eq("controleglicemico.mes" , mes)
			eq("controleglicemico.ano" ,ano)
			eq("controleglicemico.usuario" ,usuarioLogado)
			order("controleglicemico.dia", "asc")
			order("controleglicemico.mes", "asc")
			order("controleglicemico.ano", "asc")
			order("refeicao.ordemrefeicao", "asc")
			
		}
		
		respond resultado, model:[ItensControleGlicemicoInstanceCount: resultado.size , dia:dia, mes:mes , ano:ano]
    }

    def show(ItensControleGlicemico itensControleGlicemicoInstance) {
        respond itensControleGlicemicoInstance
    }

    def create() {
        respond new ItensControleGlicemico(params)
    }

    @Transactional
    def save(ItensControleGlicemico itensControleGlicemicoInstance) {
		
		if (itensControleGlicemicoInstance == null) {
			notFound()
			return
		}
		
		def controleGlicemicoInstance
		def erros=[]
		def resultado= ControleGlicemico.executeQuery("select c.id from ControleGlicemico as c where c.dia=:dia and c.mes=:mes and c.ano=:ano and c.usuario=:usuario and c.refeicao=:refeicao", [dia: params.int('dia') , mes: params.int('mes') , ano: params.int('ano') , usuario:usuarioLogado ,refeicao:Refeicao.get(params.int('refeicao.id'))])
		
		if (resultado.size()>0){
			resultado.each{ it ->
				controleGlicemicoInstance=ControleGlicemico.get(it)
			}
		}else{
		
			controleGlicemicoInstance= new ControleGlicemico()
			
			controleGlicemicoInstance.dia=params.int('dia')
			controleGlicemicoInstance.mes=params.int('mes')
			controleGlicemicoInstance.ano=params.int('ano')
			controleGlicemicoInstance.usuario=usuarioLogado
			controleGlicemicoInstance.refeicao=Refeicao.get(params.int('refeicao.id'))
			
			controleGlicemicoInstance.save flush:true
			if (controleGlicemicoInstance.hasErrors()) {
					controleGlicemicoInstance.errors.allErrors.each {
							erros.add(it)
					}
					flash.error=erros
					redirect action:"index", params:[refeicaoid: params.int('refeicao.id'), mes:params.int('mes'),ano:params.int('ano') ]
					return
			}
		}
				
		itensControleGlicemicoInstance.controleglicemico=controleGlicemicoInstance
		itensControleGlicemicoInstance.qtdinsulinelenta=params.int('qtdinsulinelenta')
		itensControleGlicemicoInstance.valorglicemiapre=params.int('valorglicemiapre')
		itensControleGlicemicoInstance.qtdinsulinarapidapre=params.int('qtdinsulinarapidapre')
		itensControleGlicemicoInstance.qtdcarboidrato=params.float('qtdcarboidrato')
		itensControleGlicemicoInstance.valorglicemiapos=params.int('valorglicemiapos')
		itensControleGlicemicoInstance.qtdinsulinarapidapos=params.int('qtdinsulinarapidapos')
		itensControleGlicemicoInstance.observacao=params.observacao
		itensControleGlicemicoInstance.save flush:true

		if (itensControleGlicemicoInstance.hasErrors()) {
				itensControleGlicemicoInstance.errors.allErrors.each {
						erros.add(it)
				}
				flash.error=erros
				redirect action:"index", params:[refeicaoid: params.int('refeicao.id'), mes:params.int('mes'),ano:params.int('ano') ]
				return
		}
		
		request.withFormat {
			form multipartForm {
			flash.message = message(code: 'default.created.message', args: [message(code: 'controleGlicemico.label', default: 'ControleGlicemico'), controleGlicemicoInstance.id])
			redirect action:"index", params:[mes:params.int('mes'),ano:params.int('ano')]
			}
			'*' { respond itensControleGlicemicoInstance, [status: CREATED] }
		}
    }

    def edit(ItensControleGlicemico itensControleGlicemicoInstance) {
        respond itensControleGlicemicoInstance
    }

    @Transactional
    def update() {
		
		def idcontrole=params.list('id')
		def mes=params.list('mes')
		def ano=params.list('ano')
		def dia 
		def icontrole=0
		def erros = []
		for(int index=0 ; index < idcontrole.size() ; index++){
				
				def itensControleGlicemicoInstance
				
				itensControleGlicemicoInstance = ItensControleGlicemico.get(idcontrole[index].toInteger())
				def qtdinsulinelenta , valorglicemiapre , qtdinsulinarapidapre
				def qtdcarboidrato, valorglicemiapos , qtdinsulinarapidapos , idrefeicao
				def obs , refeicaoid , controleglicemicoid
				def refeicaoInstance , controleglicemicoInstance
				
				if (idcontrole.size() > 1){
					controleglicemicoid		= (params.controleglicemico.id[index] ? params.controleglicemico.id[index].toInteger() : null)
					dia						= (params.diaatual[index] ? params.diaatual[index].toInteger() : null)
					refeicaoid				= (params.refeicao.id[index] ? params.refeicao.id[index].toInteger() : null)
					qtdinsulinelenta 		= (params.qtdinsulinelenta[index] ? params.qtdinsulinelenta[index].toInteger() : null)
					valorglicemiapre 		= (params.valorglicemiapre[index] ? params.valorglicemiapre[index].toInteger() : null)
					qtdinsulinarapidapre 	= (params.qtdinsulinarapidapre[index] ? params.qtdinsulinarapidapre[index].toInteger() : null)
					qtdcarboidrato 			= (params.qtdcarboidrato[index] ? params.qtdcarboidrato[index].toFloat() : null)
					valorglicemiapos 		= (params.valorglicemiapos[index] ? params.valorglicemiapos[index].toInteger() : null)
					qtdinsulinarapidapos 	= (params.qtdinsulinarapidapos[index] ? params.qtdinsulinarapidapos[index].toInteger() : null)
					obs 					= params.observacao[index]	
				}else{
					controleglicemicoid		= (params.controleglicemico.id ? params.controleglicemico.id.toInteger() : null)
					dia						= (params.dia ? params.dia.toInteger() : null)
					refeicaoid				= (params.refeicao.id ? params.refeicao.id.toInteger() : null)
					qtdinsulinelenta 		= (params.qtdinsulinelenta ? params.qtdinsulinelenta.toInteger() : null)
					valorglicemiapre 		= (params.valorglicemiapre ? params.valorglicemiapre.toInteger() : null)
					qtdinsulinarapidapre 	= (params.qtdinsulinarapidapre ? params.qtdinsulinarapidapre.toInteger() : null)
					qtdcarboidrato 			= (params.qtdcarboidrato ? params.qtdcarboidrato.toFloat() : null)
					valorglicemiapos 		= (params.valorglicemiapos ? params.valorglicemiapos.toInteger() : null)
					qtdinsulinarapidapos 	= (params.qtdinsulinarapidapos ? params.qtdinsulinarapidapos.toInteger() : null)
					obs						= params.observacao
				}
				
				controleglicemicoInstance=ControleGlicemico.get(controleglicemicoid)
				refeicaoInstance=Refeicao.get(refeicaoid)
				controleglicemicoInstance.refeicao=refeicaoInstance
				controleglicemicoInstance.save flush:true
				
				if (controleglicemicoInstance.hasErrors()) {
					controleglicemicoInstance.errors.allErrors.each {
						erros.add(it)
					}
					flash.error=erros
					redirect action:"index", params:[dia:dia , mes:params.int('mes'),ano:params.int('ano') ]
					return
				}
				
				itensControleGlicemicoInstance.qtdinsulinelenta=qtdinsulinelenta
				itensControleGlicemicoInstance.valorglicemiapre=valorglicemiapre
				itensControleGlicemicoInstance.qtdinsulinarapidapre=qtdinsulinarapidapre
				itensControleGlicemicoInstance.qtdcarboidrato=qtdcarboidrato
				itensControleGlicemicoInstance.valorglicemiapos=valorglicemiapos
				itensControleGlicemicoInstance.qtdinsulinarapidapos=qtdinsulinarapidapos
				itensControleGlicemicoInstance.observacao=obs
				itensControleGlicemicoInstance.save flush:true
				
				if (itensControleGlicemicoInstance.hasErrors()) {
					itensControleGlicemicoInstance.errors.allErrors.each {
						erros.add(it)
					}
					flash.error=erros
					redirect action:"index", params:[dia:dia , mes:params.int('mes'),ano:params.int('ano') ]
					return
				}
				
		}
		flash.message = message(code: 'default.updated.message', args: [message(code: 'controleGlicemico.label', default: 'ControleGlicemico')])
		redirect action:"index", params:[dia:dia, mes:params.int('mes'),ano:params.int('ano') ]
	}

    @Transactional
    def delete(ItensControleGlicemico itensControleGlicemicoInstance) {

        if (itensControleGlicemicoInstance == null) {
            notFound()
            return
        }

		def ControleGlicemicoInstance=itensControleGlicemicoInstance.controleglicemico
		def mes = ControleGlicemicoInstance.mes
		def ano = ControleGlicemicoInstance.ano
		
        itensControleGlicemicoInstance.delete flush:true
		if (itensControleGlicemicoInstance.hasErrors()) {
			respond itensControleGlicemicoInstance.errors, view:'index'
			return
		}else{
		
			def resultado = ItensControleGlicemico.findAllByControleglicemico(ControleGlicemicoInstance)
			if(resultado.size()==0){
				
				ControleGlicemicoInstance.delete flush:true
				
				if (ControleGlicemicoInstance.hasErrors()) {
					respond ControleGlicemicoInstance.errors, view:'index'
					return
				}
				
			}
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label'), itensControleGlicemicoInstance.id])
			redirect action:"index", params:[mes:mes,ano:ano ]
		}
		
                
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itensControleGlicemico.label', default: 'ItensControleGlicemico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
