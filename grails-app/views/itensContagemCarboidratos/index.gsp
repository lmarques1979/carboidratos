
<%@ page import="carboidratos.ItensContagemCarboidratos" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itensContagemCarboidratos.label', default: 'ItensContagemCarboidratos')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-itensContagemCarboidratos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-itensContagemCarboidratos" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="qtdalimento" title="${message(code: 'itensContagemCarboidratos.qtdalimento.label', default: 'Qtdalimento')}" />
					
						<g:sortableColumn property="qtdcarboidrato" title="${message(code: 'itensContagemCarboidratos.qtdcarboidrato.label', default: 'Qtdcarboidrato')}" />
					
						<g:sortableColumn property="alimentoforalista" title="${message(code: 'itensContagemCarboidratos.alimentoforalista.label', default: 'Alimentoforalista')}" />
					
						<th><g:message code="itensContagemCarboidratos.contagemcarboidratos.label" default="Contagemcarboidratos" /></th>
					
						<th><g:message code="itensContagemCarboidratos.alimento.label" default="Alimento" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'itensContagemCarboidratos.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itensContagemCarboidratosInstanceList}" status="i" var="itensContagemCarboidratosInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itensContagemCarboidratosInstance.id}">${fieldValue(bean: itensContagemCarboidratosInstance, field: "qtdalimento")}</g:link></td>
					
						<td>${fieldValue(bean: itensContagemCarboidratosInstance, field: "qtdcarboidrato")}</td>
					
						<td>${fieldValue(bean: itensContagemCarboidratosInstance, field: "alimentoforalista")}</td>
					
						<td>${fieldValue(bean: itensContagemCarboidratosInstance, field: "contagemcarboidratos")}</td>
					
						<td>${fieldValue(bean: itensContagemCarboidratosInstance, field: "alimento")}</td>
					
						<td><g:formatDate date="${itensContagemCarboidratosInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itensContagemCarboidratosInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
