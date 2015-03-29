import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_layoutsmain_gsp extends GroovyPage {
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
createTagBody(3, {->
invokeTag('message','g',40,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',40,['class':(params.controller=='alimento' && params.action=='index' ? 'active' : ''),'controller':("Alimento"),'action':("index")],3)
printHtmlPart(13)
createTagBody(3, {->
invokeTag('message','g',41,['code':("cadastrousuario.label")],-1)
})
invokeTag('link','g',41,['class':(params.controller=='usuario' && params.action=='create' ? 'active' : ''),'controller':("Usuario"),'action':("create")],3)
printHtmlPart(13)
createTagBody(3, {->
invokeTag('message','g',42,['code':("login.label")],-1)
})
invokeTag('link','g',42,['class':(params.controller=='login' && params.action=='auth' ? 'active' : ''),'controller':("login"),'action':("auth")],3)
printHtmlPart(14)
})
invokeTag('ifNotLoggedIn','sec',43,[:],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(15)
if(true && (sec.loggedInUserInfo(field: 'username') == 'admin')) {
printHtmlPart(16)
createTagBody(4, {->
invokeTag('message','g',46,['code':("usuario.list.label")],-1)
})
invokeTag('link','g',46,['class':(params.controller=='usuario' ? 'active' : ''),'controller':("Usuario"),'action':("index")],4)
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',47,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',47,['class':(params.controller=='alimento'  && params.action!='create' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',48,['code':("cadastroalimento.label")],-1)
})
invokeTag('link','g',48,['class':(params.controller=='alimento'  && params.action=='create' ? 'active' : ''),'controller':("Alimento"),'action':("create")],4)
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',49,['code':("configuracoes.label")],-1)
})
invokeTag('link','g',49,['class':(params.controller=='configuracoes' ? 'active' : ''),'controller':("Configuracoes"),'action':("index")],4)
printHtmlPart(18)
}
else {
printHtmlPart(16)
createTagBody(4, {->
invokeTag('message','g',52,['code':("configuracao.label")],-1)
})
invokeTag('link','g',52,['class':(params.controller=='configuracao' ? 'active' : ''),'controller':("Configuracao"),'action':("index")],4)
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',53,['code':("refeicao.label")],-1)
})
invokeTag('link','g',53,['class':(params.controller=='refeicao' ? 'active' : ''),'controller':("Refeicao"),'action':("index")],4)
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',54,['code':("listaalimentos.label")],-1)
})
invokeTag('link','g',54,['class':(params.controller=='alimento' ? 'active' : ''),'controller':("Alimento"),'action':("index")],4)
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',55,['code':("controle.label")],-1)
})
invokeTag('link','g',55,['class':(params.controller=='itensControleGlicemico' ? 'active' : ''),'controller':("ItensControleGlicemico"),'action':("index")],4)
printHtmlPart(17)
createTagBody(4, {->
invokeTag('message','g',56,['code':("contagem.label")],-1)
})
invokeTag('link','g',56,['class':(params.controller=='contagemCarboidratosAlimento' && params.action=='index'? 'active' : ''),'controller':("ContagemCarboidratosAlimento"),'action':("index")],4)
printHtmlPart(18)
}
printHtmlPart(12)
createTagBody(3, {->
invokeTag('message','g',58,['code':("logout.label")],-1)
})
invokeTag('link','g',58,['controller':("Logout"),'action':("index")],3)
printHtmlPart(14)
})
invokeTag('ifLoggedIn','sec',59,[:],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
if(true && (usuarioInstance.imagem)) {
printHtmlPart(21)
createTagBody(4, {->
printHtmlPart(22)
invokeTag('image','asset',66,['height':("40"),'width':("40"),'src':(usuarioInstance.imagem),'title':(usuarioInstance.buscaNome(usuarioInstance) + ' [ ' + usuarioInstance.username + ' ] ')],-1)
printHtmlPart(21)
})
invokeTag('link','g',67,['controller':("usuario"),'action':("show"),'id':(usuarioInstance.id)],4)
printHtmlPart(15)
}
else {
printHtmlPart(21)
createTagBody(4, {->
printHtmlPart(22)
invokeTag('image','asset',71,['height':("40"),'width':("40"),'src':("noimage.jpg"),'title':(usuarioInstance.buscaNome(usuarioInstance) + ' [ ' + usuarioInstance.username + ' ] ')],-1)
printHtmlPart(21)
})
invokeTag('link','g',72,['class':("usuario"),'controller':("Usuario"),'action':("show"),'id':(sec.loggedInUserInfo(field:"id"))],4)
printHtmlPart(15)
}
printHtmlPart(23)
})
invokeTag('ifLoggedIn','sec',75,[:],2)
printHtmlPart(24)
invokeTag('layoutBody','g',78,[:],-1)
printHtmlPart(25)
invokeTag('message','g',79,['code':("footer.label")],-1)
printHtmlPart(26)
invokeTag('message','g',80,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',81,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427407137000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
