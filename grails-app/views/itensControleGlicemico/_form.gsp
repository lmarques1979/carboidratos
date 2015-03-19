<%@ page import="carboidratos.ItensControleGlicemico" %>



<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'qtdinsulinelenta', 'error')} ">
	<label for="qtdinsulinelenta">
		<g:message code="itensControleGlicemico.qtdinsulinelenta.label" default="Qtdinsulinelenta" />
		
	</label>
	<g:field name="qtdinsulinelenta" type="number" value="${itensControleGlicemicoInstance.qtdinsulinelenta}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'valorglicemiapre', 'error')} ">
	<label for="valorglicemiapre">
		<g:message code="itensControleGlicemico.valorglicemiapre.label" default="Valorglicemiapre" />
		
	</label>
	<g:field name="valorglicemiapre" type="number" value="${itensControleGlicemicoInstance.valorglicemiapre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'qtdinsulinarapidapre', 'error')} ">
	<label for="qtdinsulinarapidapre">
		<g:message code="itensControleGlicemico.qtdinsulinarapidapre.label" default="Qtdinsulinarapidapre" />
		
	</label>
	<g:field name="qtdinsulinarapidapre" type="number" value="${itensControleGlicemicoInstance.qtdinsulinarapidapre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'qtdcarboidrato', 'error')} ">
	<label for="qtdcarboidrato">
		<g:message code="itensControleGlicemico.qtdcarboidrato.label" default="Qtdcarboidrato" />
		
	</label>
	<g:field name="qtdcarboidrato" type="number" value="${itensControleGlicemicoInstance.qtdcarboidrato}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'valorglicemiapos', 'error')} ">
	<label for="valorglicemiapos">
		<g:message code="itensControleGlicemico.valorglicemiapos.label" default="Valorglicemiapos" />
		
	</label>
	<g:field name="valorglicemiapos" type="number" value="${itensControleGlicemicoInstance.valorglicemiapos}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'qtdinsulinarapidapos', 'error')} ">
	<label for="qtdinsulinarapidapos">
		<g:message code="itensControleGlicemico.qtdinsulinarapidapos.label" default="Qtdinsulinarapidapos" />
		
	</label>
	<g:field name="qtdinsulinarapidapos" type="number" value="${itensControleGlicemicoInstance.qtdinsulinarapidapos}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'controleglicemico', 'error')} required">
	<label for="controleglicemico">
		<g:message code="itensControleGlicemico.controleglicemico.label" default="Controleglicemico" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="controleglicemico" name="controleglicemico.id" from="${carboidratos.ControleGlicemico.list()}" optionKey="id" required="" value="${itensControleGlicemicoInstance?.controleglicemico?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itensControleGlicemicoInstance, field: 'refeicao', 'error')} required">
	<label for="refeicao">
		<g:message code="itensControleGlicemico.refeicao.label" default="Refeicao" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="refeicao" name="refeicao.id" from="${carboidratos.Refeicao.list()}" optionKey="id" required="" value="${itensControleGlicemicoInstance?.refeicao?.id}" class="many-to-one"/>

</div>

