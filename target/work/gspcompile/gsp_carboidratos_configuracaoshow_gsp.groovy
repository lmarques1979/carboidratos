import carboidratos.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_configuracaoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'configuracao.label', default: 'Configuracao'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("configuracao.show.label")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',13,['code':("configuracao.list.label")],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (configuracaoInstance?.alturaimagens)) {
printHtmlPart(9)
invokeTag('message','g',25,['code':("configuracao.alturaimagens.label"),'default':("Alturaimagens")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',27,['bean':(configuracaoInstance),'field':("alturaimagens")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (configuracaoInstance?.larguraimagens)) {
printHtmlPart(13)
invokeTag('message','g',34,['code':("configuracao.larguraimagens.label"),'default':("Larguraimagens")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',36,['bean':(configuracaoInstance),'field':("larguraimagens")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (configuracaoInstance?.alturaimagensthumbs)) {
printHtmlPart(15)
invokeTag('message','g',43,['code':("configuracao.alturaimagensthumbs.label"),'default':("Alturaimagensthumbs")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',45,['bean':(configuracaoInstance),'field':("alturaimagensthumbs")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (configuracaoInstance?.larguraimagensthumbs)) {
printHtmlPart(17)
invokeTag('message','g',52,['code':("configuracao.larguraimagensthumbs.label"),'default':("Larguraimagensthumbs")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',54,['bean':(configuracaoInstance),'field':("larguraimagensthumbs")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (configuracaoInstance?.itensporpagina)) {
printHtmlPart(19)
invokeTag('message','g',61,['code':("configuracao.itensporpagina.label"),'default':("Itensporpagina")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',63,['bean':(configuracaoInstance),'field':("itensporpagina")],-1)
printHtmlPart(11)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',71,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',71,['class':("edit"),'action':("edit"),'resource':(configuracaoInstance)],3)
printHtmlPart(23)
invokeTag('actionSubmit','g',72,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(24)
})
invokeTag('form','g',74,['url':([resource:configuracaoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426778267000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
