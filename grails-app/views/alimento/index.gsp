
<%@ page import="carboidratos.Alimento" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'alimento.label', default: 'Alimento')}" />
		<title><g:message code="alimento.list.label"/></title>
	</head>
	<body>
		<a href="#list-alimento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-alimento" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<div id="buscaalimento">
				<g:form url="[resource:alimentosInstance, action:'index']" >
					<div class="busca">
						<g:textField name="nome" class="dadosbusca" placeholder="${message(code:'busca.label')}"/>
						<g:submitButton name="submit" class="botaobuscar" value=""/>
					</div>
				</g:form>
			</div>
			
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'alimento.nome.label', default: 'Nome')}" />
					
						<th>${message(code: 'alimento.imagem.label')}</th>
						
						<g:sortableColumn property="medidausual" title="${message(code: 'alimento.medidausual.label', default: 'Medidausual')}" />
					
						<g:sortableColumn property="peso" title="${message(code: 'alimento.peso.label', default: 'Peso')}" />
					
						<g:sortableColumn property="caloriaskcal" title="${message(code: 'alimento.caloriaskcal.label', default: 'Caloriaskcal')}" />
					
						<g:sortableColumn property="carboidratosg" title="${message(code: 'alimento.carboidratosg.label', default: 'Carboidratosg')}" />
					
						<g:sortableColumn property="carboidratoskcal" title="${message(code: 'alimento.carboidratoskcal.label', default: 'Carboidratoskcal')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${alimentoInstanceList}" status="i" var="alimentoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<g:if test="${sec.loggedInUserInfo(field: 'username') == 'admin'}">
							<td><g:link action="show" id="${alimentoInstance.id}">${fieldValue(bean: alimentoInstance, field: "nome")}</g:link></td>
						</g:if>
						<g:else>
							<td>${fieldValue(bean: alimentoInstance, field: "nome")}</td>
						</g:else>
						
						<g:if test="${alimentoInstance?.imagem}">
							<td><asset:image height="${params.alturaimagens}" width="${params.larguraimagens}" src="${alimentoInstance.imagem}" title="${alimentoInstance?.nome}"/></td>
						</g:if>
						<g:else>
							<td></td>
						</g:else>
						
						<td>${alimentoInstance.medidausual}</td>
						
						<td>${formatNumber(number:alimentoInstance.peso,maxFractionDigits:2 , minFractionDigits:2 )}</td>
					
						<td>${formatNumber(number:alimentoInstance.caloriaskcal,maxFractionDigits:2 , minFractionDigits:2 )}</td>
					
						<td>${formatNumber(number:alimentoInstance.carboidratosg,maxFractionDigits:2 , minFractionDigits:2 )}</td>
					
						<td>${formatNumber(number:alimentoInstance.carboidratoskcal,maxFractionDigits:2 , minFractionDigits:2 )}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${alimentoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
