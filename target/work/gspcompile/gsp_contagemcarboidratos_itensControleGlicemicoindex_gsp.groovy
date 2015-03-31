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
if(true && (params.ano)) {
printHtmlPart(1)
invokeTag('set','g',7,['var':("ano"),'value':(params.int('ano'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',10,['var':("ano"),'value':(formatDate(format:"yyyy" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(0)
if(true && (params.mes)) {
printHtmlPart(1)
invokeTag('set','g',13,['var':("mes"),'value':(params.int('mes'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',16,['var':("mes"),'value':(formatDate(format:"MM" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(0)
if(true && (params.dia)) {
printHtmlPart(1)
invokeTag('set','g',19,['var':("dia"),'value':(params.int('dia'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',22,['var':("dia"),'value':(formatDate(format:"dd" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',27,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',28,['var':("entityName"),'value':(message(code: 'controleGlicemico.label', default: 'ControleGlicemico'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',29,['code':("controle.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',29,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',29,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',30,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',33,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
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
invokeTag('message','g',43,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',44,['bean':(itensControleGlicemicoInstance),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',46,['bean':(itensControleGlicemicoInstance)],2)
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
invokeTag('message','g',51,['error':(error)],-1)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('select','g',58,['onchange':("this.form.submit()"),'value':(mes),'name':("mes"),'from':([message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(21)
invokeTag('field','g',59,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("ano"),'value':(ano),'type':("number")],-1)
printHtmlPart(22)
})
invokeTag('form','g',60,['url':([resource:itensControleGlicemicoInstance, action:'index'])],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',64,['name':("mes"),'value':(mes)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',65,['name':("ano"),'value':(ano)],-1)
printHtmlPart(25)
invokeTag('message','g',70,['code':("controle.new.label")],-1)
printHtmlPart(26)
invokeTag('message','g',74,['code':("controle.dia.label")],-1)
printHtmlPart(27)
invokeTag('message','g',75,['code':("controle.refeicao.label")],-1)
printHtmlPart(27)
invokeTag('message','g',76,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(27)
invokeTag('message','g',77,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',78,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',79,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(27)
invokeTag('message','g',80,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',81,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',82,['code':("controle.observacao.label")],-1)
printHtmlPart(28)
invokeTag('field','g',92,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(29)
invokeTag('select','g',94,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(30)
invokeTag('field','g',96,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',97,['class':("qtd"),'size':("4"),'name':("valorglicemiapre"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',98,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapre"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',99,['class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(31)
invokeTag('field','g',100,['class':("qtd"),'size':("4"),'name':("valorglicemiapos"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('field','g',101,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapos"),'type':("number")],-1)
printHtmlPart(31)
invokeTag('textField','g',102,['name':("observacao"),'class':("obs")],-1)
printHtmlPart(32)
invokeTag('submitButton','g',109,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(33)
})
invokeTag('form','g',116,['class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'save'])],2)
printHtmlPart(34)
createTagBody(2, {->
printHtmlPart(35)
invokeTag('image','asset',121,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',122,['controller':("ItensControleGlicemico"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(35)
invokeTag('image','asset',125,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',126,['controller':("ItensControleGlicemico"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(37)
invokeTag('image','asset',128,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(38)
invokeTag('render','g',133,['template':("/links/linksdia")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(39)
invokeTag('message','g',140,['code':("controle.list.label")],-1)
printHtmlPart(26)
invokeTag('message','g',144,['code':("controle.dia.label")],-1)
printHtmlPart(40)
invokeTag('message','g',146,['code':("controle.refeicao.label")],-1)
printHtmlPart(27)
invokeTag('message','g',147,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(27)
invokeTag('message','g',148,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',149,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(27)
invokeTag('message','g',150,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(27)
invokeTag('message','g',151,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',152,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(27)
invokeTag('message','g',153,['code':("controle.observacao.label")],-1)
printHtmlPart(41)
invokeTag('set','g',159,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',160,['name':("mes"),'value':(mes)],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',161,['name':("ano"),'value':(ano)],-1)
printHtmlPart(35)
loop:{
int j = 0
for( itensControleGlicemicoInstance in (itensControleGlicemicoInstanceList) ) {
printHtmlPart(42)
invokeTag('hiddenField','g',164,['name':("id"),'value':(itensControleGlicemicoInstance.id)],-1)
printHtmlPart(43)
invokeTag('set','g',165,['var':("diaatual"),'value':(itensControleGlicemicoInstance.controleglicemico.dia)],-1)
printHtmlPart(42)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(44)
expressionOut.print(itensControleGlicemicoInstance.controleglicemico.dia)
printHtmlPart(45)
createTagBody(5, {->
invokeTag('image','asset',171,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',171,['onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.controleglicemico.id),'action':("delete"),'controller':("ControleGlicemico")],5)
printHtmlPart(46)
}
printHtmlPart(47)
invokeTag('select','g',180,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'value':(itensControleGlicemicoInstance.refeicao.id),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(48)
invokeTag('field','g',182,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinelenta)],-1)
printHtmlPart(49)
invokeTag('field','g',183,['class':("qtd"),'size':("4"),'name':("valorglicemiapre"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapre)],-1)
printHtmlPart(49)
invokeTag('field','g',184,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapre"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapre)],-1)
printHtmlPart(49)
invokeTag('field','g',185,['class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.1"),'value':(itensControleGlicemicoInstance.qtdcarboidrato)],-1)
printHtmlPart(49)
invokeTag('field','g',186,['class':("qtd"),'size':("4"),'name':("valorglicemiapos"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapos)],-1)
printHtmlPart(49)
invokeTag('field','g',187,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapos"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapos)],-1)
printHtmlPart(49)
invokeTag('textField','g',188,['name':("observacao"),'class':("obs"),'value':(itensControleGlicemicoInstance.observacao)],-1)
printHtmlPart(50)
createTagBody(4, {->
invokeTag('image','asset',190,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',190,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.id),'action':("delete"),'controller':("ItensControleGlicemico")],4)
printHtmlPart(51)
invokeTag('set','g',193,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(35)
j++
}
}
printHtmlPart(52)
invokeTag('actionSubmit','g',202,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(53)
})
invokeTag('form','g',208,['class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'update'])],2)
printHtmlPart(54)
invokeTag('paginate','g',211,['total':(controleGlicemicoInstanceCount ?: 0)],-1)
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',214,[:],1)
printHtmlPart(56)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427815498000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
