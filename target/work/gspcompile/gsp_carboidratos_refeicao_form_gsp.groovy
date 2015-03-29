import carboidratos.Refeicao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_refeicao_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/refeicao/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',3,['code':("refeicao.show.label")],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: refeicaoInstance, field: 'descricao', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("refeicao.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['name':("descricao"),'required':(""),'value':(refeicaoInstance?.descricao)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: refeicaoInstance, field: 'ordemrefeicao', 'error'))
printHtmlPart(5)
invokeTag('message','g',15,['code':("refeicao.ordemrefeicao.label"),'default':("Ordemrefeicao")],-1)
printHtmlPart(3)
invokeTag('field','g',18,['name':("ordemrefeicao"),'type':("number"),'value':(refeicaoInstance.ordemrefeicao),'required':("")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427394332000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
