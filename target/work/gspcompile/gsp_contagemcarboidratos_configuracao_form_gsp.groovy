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
invokeTag('message','g',5,['code':("configuracao.alturaimagens.label"),'default':("Alturaimagens")],-1)
printHtmlPart(3)
invokeTag('field','g',8,['name':("alturaimagens"),'type':("number"),'value':(configuracaoInstance.alturaimagens),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagens', 'error'))
printHtmlPart(5)
invokeTag('message','g',14,['code':("configuracao.larguraimagens.label"),'default':("Larguraimagens")],-1)
printHtmlPart(3)
invokeTag('field','g',17,['name':("larguraimagens"),'type':("number"),'value':(configuracaoInstance.larguraimagens),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'alturaimagensthumbs', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("configuracao.alturaimagensthumbs.label"),'default':("Alturaimagensthumbs")],-1)
printHtmlPart(3)
invokeTag('field','g',26,['name':("alturaimagensthumbs"),'type':("number"),'value':(configuracaoInstance.alturaimagensthumbs),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'larguraimagensthumbs', 'error'))
printHtmlPart(7)
invokeTag('message','g',32,['code':("configuracao.larguraimagensthumbs.label"),'default':("Larguraimagensthumbs")],-1)
printHtmlPart(3)
invokeTag('field','g',35,['name':("larguraimagensthumbs"),'type':("number"),'value':(configuracaoInstance.larguraimagensthumbs),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: configuracaoInstance, field: 'itensporpagina', 'error'))
printHtmlPart(8)
invokeTag('message','g',41,['code':("configuracao.itensporpagina.label"),'default':("Itensporpagina")],-1)
printHtmlPart(3)
invokeTag('field','g',44,['name':("itensporpagina"),'type':("number"),'value':(configuracaoInstance.itensporpagina),'required':("")],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426779994000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
