import carboidratos.ContagemCarboidratosAlimento
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_contagemCarboidratosAlimento_gerarpdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/contagemCarboidratosAlimento/_gerarpdf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',4,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',5,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',11,['code':("contagem.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',63,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',70,['code':("contagem.alterar.message")],-1)
printHtmlPart(6)
invokeTag('message','g',71,['code':("headerimpressaocontamgem.message"),'args':([mes, ano , usuarioInstance.buscaNome(usuarioInstance)])],-1)
printHtmlPart(7)
invokeTag('message','g',75,['code':("contagem.dia.label")],-1)
printHtmlPart(8)
invokeTag('message','g',76,['code':("contagem.refeicao.label")],-1)
printHtmlPart(8)
invokeTag('message','g',77,['code':("contagem.alimento.label")],-1)
printHtmlPart(8)
invokeTag('message','g',78,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(8)
invokeTag('message','g',79,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(8)
invokeTag('message','g',80,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(8)
invokeTag('message','g',81,['code':("contagem.totalchorefeicao.label")],-1)
printHtmlPart(9)
invokeTag('set','g',85,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(10)
invokeTag('set','g',86,['var':("refeicaoanterior"),'value':("-1")],-1)
printHtmlPart(10)
invokeTag('set','g',87,['var':("totalrefeicao"),'value':("0")],-1)
printHtmlPart(10)
loop:{
int i = 0
for( contagemCarboidratosAlimentoInstance in (resultado) ) {
printHtmlPart(11)
invokeTag('set','g',89,['var':("diaatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)],-1)
printHtmlPart(11)
invokeTag('set','g',90,['var':("refeicaoatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id)],-1)
printHtmlPart(11)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(12)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (refeicaoanterior!=refeicaoatual)) {
printHtmlPart(15)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao)
printHtmlPart(16)
loop:{
int k = 0
for( agrupamentoInstance in (agrupamento) ) {
printHtmlPart(17)
if(true && (agrupamentoInstance[1]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia &&
													  agrupamentoInstance[2]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.mes &&
												  	  agrupamentoInstance[3]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.ano &&
													  agrupamentoInstance[4]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.usuario.id &&
													  agrupamentoInstance[5]==refeicaoatual)) {
printHtmlPart(18)
expressionOut.print(message(code: 'totalrefeicao.label' , args: [contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao , formatNumber(number:agrupamentoInstance[0],type:'number',maxFractionDigits:'2')]))
printHtmlPart(19)
}
printHtmlPart(20)
k++
}
}
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(23)
expressionOut.print(contagemCarboidratosAlimentoInstance.alimento.nome + ' ' + contagemCarboidratosAlimentoInstance.alimento.medidausual + ' de ' + contagemCarboidratosAlimentoInstance.alimento.peso + 'g : ' + contagemCarboidratosAlimentoInstance.alimento.carboidratosg + 'g Carboidrato(s)')
printHtmlPart(24)
}
else {
printHtmlPart(23)
expressionOut.print(message(code:'alimentonaocadastrado.label'))
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(contagemCarboidratosAlimentoInstance.qtdalimento)
printHtmlPart(26)
expressionOut.print(contagemCarboidratosAlimentoInstance.alimentoforalista)
printHtmlPart(26)
expressionOut.print(contagemCarboidratosAlimentoInstance.qtdcarboidrato)
printHtmlPart(27)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(28)
invokeTag('set','g',134,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento*contagemCarboidratosAlimentoInstance.alimento.carboidratosg)],-1)
printHtmlPart(29)
invokeTag('formatNumber','g',135,['number':(totaldia),'type':("number"),'maxFractionDigits':("2")],-1)
printHtmlPart(30)
}
else {
printHtmlPart(28)
invokeTag('set','g',140,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0))],-1)
printHtmlPart(29)
invokeTag('formatNumber','g',141,['number':(totaldia),'type':("number"),'maxFractionDigits':("2")],-1)
printHtmlPart(30)
}
printHtmlPart(31)
invokeTag('set','g',145,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(11)
invokeTag('set','g',146,['var':("refeicaoanterior"),'value':(refeicaoatual)],-1)
printHtmlPart(10)
i++
}
}
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',150,['class':("bodyimpressao")],1)
printHtmlPart(33)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427918993000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
