import carboidratos.ContagemCarboidratosAlimento
import seguranca.Usuario
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_contagemcarboidratos_contagemCarboidratosAlimentoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/contagemCarboidratosAlimento/index.gsp" }
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
printHtmlPart(2)
if(true && (params.dia)) {
printHtmlPart(1)
invokeTag('set','g',20,['var':("dia"),'value':(params.int('dia'))],-1)
printHtmlPart(0)
}
else {
printHtmlPart(1)
invokeTag('set','g',23,['var':("dia"),'value':(formatDate(format:"dd" , date:new Date()).toInteger())],-1)
printHtmlPart(0)
}
printHtmlPart(2)
invokeTag('set','g',26,['var':("alimentosList"),'value':(carboidratos.Alimento.list())],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',31,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
invokeTag('set','g',32,['var':("entityName"),'value':(message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento'))],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',33,['code':("contagem.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',33,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',33,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',34,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',37,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',47,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',48,['bean':(itensContagemCarboidratosInstance),'var':("error")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',50,['bean':(itensContagemCarboidratosInstance)],2)
printHtmlPart(9)
if(true && (flash.error)) {
printHtmlPart(17)
loop:{
int i = 0
for( error in (flash.error) ) {
printHtmlPart(18)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',55,['error':(error)],-1)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('select','g',62,['onchange':("this.form.submit()"),'value':(mes),'name':("mes"),'from':([message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(22)
invokeTag('field','g',63,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("ano"),'value':(ano),'type':("number")],-1)
printHtmlPart(23)
})
invokeTag('form','g',64,['url':([resource:itensContagemCarboidratosInstance, action:'index'])],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
invokeTag('hiddenField','g',68,['name':("mes"),'value':(mes)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',69,['name':("ano"),'value':(ano)],-1)
printHtmlPart(26)
invokeTag('message','g',74,['code':("contagem.inserir.message")],-1)
printHtmlPart(27)
invokeTag('message','g',78,['code':("contagem.dia.label")],-1)
printHtmlPart(28)
invokeTag('message','g',80,['code':("contagem.refeicao.label")],-1)
printHtmlPart(29)
invokeTag('message','g',82,['code':("contagem.alimento.label")],-1)
printHtmlPart(29)
invokeTag('message','g',84,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(29)
invokeTag('message','g',86,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(29)
invokeTag('message','g',88,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(30)
invokeTag('field','g',95,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(dia),'type':("number"),'required':("")],-1)
printHtmlPart(31)
invokeTag('select','g',98,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id"),'value':(params.refeicaoid)],-1)
printHtmlPart(32)
invokeTag('select','g',102,['class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(alimentosList),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(33)
invokeTag('field','g',105,['min':("0"),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(34)
invokeTag('textField','g',107,['id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(35)
invokeTag('field','g',109,['min':("0"),'id':("carboidratos"),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(36)
invokeTag('submitButton','g',117,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(37)
})
invokeTag('form','g',123,['class':("formtable"),'url':([resource:ContagemCarboidratosAlimentoInstance, action:'save'])],2)
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
invokeTag('image','asset',128,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(22)
})
invokeTag('link','g',129,['controller':("ContagemCarboidratosAlimento"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(39)
invokeTag('image','asset',132,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(22)
})
invokeTag('link','g',133,['controller':("ContagemCarboidratosAlimento"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(41)
invokeTag('image','asset',135,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(42)
invokeTag('render','g',140,['template':("/links/linksdia")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(43)
invokeTag('message','g',146,['code':("contagem.alterar.message")],-1)
printHtmlPart(44)
invokeTag('message','g',149,['code':("contagem.dia.label")],-1)
printHtmlPart(45)
invokeTag('message','g',153,['code':("contagem.refeicao.label")],-1)
printHtmlPart(46)
invokeTag('message','g',157,['code':("contagem.alimento.label")],-1)
printHtmlPart(29)
invokeTag('message','g',159,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(29)
invokeTag('message','g',161,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(29)
invokeTag('message','g',163,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(28)
invokeTag('message','g',165,['code':("contagem.totalchorefeicao.label")],-1)
printHtmlPart(47)
invokeTag('set','g',172,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(39)
invokeTag('set','g',173,['var':("refeicaoanterior"),'value':("-1")],-1)
printHtmlPart(39)
invokeTag('set','g',174,['var':("totalrefeicao"),'value':("0")],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',175,['name':("mes"),'value':(mes)],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',176,['name':("ano"),'value':(ano)],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',177,['name':("dia"),'value':(dia)],-1)
printHtmlPart(48)
loop:{
int i = 0
for( contagemCarboidratosAlimentoInstance in (contagemCarboidratosAlimentoInstanceList) ) {
printHtmlPart(49)
invokeTag('hiddenField','g',180,['name':("id"),'value':(contagemCarboidratosAlimentoInstance.id)],-1)
printHtmlPart(50)
invokeTag('set','g',181,['var':("diaatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)],-1)
printHtmlPart(50)
invokeTag('set','g',182,['var':("refeicaoatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id)],-1)
printHtmlPart(51)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(52)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)
printHtmlPart(53)
createTagBody(5, {->
invokeTag('image','asset',188,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirdia.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',188,['params':([dia:diaatual,mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'action':("delete"),'controller':("ContagemCarboidratos")],5)
printHtmlPart(54)
}
printHtmlPart(55)
if(true && (refeicaoanterior!=refeicaoatual)) {
printHtmlPart(56)
invokeTag('hiddenField','g',196,['name':("diaatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)],-1)
printHtmlPart(57)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao)
printHtmlPart(58)
createTagBody(5, {->
invokeTag('image','asset',202,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',202,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.id),'action':("deleterefeicaodia"),'controller':("ContagemCarboidratos")],5)
printHtmlPart(59)
loop:{
int k = 0
for( agrupamentoInstance in (agrupamento) ) {
printHtmlPart(60)
if(true && (agrupamentoInstance[1]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia &&
													  agrupamentoInstance[2]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.mes &&
												  	  agrupamentoInstance[3]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.ano &&
													  agrupamentoInstance[4]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.usuario.id &&
													  agrupamentoInstance[5]==refeicaoatual)) {
printHtmlPart(61)
expressionOut.print(message(code: 'totalrefeicao.label' , args: [contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao , formatNumber(number:agrupamentoInstance[0],type:'number' , maxFractionDigits:'2')]))
printHtmlPart(62)
}
printHtmlPart(63)
k++
}
}
printHtmlPart(64)
}
printHtmlPart(65)
invokeTag('hiddenField','g',228,['name':("diaatual"),'value':(diaatual)],-1)
printHtmlPart(66)
invokeTag('hiddenField','g',229,['name':("refeicaoatual"),'value':(refeicaoatual)],-1)
printHtmlPart(32)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(67)
invokeTag('select','g',234,['value':(contagemCarboidratosAlimentoInstance.alimento.id),'class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(66)
}
else {
printHtmlPart(67)
invokeTag('select','g',237,['class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(66)
}
printHtmlPart(68)
invokeTag('field','g',241,['min':("0"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(34)
invokeTag('textField','g',243,['readonly':(contagemCarboidratosAlimentoInstance.alimento ? true : false),'value':(contagemCarboidratosAlimentoInstance.alimentoforalista),'id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(35)
invokeTag('field','g',245,['min':("0"),'readonly':(contagemCarboidratosAlimentoInstance.alimento ? true:false),'id':("carboidratos"),'value':(contagemCarboidratosAlimentoInstance.qtdcarboidrato),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(69)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(70)
invokeTag('set','g',249,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento*contagemCarboidratosAlimentoInstance.alimento.carboidratosg)],-1)
printHtmlPart(67)
invokeTag('formatNumber','g',250,['number':(totaldia),'type':("number"),'maxFractionDigits':("2")],-1)
printHtmlPart(71)
}
else {
printHtmlPart(70)
invokeTag('set','g',255,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0))],-1)
printHtmlPart(67)
invokeTag('formatNumber','g',256,['number':(totaldia),'type':("number"),'maxFractionDigits':("2")],-1)
printHtmlPart(72)
}
printHtmlPart(73)
createTagBody(4, {->
invokeTag('image','asset',261,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'excluiralimento.confirm.message'))],-1)
})
invokeTag('link','g',261,['params':([mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluiralimento.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.id),'action':("delete"),'controller':("ContagemCarboidratosAlimento")],4)
printHtmlPart(74)
invokeTag('set','g',264,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(50)
invokeTag('set','g',265,['var':("refeicaoanterior"),'value':(refeicaoatual)],-1)
printHtmlPart(75)
i++
}
}
printHtmlPart(76)
invokeTag('actionSubmit','g',273,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(37)
})
invokeTag('form','g',279,['class':("formtable"),'url':([resource:itensContagemCarboidratosInstance, action:'update'])],2)
printHtmlPart(77)
})
invokeTag('captureBody','sitemesh',282,[:],1)
printHtmlPart(78)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1428118891000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
