<%@ page import="carboidratos.ItensControleGlicemico" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html>
<html>
	<head>
		<g:set var="entityName" value="${message(code: 'controleGlicemico.label', default: 'ControleGlicemico')}" />
		<title><g:message code="controle.list.label" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	<body class="bodyimpressao" onload="window.print()">
	
			<table class="impressao">
					<thead>
							<tr>
								<th colspan="11">
									<g:message code="controle.list.label" />
									<g:message code="headerimpressaocontamgem.message" args="${[params.mes, params.ano, usuarioInstance.buscaNome(usuarioInstance)]}" />
								
								</th>
							</tr>
							<tr>
							
								<th><g:message code="controle.dia.label"/></th>
								<th><g:message code="controle.refeicao.label" /></th>
								<th><g:message code="controle.qtdinsulinelenta.label" /></th>
								<th><g:message code="controle.valorglicemiapre.label" /></th>
								<th><g:message code="controle.qtdinsulinarapidapre.label" /></th>
								<th><g:message code="controle.qtdcarboidrato.label" /></th>
								<th><g:message code="controle.valorglicemiapos.label" /></th>
								<th><g:message code="controle.qtdinsulinarapidapos.label" /></th>
								<th><g:message code="controle.observacao.label"/></th>
								
							</tr>
						</thead>
						<tbody>
						
						<g:set var="diaanterior" value="-1" />
						<g:each in="${itensControleGlicemicoInstanceList}" status="j" var="itensControleGlicemicoInstance">
								
								<g:set var="diaatual" value="${itensControleGlicemicoInstance.controleglicemico.dia}" />
								
								<g:if test="${diaanterior!=diaatual}">
									<tr class="nohover">
										<td><span>${itensControleGlicemicoInstance.controleglicemico.dia}</span></td>
										
									</tr>
								</g:if>
								<tr class="nohover">
									
									<td></td>
									<td>
										${itensControleGlicemicoInstance.refeicao.descricao}
									</td>
									<td>${itensControleGlicemicoInstance.qtdinsulinelenta}</td>
									<td>${itensControleGlicemicoInstance.valorglicemiapre}</td>
									<td>${itensControleGlicemicoInstance.qtdinsulinarapidapre}</td>
									<td>${itensControleGlicemicoInstance.qtdcarboidrato}</td>
									<td>${itensControleGlicemicoInstance.valorglicemiapos}</td>
									<td>${itensControleGlicemicoInstance.qtdinsulinarapidapos}</td>
									<td>${itensControleGlicemicoInstance.observacao}</td>
																
								</tr>
								<g:set var="diaanterior" value="${diaatual}" />
						</g:each>
						
					</tbody>	
					
					
			</table>

	</body>
</html>
