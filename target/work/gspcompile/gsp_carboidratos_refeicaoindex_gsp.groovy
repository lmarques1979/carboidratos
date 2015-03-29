import carboidratos.Refeicao
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_carboidratos_refeicaoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/refeicao/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'refeicao.label', default: 'Refeicao'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("refeicao.list.label")],-1)
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
invokeTag('message','g',14,['code':("refeicao.new.label")],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('sortableColumn','g',25,['property':("descricao"),'title':(message(code: 'refeicao.descricao.label', default: 'Descricao'))],-1)
printHtmlPart(10)
invokeTag('sortableColumn','g',27,['property':("ordemrefeicao"),'title':(message(code: 'refeicao.ordemrefeicao.label', default: 'Ordemrefeicao'))],-1)
printHtmlPart(11)
loop:{
int i = 0
for( refeicaoInstance in (refeicaoInstanceList) ) {
printHtmlPart(12)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(13)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: refeicaoInstance, field: "descricao"))
})
invokeTag('link','g',36,['action':("show"),'id':(refeicaoInstance.id)],3)
printHtmlPart(14)
expressionOut.print(fieldValue(bean: refeicaoInstance, field: "ordemrefeicao"))
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
invokeTag('paginate','g',46,['total':(refeicaoInstanceCount ?: 0)],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',49,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426779445000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
