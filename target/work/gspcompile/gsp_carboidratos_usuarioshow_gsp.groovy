import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_usuarioshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'usuario.label', default: 'Usuario'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("usuario.show.label")],-1)
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
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(8)
expressionOut.print(error.field)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('message','g',17,['error':(error)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',18,['bean':(usuarioInstance),'var':("error")],3)
printHtmlPart(12)
})
invokeTag('hasErrors','g',20,['bean':(usuarioInstance)],2)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(13)
if(true && (flash.erros)) {
printHtmlPart(6)
loop:{
int i = 0
for( erro in (flash.erros) ) {
printHtmlPart(16)
expressionOut.print(erro)
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
}
else {
printHtmlPart(17)
if(true && (usuarioInstance?.username)) {
printHtmlPart(18)
invokeTag('message','g',36,['code':("usuario.username.label"),'default':("Username")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',38,['bean':(usuarioInstance),'field':("username")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.email)) {
printHtmlPart(22)
invokeTag('message','g',45,['code':("usuario.email.label"),'default':("Email")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',47,['bean':(usuarioInstance),'field':("email")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.primeironome)) {
printHtmlPart(24)
invokeTag('message','g',54,['code':("usuario.primeironome.label"),'default':("Primeironome")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',56,['bean':(usuarioInstance),'field':("primeironome")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.sobrenome)) {
printHtmlPart(26)
invokeTag('message','g',63,['code':("usuario.sobrenome.label"),'default':("Sobrenome")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',65,['bean':(usuarioInstance),'field':("sobrenome")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.imagem)) {
printHtmlPart(28)
invokeTag('message','g',72,['code':("usuario.imagem.label"),'default':("Imagem")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',74,['bean':(usuarioInstance),'field':("imagem")],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.accountExpired)) {
printHtmlPart(30)
invokeTag('message','g',81,['code':("usuario.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(31)
invokeTag('formatBoolean','g',83,['boolean':(usuarioInstance?.accountExpired)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.accountLocked)) {
printHtmlPart(32)
invokeTag('message','g',90,['code':("usuario.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(33)
invokeTag('formatBoolean','g',92,['boolean':(usuarioInstance?.accountLocked)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.enabled)) {
printHtmlPart(34)
invokeTag('message','g',99,['code':("usuario.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(35)
invokeTag('formatBoolean','g',101,['boolean':(usuarioInstance?.enabled)],-1)
printHtmlPart(20)
}
printHtmlPart(21)
if(true && (usuarioInstance?.passwordExpired)) {
printHtmlPart(36)
invokeTag('message','g',108,['code':("usuario.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(37)
invokeTag('formatBoolean','g',110,['boolean':(usuarioInstance?.passwordExpired)],-1)
printHtmlPart(20)
}
printHtmlPart(38)
createTagBody(3, {->
printHtmlPart(39)
createTagBody(4, {->
invokeTag('message','g',118,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',118,['class':("edit"),'action':("edit"),'resource':(usuarioInstance)],4)
printHtmlPart(40)
invokeTag('actionSubmit','g',119,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(41)
})
invokeTag('form','g',121,['url':([resource:usuarioInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(13)
}
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425924538000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
