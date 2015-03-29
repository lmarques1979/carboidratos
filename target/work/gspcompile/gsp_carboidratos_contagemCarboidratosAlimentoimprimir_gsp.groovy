import carboidratos.ContagemCarboidratosAlimento
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_contagemCarboidratosAlimentoimprimir_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/contagemCarboidratosAlimento/imprimir.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',5,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',6,[:],1)
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
printHtmlPart(3)
invokeTag('stylesheet','asset',12,['src':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',13,['src':("application.js")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',20,['code':("contagem.alterar.message")],-1)
printHtmlPart(5)
invokeTag('message','g',21,['code':("headerimpressaocontamgem.message"),'args':([params.mes, params.ano , usuarioInstance.buscaNome(usuarioInstance)])],-1)
printHtmlPart(6)
invokeTag('message','g',25,['code':("contagem.dia.label")],-1)
printHtmlPart(7)
invokeTag('message','g',27,['code':("contagem.refeicao.label")],-1)
printHtmlPart(7)
invokeTag('message','g',29,['code':("contagem.alimento.label")],-1)
printHtmlPart(8)
invokeTag('message','g',31,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(8)
invokeTag('message','g',33,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(8)
invokeTag('message','g',35,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(7)
invokeTag('message','g',37,['code':("contagem.totalchorefeicao.label")],-1)
printHtmlPart(9)
invokeTag('set','g',43,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(10)
invokeTag('set','g',44,['var':("refeicaoanterior"),'value':("-1")],-1)
printHtmlPart(10)
invokeTag('set','g',45,['var':("totalrefeicao"),'value':("0")],-1)
printHtmlPart(10)
loop:{
int i = 0
for( contagemCarboidratosAlimentoInstance in (contagemCarboidratosAlimentoInstanceList) ) {
printHtmlPart(11)
invokeTag('set','g',48,['var':("diaatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)],-1)
printHtmlPart(12)
invokeTag('set','g',49,['var':("refeicaoatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id)],-1)
printHtmlPart(13)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(14)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (refeicaoanterior!=refeicaoatual)) {
printHtmlPart(17)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao)
printHtmlPart(18)
loop:{
int k = 0
for( agrupamentoInstance in (agrupamento) ) {
printHtmlPart(19)
if(true && (agrupamentoInstance[1]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia &&
													  agrupamentoInstance[2]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.mes &&
												  	  agrupamentoInstance[3]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.ano &&
													  agrupamentoInstance[4]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.usuario.id &&
													  agrupamentoInstance[5]==refeicaoatual)) {
printHtmlPart(20)
expressionOut.print(message(code: 'totalrefeicao.label' , args: [contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao , formatNumber(number:agrupamentoInstance[0],type:'number',format:'####.###')]))
printHtmlPart(21)
}
printHtmlPart(22)
k++
}
}
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(25)
expressionOut.print(contagemCarboidratosAlimentoInstance.alimento.nome + ' ' + contagemCarboidratosAlimentoInstance.alimento.medidausual + ' de ' + contagemCarboidratosAlimentoInstance.alimento.peso + 'g : ' + contagemCarboidratosAlimentoInstance.alimento.carboidratosg + 'g Carboidrato(s)')
printHtmlPart(26)
}
else {
printHtmlPart(25)
expressionOut.print(message(code:'alimentonaocadastrado.label'))
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(contagemCarboidratosAlimentoInstance.qtdalimento)
printHtmlPart(28)
expressionOut.print(contagemCarboidratosAlimentoInstance.alimentoforalista)
printHtmlPart(29)
expressionOut.print(contagemCarboidratosAlimentoInstance.qtdcarboidrato)
printHtmlPart(30)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(31)
invokeTag('set','g',100,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento*contagemCarboidratosAlimentoInstance.alimento.carboidratosg)],-1)
printHtmlPart(32)
invokeTag('formatNumber','g',101,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(33)
}
else {
printHtmlPart(31)
invokeTag('set','g',106,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0))],-1)
printHtmlPart(32)
invokeTag('formatNumber','g',107,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(33)
}
printHtmlPart(34)
invokeTag('set','g',112,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(12)
invokeTag('set','g',113,['var':("refeicaoanterior"),'value':(refeicaoatual)],-1)
printHtmlPart(10)
i++
}
}
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',121,['class':("bodyimpressao"),'onload':("window.print()")],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427571868000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
