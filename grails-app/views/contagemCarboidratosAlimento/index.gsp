<%@ page import="carboidratos.ContagemCarboidratosAlimento" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<g:if test="${params.ano}">
	<g:set var="ano" value="${params.int('ano')}" />
</g:if>
<g:else>
	<g:set var="ano" value="${formatDate(format:"yyyy" , date:new Date()).toInteger()}" />
</g:else>
<g:if test="${params.mes}">
	<g:set var="mes" value="${params.int('mes')}" />
</g:if>
<g:else>
	<g:set var="mes" value="${formatDate(format:"MM" , date:new Date()).toInteger()}" />
</g:else>
<g:if test="${params.dia}">
	<g:set var="dia" value="${params.int('dia')}" />
</g:if>
<g:else>
	<g:set var="dia" value="${formatDate(format:"dd" , date:new Date()).toInteger()}" />
</g:else>


<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contagemCarboidratosAlimento.label', default: 'ContagemCarboidratosAlimento')}" />
		<title><g:message code="contagem.list.label" /></title>
	</head>
	<body>
	
		<a href="#list-contagemCarboidratosAlimento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-contagemCarboidratosAlimento" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:hasErrors bean="${itensContagemCarboidratosInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${itensContagemCarboidratosInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			<g:if test="${flash.error}">
				<ul class="errors" role="alert">
					<g:each in="${flash.error}" status="i" var="error">
						<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:each>
				</ul>
			</g:if>
			
			<div class="filtro"> 
				<g:form url="[resource:itensContagemCarboidratosInstance, action:'index']" >
					<g:select onchange="this.form.submit()" value="${mes}" name="mes" from="${[message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]}" keys="${['1','2','3','4','5','6','7','8','9','10','11','12']}"/>
					<g:field onchange="this.form.submit()" class="ano" min="2000" name="ano" value="${ano}" type="number"/>
				</g:form>				
			</div><div class="clearer"></div>
			
			<g:form class="formtable" url="[resource:ContagemCarboidratosAlimentoInstance, action:'save']" > 
					<g:hiddenField name="mes" value="${mes}" />
					<g:hiddenField name="ano" value="${ano}" />
					<table>
					<thead>
							
							<tr>
								<th colspan="8"><g:message code="contagem.inserir.message"/></th>
							</tr>
							<tr>
							
								<th><g:message code="contagem.dia.label"/></th>
								
								<th><g:message code="contagem.refeicao.label"/></th>
							
								<th><g:message code="contagem.alimento.label"/></th>
							
								<th><g:message code="contagem.qtdalimento.label"/></th>
							
								<th><g:message code="contagem.alimentoforalista.label"/></th>
							
								<th><g:message code="contagem.qtdcarboidrato.label"/></th>
							
							</tr>
						</thead>
						<tbody>
						<tr>
							
								<td><g:field class="dia" size="5" max="31" min="1" name="dia" value="${formatDate(format:"dd" , date:new Date())}" type="number" required=""/></td>
								
								<td>
									<g:select id="refeicao" name="refeicao.id" from="${carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)}"  optionValue="descricao" optionKey="id" value="${params.refeicaoid}"/>
								</td>
								
								<td>
									<g:select class="alimento" noSelection="${['-1': message(code:'alimentonaocadastrado.label')]}" id="alimento" name="alimento.id" from="${carboidratos.Alimento.list()}"  optionValue="${{ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'} }" optionKey="id"/>
								</td>
								
								<td><g:field min="0" class="qtd" size="4" name="qtdalimento" type="number" /></td>
								
								<td><g:textField id="alimentoforalista" name="alimentoforalista" class="obs"/></td>
							
								<td><g:field min="0" id="carboidratos" class="qtd" size="4" name="qtdcarboidrato" type="number" /></td>
							
							</tr>
						</tbody>
						<tbody>
							<tr class="nohover">
								<td colspan="8">
									<fieldset class="buttons">
										<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
									</fieldset>
								</td>
							</tr>
						</tbody>
					</table>
			</g:form>
			
			<div class="menuacoes">
				
					<g:link controller="ContagemCarboidratosAlimento" target="_blank" action="imprimir" params="${[mes:mes, ano:ano]}">
						<asset:image src="skin/print.png" title="${message(code: 'imprimir.label')}"/>
					</g:link>
					
					<g:link controller="ContagemCarboidratosAlimento" action="enviarpdfemail" params="${[mes:mes, ano:ano]}">
						<asset:image src="skin/email.png" title="${message(code: 'email.label')}"/>
					</g:link>
					
					<!--<asset:image id="grafico" src="skin/grafico.png" title="${message(code: 'horas.grafico.label')}"/>
					-->
								
			</div><div class="clearer"></div>
			
			<g:render template="/links/linksdia"/>
			
			<g:form class="formtable" url="[resource:itensContagemCarboidratosInstance, action:'update']" > 
					<table>
					<thead>
							<tr>
								<th colspan="10"><g:message code="contagem.alterar.message"/></th>
							</tr>
							<tr>
								<th><g:message code="contagem.dia.label"/></th>
								
								<th></th>
								
								<th><g:message code="contagem.refeicao.label"/></th>
								
								<th></th>
							
								<th><g:message code="contagem.alimento.label"/></th>
							
								<th><g:message code="contagem.qtdalimento.label"/></th>
							
								<th><g:message code="contagem.alimentoforalista.label"/></th>
							
								<th><g:message code="contagem.qtdcarboidrato.label"/></th>
								
								<th><g:message code="contagem.totalchorefeicao.label"/></th>
								
								<th></th>
							</tr>
							
						</thead>
						<tbody>
						<g:set var="diaanterior" value="-1" />
						<g:set var="refeicaoanterior" value="-1" />
						<g:set var="totalrefeicao" value="0" />
						<g:hiddenField name="mes" value="${mes}" />
						<g:hiddenField name="ano" value="${ano}" />
						<g:each in="${contagemCarboidratosAlimentoInstanceList}" status="i" var="contagemCarboidratosAlimentoInstance">
									
							<g:hiddenField name="id" value="${contagemCarboidratosAlimentoInstance.id}"/>
							<g:set var="diaatual" value="${contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia}"/>
							<g:set var="refeicaoatual" value="${contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.id}"/>
							
							<g:if test="${diaanterior!=diaatual}">
								<tr class="listadia">
									<td><span>${contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia}</span></td>
									<td>
										<g:link params="[dia:diaatual,mes:mes,ano:ano]" onclick="return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');" action="delete" controller="ContagemCarboidratos"><asset:image class="excluir" src="skin/remove.png" title="${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}"/></g:link></li>
									</td>
									<td colspan="8"></td>
								</tr>
							</g:if>		
							<g:if test="${refeicaoanterior!=refeicaoatual}">
								<tr class="nohover">
									<td colspan="2"></td>
									<td>
										<span>${contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao}</span>
									</td>
									<td>
										<g:link onclick="return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');" id="${contagemCarboidratosAlimentoInstance.contagemcarboidratos.id}" action="deleterefeicaodia" controller="ContagemCarboidratos"><asset:image class="excluir" src="skin/remove.png" title="${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}"/></g:link></li>
									</td>
									
									<g:each in="${agrupamento}" status="k" var="agrupamentoInstance">
								    	
								    	<g:if test="${agrupamentoInstance[1]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.dia &&
													  agrupamentoInstance[2]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.mes &&
												  	  agrupamentoInstance[3]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.ano &&
													  agrupamentoInstance[4]==contagemCarboidratosAlimentoInstance.contagemcarboidratos.usuario.id &&
													  agrupamentoInstance[5]==refeicaoatual
												   }">
												   
										<td colspan="6" class="totalrefeicao">${message(code: 'totalrefeicao.label' , args: [contagemCarboidratosAlimentoInstance.contagemcarboidratos.refeicao.descricao , formatNumber(number:agrupamentoInstance[0],type:'number',format:'####.###')])}</td>
								    	</g:if>
								    	
								    </g:each>
	    
								</tr>
								
							</g:if>		
											
							<tr class="nohover">
							
								<td colspan="4"></td>
								
								<td>
									<g:if test="${contagemCarboidratosAlimentoInstance.alimento}">
										<g:select value="${contagemCarboidratosAlimentoInstance.alimento.id}" class="total" noSelection="${['-1': message(code:'alimentonaocadastrado.label')]}" id="alimento" name="alimento.id" from="${carboidratos.Alimento.list()}"  optionValue="${{ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'} }" optionKey="id"/>
									</g:if>
									<g:else>
										<g:select class="total" noSelection="${['-1': message(code:'alimentonaocadastrado.label')]}" id="alimento" name="alimento.id" from="${carboidratos.Alimento.list()}"  optionValue="${{ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'} }" optionKey="id"/>
									</g:else>
								</td>
															
								<td><g:field min="0" value="${contagemCarboidratosAlimentoInstance.qtdalimento}" class="qtd" size="4" name="qtdalimento" type="number" /></td>
								
								<td><g:textField value="${contagemCarboidratosAlimentoInstance.alimentoforalista}" id="alimentoforalista" name="alimentoforalista" class="obs"/></td>
							
								<td><g:field min="0" id="carboidratos" value="${contagemCarboidratosAlimentoInstance.qtdcarboidrato}" class="qtd" size="4" name="qtdcarboidrato" type="number" /></td>
							
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
								
								<td>
										<g:link params="[mes:mes,ano:ano]" onclick="return confirm('${message(code: 'excluiralimento.confirm.message', default: 'Are you sure?')}');" id="${contagemCarboidratosAlimentoInstance.id}" action="delete" controller="ContagemCarboidratosAlimento"><asset:image class="excluir" src="skin/remove.png" title="${message(code:'excluiralimento.confirm.message')}"/></g:link></li>
								</td>					
							</tr>
							<g:set var="diaanterior" value="${diaatual}"/>
							<g:set var="refeicaoanterior" value="${refeicaoatual}"/>
							
						</g:each>
						</tbody>
						<tbody>	
							<tr class="nohover">
								<td colspan="10">
									<fieldset class="buttons">
										<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
									</fieldset>
								</td>
							</tr>
						</tbody>
					</table>
			</g:form>

			
			<div class="pagination">
				<g:paginate total="${contagemCarboidratosAlimentoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
