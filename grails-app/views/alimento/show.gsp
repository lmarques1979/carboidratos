
<%@ page import="carboidratos.Alimento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'alimento.label', default: 'Alimento')}" />
		<title><g:message code="alimento.show.label" /></title>
	</head>
	<body>
		<a href="#show-alimento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="alimento.list.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="alimento.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="show-alimento" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list alimento">
			
				<g:if test="${alimentoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="alimento.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${alimentoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.medidausual}">
				<li class="fieldcontain">
					<span id="medidausual-label" class="property-label"><g:message code="alimento.medidausual.label" default="Medidausual" /></span>
					
						<span class="property-value" aria-labelledby="medidausual-label"><g:fieldValue bean="${alimentoInstance}" field="medidausual"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.peso}">
				<li class="fieldcontain">
					<span id="peso-label" class="property-label"><g:message code="alimento.peso.label" default="Peso" /></span>
					
						<span class="property-value" aria-labelledby="peso-label"><g:fieldValue bean="${alimentoInstance}" field="peso"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.caloriaskcal}">
				<li class="fieldcontain">
					<span id="caloriaskcal-label" class="property-label"><g:message code="alimento.caloriaskcal.label" default="Caloriaskcal" /></span>
					
						<span class="property-value" aria-labelledby="caloriaskcal-label"><g:fieldValue bean="${alimentoInstance}" field="caloriaskcal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.carboidratosg}">
				<li class="fieldcontain">
					<span id="carboidratosg-label" class="property-label"><g:message code="alimento.carboidratosg.label" default="Carboidratosg" /></span>
					
						<span class="property-value" aria-labelledby="carboidratosg-label"><g:fieldValue bean="${alimentoInstance}" field="carboidratosg"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.carboidratoskcal}">
				<li class="fieldcontain">
					<span id="carboidratoskcal-label" class="property-label"><g:message code="alimento.carboidratoskcal.label" default="Carboidratoskcal" /></span>
					
						<span class="property-value" aria-labelledby="carboidratoskcal-label"><g:fieldValue bean="${alimentoInstance}" field="carboidratoskcal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.imagem}">
				<li class="fieldcontain">
					<span id="imagem-label" class="property-label"><g:message code="alimento.imagem.label" default="Imagem" /></span>
					
						<span class="property-value" aria-labelledby="imagem-label"><g:fieldValue bean="${alimentoInstance}" field="imagem"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate format="dd/MM/yyyy hh:mm" date="${alimentoInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${alimentoInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate format="dd/MM/yyyy hh:mm" date="${alimentoInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:alimentoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${alimentoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
