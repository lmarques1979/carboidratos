
<%@ page import="carboidratos.ContagemCarboidratos" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contagemCarboidratos.label', default: 'ContagemCarboidratos')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-contagemCarboidratos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-contagemCarboidratos" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dia" title="${message(code: 'contagemCarboidratos.dia.label', default: 'Dia')}" />
					
						<g:sortableColumn property="mes" title="${message(code: 'contagemCarboidratos.mes.label', default: 'Mes')}" />
					
						<g:sortableColumn property="ano" title="${message(code: 'contagemCarboidratos.ano.label', default: 'Ano')}" />
					
						<g:sortableColumn property="qtdalimento" title="${message(code: 'contagemCarboidratos.qtdalimento.label', default: 'Qtdalimento')}" />
					
						<th><g:message code="contagemCarboidratos.alimento.label" default="Alimento" /></th>
					
						<th><g:message code="contagemCarboidratos.usuario.label" default="Usuario" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contagemCarboidratosInstanceList}" status="i" var="contagemCarboidratosInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${contagemCarboidratosInstance.id}">${fieldValue(bean: contagemCarboidratosInstance, field: "dia")}</g:link></td>
					
						<td>${fieldValue(bean: contagemCarboidratosInstance, field: "mes")}</td>
					
						<td>${fieldValue(bean: contagemCarboidratosInstance, field: "ano")}</td>
					
						<td>${fieldValue(bean: contagemCarboidratosInstance, field: "qtdalimento")}</td>
					
						<td>${fieldValue(bean: contagemCarboidratosInstance, field: "alimento")}</td>
					
						<td>${fieldValue(bean: contagemCarboidratosInstance, field: "usuario")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${contagemCarboidratosInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
