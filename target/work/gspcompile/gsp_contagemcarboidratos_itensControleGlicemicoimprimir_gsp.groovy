import carboidratos.ItensControleGlicemico
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_itensControleGlicemicoimprimir_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/itensControleGlicemico/imprimir.gsp" }
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
invokeTag('set','g',9,['var':("entityName"),'value':(message(code: 'controleGlicemico.label', default: 'ControleGlicemico'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',10,['code':("controle.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(3)
invokeTag('stylesheet','asset',11,['src':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',12,['src':("application.js")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',20,['code':("controle.list.label")],-1)
printHtmlPart(5)
invokeTag('message','g',21,['code':("headerimpressaocontamgem.message"),'args':([params.mes, params.ano, usuarioInstance.buscaNome(usuarioInstance)])],-1)
printHtmlPart(6)
invokeTag('message','g',27,['code':("controle.dia.label")],-1)
printHtmlPart(7)
invokeTag('message','g',28,['code':("controle.refeicao.label")],-1)
printHtmlPart(7)
invokeTag('message','g',29,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(7)
invokeTag('message','g',30,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(7)
invokeTag('message','g',31,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(7)
invokeTag('message','g',32,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(7)
invokeTag('message','g',33,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(7)
invokeTag('message','g',34,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(7)
invokeTag('message','g',35,['code':("controle.observacao.label")],-1)
printHtmlPart(8)
invokeTag('set','g',41,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(9)
loop:{
int j = 0
for( itensControleGlicemicoInstance in (itensControleGlicemicoInstanceList) ) {
printHtmlPart(10)
invokeTag('set','g',44,['var':("diaatual"),'value':(itensControleGlicemicoInstance.controleglicemico.dia)],-1)
printHtmlPart(10)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(11)
expressionOut.print(itensControleGlicemicoInstance.controleglicemico.dia)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(itensControleGlicemicoInstance.refeicao.descricao)
printHtmlPart(14)
expressionOut.print(itensControleGlicemicoInstance.qtdinsulinelenta)
printHtmlPart(15)
expressionOut.print(itensControleGlicemicoInstance.valorglicemiapre)
printHtmlPart(15)
expressionOut.print(itensControleGlicemicoInstance.qtdinsulinarapidapre)
printHtmlPart(15)
expressionOut.print(itensControleGlicemicoInstance.qtdcarboidrato)
printHtmlPart(15)
expressionOut.print(itensControleGlicemicoInstance.valorglicemiapos)
printHtmlPart(15)
expressionOut.print(itensControleGlicemicoInstance.qtdinsulinarapidapos)
printHtmlPart(15)
expressionOut.print(itensControleGlicemicoInstance.observacao)
printHtmlPart(16)
invokeTag('set','g',67,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(9)
j++
}
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',75,['class':("bodyimpressao"),'onload':("window.print()")],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427583760000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
