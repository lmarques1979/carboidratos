
<%@ page import="carboidratos.Refeicao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'refeicao.label', default: 'Refeicao')}" />
		<title><g:message code="refeicao.list.label" /></title>
	</head>
	<body>
		<a href="#list-refeicao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="refeicao.new.label"/></g:link></li>
			</ul>
		</div>
		<div id="list-refeicao" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="descricao" title="${message(code: 'refeicao.descricao.label', default: 'Descricao')}" />
					
						<g:sortableColumn property="ordemrefeicao" title="${message(code: 'refeicao.ordemrefeicao.label', default: 'Ordemrefeicao')}" />
					
						<g:sortableColumn property="descontoinsulina" title="${message(code: 'refeicao.descontoinsulina.label', default: 'Desconto Insuina')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${refeicaoInstanceList}" status="i" var="refeicaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${refeicaoInstance.id}">${fieldValue(bean: refeicaoInstance, field: "descricao")}</g:link></td>
					
						<td>${fieldValue(bean: refeicaoInstance, field: "ordemrefeicao")}</td>
					
						<td>${fieldValue(bean: refeicaoInstance, field: "descontoinsulina")}</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${refeicaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
