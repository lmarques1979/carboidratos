
<%@ page import="carboidratos.ContagemCarboidratos" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contagemCarboidratos.label', default: 'ContagemCarboidratos')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-contagemCarboidratos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-contagemCarboidratos" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list contagemCarboidratos">
			
				<g:if test="${contagemCarboidratosInstance?.dia}">
				<li class="fieldcontain">
					<span id="dia-label" class="property-label"><g:message code="contagemCarboidratos.dia.label" default="Dia" /></span>
					
						<span class="property-value" aria-labelledby="dia-label"><g:fieldValue bean="${contagemCarboidratosInstance}" field="dia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.mes}">
				<li class="fieldcontain">
					<span id="mes-label" class="property-label"><g:message code="contagemCarboidratos.mes.label" default="Mes" /></span>
					
						<span class="property-value" aria-labelledby="mes-label"><g:fieldValue bean="${contagemCarboidratosInstance}" field="mes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.ano}">
				<li class="fieldcontain">
					<span id="ano-label" class="property-label"><g:message code="contagemCarboidratos.ano.label" default="Ano" /></span>
					
						<span class="property-value" aria-labelledby="ano-label"><g:fieldValue bean="${contagemCarboidratosInstance}" field="ano"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.qtdalimento}">
				<li class="fieldcontain">
					<span id="qtdalimento-label" class="property-label"><g:message code="contagemCarboidratos.qtdalimento.label" default="Qtdalimento" /></span>
					
						<span class="property-value" aria-labelledby="qtdalimento-label"><g:fieldValue bean="${contagemCarboidratosInstance}" field="qtdalimento"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.alimento}">
				<li class="fieldcontain">
					<span id="alimento-label" class="property-label"><g:message code="contagemCarboidratos.alimento.label" default="Alimento" /></span>
					
						<span class="property-value" aria-labelledby="alimento-label"><g:link controller="alimento" action="show" id="${contagemCarboidratosInstance?.alimento?.id}">${contagemCarboidratosInstance?.alimento?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="contagemCarboidratos.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="usuario" action="show" id="${contagemCarboidratosInstance?.usuario?.id}">${contagemCarboidratosInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.qtdcarboidrato}">
				<li class="fieldcontain">
					<span id="qtdcarboidrato-label" class="property-label"><g:message code="contagemCarboidratos.qtdcarboidrato.label" default="Qtdcarboidrato" /></span>
					
						<span class="property-value" aria-labelledby="qtdcarboidrato-label"><g:fieldValue bean="${contagemCarboidratosInstance}" field="qtdcarboidrato"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.alimentoforalista}">
				<li class="fieldcontain">
					<span id="alimentoforalista-label" class="property-label"><g:message code="contagemCarboidratos.alimentoforalista.label" default="Alimentoforalista" /></span>
					
						<span class="property-value" aria-labelledby="alimentoforalista-label"><g:fieldValue bean="${contagemCarboidratosInstance}" field="alimentoforalista"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="contagemCarboidratos.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${contagemCarboidratosInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="contagemCarboidratos.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${contagemCarboidratosInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${contagemCarboidratosInstance?.refeicao}">
				<li class="fieldcontain">
					<span id="refeicao-label" class="property-label"><g:message code="contagemCarboidratos.refeicao.label" default="Refeicao" /></span>
					
						<span class="property-value" aria-labelledby="refeicao-label"><g:link controller="refeicao" action="show" id="${contagemCarboidratosInstance?.refeicao?.id}">${contagemCarboidratosInstance?.refeicao?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:contagemCarboidratosInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${contagemCarboidratosInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
