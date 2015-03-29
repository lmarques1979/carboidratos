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
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',5,['var':("usuarioInstance"),'value':(Usuario.get(sec.loggedInUserInfo(field: 'id')))],-1)
printHtmlPart(0)
})
invokeTag('ifLoggedIn','sec',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',12,['code':("contagem.list.label")],-1)
})
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
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
invokeTag('message','g',26,['error':(error)],-1)
printHtmlPart(14)
})
invokeTag('eachError','g',27,['bean':(itensContagemCarboidratosInstance),'var':("error")],3)
printHtmlPart(15)
})
invokeTag('hasErrors','g',29,['bean':(itensContagemCarboidratosInstance)],2)
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
invokeTag('message','g',34,['error':(error)],-1)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
}
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('select','g',41,['onchange':("this.form.submit()"),'value':(mes),'name':("mes"),'from':([message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(21)
invokeTag('field','g',42,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("ano"),'value':(ano),'type':("number")],-1)
printHtmlPart(22)
})
invokeTag('form','g',43,['url':([resource:itensContagemCarboidratosInstance, action:'index'])],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',47,['name':("mes"),'value':(mes)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',48,['name':("ano"),'value':(ano)],-1)
printHtmlPart(25)
invokeTag('message','g',53,['code':("contagem.inserir.message")],-1)
printHtmlPart(26)
invokeTag('message','g',57,['code':("contagem.dia.label")],-1)
printHtmlPart(27)
invokeTag('message','g',59,['code':("contagem.refeicao.label")],-1)
printHtmlPart(28)
invokeTag('message','g',61,['code':("contagem.alimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',63,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',65,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(28)
invokeTag('message','g',67,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(29)
invokeTag('field','g',74,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(30)
invokeTag('select','g',77,['id':("refeicao"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id"),'value':(params.refeicaoid)],-1)
printHtmlPart(31)
invokeTag('select','g',81,['class':("alimento"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(32)
invokeTag('field','g',84,['min':("0"),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number")],-1)
printHtmlPart(33)
invokeTag('textField','g',86,['id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(34)
invokeTag('field','g',88,['min':("0"),'id':("carboidratos"),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number")],-1)
printHtmlPart(35)
invokeTag('submitButton','g',96,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(36)
})
invokeTag('form','g',102,['class':("formtable"),'url':([resource:ContagemCarboidratosAlimentoInstance, action:'save'])],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(38)
invokeTag('image','asset',107,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',108,['controller':("ContagemCarboidratosAlimento"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(39)
createTagBody(2, {->
printHtmlPart(38)
invokeTag('image','asset',111,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(21)
})
invokeTag('link','g',112,['controller':("ContagemCarboidratosAlimento"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(40)
invokeTag('image','asset',114,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
invokeTag('message','g',123,['code':("contagem.alterar.message")],-1)
printHtmlPart(43)
invokeTag('message','g',126,['code':("contagem.dia.label")],-1)
printHtmlPart(44)
invokeTag('message','g',130,['code':("contagem.refeicao.label")],-1)
printHtmlPart(45)
invokeTag('message','g',134,['code':("contagem.alimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',136,['code':("contagem.qtdalimento.label")],-1)
printHtmlPart(28)
invokeTag('message','g',138,['code':("contagem.alimentoforalista.label")],-1)
printHtmlPart(28)
invokeTag('message','g',140,['code':("contagem.qtdcarboidrato.label")],-1)
printHtmlPart(27)
invokeTag('message','g',142,['code':("contagem.totalchorefeicao.label")],-1)
printHtmlPart(46)
invokeTag('set','g',149,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(38)
invokeTag('set','g',150,['var':("refeicaoanterior"),'value':("-1")],-1)
printHtmlPart(38)
invokeTag('set','g',151,['var':("totalrefeicao"),'value':("0")],-1)
printHtmlPart(38)
invokeTag('hiddenField','g',152,['name':("mes"),'value':(mes)],-1)
printHtmlPart(38)
invokeTag('hiddenField','g',153,['name':("ano"),'value':(ano)],-1)
printHtmlPart(38)
loop:{
int i = 0
for( contagemCarboidratosAlimentoInstance in (contagemCarboidratosAlimentoInstanceList) ) {
printHtmlPart(47)
invokeTag('hiddenField','g',156,['name':("id"),'value':(contagemCarboidratosAlimentoInstance.id)],-1)
printHtmlPart(48)
invokeTag('set','g',157,['var':("diaatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)],-1)
printHtmlPart(48)
invokeTag('set','g',158,['var':("refeicaoatual"),'value':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id)],-1)
printHtmlPart(49)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(50)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia)
printHtmlPart(51)
createTagBody(5, {->
invokeTag('image','asset',164,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirdia.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',164,['params':([dia:diaatual,mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'action':("delete"),'controller':("ContagemCarboidratos")],5)
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (refeicaoanterior!=refeicaoatual)) {
printHtmlPart(54)
expressionOut.print(contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao)
printHtmlPart(55)
createTagBody(5, {->
invokeTag('image','asset',176,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?'))],-1)
})
invokeTag('link','g',176,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.contagemcarboidratos.id),'action':("deleterefeicaodia"),'controller':("ContagemCarboidratos")],5)
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
invokeTag('select','g',202,['value':(contagemCarboidratosAlimentoInstance.alimento.id),'class':("total"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(64)
}
else {
printHtmlPart(63)
invokeTag('select','g',205,['class':("total"),'noSelection':(['-1': message(code:'alimentonaocadastrado.label')]),'id':("alimento"),'name':("alimento.id"),'from':(carboidratos.Alimento.list()),'optionValue':({ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'}),'optionKey':("id")],-1)
printHtmlPart(64)
}
printHtmlPart(65)
invokeTag('field','g',209,['min':("0"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento),'class':("qtd"),'size':("4"),'name':("qtdalimento"),'type':("number")],-1)
printHtmlPart(33)
invokeTag('textField','g',211,['value':(contagemCarboidratosAlimentoInstance.alimentoforalista),'id':("alimentoforalista"),'name':("alimentoforalista"),'class':("obs")],-1)
printHtmlPart(34)
invokeTag('field','g',213,['min':("0"),'id':("carboidratos"),'value':(contagemCarboidratosAlimentoInstance.qtdcarboidrato),'class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number")],-1)
printHtmlPart(66)
if(true && (contagemCarboidratosAlimentoInstance.alimento)) {
printHtmlPart(67)
invokeTag('set','g',217,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento*contagemCarboidratosAlimentoInstance.alimento.carboidratosg)],-1)
printHtmlPart(63)
invokeTag('formatNumber','g',218,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(68)
}
else {
printHtmlPart(67)
invokeTag('set','g',223,['var':("totaldia"),'value':(contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0))],-1)
printHtmlPart(63)
invokeTag('formatNumber','g',224,['number':(totaldia),'type':("number"),'format':("####.###")],-1)
printHtmlPart(68)
}
printHtmlPart(69)
createTagBody(4, {->
invokeTag('image','asset',229,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'excluiralimento.confirm.message'))],-1)
})
invokeTag('link','g',229,['params':([mes:mes,ano:ano]),'onclick':("return confirm('${message(code: 'excluiralimento.confirm.message', default: 'Are you sure?')}');"),'id':(contagemCarboidratosAlimentoInstance.id),'action':("delete"),'controller':("ContagemCarboidratosAlimento")],4)
printHtmlPart(70)
invokeTag('set','g',232,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(48)
invokeTag('set','g',233,['var':("refeicaoanterior"),'value':(refeicaoatual)],-1)
printHtmlPart(71)
i++
}
}
printHtmlPart(72)
invokeTag('actionSubmit','g',241,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(36)
})
invokeTag('form','g',247,['class':("formtable"),'url':([resource:itensContagemCarboidratosInstance, action:'update'])],2)
printHtmlPart(73)
invokeTag('paginate','g',251,['total':(contagemCarboidratosAlimentoInstanceCount ?: 0)],-1)
printHtmlPart(74)
})
invokeTag('captureBody','sitemesh',254,[:],1)
printHtmlPart(75)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427583990000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
