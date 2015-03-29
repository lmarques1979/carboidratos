import carboidratos.Alimento
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_alimento_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/alimento/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',3,['code':("alimento.label")],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: alimentoInstance, field: 'nome', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("alimento.nome.label"),'default':("Nome")],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['name':("nome"),'required':(""),'value':(alimentoInstance?.nome)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: alimentoInstance, field: 'medidausual', 'error'))
printHtmlPart(5)
invokeTag('message','g',15,['code':("alimento.medidausual.label"),'default':("Medidausual")],-1)
printHtmlPart(3)
invokeTag('textField','g',18,['name':("medidausual"),'required':(""),'value':(alimentoInstance?.medidausual)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: alimentoInstance, field: 'peso', 'error'))
printHtmlPart(6)
invokeTag('message','g',24,['code':("alimento.peso.label"),'default':("Peso")],-1)
printHtmlPart(3)
invokeTag('textField','g',27,['name':("peso"),'size':("4"),'value':(formatNumber(number:alimentoInstance?.peso,maxFractionDigits:2 , minFractionDigits:2))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: alimentoInstance, field: 'caloriaskcal', 'error'))
printHtmlPart(8)
invokeTag('message','g',32,['code':("alimento.caloriaskcal.label"),'default':("Caloriaskcal")],-1)
printHtmlPart(9)
invokeTag('textField','g',35,['name':("caloriaskcal"),'size':("4"),'value':(formatNumber(number:alimentoInstance?.caloriaskcal,maxFractionDigits:2 , minFractionDigits:2))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: alimentoInstance, field: 'carboidratosg', 'error'))
printHtmlPart(10)
invokeTag('message','g',40,['code':("alimento.carboidratosg.label"),'default':("Carboidratosg")],-1)
printHtmlPart(9)
invokeTag('textField','g',43,['name':("carboidratosg"),'size':("4"),'value':(formatNumber(number:alimentoInstance?.carboidratosg,maxFractionDigits:2 , minFractionDigits:2))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: alimentoInstance, field: 'carboidratoskcal', 'error'))
printHtmlPart(11)
invokeTag('message','g',48,['code':("alimento.carboidratoskcal.label"),'default':("Carboidratoskcal")],-1)
printHtmlPart(9)
invokeTag('textField','g',51,['name':("carboidratoskcal"),'size':("4"),'value':(formatNumber(number:alimentoInstance?.carboidratoskcal,maxFractionDigits:2 , minFractionDigits:2))],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: alimentoInstance, field: 'imagem', 'error'))
printHtmlPart(12)
invokeTag('message','g',56,['code':("alimento.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(13)
expressionOut.print(message(code:'alimento.imagem.label'))
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427382582000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
