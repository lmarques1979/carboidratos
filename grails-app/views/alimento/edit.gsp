<%@ page import="carboidratos.Alimento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'alimento.label', default: 'Alimento')}" />
		<title><g:message code="alimento.edit.label" /></title>
	</head>
	<body>
		<a href="#edit-alimento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="alimento.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="alimento.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-alimento" class="content scaffold-edit" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${alimentoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${alimentoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:uploadForm url="[resource:alimentoInstance, action:'update']">
				<g:hiddenField name="version" value="${alimentoInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:uploadForm>
		</div>
	</body>
</html>
