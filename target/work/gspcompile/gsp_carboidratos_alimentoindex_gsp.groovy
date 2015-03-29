import carboidratos.Alimento
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_alimentoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/alimento/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'alimento.label', default: 'Alimento'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("alimento.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',21,['name':("nome"),'class':("dadosbusca"),'placeholder':(message(code:'busca.label'))],-1)
printHtmlPart(10)
invokeTag('submitButton','g',22,['name':("submit"),'class':("botaobuscar"),'value':("")],-1)
printHtmlPart(11)
})
invokeTag('form','g',24,['url':([resource:alimentosInstance, action:'index'])],2)
printHtmlPart(12)
invokeTag('sortableColumn','g',31,['property':("nome"),'title':(message(code: 'alimento.nome.label', default: 'Nome'))],-1)
printHtmlPart(13)
expressionOut.print(message(code: 'alimento.imagem.label'))
printHtmlPart(14)
invokeTag('sortableColumn','g',35,['property':("medidausual"),'title':(message(code: 'alimento.medidausual.label', default: 'Medidausual'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("peso"),'title':(message(code: 'alimento.peso.label', default: 'Peso'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',39,['property':("caloriaskcal"),'title':(message(code: 'alimento.caloriaskcal.label', default: 'Caloriaskcal'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',41,['property':("carboidratosg"),'title':(message(code: 'alimento.carboidratosg.label', default: 'Carboidratosg'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',43,['property':("carboidratoskcal"),'title':(message(code: 'alimento.carboidratoskcal.label', default: 'Carboidratoskcal'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( alimentoInstance in (alimentoInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(19)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: alimentoInstance, field: "nome"))
})
invokeTag('link','g',52,['action':("show"),'id':(alimentoInstance.id)],4)
printHtmlPart(20)
}
else {
printHtmlPart(19)
expressionOut.print(fieldValue(bean: alimentoInstance, field: "nome"))
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (alimentoInstance?.imagem)) {
printHtmlPart(19)
invokeTag('image','asset',59,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':(alimentoInstance.imagem),'title':(alimentoInstance?.nome)],-1)
printHtmlPart(20)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(alimentoInstance.medidausual)
printHtmlPart(24)
expressionOut.print(formatNumber(number:alimentoInstance.peso,maxFractionDigits:2 , minFractionDigits:2 ))
printHtmlPart(25)
expressionOut.print(formatNumber(number:alimentoInstance.caloriaskcal,maxFractionDigits:2 , minFractionDigits:2 ))
printHtmlPart(25)
expressionOut.print(formatNumber(number:alimentoInstance.carboidratosg,maxFractionDigits:2 , minFractionDigits:2 ))
printHtmlPart(25)
expressionOut.print(formatNumber(number:alimentoInstance.carboidratoskcal,maxFractionDigits:2 , minFractionDigits:2 ))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',80,['total':(alimentoInstanceCount ?: 0)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',83,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427391629000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
