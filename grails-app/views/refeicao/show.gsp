<%@ page import="carboidratos.Refeicao" %>
<%@ page import="seguranca.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'refeicao.label', default: 'Refeicao')}" />
		<title><g:message code="refeicao.show.label" /></title>
	</head>
	<body>
		<a href="#show-refeicao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="refeicao.list.label"  /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="refeicao.new.label"  /></g:link></li>
			</ul>
		</div>
		<div id="show-refeicao" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list refeicao">
			
				<g:if test="${refeicaoInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="refeicao.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${refeicaoInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${refeicaoInstance?.ordemrefeicao}">
				<li class="fieldcontain">
					<span id="ordemrefeicao-label" class="property-label"><g:message code="refeicao.ordemrefeicao.label" default="Ordemrefeicao" /></span>
					
						<span class="property-value" aria-labelledby="ordemrefeicao-label"><g:fieldValue bean="${refeicaoInstance}" field="ordemrefeicao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${refeicaoInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate format="dd/MM/yyyy hh:mm" date="${refeicaoInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${refeicaoInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate format="dd/MM/yyyy hh:mm" date="${refeicaoInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:refeicaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${refeicaoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
