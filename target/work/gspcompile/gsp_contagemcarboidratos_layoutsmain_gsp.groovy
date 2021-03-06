import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',3,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',4,[:],1)
printHtmlPart(0)
invokeTag('set','g',5,['var':("language"),'value':(session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'.toString())],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',15,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',15,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',15,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'apple-touch-icon.png'))
printHtmlPart(6)
expressionOut.print(assetPath(src: 'apple-touch-icon-retina.png'))
printHtmlPart(7)
invokeTag('stylesheet','asset',20,['src':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',21,['src':("application.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',22,[:],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',23,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(8)
invokeTag('image','asset',30,['class':("logo"),'src':(language=='en' ? 'logoen.png' : language=='es' ? 'logoes.png' : 'logo.png')],-1)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('image','asset',33,['class':("internacionalizacao"),'src':("bandeiras/24/Brazil.png"),'title':(message(code:'portuguesbrasil.label'))],-1)
})
invokeTag('link','g',33,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'pt_BR'])],2)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('image','asset',34,['class':("internacionalizacao"),'src':("bandeiras/24/britain.png"),'title':(message(code:'english.label'))],-1)
})
invokeTag('link','g',34,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'en'])],2)
printHtmlPart(11)
createTagBody(2, {->
invokeTag('image','asset',35,['class':("internacionalizacao"),'src':("bandeiras/24/spain.png"),'title':(message(code:'spain.label'))],-1)
})
invokeTag('link','g',35,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'es'])],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
if(true && (usuarioInstance)) {
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
invokeTag('image','asset',44,['class':("logousuario"),'src':(usuarioInstance.imagem ? usuarioInstance.imagem : 'noimage.png'),'title':(usuarioInstance.buscaNome(usuarioInstance) + ' [' + usuarioInstance.username + ']')],-1)
printHtmlPart(14)
})
invokeTag('link','g',45,['controller':("usuario"),'action':("show"),'id':(usuarioInstance.id)],4)
printHtmlPart(10)
}
printHtmlPart(16)
})
invokeTag('ifLoggedIn','sec',48,[:],2)
printHtmlPart(17)
createTagBody(2, {->
invokeTag('message','g',52,['code':("paginalprincipal.label")],-1)
})
invokeTag('link','g',52,['class':(params.controller=='index' && params.action=='index' ? 'active' : ''),'controller':("Index"),'action':("index")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',54,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',54,['class':(params.controller=='alimento' && params.action=='index' ? 'active' : ''),'controller':("Alimento"),'action':("index")],3)
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',55,['code':("cadastrousuario.label")],-1)
})
invokeTag('link','g',55,['class':(params.controller=='usuario' && params.action=='create' ? 'active' : ''),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',56,['code':("login.label")],-1)
})
invokeTag('link','g',56,['class':(params.controller=='login' && params.action=='auth' ? 'active' : ''),'controller':("login"),'action':("auth")],3)
printHtmlPart(18)
})
invokeTag('ifNotLoggedIn','sec',57,[:],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(14)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(21)
createTagBody(4, {->
invokeTag('message','g',60,['code':("usuario.list.label")],-1)
})
invokeTag('link','g',60,['class':(params.controller=='usuario' ? 'active' : ''),'controller':("Usuario"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',61,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',61,['class':(params.controller=='alimento'  && params.action!='create' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',62,['code':("cadastroalimento.label")],-1)
})
invokeTag('link','g',62,['class':(params.controller=='alimento'  && params.action=='create' ? 'active' : ''),'controller':("Alimento"),'action':("create")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',63,['code':("configuracoes.label")],-1)
})
invokeTag('link','g',63,['class':(params.controller=='configuracoes' ? 'active' : ''),'controller':("Configuracoes"),'action':("index")],4)
printHtmlPart(23)
}
else {
printHtmlPart(21)
createTagBody(4, {->
invokeTag('message','g',66,['code':("configuracao.label")],-1)
})
invokeTag('link','g',66,['class':(params.controller=='configuracao' ? 'active' : ''),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',67,['code':("refeicao.label")],-1)
})
invokeTag('link','g',67,['class':(params.controller=='refeicao' ? 'active' : ''),'controller':("Refeicao"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',68,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',68,['class':(params.controller=='alimento' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',69,['code':("contagem.label")],-1)
})
invokeTag('link','g',69,['class':(params.controller=='contagemCarboidratosAlimento' && params.action=='index'? 'active' : ''),'controller':("ContagemCarboidratosAlimento"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',70,['code':("controle.label")],-1)
})
invokeTag('link','g',70,['class':(params.controller=='itensControleGlicemico' ? 'active' : ''),'controller':("ItensControleGlicemico"),'action':("index")],4)
printHtmlPart(24)
}
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',73,['code':("logout.label")],-1)
})
invokeTag('link','g',73,['controller':("Logout"),'action':("index")],3)
printHtmlPart(18)
})
invokeTag('ifLoggedIn','sec',74,[:],2)
printHtmlPart(25)
invokeTag('layoutBody','g',80,[:],-1)
printHtmlPart(26)
invokeTag('message','g',81,['code':("footer.label")],-1)
printHtmlPart(27)
invokeTag('message','g',82,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
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
public static final long LAST_MODIFIED = 1430012254000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
