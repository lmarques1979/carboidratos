<%@ page import="carboidratos.Refeicao" %>

<legend><g:message code="refeicao.show.label"/></legend>
<div class="fieldcontain ${hasErrors(bean: refeicaoInstance, field: 'descricao', 'error')} required">
	<label for="descricao">
		<g:message code="refeicao.descricao.label" default="Descricao" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descricao" required="" value="${refeicaoInstance?.descricao}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: refeicaoInstance, field: 'ordemrefeicao', 'error')} required">
	<label for="ordemrefeicao">
		<g:message code="refeicao.ordemrefeicao.label" default="Ordemrefeicao" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ordemrefeicao" type="number" value="${refeicaoInstance.ordemrefeicao}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: refeicaoInstance, field: 'descontoinsulina', 'error')}">
	<label for="descontoinsulina">
		<g:message code="refeicao.descontoinsulina.label" default="Desconto Insulina" />
	</label>
	<g:field name="descontoinsulina" type="number" value="${refeicaoInstance.descontoinsulina}"/>

</div>