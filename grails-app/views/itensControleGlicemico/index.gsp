
<%@ page import="carboidratos.ItensControleGlicemico" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itensControleGlicemico.label', default: 'ItensControleGlicemico')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-itensControleGlicemico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-itensControleGlicemico" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="qtdinsulinelenta" title="${message(code: 'itensControleGlicemico.qtdinsulinelenta.label', default: 'Qtdinsulinelenta')}" />
					
						<g:sortableColumn property="valorglicemiapre" title="${message(code: 'itensControleGlicemico.valorglicemiapre.label', default: 'Valorglicemiapre')}" />
					
						<g:sortableColumn property="qtdinsulinarapidapre" title="${message(code: 'itensControleGlicemico.qtdinsulinarapidapre.label', default: 'Qtdinsulinarapidapre')}" />
					
						<g:sortableColumn property="qtdcarboidrato" title="${message(code: 'itensControleGlicemico.qtdcarboidrato.label', default: 'Qtdcarboidrato')}" />
					
						<g:sortableColumn property="valorglicemiapos" title="${message(code: 'itensControleGlicemico.valorglicemiapos.label', default: 'Valorglicemiapos')}" />
					
						<g:sortableColumn property="qtdinsulinarapidapos" title="${message(code: 'itensControleGlicemico.qtdinsulinarapidapos.label', default: 'Qtdinsulinarapidapos')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itensControleGlicemicoInstanceList}" status="i" var="itensControleGlicemicoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itensControleGlicemicoInstance.id}">${fieldValue(bean: itensControleGlicemicoInstance, field: "qtdinsulinelenta")}</g:link></td>
					
						<td>${fieldValue(bean: itensControleGlicemicoInstance, field: "valorglicemiapre")}</td>
					
						<td>${fieldValue(bean: itensControleGlicemicoInstance, field: "qtdinsulinarapidapre")}</td>
					
						<td>${fieldValue(bean: itensControleGlicemicoInstance, field: "qtdcarboidrato")}</td>
					
						<td>${fieldValue(bean: itensControleGlicemicoInstance, field: "valorglicemiapos")}</td>
					
						<td>${fieldValue(bean: itensControleGlicemicoInstance, field: "qtdinsulinarapidapos")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itensControleGlicemicoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
