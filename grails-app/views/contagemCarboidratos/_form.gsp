<%@ page import="carboidratos.ContagemCarboidratos" %>



<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'dia', 'error')} required">
	<label for="dia">
		<g:message code="contagemCarboidratos.dia.label" default="Dia" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dia" type="number" value="${contagemCarboidratosInstance.dia}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'mes', 'error')} required">
	<label for="mes">
		<g:message code="contagemCarboidratos.mes.label" default="Mes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="mes" type="number" value="${contagemCarboidratosInstance.mes}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'ano', 'error')} required">
	<label for="ano">
		<g:message code="contagemCarboidratos.ano.label" default="Ano" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ano" type="number" value="${contagemCarboidratosInstance.ano}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'qtdalimento', 'error')} required">
	<label for="qtdalimento">
		<g:message code="contagemCarboidratos.qtdalimento.label" default="Qtdalimento" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="qtdalimento" type="number" value="${contagemCarboidratosInstance.qtdalimento}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'alimento', 'error')} ">
	<label for="alimento">
		<g:message code="contagemCarboidratos.alimento.label" default="Alimento" />
		
	</label>
	<g:select id="alimento" name="alimento.id" from="${carboidratos.Alimento.list()}" optionKey="id" value="${contagemCarboidratosInstance?.alimento?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="contagemCarboidratos.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${seguranca.Usuario.list()}" optionKey="id" required="" value="${contagemCarboidratosInstance?.usuario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'qtdcarboidrato', 'error')} ">
	<label for="qtdcarboidrato">
		<g:message code="contagemCarboidratos.qtdcarboidrato.label" default="Qtdcarboidrato" />
		
	</label>
	<g:field name="qtdcarboidrato" type="number" value="${contagemCarboidratosInstance.qtdcarboidrato}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'alimentoforalista', 'error')} ">
	<label for="alimentoforalista">
		<g:message code="contagemCarboidratos.alimentoforalista.label" default="Alimentoforalista" />
		
	</label>
	<g:textField name="alimentoforalista" value="${contagemCarboidratosInstance?.alimentoforalista}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: contagemCarboidratosInstance, field: 'refeicao', 'error')} required">
	<label for="refeicao">
		<g:message code="contagemCarboidratos.refeicao.label" default="Refeicao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="refeicao" name="refeicao.id" from="${carboidratos.Refeicao.list()}" optionKey="id" required="" value="${contagemCarboidratosInstance?.refeicao?.id}" class="many-to-one"/>

</div>

