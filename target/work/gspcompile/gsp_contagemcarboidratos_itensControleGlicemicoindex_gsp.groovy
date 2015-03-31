import carboidratos.ItensControleGlicemico
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_itensControleGlicemicoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/itensControleGlicemico/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',4,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',5,[:],1)
printHtmlPart(0)
if(true && (params.mes)) {
printHtmlPart(1)
invokeTag('set','g',7,['var':("mes"),'value':(params.int('mes'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',10,['var':("mes"),'value':(formatDate(format:"MM" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(0)
if(true && (params.dia)) {
printHtmlPart(1)
invokeTag('set','g',13,['var':("dia"),'value':(params.int('dia'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',16,['var':("dia"),'value':(formatDate(format:"dd" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',21,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',22,['var':("entityName"),'value':(message(code: 'controleGlicemico.label', default: 'ControleGlicemico'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',23,['code':("controle.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',23,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',23,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',27,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',37,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',38,['bean':(itensControleGlicemicoInstance),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',40,['bean':(itensControleGlicemicoInstance)],2)
printHtmlPart(8)
if(true && (flash.error)) {
printHtmlPart(16)
loop:{
int i = 0
for( error in (flash.error) ) {
printHtmlPart(17)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(11)
expressionOut.print(error.field)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',45,['error':(error)],-1)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('select','g',52,['onchange':("this.form.submit()"),'value':(mes),'name':("mes"),'from':([message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(21)
invokeTag('field','g',53,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("ano"),'value':(ano),'type':("number")],-1)
printHtmlPart(22)
})
invokeTag('form','g',54,['url':([resource:itensControleGlicemicoInstance, action:'index'])],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',58,['name':("mes"),'value':(mes)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',59,['name':("ano"),'value':(ano)],-1)
printHtmlPart(25)
invokeTag('message','g',64,['code':("controle.new.label")],-1)
printHtmlPart(26)
invokeTag('message','g',68,['code':("controle.dia.label")],-1)
printHtmlPart(27)
invokeTag('message','g',69,['code':("controle.refeicao.label")],-1)
printHtmlPart(27)
invokeTag('message','g',70,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(27)
invokeTag('message','g',71,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',72,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',73,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(27)
invokeTag('message','g',74,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',75,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',76,['code':("controle.observacao.label")],-1)
printHtmlPart(28)
invokeTag('field','g',86,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(29)
invokeTag('select','g',88,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(30)
invokeTag('field','g',90,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',91,['class':("qtd"),'size':("4"),'name':("valorglicemiapre"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',92,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapre"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',93,['class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',94,['class':("qtd"),'size':("4"),'name':("valorglicemiapos"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',95,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapos"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('textField','g',96,['name':("observacao"),'class':("obs")],-1)
printHtmlPart(32)
invokeTag('submitButton','g',103,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(33)
})
invokeTag('form','g',110,['class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'save'])],2)
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
invokeTag('image','asset',115,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',116,['controller':("ItensControleGlicemico"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(35)
invokeTag('image','asset',119,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',120,['controller':("ItensControleGlicemico"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(37)
invokeTag('image','asset',122,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(38)
invokeTag('render','g',127,['template':("linksdia")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(39)
invokeTag('message','g',134,['code':("controle.list.label")],-1)
printHtmlPart(26)
invokeTag('message','g',138,['code':("controle.dia.label")],-1)
printHtmlPart(40)
invokeTag('message','g',140,['code':("controle.refeicao.label")],-1)
printHtmlPart(27)
invokeTag('message','g',141,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(27)
invokeTag('message','g',142,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',143,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',144,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(27)
invokeTag('message','g',145,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',146,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',147,['code':("controle.observacao.label")],-1)
printHtmlPart(41)
invokeTag('set','g',153,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',154,['name':("mes"),'value':(mes)],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',155,['name':("ano"),'value':(ano)],-1)
printHtmlPart(35)
loop:{
int j = 0
for( itensControleGlicemicoInstance in (itensControleGlicemicoInstanceList) ) {
printHtmlPart(42)
invokeTag('hiddenField','g',158,['name':("id"),'value':(itensControleGlicemicoInstance.id)],-1)
printHtmlPart(43)
invokeTag('set','g',159,['var':("diaatual"),'value':(itensControleGlicemicoInstance.controleglicemico.dia)],-1)
printHtmlPart(42)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(44)
expressionOut.print(itensControleGlicemicoInstance.controleglicemico.dia)
printHtmlPart(45)
createTagBody(5, {->
invokeTag('image','asset',165,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',165,['onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.controleglicemico.id),'action':("delete"),'controller':("ControleGlicemico")],5)
printHtmlPart(46)
}
printHtmlPart(47)
invokeTag('select','g',174,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'value':(itensControleGlicemicoInstance.refeicao.id),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(48)
invokeTag('field','g',176,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinelenta)],-1)
printHtmlPart(49)
invokeTag('field','g',177,['class':("qtd"),'size':("4"),'name':("valorglicemiapre"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapre)],-1)
printHtmlPart(49)
invokeTag('field','g',178,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapre"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapre)],-1)
printHtmlPart(49)
invokeTag('field','g',179,['class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdcarboidrato)],-1)
printHtmlPart(49)
invokeTag('field','g',180,['class':("qtd"),'size':("4"),'name':("valorglicemiapos"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapos)],-1)
printHtmlPart(49)
invokeTag('field','g',181,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapos"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapos)],-1)
printHtmlPart(49)
invokeTag('textField','g',182,['name':("observacao"),'class':("obs"),'value':(itensControleGlicemicoInstance.observacao)],-1)
printHtmlPart(50)
createTagBody(4, {->
invokeTag('image','asset',184,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',184,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.id),'action':("delete"),'controller':("ItensControleGlicemico")],4)
printHtmlPart(51)
invokeTag('set','g',187,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(35)
j++
}
}
printHtmlPart(52)
invokeTag('actionSubmit','g',196,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(53)
})
invokeTag('form','g',202,['class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'update'])],2)
printHtmlPart(54)
invokeTag('paginate','g',205,['total':(controleGlicemicoInstanceCount ?: 0)],-1)
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',208,[:],1)
printHtmlPart(56)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427766266000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
