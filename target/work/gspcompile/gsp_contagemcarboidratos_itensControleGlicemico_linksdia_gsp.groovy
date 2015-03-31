import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_itensControleGlicemico_linksdia_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/itensControleGlicemico/_linksdia.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("selecionardia.label")],-1)
printHtmlPart(1)
createTagBody(1, {->
invokeTag('message','g',6,['code':("todos.label")],-1)
})
invokeTag('link','g',6,['class':(dia==0 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'0'])],1)
printHtmlPart(2)
createClosureForHtmlPart(3, 1)
invokeTag('link','g',7,['class':(dia==1 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'1'])],1)
printHtmlPart(2)
createClosureForHtmlPart(4, 1)
invokeTag('link','g',8,['class':(dia==2 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'2'])],1)
printHtmlPart(2)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',9,['class':(dia==3 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'3'])],1)
printHtmlPart(2)
createClosureForHtmlPart(6, 1)
invokeTag('link','g',10,['class':(dia==4 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'4'])],1)
printHtmlPart(2)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',11,['class':(dia==5 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'5'])],1)
printHtmlPart(2)
createClosureForHtmlPart(8, 1)
invokeTag('link','g',12,['class':(dia==6 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'6'])],1)
printHtmlPart(2)
createClosureForHtmlPart(9, 1)
invokeTag('link','g',13,['class':(dia==7 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'7'])],1)
printHtmlPart(2)
createClosureForHtmlPart(10, 1)
invokeTag('link','g',14,['class':(dia==8 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'8'])],1)
printHtmlPart(2)
createClosureForHtmlPart(11, 1)
invokeTag('link','g',15,['class':(dia==9 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'9'])],1)
printHtmlPart(2)
createClosureForHtmlPart(12, 1)
invokeTag('link','g',16,['class':(dia==10 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'10'])],1)
printHtmlPart(2)
createClosureForHtmlPart(13, 1)
invokeTag('link','g',17,['class':(dia==11 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'11'])],1)
printHtmlPart(2)
createClosureForHtmlPart(14, 1)
invokeTag('link','g',18,['class':(dia==12 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'12'])],1)
printHtmlPart(2)
createClosureForHtmlPart(15, 1)
invokeTag('link','g',19,['class':(dia==13 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'13'])],1)
printHtmlPart(2)
createClosureForHtmlPart(16, 1)
invokeTag('link','g',20,['class':(dia==14 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'14'])],1)
printHtmlPart(2)
createClosureForHtmlPart(17, 1)
invokeTag('link','g',21,['class':(dia==15 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'15'])],1)
printHtmlPart(2)
createClosureForHtmlPart(18, 1)
invokeTag('link','g',22,['class':(dia==16 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'16'])],1)
printHtmlPart(2)
createClosureForHtmlPart(19, 1)
invokeTag('link','g',23,['class':(dia==17 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'17'])],1)
printHtmlPart(2)
createClosureForHtmlPart(20, 1)
invokeTag('link','g',24,['class':(dia==18 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'18'])],1)
printHtmlPart(2)
createClosureForHtmlPart(21, 1)
invokeTag('link','g',25,['class':(dia==19 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'19'])],1)
printHtmlPart(2)
createClosureForHtmlPart(22, 1)
invokeTag('link','g',26,['class':(dia==20 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'20'])],1)
printHtmlPart(23)
createClosureForHtmlPart(24, 1)
invokeTag('link','g',27,['class':(dia==21 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'21'])],1)
printHtmlPart(2)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',28,['class':(dia==22 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'22'])],1)
printHtmlPart(2)
createClosureForHtmlPart(26, 1)
invokeTag('link','g',29,['class':(dia==23 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'23'])],1)
printHtmlPart(2)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',30,['class':(dia==24 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'24'])],1)
printHtmlPart(2)
createClosureForHtmlPart(28, 1)
invokeTag('link','g',31,['class':(dia==25 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'25'])],1)
printHtmlPart(2)
createClosureForHtmlPart(29, 1)
invokeTag('link','g',32,['class':(dia==26 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'26'])],1)
printHtmlPart(2)
createClosureForHtmlPart(30, 1)
invokeTag('link','g',33,['class':(dia==27 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'27'])],1)
printHtmlPart(2)
createClosureForHtmlPart(31, 1)
invokeTag('link','g',34,['class':(dia==28 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'28'])],1)
printHtmlPart(2)
createClosureForHtmlPart(32, 1)
invokeTag('link','g',35,['class':(dia==29 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'29'])],1)
printHtmlPart(23)
if(true && (mes!=2)) {
printHtmlPart(33)
createClosureForHtmlPart(34, 2)
invokeTag('link','g',37,['class':(dia==30 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'30'])],2)
printHtmlPart(33)
if(true && (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12)) {
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',39,['class':(dia==31 ? 'atual' : ''),'action':(params.action),'controller':(params.controller),'params':([dia:'31'])],3)
printHtmlPart(33)
}
printHtmlPart(23)
}
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427766187000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
