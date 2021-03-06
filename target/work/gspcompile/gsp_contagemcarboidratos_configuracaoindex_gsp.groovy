import carboidratos.Configuracao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_configuracaoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/configuracao/index.gsp" }
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
invokeTag('message','g',7,['code':("configuracao.list.label")],-1)
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
if(true && (configuracaoInstanceCount==0)) {
printHtmlPart(5)
createTagBody(3, {->
invokeTag('message','g',14,['code':("configuracao.create.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],3)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('sortableColumn','g',26,['property':("alturaimagens"),'title':(message(code: 'configuracao.alturaimagens.label', default: 'Alturaimagens'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("larguraimagens"),'title':(message(code: 'configuracao.larguraimagens.label', default: 'Larguraimagens'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',30,['property':("alturaimagensthumbs"),'title':(message(code: 'configuracao.alturaimagensthumbs.label', default: 'Alturaimagensthumbs'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',32,['property':("larguraimagensthumbs"),'title':(message(code: 'configuracao.larguraimagensthumbs.label', default: 'Larguraimagensthumbs'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',34,['property':("itensporpagina"),'title':(message(code: 'configuracao.itensporpagina.label', default: 'Itensporpagina'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',36,['property':("metaglicose"),'title':(message(code: 'configuracao.metaglicose.label', default: 'Alturaimagens'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',38,['property':("sensibilidadeinsulina"),'title':(message(code: 'configuracao.sensibilidadeinsulina.label', default: 'Alturaimagens'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',40,['property':("sensibilidadecarboidrato"),'title':(message(code: 'configuracao.sensibilidadecarboidrato.label', default: 'Alturaimagens'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',42,['property':("qtdinsulinarepositorio"),'title':(message(code: 'configuracao.qtdinsulinarepositorio.label', default: 'Alturaimagens'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( configuracaoInstance in (configuracaoInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "alturaimagens"))
})
invokeTag('link','g',49,['action':("show"),'id':(configuracaoInstance.id)],3)
printHtmlPart(16)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "larguraimagens"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "alturaimagensthumbs"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "larguraimagensthumbs"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "itensporpagina"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "metaglicose"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "sensibilidadeinsulina"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "sensibilidadecarboidrato"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: configuracaoInstance, field: "qtdinsulinarepositorio"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',72,['total':(configuracaoInstanceCount ?: 0)],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',75,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427972523000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
