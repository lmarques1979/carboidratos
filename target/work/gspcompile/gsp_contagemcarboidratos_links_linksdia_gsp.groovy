import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_links_linksdia_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/links/_linksdia.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && ((((ano%4==0) && (ano%100!=0)) || (ano%400==0)))) {
printHtmlPart(0)
invokeTag('set','g',2,['var':("bisexto"),'value':(1.toInteger())],-1)
printHtmlPart(1)
}
else {
printHtmlPart(0)
invokeTag('set','g',5,['var':("bisexto"),'value':(0.toInteger())],-1)
printHtmlPart(1)
}
printHtmlPart(2)
invokeTag('message','g',10,['code':("selecionardia.label")],-1)
printHtmlPart(3)
createTagBody(1, {->
invokeTag('message','g',12,['code':("todos.label")],-1)
})
invokeTag('link','g',12,['class':(dia==0 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'0' , mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('link','g',13,['class':(dia==1 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'1', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(6, 1)
invokeTag('link','g',14,['class':(dia==2 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'2', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',15,['class':(dia==3 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'3', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(8, 1)
invokeTag('link','g',16,['class':(dia==4 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'4', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(9, 1)
invokeTag('link','g',17,['class':(dia==5 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'5', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(10, 1)
invokeTag('link','g',18,['class':(dia==6 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'6', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(11, 1)
invokeTag('link','g',19,['class':(dia==7 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'7', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(12, 1)
invokeTag('link','g',20,['class':(dia==8 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'8', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(13, 1)
invokeTag('link','g',21,['class':(dia==9 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'9', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(14, 1)
invokeTag('link','g',22,['class':(dia==10 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'10', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(15, 1)
invokeTag('link','g',23,['class':(dia==11 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'11', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(16, 1)
invokeTag('link','g',24,['class':(dia==12 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'12', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(17, 1)
invokeTag('link','g',25,['class':(dia==13 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'13', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(18, 1)
invokeTag('link','g',26,['class':(dia==14 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'14', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(19, 1)
invokeTag('link','g',27,['class':(dia==15 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'15', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(20, 1)
invokeTag('link','g',28,['class':(dia==16 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'16', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(21, 1)
invokeTag('link','g',29,['class':(dia==17 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'17', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(22, 1)
invokeTag('link','g',30,['class':(dia==18 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'18', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(23, 1)
invokeTag('link','g',31,['class':(dia==19 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'19', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(24, 1)
invokeTag('link','g',32,['class':(dia==20 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'20', mes:mes , ano:ano])],1)
printHtmlPart(25)
createClosureForHtmlPart(26, 1)
invokeTag('link','g',33,['class':(dia==21 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'21', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',34,['class':(dia==22 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'22', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(28, 1)
invokeTag('link','g',35,['class':(dia==23 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'23', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(29, 1)
invokeTag('link','g',36,['class':(dia==24 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'24', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(30, 1)
invokeTag('link','g',37,['class':(dia==25 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'25', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(31, 1)
invokeTag('link','g',38,['class':(dia==26 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'26', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(32, 1)
invokeTag('link','g',39,['class':(dia==27 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'27', mes:mes , ano:ano])],1)
printHtmlPart(4)
createClosureForHtmlPart(33, 1)
invokeTag('link','g',40,['class':(dia==28 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'28', mes:mes , ano:ano])],1)
printHtmlPart(34)
if(true && (((mes==2 && bisexto) || (mes!=2)))) {
printHtmlPart(35)
createClosureForHtmlPart(36, 2)
invokeTag('link','g',43,['class':(dia==29 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'29', mes:mes , ano:ano])],2)
printHtmlPart(25)
}
printHtmlPart(37)
if(true && (mes!=2)) {
printHtmlPart(35)
createClosureForHtmlPart(38, 2)
invokeTag('link','g',47,['class':(dia==30 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'30', mes:mes , ano:ano])],2)
printHtmlPart(35)
if(true && (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12)) {
printHtmlPart(39)
createClosureForHtmlPart(40, 3)
invokeTag('link','g',49,['class':(dia==31 ? 'atual' : 'dia'),'action':(params.action),'controller':(params.controller),'params':([dia:'31', mes:mes , ano:ano])],3)
printHtmlPart(35)
}
printHtmlPart(25)
}
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427812387000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
