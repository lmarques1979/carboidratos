<%@ page import="carboidratos.Configuracao" %>
<legend><g:message code="configuracao.show.label"/></legend>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'alturaimagens', 'error')} required">
	<label for="alturaimagens">
		<g:message code="configuracao.alturaimagens.label" default="Alturaimagens" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="alturaimagens" type="number" value="${configuracaoInstance.alturaimagens}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'larguraimagens', 'error')} required">
	<label for="larguraimagens">
		<g:message code="configuracao.larguraimagens.label" default="Larguraimagens" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="larguraimagens" type="number" value="${configuracaoInstance.larguraimagens}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'alturaimagensthumbs', 'error')} required">
	<label for="alturaimagensthumbs">
		<g:message code="configuracao.alturaimagensthumbs.label" default="Alturaimagensthumbs" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="alturaimagensthumbs" type="number" value="${configuracaoInstance.alturaimagensthumbs}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'larguraimagensthumbs', 'error')} required">
	<label for="larguraimagensthumbs">
		<g:message code="configuracao.larguraimagensthumbs.label" default="Larguraimagensthumbs" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="larguraimagensthumbs" type="number" value="${configuracaoInstance.larguraimagensthumbs}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'itensporpagina', 'error')} required">
	<label for="itensporpagina">
		<g:message code="configuracao.itensporpagina.label" default="Itensporpagina" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="itensporpagina" type="number" value="${configuracaoInstance.itensporpagina}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'metaglicose', 'error')}">
	<label for="metaglicose">
		<g:message code="configuracao.metaglicose.label" default="Alturaimagens" />
	</label>
	<g:field name="metaglicose" type="number" value="${configuracaoInstance.metaglicose}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'sensibilidadeinsulina', 'error')}">
	<label for="sensibilidadeinsulina">
		<g:message code="configuracao.sensibilidadeinsulina.label" default="Alturaimagens" />
	</label>
	<g:field name="sensibilidadeinsulina" type="number" value="${configuracaoInstance.sensibilidadeinsulina}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: configuracaoInstance, field: 'qtdinsulinarepositorio', 'error')}">
	<label for="sensibilidadeinsulina">
		<g:message code="configuracao.qtdinsulinarepositorio.label" default="Alturaimagens" />
	</label>
	<g:field name="qtdinsulinarepositorio" type="number" value="${configuracaoInstance.qtdinsulinarepositorio}"/>

</div>



