
<%@ page import="carboidratos.ItensControleGlicemico" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itensControleGlicemico.label', default: 'ItensControleGlicemico')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-itensControleGlicemico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-itensControleGlicemico" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list itensControleGlicemico">
			
				<g:if test="${itensControleGlicemicoInstance?.qtdinsulinelenta}">
				<li class="fieldcontain">
					<span id="qtdinsulinelenta-label" class="property-label"><g:message code="itensControleGlicemico.qtdinsulinelenta.label" default="Qtdinsulinelenta" /></span>
					
						<span class="property-value" aria-labelledby="qtdinsulinelenta-label"><g:fieldValue bean="${itensControleGlicemicoInstance}" field="qtdinsulinelenta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.valorglicemiapre}">
				<li class="fieldcontain">
					<span id="valorglicemiapre-label" class="property-label"><g:message code="itensControleGlicemico.valorglicemiapre.label" default="Valorglicemiapre" /></span>
					
						<span class="property-value" aria-labelledby="valorglicemiapre-label"><g:fieldValue bean="${itensControleGlicemicoInstance}" field="valorglicemiapre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.qtdinsulinarapidapre}">
				<li class="fieldcontain">
					<span id="qtdinsulinarapidapre-label" class="property-label"><g:message code="itensControleGlicemico.qtdinsulinarapidapre.label" default="Qtdinsulinarapidapre" /></span>
					
						<span class="property-value" aria-labelledby="qtdinsulinarapidapre-label"><g:fieldValue bean="${itensControleGlicemicoInstance}" field="qtdinsulinarapidapre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.qtdcarboidrato}">
				<li class="fieldcontain">
					<span id="qtdcarboidrato-label" class="property-label"><g:message code="itensControleGlicemico.qtdcarboidrato.label" default="Qtdcarboidrato" /></span>
					
						<span class="property-value" aria-labelledby="qtdcarboidrato-label"><g:fieldValue bean="${itensControleGlicemicoInstance}" field="qtdcarboidrato"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.valorglicemiapos}">
				<li class="fieldcontain">
					<span id="valorglicemiapos-label" class="property-label"><g:message code="itensControleGlicemico.valorglicemiapos.label" default="Valorglicemiapos" /></span>
					
						<span class="property-value" aria-labelledby="valorglicemiapos-label"><g:fieldValue bean="${itensControleGlicemicoInstance}" field="valorglicemiapos"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.qtdinsulinarapidapos}">
				<li class="fieldcontain">
					<span id="qtdinsulinarapidapos-label" class="property-label"><g:message code="itensControleGlicemico.qtdinsulinarapidapos.label" default="Qtdinsulinarapidapos" /></span>
					
						<span class="property-value" aria-labelledby="qtdinsulinarapidapos-label"><g:fieldValue bean="${itensControleGlicemicoInstance}" field="qtdinsulinarapidapos"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.controleglicemico}">
				<li class="fieldcontain">
					<span id="controleglicemico-label" class="property-label"><g:message code="itensControleGlicemico.controleglicemico.label" default="Controleglicemico" /></span>
					
						<span class="property-value" aria-labelledby="controleglicemico-label"><g:link controller="controleGlicemico" action="show" id="${itensControleGlicemicoInstance?.controleglicemico?.id}">${itensControleGlicemicoInstance?.controleglicemico?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="itensControleGlicemico.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${itensControleGlicemicoInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="itensControleGlicemico.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${itensControleGlicemicoInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${itensControleGlicemicoInstance?.refeicao}">
				<li class="fieldcontain">
					<span id="refeicao-label" class="property-label"><g:message code="itensControleGlicemico.refeicao.label" default="Refeicao" /></span>
					
						<span class="property-value" aria-labelledby="refeicao-label"><g:link controller="refeicao" action="show" id="${itensControleGlicemicoInstance?.refeicao?.id}">${itensControleGlicemicoInstance?.refeicao?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:itensControleGlicemicoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${itensControleGlicemicoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
