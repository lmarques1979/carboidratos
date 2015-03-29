import carboidratos.Alimento
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_alimentoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/alimento/show.gsp" }
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
invokeTag('message','g',8,['code':("alimento.show.label")],-1)
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
createTagBody(2, {->
invokeTag('message','g',14,['code':("alimento.list.label")],-1)
})
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',15,['code':("alimento.new.label")],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (alimentoInstance?.nome)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("alimento.nome.label"),'default':("Nome")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',28,['bean':(alimentoInstance),'field':("nome")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (alimentoInstance?.medidausual)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("alimento.medidausual.label"),'default':("Medidausual")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',37,['bean':(alimentoInstance),'field':("medidausual")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (alimentoInstance?.peso)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("alimento.peso.label"),'default':("Peso")],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',46,['number':(alimentoInstance.peso),'format':("####.##")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (alimentoInstance?.caloriaskcal)) {
printHtmlPart(19)
invokeTag('message','g',53,['code':("alimento.caloriaskcal.label"),'default':("Caloriaskcal")],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',55,['number':(alimentoInstance.caloriaskcal),'format':("####.##")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (alimentoInstance?.carboidratosg)) {
printHtmlPart(21)
invokeTag('message','g',62,['code':("alimento.carboidratosg.label"),'default':("Carboidratosg")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',64,['number':(alimentoInstance.carboidratosg),'format':("####.##")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (alimentoInstance?.carboidratoskcal)) {
printHtmlPart(23)
invokeTag('message','g',71,['code':("alimento.carboidratoskcal.label"),'default':("Carboidratoskcal")],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',73,['number':(alimentoInstance.carboidratoskcal),'format':("####.##")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (alimentoInstance?.imagem)) {
printHtmlPart(25)
invokeTag('message','g',80,['code':("alimento.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(26)
invokeTag('image','asset',84,['height':(params.alturaimagens),'width':(params.larguraimagens),'src':(alimentoInstance.imagem),'title':(alimentoInstance?.nome)],-1)
printHtmlPart(27)
}
printHtmlPart(14)
if(true && (alimentoInstance?.dateCreated)) {
printHtmlPart(28)
invokeTag('message','g',93,['code':("dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(29)
invokeTag('formatDate','g',95,['format':("dd/MM/yyyy hh:mm"),'date':(alimentoInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (alimentoInstance?.lastUpdated)) {
printHtmlPart(30)
invokeTag('message','g',102,['code':("lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(31)
invokeTag('formatDate','g',104,['format':("dd/MM/yyyy hh:mm"),'date':(alimentoInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',112,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',112,['class':("edit"),'action':("edit"),'resource':(alimentoInstance)],3)
printHtmlPart(34)
invokeTag('actionSubmit','g',113,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(35)
})
invokeTag('form','g',115,['url':([resource:alimentoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(36)
})
invokeTag('captureBody','sitemesh',117,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427387125000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
