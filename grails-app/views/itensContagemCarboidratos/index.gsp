
<%@ page import="carboidratos.ItensContagemCarboidratos" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itensContagemCarboidratos.label', default: 'ItensContagemCarboidratos')}" />
		<title><g:message code="contagem.list.label"/></title>
		<asset:javascript src="funcoes.js"/>
	</head>
	<body>
		<a href="#list-itensContagemCarboidratos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-itensContagemCarboidratos" class="content scaffold-list" role="main">
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
			
			<g:form class="formtable" url="[resource:itensContagemCarboidratosInstance, action:'save']" > 
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
							
								<th><g:message code="contagem.alimento.label"/>
							
								<th><g:message code="contagem.qtdalimento.label"/>
							
								<th><g:message code="contagem.alimentoforalista.label"/></th>
							
								<th><g:message code="contagem.qtdcarboidrato.label"/></th>
							
							</tr>
						</thead>
						<tbody>
						<tr>
							
								<td><g:field class="dia" size="5" max="31" min="1" name="dia" value="${formatDate(format:"dd" , date:new Date())}" type="number" required=""/></td>
								
								<td>
									<g:select id="refeicao" name="refeicao.id" from="${carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)}"  optionValue="descricao" optionKey="id" value="${params.int('refeicao.id')}"/>
								</td>
								
								<td>
									<g:select class="alimento" noSelection="${['-1': message(code:'alimentonaocadastrado.label')]}" id="alimento" name="alimento.id" from="${carboidratos.Alimento.list()}"  optionValue="${{ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'} }" optionKey="id"/>
								</td>
								
								<td><g:field class="qtd" size="4" name="qtdalimento" type="number" /></td>
								
								<td><g:textField id="alimentoforalista" name="alimentoforalista" class="obs"/></td>
							
								<td><g:field id="carboidratos" class="qtd" size="4" name="qtdcarboidrato" type="number" /></td>
							
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
							
								<th><g:message code="contagem.alimento.label"/>
							
								<th><g:message code="contagem.qtdalimento.label"/>
							
								<th><g:message code="contagem.alimentoforalista.label"/></th>
							
								<th><g:message code="contagem.qtdcarboidrato.label"/></th>
								
								<th><g:message code="contagem.totalchorefeicao.label"/></th>
								
								<th></th>
							</tr>
							
						</thead>
						<tbody>
						<g:set var="diaanterior" value="-1" />
						<g:set var="refeicaoanterior" value="-1" />
						<g:each in="${itensContagemCarboidratosInstanceList}" status="i" var="itensContagemCarboidratosInstance">
							
							<g:hiddenField name="id" value="${itensContagemCarboidratosInstance.id}"/>
							<g:set var="diaatual" value="${itensContagemCarboidratosInstance.refeicoescontagemcarboidratos.contagemcarboidratos.dia}"/>
							<g:set var="refeicaoatual" value="${itensContagemCarboidratosInstance.refeicoescontagemcarboidratos.refeicao.id}"/>
							
							<g:if test="${diaanterior!=diaatual}">
								<tr>
									<td><g:field class="dia" size="5" max="31" min="1" name="dia" value="${itensContagemCarboidratosInstance.refeicoescontagemcarboidratos.contagemcarboidratos.dia}" type="number" required=""/></td>
									<td>
										<g:link onclick="return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');" id="${itensContagemCarboidratosInstance.refeicoescontagemcarboidratos.contagemcarboidratos.id}" action="delete" controller="ContagemCarboidratos"><asset:image class="excluir" src="skin/remove.png" title="${message(code:'remove.label')}"/></g:link></li>
									</td>
								</tr>
							</g:if>		
							<g:if test="${refeicaoanterior!=refeicaoatual}">
								<tr>
									<td colspan="2"></td>
									<td>
										<g:select id="refeicao" name="refeicao.id" from="${carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)}"  optionValue="descricao" optionKey="id" value="${itensContagemCarboidratosInstance.refeicoescontagemcarboidratos.refeicao.id}"/>
									</td>
									<td>
										<g:link onclick="return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');" id="${itensContagemCarboidratosInstance.refeicoescontagemcarboidratos.id}" action="delete" controller="RefeicoesContagemCarboidratos"><asset:image class="excluir" src="skin/remove.png" title="${message(code:'remove.label')}"/></g:link></li>
									</td>
								</tr>
							</g:if>						
							<tr>
							
								<td colspan="4"></td>
								
								<td>
									<g:if test="${itensContagemCarboidratosInstance.alimento}">
										<g:select value="${itensContagemCarboidratosInstance.alimento.id}" class="total" noSelection="${['-1': message(code:'alimentonaocadastrado.label')]}" id="alimento" name="alimento.id" from="${carboidratos.Alimento.list()}"  optionValue="${{ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'} }" optionKey="id"/>
									</g:if>
									<g:else>
										<g:select class="total" noSelection="${['-1': message(code:'alimentonaocadastrado.label')]}" id="alimento" name="alimento.id" from="${carboidratos.Alimento.list()}"  optionValue="${{ it.nome + ' ' + it.medidausual + ' de ' + it.peso + 'g : ' + it.carboidratosg + 'g Carboidrato(s)'} }" optionKey="id"/>
									</g:else>
								</td>
															
								<td><g:field value="${itensContagemCarboidratosInstance.qtdalimento}" class="qtd" size="4" name="qtdalimento" type="number" /></td>
								
								<td><g:textField value="${itensContagemCarboidratosInstance.alimentoforalista}" id="alimentoforalista" name="alimentoforalista" class="obs"/></td>
							
								<td><g:field id="carboidratos" value="${itensContagemCarboidratosInstance.qtdcarboidrato}" class="qtd" size="4" name="qtdcarboidrato" type="number" /></td>
							
								<g:if test="${itensContagemCarboidratosInstance.alimento}">
									<td class="centro">
										<g:formatNumber number="${itensContagemCarboidratosInstance.qtdalimento*itensContagemCarboidratosInstance.alimento.carboidratosg}" type="number" format="####.###" />
									</td>
								</g:if>
								<g:else>
									<td class="centro">
										<g:formatNumber number="${itensContagemCarboidratosInstance.qtdalimento*itensContagemCarboidratosInstance.qtdcarboidrato}" type="number" format="####.###" />
									</td>
								</g:else>	
								
								<td>
										<g:link onclick="return confirm('${message(code: 'excluiralimento.confirm.message', default: 'Are you sure?')}');" id="${itensContagemCarboidratosInstance.id}" action="delete" controller="ItensContagemCarboidratos"><asset:image class="excluir" src="skin/remove.png" title="${message(code:'remove.label')}"/></g:link></li>
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
				<g:paginate total="${itensContagemCarboidratosInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
