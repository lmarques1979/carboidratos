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
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',38,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
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
invokeTag('message','g',48,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',49,['bean':(itensControleGlicemicoInstance),'var':("error")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',51,['bean':(itensControleGlicemicoInstance)],2)
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
invokeTag('message','g',56,['error':(error)],-1)
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('select','g',63,['onchange':("this.form.submit()"),'value':(mes),'name':("mes"),'from':([message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]),'keys':(['1','2','3','4','5','6','7','8','9','10','11','12'])],-1)
printHtmlPart(22)
invokeTag('field','g',64,['onchange':("this.form.submit()"),'class':("ano"),'min':("2000"),'name':("ano"),'value':(ano),'type':("number")],-1)
printHtmlPart(23)
})
invokeTag('form','g',65,['url':([resource:itensControleGlicemicoInstance, action:'index'])],2)
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
invokeTag('hiddenField','g',70,['id':("mes"),'name':("mes"),'value':(mes)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',71,['id':("ano"),'name':("ano"),'value':(ano)],-1)
printHtmlPart(26)
invokeTag('message','g',76,['code':("controle.new.label")],-1)
printHtmlPart(27)
invokeTag('message','g',80,['code':("controle.dia.label")],-1)
printHtmlPart(28)
invokeTag('message','g',81,['code':("controle.refeicao.label")],-1)
printHtmlPart(28)
invokeTag('message','g',82,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(28)
invokeTag('message','g',83,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(29)
invokeTag('message','g',85,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(28)
invokeTag('message','g',86,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(28)
invokeTag('message','g',87,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(29)
invokeTag('message','g',89,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(28)
invokeTag('message','g',90,['code':("controle.observacao.label")],-1)
printHtmlPart(30)
invokeTag('field','g',100,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(31)
invokeTag('select','g',102,['id':("refeicaoins"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id"),'value':(params.refeicaoid)],-1)
printHtmlPart(32)
invokeTag('field','g',104,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number")],-1)
printHtmlPart(33)
invokeTag('field','g',105,['class':("qtd"),'size':("4"),'id':("valorglicemiapre"),'name':("valorglicemiapre"),'type':("number")],-1)
printHtmlPart(34)
invokeTag('image','asset',107,['id':("calculapre"),'class':("excluir"),'src':("skin/calcular.png"),'title':(message(code:'calcularvalorinsulinapre.confirm.message'))],-1)
printHtmlPart(32)
invokeTag('field','g',109,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidapre"),'name':("qtdinsulinarapidapre"),'type':("number")],-1)
printHtmlPart(33)
invokeTag('field','g',110,['class':("qtd"),'size':("4"),'id':("qtdcarboidratos"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.01")],-1)
printHtmlPart(33)
invokeTag('field','g',111,['class':("qtd"),'size':("4"),'id':("valorglicemiapos"),'name':("valorglicemiapos"),'type':("number")],-1)
printHtmlPart(35)
invokeTag('image','asset',113,['id':("calculapos"),'class':("excluir"),'src':("skin/calcular.png"),'title':(message(code:'calcularvalorinsulinapos.confirm.message'))],-1)
printHtmlPart(32)
invokeTag('field','g',115,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidapos"),'name':("qtdinsulinarapidapos"),'type':("number")],-1)
printHtmlPart(33)
invokeTag('textField','g',116,['name':("observacao"),'class':("obs")],-1)
printHtmlPart(36)
invokeTag('submitButton','g',123,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(37)
})
invokeTag('form','g',130,['id':("formins"),'class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'save'])],2)
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
invokeTag('image','asset',135,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(22)
})
invokeTag('link','g',136,['controller':("ItensControleGlicemico"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(39)
invokeTag('image','asset',139,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(22)
})
invokeTag('link','g',140,['controller':("ItensControleGlicemico"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(41)
invokeTag('image','asset',142,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(42)
invokeTag('render','g',147,['template':("/links/linksdia")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(43)
invokeTag('message','g',154,['code':("controle.list.label")],-1)
printHtmlPart(27)
invokeTag('message','g',158,['code':("controle.dia.label")],-1)
printHtmlPart(29)
invokeTag('message','g',160,['code':("controle.refeicao.label")],-1)
printHtmlPart(44)
invokeTag('message','g',162,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(28)
invokeTag('message','g',163,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(28)
invokeTag('message','g',164,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(28)
invokeTag('message','g',165,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(28)
invokeTag('message','g',166,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(28)
invokeTag('message','g',167,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(28)
invokeTag('message','g',168,['code':("controle.observacao.label")],-1)
printHtmlPart(45)
invokeTag('set','g',174,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',175,['id':("mesalt"),'name':("mes"),'value':(mes)],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',176,['id':("anoalt"),'name':("ano"),'value':(ano)],-1)
printHtmlPart(39)
loop:{
int j = 0
for( itensControleGlicemicoInstance in (itensControleGlicemicoInstanceList) ) {
printHtmlPart(46)
invokeTag('hiddenField','g',179,['name':("id"),'value':(itensControleGlicemicoInstance.id)],-1)
printHtmlPart(47)
invokeTag('set','g',180,['id':("diaatual"),'var':("diaatual"),'value':(itensControleGlicemicoInstance.controleglicemico.dia)],-1)
printHtmlPart(46)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(48)
expressionOut.print(itensControleGlicemicoInstance.controleglicemico.dia)
printHtmlPart(49)
createTagBody(5, {->
invokeTag('image','asset',187,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',187,['onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.controleglicemico.id),'action':("delete"),'controller':("ControleGlicemico")],5)
printHtmlPart(50)
}
printHtmlPart(51)
invokeTag('hiddenField','g',195,['id':("diaatual"),'name':("diaatual"),'value':(diaatual)],-1)
printHtmlPart(52)
invokeTag('select','g',198,['id':("refeicaoalt"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'value':(itensControleGlicemicoInstance.controleglicemico.refeicao.id),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(53)
invokeTag('field','g',200,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinelenta)],-1)
printHtmlPart(54)
invokeTag('field','g',201,['class':("qtd"),'size':("4"),'id':("valorglicemiaprealt"),'name':("valorglicemiapre"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapre)],-1)
printHtmlPart(55)
invokeTag('field','g',203,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidaprealt"),'name':("qtdinsulinarapidapre"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapre)],-1)
printHtmlPart(54)
invokeTag('field','g',204,['class':("qtd"),'size':("4"),'id':("qtdcarboidratoalt"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.01"),'value':(itensControleGlicemicoInstance.qtdcarboidrato)],-1)
printHtmlPart(54)
invokeTag('field','g',205,['class':("qtd"),'size':("4"),'id':("valorglicemiaposalt"),'name':("valorglicemiapos"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapos)],-1)
printHtmlPart(55)
invokeTag('field','g',207,['class':("qtd"),'size':("4"),'id':("qtdinsulinarapidaposalt"),'name':("qtdinsulinarapidapos"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapos)],-1)
printHtmlPart(54)
invokeTag('textField','g',208,['name':("observacao"),'class':("obs"),'value':(itensControleGlicemicoInstance.observacao)],-1)
printHtmlPart(56)
createTagBody(4, {->
invokeTag('image','asset',210,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',210,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.id),'action':("delete"),'controller':("ItensControleGlicemico")],4)
printHtmlPart(57)
invokeTag('set','g',214,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(39)
j++
}
}
printHtmlPart(58)
invokeTag('actionSubmit','g',223,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(59)
})
invokeTag('form','g',229,['id':("formalt"),'class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'update'])],2)
printHtmlPart(60)
invokeTag('paginate','g',232,['total':(controleGlicemicoInstanceCount ?: 0)],-1)
printHtmlPart(61)
})
invokeTag('captureBody','sitemesh',235,[:],1)
printHtmlPart(62)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1428090617000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
