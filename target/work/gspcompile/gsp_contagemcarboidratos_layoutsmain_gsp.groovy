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
createTagBody(2, {->
invokeTag('image','asset',29,['class':("internacionalizacao"),'src':("bandeiras/24/Brazil.png"),'title':(message(code:'portuguesbrasil.label'))],-1)
})
invokeTag('link','g',29,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'pt_BR'])],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('image','asset',30,['class':("internacionalizacao"),'src':("bandeiras/24/britain.png"),'title':(message(code:'english.label'))],-1)
})
invokeTag('link','g',30,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'en'])],2)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('image','asset',31,['class':("internacionalizacao"),'src':("bandeiras/24/spain.png"),'title':(message(code:'spain.label'))],-1)
})
invokeTag('link','g',31,['id':(params.id),'action':(params.action ? params.action : 'index'),'controller':(params.controller ? params.controller : 'index'),'params':([lang: 'es'])],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
if(true && (usuarioInstance)) {
printHtmlPart(13)
createTagBody(4, {->
printHtmlPart(14)
expressionOut.print(usuarioInstance.buscaNome(usuarioInstance) + ' [ ' + usuarioInstance.username + ' ] ')
printHtmlPart(13)
})
invokeTag('link','g',39,['controller':("usuario"),'action':("show"),'id':(usuarioInstance.id)],4)
printHtmlPart(15)
}
printHtmlPart(16)
})
invokeTag('ifLoggedIn','sec',43,[:],2)
printHtmlPart(17)
createTagBody(2, {->
invokeTag('message','g',49,['code':("paginalprincipal.label")],-1)
})
invokeTag('link','g',49,['class':(params.controller=='index' && params.action=='index' ? 'active' : ''),'controller':("Index"),'action':("index")],2)
printHtmlPart(18)
createTagBody(2, {->
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',51,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',51,['class':(params.controller=='alimento' && params.action=='index' ? 'active' : ''),'controller':("Alimento"),'action':("index")],3)
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',52,['code':("cadastrousuario.label")],-1)
})
invokeTag('link','g',52,['class':(params.controller=='usuario' && params.action=='create' ? 'active' : ''),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',53,['code':("login.label")],-1)
})
invokeTag('link','g',53,['class':(params.controller=='login' && params.action=='auth' ? 'active' : ''),'controller':("login"),'action':("auth")],3)
printHtmlPart(18)
})
invokeTag('ifNotLoggedIn','sec',54,[:],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(15)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(21)
createTagBody(4, {->
invokeTag('message','g',57,['code':("usuario.list.label")],-1)
})
invokeTag('link','g',57,['class':(params.controller=='usuario' ? 'active' : ''),'controller':("Usuario"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',58,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',58,['class':(params.controller=='alimento'  && params.action!='create' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',59,['code':("cadastroalimento.label")],-1)
})
invokeTag('link','g',59,['class':(params.controller=='alimento'  && params.action=='create' ? 'active' : ''),'controller':("Alimento"),'action':("create")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',60,['code':("configuracoes.label")],-1)
})
invokeTag('link','g',60,['class':(params.controller=='configuracoes' ? 'active' : ''),'controller':("Configuracoes"),'action':("index")],4)
printHtmlPart(23)
}
else {
printHtmlPart(21)
createTagBody(4, {->
invokeTag('message','g',63,['code':("configuracao.label")],-1)
})
invokeTag('link','g',63,['class':(params.controller=='configuracao' ? 'active' : ''),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',64,['code':("refeicao.label")],-1)
})
invokeTag('link','g',64,['class':(params.controller=='refeicao' ? 'active' : ''),'controller':("Refeicao"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',65,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',65,['class':(params.controller=='alimento' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',66,['code':("contagem.label")],-1)
})
invokeTag('link','g',66,['class':(params.controller=='contagemCarboidratosAlimento' && params.action=='index'? 'active' : ''),'controller':("ContagemCarboidratosAlimento"),'action':("index")],4)
printHtmlPart(22)
createTagBody(4, {->
invokeTag('message','g',67,['code':("controle.label")],-1)
})
invokeTag('link','g',67,['class':(params.controller=='itensControleGlicemico' ? 'active' : ''),'controller':("ItensControleGlicemico"),'action':("index")],4)
printHtmlPart(24)
}
printHtmlPart(19)
createTagBody(3, {->
invokeTag('message','g',70,['code':("logout.label")],-1)
})
invokeTag('link','g',70,['controller':("Logout"),'action':("index")],3)
printHtmlPart(18)
})
invokeTag('ifLoggedIn','sec',71,[:],2)
printHtmlPart(25)
invokeTag('layoutBody','g',76,[:],-1)
printHtmlPart(26)
invokeTag('message','g',77,['code':("footer.label")],-1)
printHtmlPart(27)
invokeTag('message','g',78,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427832383000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
