import carboidratos.Refeicao
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_refeicaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/refeicao/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'refeicao.label', default: 'Refeicao'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("refeicao.show.label")],-1)
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
invokeTag('message','g',14,['code':("refeicao.list.label")],-1)
})
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',15,['code':("refeicao.new.label")],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (refeicaoInstance?.descricao)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("refeicao.descricao.label"),'default':("Descricao")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',28,['bean':(refeicaoInstance),'field':("descricao")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (refeicaoInstance?.ordemrefeicao)) {
printHtmlPart(15)
invokeTag('message','g',35,['code':("refeicao.ordemrefeicao.label"),'default':("Ordemrefeicao")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',37,['bean':(refeicaoInstance),'field':("ordemrefeicao")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (refeicaoInstance?.dateCreated)) {
printHtmlPart(17)
invokeTag('message','g',44,['code':("dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',46,['format':("dd/MM/yyyy hh:mm"),'date':(refeicaoInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (refeicaoInstance?.lastUpdated)) {
printHtmlPart(19)
invokeTag('message','g',53,['code':("lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',55,['format':("dd/MM/yyyy hh:mm"),'date':(refeicaoInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',63,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',63,['class':("edit"),'action':("edit"),'resource':(refeicaoInstance)],3)
printHtmlPart(23)
invokeTag('actionSubmit','g',64,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(24)
})
invokeTag('form','g',66,['url':([resource:refeicaoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426780723000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
