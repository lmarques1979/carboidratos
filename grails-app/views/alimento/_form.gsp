<%@ page import="carboidratos.Alimento" %>

<legend><g:message code="alimento.label"/></legend>
<div class="fieldcontain ${hasErrors(bean: alimentoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="alimento.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${alimentoInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: alimentoInstance, field: 'medidausual', 'error')} required">
	<label for="medidausual">
		<g:message code="alimento.medidausual.label" default="Medidausual" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="medidausual" required="" value="${alimentoInstance?.medidausual}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: alimentoInstance, field: 'peso', 'error')} required">
	<label for="peso">
		<g:message code="alimento.peso.label" default="Peso" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="peso" size="4" value="${formatNumber(number:alimentoInstance?.peso,maxFractionDigits:2 , minFractionDigits:2)}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: alimentoInstance, field: 'caloriaskcal', 'error')} ">
	<label for="caloriaskcal">
		<g:message code="alimento.caloriaskcal.label" default="Caloriaskcal" />
		
	</label>
	<g:textField name="caloriaskcal" size="4" value="${formatNumber(number:alimentoInstance?.caloriaskcal,maxFractionDigits:2 , minFractionDigits:2)}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: alimentoInstance, field: 'carboidratosg', 'error')} ">
	<label for="carboidratosg">
		<g:message code="alimento.carboidratosg.label" default="Carboidratosg" />
		
	</label>
	<g:textField name="carboidratosg" size="4" value="${formatNumber(number:alimentoInstance?.carboidratosg,maxFractionDigits:2 , minFractionDigits:2)}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: alimentoInstance, field: 'carboidratoskcal', 'error')} ">
	<label for="carboidratoskcal">
		<g:message code="alimento.carboidratoskcal.label" default="Carboidratoskcal" />
		
	</label>
	<g:textField name="carboidratoskcal" size="4" value="${formatNumber(number:alimentoInstance?.carboidratoskcal,maxFractionDigits:2 , minFractionDigits:2)}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: alimentoInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="alimento.imagem.label" default="Imagem" />
		
	</label>
	<input type="file" name="arquivo" placeholder="${message(code:'alimento.imagem.label') }"/>
</div>

