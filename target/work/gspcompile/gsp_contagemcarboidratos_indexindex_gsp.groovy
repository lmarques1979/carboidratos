import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_indexindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("titulopagina.label")],-1)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',14,['code':("titulopaginainicial.label")],-1)
printHtmlPart(5)
invokeTag('message','g',17,['code':("facaocadastro.label")],-1)
createTagBody(2, {->
invokeTag('message','g',17,['code':("cadastrese.label")],-1)
})
invokeTag('link','g',17,['action':("create"),'controller':("Usuario")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("aposcadastro.label")],-1)
createTagBody(2, {->
invokeTag('message','g',18,['code':("logarnosistema.label")],-1)
})
invokeTag('link','g',18,['action':("auth"),'controller':("Login")],2)
printHtmlPart(6)
invokeTag('message','g',19,['code':("refeicoesdiarias.label")],-1)
printHtmlPart(6)
invokeTag('message','g',20,['code':("contagemcarboidratos.label")],-1)
printHtmlPart(6)
invokeTag('message','g',21,['code':("controleglicemico.label")],-1)
printHtmlPart(6)
invokeTag('message','g',22,['code':("impressaocontagens.label")],-1)
printHtmlPart(7)
invokeTag('message','g',23,['code':("enviopdfemail.label")],-1)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',31,[:],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427641806000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
