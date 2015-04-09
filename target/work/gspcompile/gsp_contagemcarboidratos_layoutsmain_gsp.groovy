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
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',14,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(4)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'apple-touch-icon.png'))
printHtmlPart(6)
expressionOut.print(assetPath(src: 'apple-touch-icon-retina.png'))
printHtmlPart(7)
invokeTag('stylesheet','asset',19,['src':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',20,['src':("application.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',21,[:],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(8)
if(true && (params.lang=='en')) {
printHtmlPart(9)
invokeTag('image','asset',29,['class':("logo"),'src':("logoen.png")],-1)
printHtmlPart(10)
}
else if(true && (params.lang=='es')) {
printHtmlPart(9)
invokeTag('image','asset',32,['class':("logo"),'src':("logoes.png")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(9)
invokeTag('image','asset',35,['class':("logo"),'src':("logo.png")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
invokeTag('image','asset',40,['class':("internacionalizacao"),'src':("bandeiras/24/Brazil.png"),'title':(message(code:'portuguesbrasil.label'))],-1)
})
invokeTag('link','g',40,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'pt_BR'])],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('image','asset',41,['class':("internacionalizacao"),'src':("bandeiras/24/britain.png"),'title':(message(code:'english.label'))],-1)
})
invokeTag('link','g',41,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'en'])],2)
printHtmlPart(12)
createTagBody(2, {->
invokeTag('image','asset',42,['class':("internacionalizacao"),'src':("bandeiras/24/spain.png"),'title':(message(code:'spain.label'))],-1)
})
invokeTag('link','g',42,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'es'])],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
if(true && (usuarioInstance)) {
printHtmlPart(15)
createTagBody(4, {->
printHtmlPart(16)
expressionOut.print(usuarioInstance.buscaNome(usuarioInstance) + ' [ ' + usuarioInstance.username + ' ] ')
printHtmlPart(15)
})
invokeTag('link','g',50,['controller':("usuario"),'action':("show"),'id':(usuarioInstance.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
})
invokeTag('ifLoggedIn','sec',54,[:],2)
printHtmlPart(19)
createTagBody(2, {->
invokeTag('message','g',60,['code':("paginalprincipal.label")],-1)
})
invokeTag('link','g',60,['class':(params.controller=='index' && params.action=='index' ? 'active' : ''),'controller':("Index"),'action':("index")],2)
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
createTagBody(3, {->
invokeTag('message','g',62,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',62,['class':(params.controller=='alimento' && params.action=='index' ? 'active' : ''),'controller':("Alimento"),'action':("index")],3)
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',63,['code':("cadastrousuario.label")],-1)
})
invokeTag('link','g',63,['class':(params.controller=='usuario' && params.action=='create' ? 'active' : ''),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(22)
createTagBody(3, {->
invokeTag('message','g',64,['code':("login.label")],-1)
})
invokeTag('link','g',64,['class':(params.controller=='login' && params.action=='auth' ? 'active' : ''),'controller':("login"),'action':("auth")],3)
printHtmlPart(20)
})
invokeTag('ifNotLoggedIn','sec',65,[:],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(17)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(23)
createTagBody(4, {->
invokeTag('message','g',68,['code':("usuario.list.label")],-1)
})
invokeTag('link','g',68,['class':(params.controller=='usuario' ? 'active' : ''),'controller':("Usuario"),'action':("index")],4)
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',69,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',69,['class':(params.controller=='alimento'  && params.action!='create' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',70,['code':("cadastroalimento.label")],-1)
})
invokeTag('link','g',70,['class':(params.controller=='alimento'  && params.action=='create' ? 'active' : ''),'controller':("Alimento"),'action':("create")],4)
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',71,['code':("configuracoes.label")],-1)
})
invokeTag('link','g',71,['class':(params.controller=='configuracoes' ? 'active' : ''),'controller':("Configuracoes"),'action':("index")],4)
printHtmlPart(25)
}
else {
printHtmlPart(23)
createTagBody(4, {->
invokeTag('message','g',74,['code':("configuracao.label")],-1)
})
invokeTag('link','g',74,['class':(params.controller=='configuracao' ? 'active' : ''),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',75,['code':("refeicao.label")],-1)
})
invokeTag('link','g',75,['class':(params.controller=='refeicao' ? 'active' : ''),'controller':("Refeicao"),'action':("index")],4)
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',76,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',76,['class':(params.controller=='alimento' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',77,['code':("contagem.label")],-1)
})
invokeTag('link','g',77,['class':(params.controller=='contagemCarboidratosAlimento' && params.action=='index'? 'active' : ''),'controller':("ContagemCarboidratosAlimento"),'action':("index")],4)
printHtmlPart(24)
createTagBody(4, {->
invokeTag('message','g',78,['code':("controle.label")],-1)
})
invokeTag('link','g',78,['class':(params.controller=='itensControleGlicemico' ? 'active' : ''),'controller':("ItensControleGlicemico"),'action':("index")],4)
printHtmlPart(26)
}
printHtmlPart(21)
createTagBody(3, {->
invokeTag('message','g',81,['code':("logout.label")],-1)
})
invokeTag('link','g',81,['controller':("Logout"),'action':("index")],3)
printHtmlPart(20)
})
invokeTag('ifLoggedIn','sec',82,[:],2)
printHtmlPart(27)
invokeTag('layoutBody','g',87,[:],-1)
printHtmlPart(28)
invokeTag('message','g',88,['code':("footer.label")],-1)
printHtmlPart(29)
invokeTag('message','g',89,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1428583591000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
