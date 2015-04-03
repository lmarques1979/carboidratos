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
printHtmlPart(28)
invokeTag('message','g',84,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(28)
invokeTag('message','g',85,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(28)
invokeTag('message','g',86,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(28)
invokeTag('message','g',87,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(28)
invokeTag('message','g',88,['code':("controle.observacao.label")],-1)
printHtmlPart(29)
invokeTag('field','g',98,['class':("dia"),'size':("5"),'max':("31"),'min':("1"),'name':("dia"),'value':(formatDate(format:"dd" , date:new Date())),'type':("number"),'required':("")],-1)
printHtmlPart(30)
invokeTag('select','g',100,['id':("refeicaoins"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(31)
invokeTag('field','g',102,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number")],-1)
printHtmlPart(32)
invokeTag('field','g',103,['class':("qtd"),'size':("4"),'name':("valorglicemiapre"),'type':("number")],-1)
printHtmlPart(32)
invokeTag('field','g',104,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapre"),'type':("number")],-1)
printHtmlPart(32)
invokeTag('field','g',105,['class':("qtd"),'size':("4"),'id':("qtdcarboidratos"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.01")],-1)
printHtmlPart(32)
invokeTag('field','g',106,['class':("qtd"),'size':("4"),'name':("valorglicemiapos"),'type':("number")],-1)
printHtmlPart(32)
invokeTag('field','g',107,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapos"),'type':("number")],-1)
printHtmlPart(32)
invokeTag('textField','g',108,['name':("observacao"),'class':("obs")],-1)
printHtmlPart(33)
invokeTag('submitButton','g',115,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(34)
})
invokeTag('form','g',122,['id':("formins"),'class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'save'])],2)
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
invokeTag('image','asset',127,['src':("skin/print.png"),'title':(message(code: 'imprimir.label'))],-1)
printHtmlPart(22)
})
invokeTag('link','g',128,['controller':("ItensControleGlicemico"),'target':("_blank"),'action':("imprimir"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(37)
createTagBody(2, {->
printHtmlPart(36)
invokeTag('image','asset',131,['src':("skin/email.png"),'title':(message(code: 'email.label'))],-1)
printHtmlPart(22)
})
invokeTag('link','g',132,['controller':("ItensControleGlicemico"),'action':("enviarpdfemail"),'params':([mes:mes, ano:ano])],2)
printHtmlPart(38)
invokeTag('image','asset',134,['id':("grafico"),'src':("skin/grafico.png"),'title':(message(code: 'horas.grafico.label'))],-1)
printHtmlPart(39)
invokeTag('render','g',139,['template':("/links/linksdia")],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(40)
invokeTag('message','g',146,['code':("controle.list.label")],-1)
printHtmlPart(27)
invokeTag('message','g',150,['code':("controle.dia.label")],-1)
printHtmlPart(41)
invokeTag('message','g',152,['code':("controle.refeicao.label")],-1)
printHtmlPart(28)
invokeTag('message','g',153,['code':("controle.qtdinsulinelenta.label")],-1)
printHtmlPart(28)
invokeTag('message','g',154,['code':("controle.valorglicemiapre.label")],-1)
printHtmlPart(28)
invokeTag('message','g',155,['code':("controle.qtdinsulinarapidapre.label")],-1)
printHtmlPart(28)
invokeTag('message','g',156,['code':("controle.qtdcarboidrato.label")],-1)
printHtmlPart(28)
invokeTag('message','g',157,['code':("controle.valorglicemiapos.label")],-1)
printHtmlPart(28)
invokeTag('message','g',158,['code':("controle.qtdinsulinarapidapos.label")],-1)
printHtmlPart(28)
invokeTag('message','g',159,['code':("controle.observacao.label")],-1)
printHtmlPart(42)
invokeTag('set','g',165,['var':("diaanterior"),'value':("-1")],-1)
printHtmlPart(36)
invokeTag('hiddenField','g',166,['name':("mes"),'value':(mes)],-1)
printHtmlPart(36)
invokeTag('hiddenField','g',167,['name':("ano"),'value':(ano)],-1)
printHtmlPart(36)
loop:{
int j = 0
for( itensControleGlicemicoInstance in (itensControleGlicemicoInstanceList) ) {
printHtmlPart(43)
invokeTag('hiddenField','g',170,['name':("id"),'value':(itensControleGlicemicoInstance.id)],-1)
printHtmlPart(44)
invokeTag('set','g',171,['var':("diaatual"),'value':(itensControleGlicemicoInstance.controleglicemico.dia)],-1)
printHtmlPart(43)
if(true && (diaanterior!=diaatual)) {
printHtmlPart(45)
expressionOut.print(itensControleGlicemicoInstance.controleglicemico.dia)
printHtmlPart(46)
createTagBody(5, {->
invokeTag('image','asset',177,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',177,['onclick':("return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.controleglicemico.id),'action':("delete"),'controller':("ControleGlicemico")],5)
printHtmlPart(47)
}
printHtmlPart(48)
invokeTag('select','g',186,['id':("refeicaoalt"),'name':("refeicao.id"),'from':(carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)),'value':(itensControleGlicemicoInstance.controleglicemico.refeicao.id),'optionValue':("descricao"),'optionKey':("id")],-1)
printHtmlPart(49)
invokeTag('field','g',188,['class':("qtd"),'size':("4"),'name':("qtdinsulinelenta"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinelenta)],-1)
printHtmlPart(50)
invokeTag('field','g',189,['class':("qtd"),'size':("4"),'name':("valorglicemiapre"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapre)],-1)
printHtmlPart(50)
invokeTag('field','g',190,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapre"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapre)],-1)
printHtmlPart(50)
invokeTag('field','g',191,['class':("qtd"),'size':("4"),'name':("qtdcarboidrato"),'type':("number"),'step':("0.01"),'value':(itensControleGlicemicoInstance.qtdcarboidrato)],-1)
printHtmlPart(50)
invokeTag('field','g',192,['class':("qtd"),'size':("4"),'name':("valorglicemiapos"),'type':("number"),'value':(itensControleGlicemicoInstance.valorglicemiapos)],-1)
printHtmlPart(50)
invokeTag('field','g',193,['class':("qtd"),'size':("4"),'name':("qtdinsulinarapidapos"),'type':("number"),'value':(itensControleGlicemicoInstance.qtdinsulinarapidapos)],-1)
printHtmlPart(50)
invokeTag('textField','g',194,['name':("observacao"),'class':("obs"),'value':(itensControleGlicemicoInstance.observacao)],-1)
printHtmlPart(51)
createTagBody(4, {->
invokeTag('image','asset',196,['class':("excluir"),'src':("skin/remove.png"),'title':(message(code:'remove.label'))],-1)
})
invokeTag('link','g',196,['onclick':("return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');"),'id':(itensControleGlicemicoInstance.id),'action':("delete"),'controller':("ItensControleGlicemico")],4)
printHtmlPart(52)
invokeTag('set','g',199,['var':("diaanterior"),'value':(diaatual)],-1)
printHtmlPart(36)
j++
}
}
printHtmlPart(53)
invokeTag('actionSubmit','g',208,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(54)
})
invokeTag('form','g',214,['class':("formtable"),'url':([resource:itensControleGlicemicoInstance, action:'update'])],2)
printHtmlPart(55)
invokeTag('paginate','g',217,['total':(controleGlicemicoInstanceCount ?: 0)],-1)
printHtmlPart(56)
})
invokeTag('captureBody','sitemesh',220,[:],1)
printHtmlPart(57)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1427922469000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
