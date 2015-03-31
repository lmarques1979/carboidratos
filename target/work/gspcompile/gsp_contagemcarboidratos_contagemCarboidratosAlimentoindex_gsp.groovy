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
invokeTag('set','g',22,['var':("entityName"),'value':(message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',23,['code':("contagem.list.label")],-1)
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
invokeTag('eachError','g',38,['bean':(itensContagemCarboidratosInstance),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',40,['bean':(itensContagemCarboidratosInstance)],2)
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
invokeTag('form','g',54,['url':([resource:itensContagemCarboidratosInstance, action:'index'])],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',58,['name':("mes"),'value':(mes)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',59,['name':("ano"),'value':(ano)],-1)
printHtmlPart(25)
invokeTag('message','g',64,['code':("contagem.inserir.message")],-1)
printHtmlPart(26)
invokeTag('message','g',68,['code':("contagem.dia.label")],-1)
printHtmlPart(27)
invokeTag('message','g',70,['code':("contagem.refeicao.label")],-1)
printHtmlPart(28)
invokeTag('message','g',72,['code':("contagem.alimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',74,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',76,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(28)
invokeTag('message','g',78,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(29)
invokeTag('field','g',85,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(30)
invokeTag('select','g',88,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id"),'value':(params.refeicaoid)],-1)
printHtmlPart(31)
invokeTag('select','g',92,['class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(32)
invokeTag('field','g',95,['min':("0"),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number")],-1)
printHtmlPart(33)
invokeTag('textField','g',97,['id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(34)
invokeTag('field','g',99,['min':("0"),'id':("carboidratos"),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number")],-1)
printHtmlPart(35)
invokeTag('submitButton','g',107,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(36)
})
invokeTag('form','g',113,['class':("formtable"),'url':([resource:ContagemCarboidratosAlimentoInstance, action:'save'])],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
invokeTag('image','asset',118,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',119,['controller':("ContagemCarboidratosAlimento"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(38)
invokeTag('image','asset',122,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',123,['controller':("ContagemCarboidratosAlimento"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(40)
invokeTag('image','asset',125,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(41)
invokeTag('render','g',130,['template':("linksdia")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(42)
invokeTag('message','g',136,['code':("contagem.alterar.message")],-1)
printHtmlPart(43)
invokeTag('message','g',139,['code':("contagem.dia.label")],-1)
printHtmlPart(44)
invokeTag('message','g',143,['code':("contagem.refeicao.label")],-1)
printHtmlPart(45)
invokeTag('message','g',147,['code':("contagem.alimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',149,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',151,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(28)
invokeTag('message','g',153,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(27)
invokeTag('message','g',155,['code':("contagem.totalchorefeicao.label")],-1)
printHtmlPart(46)
invokeTag('set','g',162,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(38)
invokeTag('set','g',163,['var':("refeicaoanterior"),'value':("-1")],-1)
printHtmlPart(38)
invokeTag('set','g',164,['var':("totalrefeicao"),'value':("0")],-1)
printHtmlPart(38)
invokeTag('hiddenField','g',165,['name':("mes"),'value':(mes)],-1)
printHtmlPart(38)
invokeTag('hiddenField','g',166,['name':("ano"),'value':(ano)],-1)
printHtmlPart(38)
loop:{
int i = 0
for( contagemCarboidratosAlimentoInstance in (contagemCarboidratosAlimentoInstanceList) ) {
printHtmlPart(47)
invokeTag('hiddenField','g',169,['name':("id"),'value':(contagemCarboidratosAlimentoInstance.id)],-1)
printHtmlPart(48)
invokeTag('set','g',170,['var':("diaatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)],-1)
printHtmlPart(48)
invokeTag('set','g',171,['var':("refeicaoatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id)],-1)
printHtmlPart(49)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(50)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)
printHtmlPart(51)
createTagBody(5, {->
invokeTag('image','asset',177,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirdia.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',177,['params':([dia:diaatual,mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'action':("delete"),'controller':("ContagemCarboidratos")],5)
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (refeicaoanterior!=refeicaoatual)) {
printHtmlPart(54)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao)
printHtmlPart(55)
createTagBody(5, {->
invokeTag('image','asset',189,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',189,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.id),'action':("deleterefeicaodia"),'controller':("ContagemCarboidratos")],5)
printHtmlPart(56)
loop:{
int k = 0
for( agrupamentoInstance in (agrupamento) ) {
printHtmlPart(57)
if(true && (agrupamentoInstance[1]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia &&
													  agrupamentoInstance[2]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.mes &&
												  	  agrupamentoInstance[3]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.ano &&
													  agrupamentoInstance[4]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.usuario.id &&
													  agrupamentoInstance[5]==refeicaoatual)) {
printHtmlPart(58)
expressionOut.print(message(code: 'totalrefeicao.label' , args: [contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao , formatNumber(number:agrupamentoInstance[0],type:'number',format:'####.###')]))
printHtmlPart(59)
}
printHtmlPart(60)
k++
}
}
printHtmlPart(61)
}
printHtmlPart(62)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(63)
invokeTag('select','g',216,['value':(contagemCarboidratosAlimentoInstance.alimento.id),'class':("total"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(64)
}
else {
printHtmlPart(63)
invokeTag('select','g',219,['class':("total"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(64)
}
printHtmlPart(65)
invokeTag('field','g',223,['min':("0"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number")],-1)
printHtmlPart(33)
invokeTag('textField','g',225,['value':(contagemCarboidratosAlimentoInstance.alimentoforalista),'id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(34)
invokeTag('field','g',227,['min':("0"),'id':("carboidratos"),'value':(contagemCarboidratosAlimentoInstance.qtdcarboidrato),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number")],-1)
printHtmlPart(66)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(67)
invokeTag('set','g',231,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento*contagemCarboidratosAlimentoInstance.alimento.carboidratosg)],-1)
printHtmlPart(63)
invokeTag('formatNumber','g',232,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(68)
}
else {
printHtmlPart(67)
invokeTag('set','g',237,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0))],-1)
printHtmlPart(63)
invokeTag('formatNumber','g',238,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(68)
}
printHtmlPart(69)
createTagBody(4, {->
invokeTag('image','asset',243,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'excluiralimento.confirm.message'))],-1)
})
invokeTag('link','g',243,['params':([mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluiralimento.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.id),'action':("delete"),'controller':("ContagemCarboidratosAlimento")],4)
printHtmlPart(70)
invokeTag('set','g',246,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(48)
invokeTag('set','g',247,['var':("refeicaoanterior"),'value':(refeicaoatual)],-1)
printHtmlPart(71)
i++
}
}
printHtmlPart(72)
invokeTag('actionSubmit','g',255,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(36)
})
invokeTag('form','g',261,['class':("formtable"),'url':([resource:itensContagemCarboidratosInstance, action:'update'])],2)
printHtmlPart(73)
invokeTag('paginate','g',265,['total':(contagemCarboidratosAlimentoInstanceCount ?: 0)],-1)
printHtmlPart(74)
})
invokeTag('captureBody','sitemesh',268,[:],1)
printHtmlPart(75)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427756464000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
