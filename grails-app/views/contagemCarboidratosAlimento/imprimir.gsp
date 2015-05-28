
<%@ page import="carboidratos.ContagemCarboidratosAlimento" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html>
<html>
	<head>
		<g:set var="entityName" value="${message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento')}" />
		<title><g:message code="contagem.list.label" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	<body class="bodyimpressao" onload="window.print()">
		<table class="impressao">
					<thead>
							<tr>
								<th colspan="7">
								<g:message code="contagem.alterar.message"/>
								<g:message code="headerimpressaocontamgem.message" args="${[params.mes, params.ano , usuarioInstance.buscaNome(usuarioInstance)]}" />
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
						<g:each in="${contagemCarboidratosAlimentoInstanceList}" status="i" var="contagemCarboidratosAlimentoInstance">
									
							<g:set var="diaatual" value="${contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia}"/>
							<g:set var="refeicaoatual" value="${contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id}"/>
							
							<g:if test="${diaanterior!=diaatual}">
								<tr class="listadia">
									<td><span>${contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia}</span></td>
									<td colspan="6"></td>
								</tr>
							</g:if>		
							<g:if test="${refeicaoanterior!=refeicaoatual}">
								<tr class="nohover descricaorefeicao">
									<td></td>
									<td>
										<span>${contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao}</span>
									</td>
									<g:each in="${agrupamento}" status="k" var="agrupamentoInstance">
								    
								    	<g:if test="${agrupamentoInstance[1]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia &&
													  agrupamentoInstance[2]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.mes &&
												  	  agrupamentoInstance[3]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.ano &&
													  agrupamentoInstance[4]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.usuario.id &&
													  agrupamentoInstance[5]==refeicaoatual
												   }">
								    	<td colspan="6" class="totalrefeicao">${message(code: 'totalrefeicao.label' , args: [contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao , formatNumber(number:agrupamentoInstance[0],type:'number',maxFractionDigits:'2')])}</td>
								    	</g:if>
								    	
								    </g:each>
								</tr>
								
							</g:if>		
											
							<tr class="nohover">
							
								<td colspan="2"></td>
								
								<td class="tab">
									<g:if test="${contagemCarboidratosAlimentoInstance.alimento}">
											${contagemCarboidratosAlimentoInstance.alimento.nome + ' ' + contagemCarboidratosAlimentoInstance.alimento.medidausual + ' de ' + contagemCarboidratosAlimentoInstance.alimento.peso + 'g : ' + contagemCarboidratosAlimentoInstance.alimento.carboidratosg + 'g Carboidrato(s)'}
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
										<g:formatNumber number="${totaldia}" type="number" maxFractionDigits="2" />
									</td>
								</g:if>
								<g:else>
									<td class="centro">
										<g:set var="totaldia" value="${contagemCarboidratosAlimentoInstance.qtdalimento* (contagemCarboidratosAlimentoInstance.qtdcarboidrato ? contagemCarboidratosAlimentoInstance.qtdcarboidrato : 0)}" />
										<g:formatNumber number="${totaldia}" type="number" maxFractionDigits="2" />
									</td>
								</g:else>	
													
							</tr>
							<g:set var="diaanterior" value="${diaatual}"/>
							<g:set var="refeicaoanterior" value="${refeicaoatual}"/>
						</g:each>
				</tbody>
						
			</table>
			

		</div>
	</body>
</html>
