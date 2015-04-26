import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_usuario_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',2,['code':("dadosusuario.label")],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'username', 'error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("usuario.username.label"),'default':("Username")],-1)
printHtmlPart(3)
invokeTag('textField','g',8,['name':("username"),'required':(""),'value':(usuarioInstance?.username),'placeholder':(message(code:'usuario.username.label'))],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'password', 'error'))
printHtmlPart(5)
invokeTag('message','g',14,['code':("usuario.password.label"),'default':("Password")],-1)
printHtmlPart(3)
invokeTag('passwordField','g',17,['name':("password"),'required':(""),'value':(usuarioInstance?.password),'placeholder':(message(code:'usuario.password.label'))],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'email', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("usuario.email.label"),'default':("Email")],-1)
printHtmlPart(3)
invokeTag('field','g',26,['type':("email"),'name':("email"),'required':(""),'value':(usuarioInstance?.email),'placeholder':(message(code:'usuario.email.label'))],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'primeironome', 'error'))
printHtmlPart(7)
invokeTag('message','g',32,['code':("usuario.primeironome.label"),'default':("Primeironome")],-1)
printHtmlPart(3)
invokeTag('textField','g',35,['name':("primeironome"),'required':(""),'value':(usuarioInstance?.primeironome),'placeholder':(message(code:'usuario.primeironome.label'))],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'sobrenome', 'error'))
printHtmlPart(8)
invokeTag('message','g',41,['code':("usuario.sobrenome.label"),'default':("Sobrenome")],-1)
printHtmlPart(9)
invokeTag('textField','g',44,['name':("sobrenome"),'value':(usuarioInstance?.sobrenome),'placeholder':(message(code:'usuario.sobrenome.label'))],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'imagem', 'error'))
printHtmlPart(10)
invokeTag('message','g',50,['code':("usuario.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(11)
expressionOut.print(message(code:'usuario.imagem.label'))
printHtmlPart(12)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'enabled', 'error'))
printHtmlPart(13)
invokeTag('message','g',57,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(14)
invokeTag('checkBox','g',59,['name':("enabled"),'value':(usuarioInstance?.enabled)],-1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'accountExpired', 'error'))
printHtmlPart(16)
invokeTag('message','g',65,['code':("usuario.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(17)
invokeTag('checkBox','g',68,['name':("accountExpired"),'value':(usuarioInstance?.accountExpired)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'accountLocked', 'error'))
printHtmlPart(18)
invokeTag('message','g',74,['code':("usuario.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(17)
invokeTag('checkBox','g',77,['name':("accountLocked"),'value':(usuarioInstance?.accountLocked)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'error'))
printHtmlPart(19)
invokeTag('message','g',83,['code':("usuario.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(17)
invokeTag('checkBox','g',86,['name':("passwordExpired"),'value':(usuarioInstance?.passwordExpired)],-1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1430011370000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
