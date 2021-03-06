<%@ page import="carboidratos.Configuracao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'configuracao.label', default: 'Configuracao')}" />
		<title><g:message code="configuracao.list.label"/></title>
	</head>
	<body>
		<a href="#list-configuracao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<g:if test="${configuracaoInstanceCount==0}">
			<div class="nav" role="navigation">
				<ul>
					<li><g:link class="create" action="create"><g:message code="configuracao.create.label"/></g:link></li>
				</ul>
			</div>
		</g:if>
		<div id="list-configuracao" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						
						<g:sortableColumn property="alturaimagens" title="${message(code: 'configuracao.alturaimagens.label', default: 'Alturaimagens')}" />
					
						<g:sortableColumn property="larguraimagens" title="${message(code: 'configuracao.larguraimagens.label', default: 'Larguraimagens')}" />
					
						<g:sortableColumn property="alturaimagensthumbs" title="${message(code: 'configuracao.alturaimagensthumbs.label', default: 'Alturaimagensthumbs')}" />
					
						<g:sortableColumn property="larguraimagensthumbs" title="${message(code: 'configuracao.larguraimagensthumbs.label', default: 'Larguraimagensthumbs')}" />
					
						<g:sortableColumn property="itensporpagina" title="${message(code: 'configuracao.itensporpagina.label', default: 'Itensporpagina')}" />
					
						<g:sortableColumn property="metaglicose" title="${message(code: 'configuracao.metaglicose.label', default: 'Alturaimagens')}" />
						
						<g:sortableColumn property="sensibilidadeinsulina" title="${message(code: 'configuracao.sensibilidadeinsulina.label', default: 'Alturaimagens')}" />
						
						<g:sortableColumn property="sensibilidadecarboidrato" title="${message(code: 'configuracao.sensibilidadecarboidrato.label', default: 'Alturaimagens')}" />
						
						<g:sortableColumn property="qtdinsulinarepositorio" title="${message(code: 'configuracao.qtdinsulinarepositorio.label', default: 'Alturaimagens')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${configuracaoInstanceList}" status="i" var="configuracaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${configuracaoInstance.id}">${fieldValue(bean: configuracaoInstance, field: "alturaimagens")}</g:link></td>
						
						<td>${fieldValue(bean: configuracaoInstance, field: "larguraimagens")}</td>
					
						<td>${fieldValue(bean: configuracaoInstance, field: "alturaimagensthumbs")}</td>
					
						<td>${fieldValue(bean: configuracaoInstance, field: "larguraimagensthumbs")}</td>
					
						<td>${fieldValue(bean: configuracaoInstance, field: "itensporpagina")}</td>
					
						<td>${fieldValue(bean: configuracaoInstance, field: "metaglicose")}</td>
						
						<td>${fieldValue(bean: configuracaoInstance, field: "sensibilidadeinsulina")}</td>
						
						<td>${fieldValue(bean: configuracaoInstance, field: "sensibilidadecarboidrato")}</td>
						
						<td>${fieldValue(bean: configuracaoInstance, field: "qtdinsulinarepositorio")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${configuracaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
