import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='spring-security-core', version='2.0-RC3')
class gsp_springSecurityCore_loginauth_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/spring-security-core-2.0-RC3/grails-app/views/login/auth.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',4,['code':("springSecurity.login.title")],-1)
})
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(postUrl)
printHtmlPart(8)
invokeTag('message','g',21,['code':("loginaplicacao.label")],-1)
printHtmlPart(9)
invokeTag('message','g',25,['code':("springSecurity.login.username.label")],-1)
printHtmlPart(10)
invokeTag('textField','g',28,['id':("username"),'name':("j_username"),'placeholder':(message(code:'usuario.username.label'))],-1)
printHtmlPart(11)
invokeTag('message','g',33,['code':("springSecurity.login.password.label")],-1)
printHtmlPart(10)
invokeTag('passwordField','g',36,['id':("password"),'name':("j_password"),'placeholder':(message(code:'usuario.password.label'))],-1)
printHtmlPart(12)
createTagBody(2, {->
invokeTag('message','g',41,['code':("esqueceusenha.label")],-1)
})
invokeTag('link','g',41,['class':("esqueceu"),'controller':("Usuario"),'action':("esqueceusenha")],2)
printHtmlPart(13)
invokeTag('submitButton','g',44,['id':("submit"),'name':("create"),'value':(message(code: "springSecurity.login.button"))],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',55,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1428097903000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
