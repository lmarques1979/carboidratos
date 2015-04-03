import carboidratos.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_configuracao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',2,['code':("configuracao.show.label")],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'alturaimagens', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("configuracao.alturaimagens.label"),'default':("Alturaimagens")],-1)
printHtmlPart(3)
invokeTag('field','g',9,['name':("alturaimagens"),'type':("number"),'value':(configuracaoInstance.alturaimagens),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagens', 'error'))
printHtmlPart(5)
invokeTag('message','g',15,['code':("configuracao.larguraimagens.label"),'default':("Larguraimagens")],-1)
printHtmlPart(3)
invokeTag('field','g',18,['name':("larguraimagens"),'type':("number"),'value':(configuracaoInstance.larguraimagens),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'alturaimagensthumbs', 'error'))
printHtmlPart(6)
invokeTag('message','g',24,['code':("configuracao.alturaimagensthumbs.label"),'default':("Alturaimagensthumbs")],-1)
printHtmlPart(3)
invokeTag('field','g',27,['name':("alturaimagensthumbs"),'type':("number"),'value':(configuracaoInstance.alturaimagensthumbs),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagensthumbs', 'error'))
printHtmlPart(7)
invokeTag('message','g',33,['code':("configuracao.larguraimagensthumbs.label"),'default':("Larguraimagensthumbs")],-1)
printHtmlPart(3)
invokeTag('field','g',36,['name':("larguraimagensthumbs"),'type':("number"),'value':(configuracaoInstance.larguraimagensthumbs),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'itensporpagina', 'error'))
printHtmlPart(8)
invokeTag('message','g',42,['code':("configuracao.itensporpagina.label"),'default':("Itensporpagina")],-1)
printHtmlPart(3)
invokeTag('field','g',45,['name':("itensporpagina"),'type':("number"),'value':(configuracaoInstance.itensporpagina),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'metaglicose', 'error'))
printHtmlPart(9)
invokeTag('message','g',51,['code':("configuracao.metaglicose.label"),'default':("Alturaimagens")],-1)
printHtmlPart(10)
invokeTag('field','g',53,['name':("metaglicose"),'type':("number"),'value':(configuracaoInstance.metaglicose)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'sensibilidadeinsulina', 'error'))
printHtmlPart(11)
invokeTag('message','g',59,['code':("configuracao.sensibilidadeinsulina.label"),'default':("Alturaimagens")],-1)
printHtmlPart(10)
invokeTag('field','g',61,['name':("sensibilidadeinsulina"),'type':("number"),'value':(configuracaoInstance.sensibilidadeinsulina)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'qtdinsulinarepositorio', 'error'))
printHtmlPart(11)
invokeTag('message','g',67,['code':("configuracao.qtdinsulinarepositorio.label"),'default':("Alturaimagens")],-1)
printHtmlPart(10)
invokeTag('field','g',69,['name':("qtdinsulinarepositorio"),'type':("number"),'value':(configuracaoInstance.qtdinsulinarepositorio)],-1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427972371000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
