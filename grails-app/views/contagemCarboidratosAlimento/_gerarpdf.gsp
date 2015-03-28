
<%@ page import="carboidratos.ContagemCarboidratosAlimento" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<g:set var="entityName" value="${message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento')}" />
		<title><g:message code="contagem.list.label" /></title>
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
	<body class="bodyimpressao">
	
	    <table class="impressao">
					<thead>
							<tr>
								<th colspan="7">
									<g:message code="contagem.alterar.message"/>
								  	<g:message code="headerimpressaocontamgem.message" args="${[mes, ano , usuarioInstance.buscaNome(usuarioInstance)]}"/>
								</th>
							</tr>
							<tr>
								<th><g:message code="contagem.dia.label"/></th>
								<th><g:message code="contagem.refeicao.label"/></th>
								<th><g:message code="contagem.alimento.label"/></th>
								<th><g:message code="contagem.qtdalimento.label"/></th>
								<th><g:message code="contagem.alimentoforalista.label"/></th>
								<th><g:message code="contagem.qtdcarboidrato.label"/></th>
								<th><g:message code="contagem.totalchorefeicao.label"/></th>
							</tr>
						</thead>
						<tbody>
						<g:set var="diaanterior" value="-1" />
						<g:set var="refeicaoanterior" value="-1" />
						<g:set var="totalrefeicao" value="0" />
						<g:each in="${resultado}" status="i" var="contagemCarboidratosAlimentoInstance">
							<g:set var="diaatual" value="${contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia}"/>
							<g:set var="refeicaoatual" value="${contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id}"/>
							<g:if test="${diaanterior!=diaatual}">
								<tr class="nohover">
									<td><span>${contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia}</span></td>
								</tr>
							</g:if>		
							<g:if test="${refeicaoanterior!=refeicaoatual}">
								<tr>
									<td></td>
									<td>
										<span>${contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao}</span>
									</td>
								</tr>
							</g:if>		
							<tr>
								<td colspan="2"></td>
								<td>
									<g:if test="${contagemCarboidratosAlimentoInstance.alimento}">
											${contagemCarboidratosAlimentoInstance.alimento.nome}
									</g:if>
									<g:else>
											${message(code:'alimentonaocadastrado.label') }
									</g:else>
								</td>
								<td>${contagemCarboidratosAlimentoInstance.qtdalimento}</td>
								<td>${contagemCarboidratosAlimentoInstance.alimentoforalista}</td>
								<td>${contagemCarboidratosAlimentoInstance.qtdcarboidrato}</td>
								<g:if test="${contagemCarboidratosAlimentoInstance.alimento}">
									<td class="centro">
										<g:set var="totaldia" value="${contagemCarboidratosAlimentoInstance.qtdalimento*contagemCarboidratosAlimentoInstance.alimento.carboidratosg}" />
										<g:formatNumber number="${totaldia}" type="number" format="####.###" />
									</td>
								</g:if>
								<g:else>
									<td class="centro">
										<g:set var="totaldia" value="${contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0)}" />
										<g:formatNumber number="${totaldia}" type="number" format="####.###" />
									</td>
								</g:else>	
							</tr>
							<g:set var="diaanterior" value="${diaatual}"/>
							<g:set var="refeicaoanterior" value="${refeicaoatual}"/>
						</g:each>
				</tbody>
			</table>
	</body>
</html>