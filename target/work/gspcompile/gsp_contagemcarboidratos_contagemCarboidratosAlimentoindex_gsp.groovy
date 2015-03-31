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
invokeTag('captureMeta','sitemesh',29,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',30,['var':("entityName"),'value':(message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',31,['code':("contagem.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',31,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',31,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',35,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
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
invokeTag('message','g',45,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',46,['bean':(itensContagemCarboidratosInstance),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',48,['bean':(itensContagemCarboidratosInstance)],2)
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
invokeTag('message','g',53,['error':(error)],-1)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('select','g',60,['onchange':("this.form.submit()"),'value':(mes),'name':("mes"),'from':([message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(21)
invokeTag('field','g',61,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("ano"),'value':(ano),'type':("number")],-1)
printHtmlPart(22)
})
invokeTag('form','g',62,['url':([resource:itensContagemCarboidratosInstance, action:'index'])],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',66,['name':("mes"),'value':(mes)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',67,['name':("ano"),'value':(ano)],-1)
printHtmlPart(25)
invokeTag('message','g',72,['code':("contagem.inserir.message")],-1)
printHtmlPart(26)
invokeTag('message','g',76,['code':("contagem.dia.label")],-1)
printHtmlPart(27)
invokeTag('message','g',78,['code':("contagem.refeicao.label")],-1)
printHtmlPart(28)
invokeTag('message','g',80,['code':("contagem.alimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',82,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',84,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(28)
invokeTag('message','g',86,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(29)
invokeTag('field','g',93,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(30)
invokeTag('select','g',96,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id"),'value':(params.refeicaoid)],-1)
printHtmlPart(31)
invokeTag('select','g',100,['class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(32)
invokeTag('field','g',103,['min':("0"),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(33)
invokeTag('textField','g',105,['id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(34)
invokeTag('field','g',107,['min':("0"),'id':("carboidratos"),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(35)
invokeTag('submitButton','g',115,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(36)
})
invokeTag('form','g',121,['class':("formtable"),'url':([resource:ContagemCarboidratosAlimentoInstance, action:'save'])],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
invokeTag('image','asset',126,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',127,['controller':("ContagemCarboidratosAlimento"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(38)
invokeTag('image','asset',130,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',131,['controller':("ContagemCarboidratosAlimento"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(40)
invokeTag('image','asset',133,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(41)
invokeTag('render','g',138,['template':("/links/linksdia")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(42)
invokeTag('message','g',144,['code':("contagem.alterar.message")],-1)
printHtmlPart(43)
invokeTag('message','g',147,['code':("contagem.dia.label")],-1)
printHtmlPart(44)
invokeTag('message','g',151,['code':("contagem.refeicao.label")],-1)
printHtmlPart(45)
invokeTag('message','g',155,['code':("contagem.alimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',157,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',159,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(28)
invokeTag('message','g',161,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(27)
invokeTag('message','g',163,['code':("contagem.totalchorefeicao.label")],-1)
printHtmlPart(46)
invokeTag('set','g',170,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(38)
invokeTag('set','g',171,['var':("refeicaoanterior"),'value':("-1")],-1)
printHtmlPart(38)
invokeTag('set','g',172,['var':("totalrefeicao"),'value':("0")],-1)
printHtmlPart(38)
invokeTag('hiddenField','g',173,['name':("mes"),'value':(mes)],-1)
printHtmlPart(38)
invokeTag('hiddenField','g',174,['name':("ano"),'value':(ano)],-1)
printHtmlPart(38)
loop:{
int i = 0
for( contagemCarboidratosAlimentoInstance in (contagemCarboidratosAlimentoInstanceList) ) {
printHtmlPart(47)
invokeTag('hiddenField','g',177,['name':("id"),'value':(contagemCarboidratosAlimentoInstance.id)],-1)
printHtmlPart(48)
invokeTag('set','g',178,['var':("diaatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)],-1)
printHtmlPart(48)
invokeTag('set','g',179,['var':("refeicaoatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id)],-1)
printHtmlPart(49)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(50)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)
printHtmlPart(51)
createTagBody(5, {->
invokeTag('image','asset',185,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirdia.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',185,['params':([dia:diaatual,mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'action':("delete"),'controller':("ContagemCarboidratos")],5)
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (refeicaoanterior!=refeicaoatual)) {
printHtmlPart(54)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao)
printHtmlPart(55)
createTagBody(5, {->
invokeTag('image','asset',197,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',197,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.id),'action':("deleterefeicaodia"),'controller':("ContagemCarboidratos")],5)
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
invokeTag('select','g',224,['value':(contagemCarboidratosAlimentoInstance.alimento.id),'class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(64)
}
else {
printHtmlPart(63)
invokeTag('select','g',227,['class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(64)
}
printHtmlPart(65)
invokeTag('field','g',231,['min':("0"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(33)
invokeTag('textField','g',233,['readonly':(contagemCarboidratosAlimentoInstance.alimento ? true : false),'value':(contagemCarboidratosAlimentoInstance.alimentoforalista),'id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(34)
invokeTag('field','g',235,['min':("0"),'readonly':(contagemCarboidratosAlimentoInstance.alimento ? true:false),'id':("carboidratos"),'value':(contagemCarboidratosAlimentoInstance.qtdcarboidrato),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.1")],-1)
printHtmlPart(66)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(67)
invokeTag('set','g',239,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento*contagemCarboidratosAlimentoInstance.alimento.carboidratosg)],-1)
printHtmlPart(63)
invokeTag('formatNumber','g',240,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(68)
}
else {
printHtmlPart(67)
invokeTag('set','g',245,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0))],-1)
printHtmlPart(63)
invokeTag('formatNumber','g',246,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(68)
}
printHtmlPart(69)
createTagBody(4, {->
invokeTag('image','asset',251,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'excluiralimento.confirm.message'))],-1)
})
invokeTag('link','g',251,['params':([mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluiralimento.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.id),'action':("delete"),'controller':("ContagemCarboidratosAlimento")],4)
printHtmlPart(70)
invokeTag('set','g',254,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(48)
invokeTag('set','g',255,['var':("refeicaoanterior"),'value':(refeicaoatual)],-1)
printHtmlPart(71)
i++
}
}
printHtmlPart(72)
invokeTag('actionSubmit','g',263,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(36)
})
invokeTag('form','g',269,['class':("formtable"),'url':([resource:itensContagemCarboidratosInstance, action:'update'])],2)
printHtmlPart(73)
invokeTag('paginate','g',273,['total':(contagemCarboidratosAlimentoInstanceCount ?: 0)],-1)
printHtmlPart(74)
})
invokeTag('captureBody','sitemesh',276,[:],1)
printHtmlPart(75)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427816919000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
