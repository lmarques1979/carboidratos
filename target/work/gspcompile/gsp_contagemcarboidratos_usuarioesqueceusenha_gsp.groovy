import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_usuarioesqueceusenha_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/esqueceusenha.gsp" }
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
invokeTag('message','g',5,['code':("esqueceusenha.label")],-1)
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
if(true && (flash.message)) {
printHtmlPart(5)
loop:{
int i = 0
for( mensagem in (flash.message) ) {
printHtmlPart(6)
expressionOut.print(mensagem)
printHtmlPart(7)
i++
}
}
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (flash.erros)) {
printHtmlPart(10)
loop:{
int i = 0
for( error in (flash.erros) ) {
printHtmlPart(11)
expressionOut.print(error)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',29,['code':("esqueceusenha.label")],-1)
printHtmlPart(15)
invokeTag('message','g',33,['code':("dadosusuario.label")],-1)
printHtmlPart(16)
invokeTag('textField','g',36,['id':("username"),'name':("username"),'placeholder':(message(code:'usuario.username.label'))],-1)
printHtmlPart(17)
invokeTag('message','g',41,['code':("usuario.email.label")],-1)
printHtmlPart(16)
invokeTag('textField','g',44,['id':("email"),'name':("email"),'placeholder':(message(code:'usuario.email.label'))],-1)
printHtmlPart(18)
invokeTag('submitButton','g',49,['id':("submit"),'name':("create"),'value':(message(code: "usuario.enviarsenha"))],-1)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424459853000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
