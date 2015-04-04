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
invokeTag('set','g',25,['var':("refeicaousuariolist"),'value':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance))],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',29,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
invokeTag('set','g',30,['var':("entityName"),'value':(message(code: 'controleGlicemico.label', default: 'ControleGlicemico'))],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',31,['code':("controle.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',31,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',31,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',37,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('message','g',40,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',50,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',51,['bean':(itensControleGlicemicoInstance),'var':("error")],3)
printHtmlPart(17)
})
invokeTag('hasErrors','g',53,['bean':(itensControleGlicemicoInstance)],2)
printHtmlPart(10)
if(true && (flash.error)) {
printHtmlPart(18)
loop:{
int i = 0
for( error in (flash.error) ) {
printHtmlPart(19)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',58,['error':(error)],-1)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
}
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('select','g',65,['onchange':("this.form.submit()"),'value':(mes),'name':("mes"),'from':([message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(23)
invokeTag('field','g',66,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("ano"),'value':(ano),'type':("number")],-1)
printHtmlPart(24)
})
invokeTag('form','g',67,['url':([resource:itensControleGlicemicoInstance, action:'index'])],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('hiddenField','g',72,['id':("mes"),'name':("mes"),'value':(mes)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',73,['id':("ano"),'name':("ano"),'value':(ano)],-1)
printHtmlPart(27)
invokeTag('message','g',78,['code':("controle.new.label")],-1)
printHtmlPart(28)
invokeTag('message','g',82,['code':("controle.dia.label")],-1)
printHtmlPart(29)
invokeTag('message','g',83,['code':("controle.refeicao.label")],-1)
printHtmlPart(29)
invokeTag('message','g',84,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(29)
invokeTag('message','g',85,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(30)
invokeTag('message','g',87,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(29)
invokeTag('message','g',88,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(29)
invokeTag('message','g',89,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(30)
invokeTag('message','g',91,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(29)
invokeTag('message','g',92,['code':("controle.observacao.label")],-1)
printHtmlPart(31)
invokeTag('field','g',102,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(32)
invokeTag('select','g',104,['id':("refeicaoins"),'name':("refeicao.id"),'from':(refeicaousuariolist),'optionValue':("descricao"),'optionKey':("id"),'value':(params.refeicaoid)],-1)
printHtmlPart(33)
invokeTag('field','g',106,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number")],-1)
printHtmlPart(34)
invokeTag('field','g',107,['class':("qtd"),'size':("4"),'id':("valorglicemiapre"),'name':("valorglicemiapre"),'type':("number")],-1)
printHtmlPart(35)
invokeTag('image','asset',109,['id':("calculapre"),'class':("excluir"),'src':("skin/calcular.png"),'title':(message(code:'calcularvalorinsulinapre.confirm.message'))],-1)
printHtmlPart(33)
invokeTag('field','g',111,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidapre"),'name':("qtdinsulinarapidapre"),'type':("number")],-1)
printHtmlPart(34)
invokeTag('field','g',112,['class':("qtd"),'size':("4"),'id':("qtdcarboidratos"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.01")],-1)
printHtmlPart(34)
invokeTag('field','g',113,['class':("qtd"),'size':("4"),'id':("valorglicemiapos"),'name':("valorglicemiapos"),'type':("number")],-1)
printHtmlPart(36)
invokeTag('image','asset',115,['id':("calculapos"),'class':("excluir"),'src':("skin/calcular.png"),'title':(message(code:'calcularvalorinsulinapos.confirm.message'))],-1)
printHtmlPart(33)
invokeTag('field','g',117,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidapos"),'name':("qtdinsulinarapidapos"),'type':("number")],-1)
printHtmlPart(34)
invokeTag('textField','g',118,['name':("observacao"),'class':("obs")],-1)
printHtmlPart(37)
invokeTag('submitButton','g',125,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(38)
})
invokeTag('form','g',132,['id':("formins"),'class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'save'])],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(40)
invokeTag('image','asset',137,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(23)
})
invokeTag('link','g',138,['controller':("ItensControleGlicemico"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(40)
invokeTag('image','asset',141,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(23)
})
invokeTag('link','g',142,['controller':("ItensControleGlicemico"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(42)
invokeTag('image','asset',144,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(43)
invokeTag('render','g',149,['template':("/links/linksdia")],-1)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(44)
invokeTag('message','g',156,['code':("controle.list.label")],-1)
printHtmlPart(28)
invokeTag('message','g',160,['code':("controle.dia.label")],-1)
printHtmlPart(30)
invokeTag('message','g',162,['code':("controle.refeicao.label")],-1)
printHtmlPart(45)
invokeTag('message','g',164,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(29)
invokeTag('message','g',165,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(29)
invokeTag('message','g',166,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(29)
invokeTag('message','g',167,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(29)
invokeTag('message','g',168,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(29)
invokeTag('message','g',169,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(29)
invokeTag('message','g',170,['code':("controle.observacao.label")],-1)
printHtmlPart(46)
invokeTag('set','g',176,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(40)
invokeTag('hiddenField','g',177,['id':("mesalt"),'name':("mes"),'value':(mes)],-1)
printHtmlPart(40)
invokeTag('hiddenField','g',178,['id':("anoalt"),'name':("ano"),'value':(ano)],-1)
printHtmlPart(40)
loop:{
int j = 0
for( itensControleGlicemicoInstance in (itensControleGlicemicoInstanceList) ) {
printHtmlPart(47)
invokeTag('hiddenField','g',181,['name':("id"),'value':(itensControleGlicemicoInstance.id)],-1)
printHtmlPart(48)
invokeTag('set','g',182,['id':("diaatual"),'var':("diaatual"),'value':(itensControleGlicemicoInstance.controleglicemico.dia)],-1)
printHtmlPart(47)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(49)
expressionOut.print(itensControleGlicemicoInstance.controleglicemico.dia)
printHtmlPart(50)
createTagBody(5, {->
invokeTag('image','asset',189,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',189,['onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.controleglicemico.id),'action':("delete"),'controller':("ControleGlicemico")],5)
printHtmlPart(51)
}
printHtmlPart(52)
invokeTag('hiddenField','g',197,['name':("index")],-1)
printHtmlPart(53)
invokeTag('hiddenField','g',198,['id':("diaatual${j}"),'name':("diaatual"),'value':(diaatual)],-1)
printHtmlPart(53)
invokeTag('hiddenField','g',199,['id':("controleglicemico.id"),'name':("controleglicemico.id"),'value':(itensControleGlicemicoInstance.controleglicemico.id)],-1)
printHtmlPart(54)
invokeTag('select','g',202,['id':("refeicaoalt"),'name':("refeicao.id"),'from':(refeicaousuariolist),'value':(itensControleGlicemicoInstance.controleglicemico.refeicao.id),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(55)
invokeTag('field','g',204,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinelenta)],-1)
printHtmlPart(56)
invokeTag('field','g',206,['class':("valorglicemiaprealt"),'data-index':(j),'size':("4"),'id':("valorglicemiaprealt${j}"),'name':("valorglicemiapre"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapre)],-1)
printHtmlPart(57)
invokeTag('field','g',207,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidaprealt"),'name':("qtdinsulinarapidapre"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapre)],-1)
printHtmlPart(56)
invokeTag('field','g',209,['class':("qtd"),'size':("4"),'id':("qtdcarboidratoalt${j}"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.01"),'value':(itensControleGlicemicoInstance.qtdcarboidrato)],-1)
printHtmlPart(56)
invokeTag('field','g',211,['class':("valorglicemiaposalt"),'data-index':(j),'size':("4"),'id':("valorglicemiaposalt${j}"),'name':("valorglicemiapos"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapos)],-1)
printHtmlPart(57)
invokeTag('field','g',212,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidaposalt"),'name':("qtdinsulinarapidapos"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapos)],-1)
printHtmlPart(56)
invokeTag('textField','g',214,['name':("observacao"),'class':("obs"),'value':(itensControleGlicemicoInstance.observacao)],-1)
printHtmlPart(58)
createTagBody(4, {->
invokeTag('image','asset',216,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',216,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.id),'action':("delete"),'controller':("ItensControleGlicemico")],4)
printHtmlPart(59)
invokeTag('set','g',220,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(40)
j++
}
}
printHtmlPart(60)
invokeTag('actionSubmit','g',229,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(61)
})
invokeTag('form','g',235,['id':("formupd"),'class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'update'])],2)
printHtmlPart(62)
})
invokeTag('captureBody','sitemesh',238,[:],1)
printHtmlPart(63)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1428117144000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
