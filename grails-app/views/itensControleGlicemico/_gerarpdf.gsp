<%@ page import="carboidratos.ItensControleGlicemico" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<g:set var="entityName" value="${message(code: 'controleGlicemico.label', default: 'ControleGlicemico')}" />
		<title><g:message code="controle.list.label" /></title>
		<style type="text/css" media="all">
		
			body.bodyimpressao{
				background:#FFF;
				color:#000;
				margin: 0px auto;
				max-width:90%;
				font-size:13px;
				overflow-x:hidden;
				box-shadow:0px 0px 0px #fff;
			}
			
			table.impressao {
				background:#fff;
				width:100%;
				border:1px solid #000;
				border-collapse: collapse;
				margin-bottom: 1em;
			}
			
			table.impressao thead tr th {
				text-align:center;
				background:#fff;
				border:1px solid #000;
				color:#000;
				font-size:12px;
			}
			
			table.impressao tbody tr td {
				text-align:center;
				background:#fff;
				border:0px solid #000;
				color:#000;
				font-size:12px;
			}
			
		</style>
	</head>
	<body class="bodyimpressao" onload="window.print()">
	
			<table class="impressao">
					<thead>
							<tr>
								<th colspan="11">
									<g:message code="controle.list.label" />
									<g:message code="headerimpressaocontamgem.message" args="${[mes, ano, usuarioInstance.buscaNome(usuarioInstance)]}" />
								
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
						<g:each in="${resultado}" status="j" var="itensControleGlicemicoInstance">
								
								<g:set var="diaatual" value="${itensControleGlicemicoInstance.controleglicemico.dia}" />
								<g:if test="${diaanterior!=diaatual}">
									<tr class="nohover">
										<td><span>${itensControleGlicemicoInstance.controleglicemico.dia}</span></td>
										
									</tr>
								</g:if>
								<tr>
									
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