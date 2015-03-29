import carboidratos.ItensControleGlicemico
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_itensControleGlicemico_gerarpdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/itensControleGlicemico/_gerarpdf.gsp" }
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
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'controleGlicemico.label', default: 'ControleGlicemico'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',11,['code':("controle.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',53,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',60,['code':("controle.list.label")],-1)
printHtmlPart(6)
invokeTag('message','g',61,['code':("headerimpressaocontamgem.message"),'args':([mes, ano, usuarioInstance.buscaNome(usuarioInstance)])],-1)
printHtmlPart(7)
invokeTag('message','g',67,['code':("controle.dia.label")],-1)
printHtmlPart(8)
invokeTag('message','g',68,['code':("controle.refeicao.label")],-1)
printHtmlPart(8)
invokeTag('message','g',69,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(8)
invokeTag('message','g',70,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(8)
invokeTag('message','g',71,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(8)
invokeTag('message','g',72,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(8)
invokeTag('message','g',73,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(8)
invokeTag('message','g',74,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(8)
invokeTag('message','g',75,['code':("controle.observacao.label")],-1)
printHtmlPart(9)
invokeTag('set','g',81,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(10)
loop:{
int j = 0
for( itensControleGlicemicoInstance in (resultado) ) {
printHtmlPart(11)
invokeTag('set','g',84,['var':("diaatual"),'value':(itensControleGlicemicoInstance.controleglicemico.dia)],-1)
printHtmlPart(12)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(13)
expressionOut.print(itensControleGlicemicoInstance.controleglicemico.dia)
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(itensControleGlicemicoInstance.refeicao.descricao)
printHtmlPart(16)
expressionOut.print(itensControleGlicemicoInstance.qtdinsulinelenta)
printHtmlPart(17)
expressionOut.print(itensControleGlicemicoInstance.valorglicemiapre)
printHtmlPart(17)
expressionOut.print(itensControleGlicemicoInstance.qtdinsulinarapidapre)
printHtmlPart(17)
expressionOut.print(itensControleGlicemicoInstance.qtdcarboidrato)
printHtmlPart(17)
expressionOut.print(itensControleGlicemicoInstance.valorglicemiapos)
printHtmlPart(17)
expressionOut.print(itensControleGlicemicoInstance.qtdinsulinarapidapos)
printHtmlPart(17)
expressionOut.print(itensControleGlicemicoInstance.observacao)
printHtmlPart(18)
invokeTag('set','g',106,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(10)
j++
}
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',114,['class':("bodyimpressao"),'onload':("window.print()")],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427583788000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
