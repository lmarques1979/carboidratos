
<%@ page import="carboidratos.ControleGlicemico" %>
<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'controleGlicemico.label', default: 'ControleGlicemico')}" />
		<title><g:message code="controle.list.label" /></title>
	</head>
	<body>
	
		<a href="#list-controleGlicemico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-controleGlicemico" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:hasErrors bean="${itensControleGlicemicoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${itensControleGlicemicoInstance}" var="error">
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
				<g:form url="[resource:itensControleGlicemicoInstance, action:'index']" >
					<g:select onchange="this.form.submit()" value="${mes}" name="mes" from="${[message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]}" keys="${['1','2','3','4','5','6','7','8','9','10','11','12']}"/>
					<g:field onchange="this.form.submit()" class="ano" min="2000" name="ano" value="${ano}" type="number"/>
				</g:form>				
			</div><div class="clearer"></div>
				
			<g:form class="formtable" url="[resource:itensControleGlicemicoInstance, action:'save']" > 
				<g:hiddenField name="mes" value="${mes}" />
				<g:hiddenField name="ano" value="${ano}" />
			
				<table>
					<thead>
							<tr>
								<th colspan="9"><g:message code="controle.new.label" /></th>
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
						
							<tr>
							
								<td><g:field class="dia" size="5" max="31" min="1" name="dia" value="${formatDate(format:"dd" , date:new Date())}" type="number" required=""/></td>
								<td>
									<g:select id="refeicao" name="refeicao.id" from="${carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)}"  optionValue="descricao" optionKey="id"/>
								</td>
								<td><g:field class="qtd" size="4" name="qtdinsulinelenta" type="number" /></td>
								<td><g:field class="qtd" size="4" name="valorglicemiapre" type="number" /></td>
								<td><g:field class="qtd" size="4" name="qtdinsulinarapidapre" type="number" /></td>
								<td><g:field class="qtd" size="4" name="qtdcarboidrato" type="number" /></td>
								<td><g:field class="qtd" size="4" name="valorglicemiapos" type="number" /></td>
								<td><g:field class="qtd" size="4" name="qtdinsulinarapidapos" type="number" /></td>
								<td><g:textField name="observacao" class="obs"/></td>
							
							</tr>
							
							<tr class="nohover">
								<td colspan="9">
									<fieldset class="buttons">
										<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
									</fieldset>
								</td>
							</tr>
						
						</tbody>
					</table>
			</g:form>
			
			<g:form class="formtable" url="[resource:itensControleGlicemicoInstance, action:'update']" > 
				
					<table>
					<thead>
							<tr>
								<th colspan="11"><g:message code="controle.list.label" /></th>
							</tr>
							<tr>
							
								<th><g:message code="controle.dia.label"/></th>
								<th></th>
								<th><g:message code="controle.refeicao.label" /></th>
								<th><g:message code="controle.qtdinsulinelenta.label" /></th>
								<th><g:message code="controle.valorglicemiapre.label" /></th>
								<th><g:message code="controle.qtdinsulinarapidapre.label" /></th>
								<th><g:message code="controle.qtdcarboidrato.label" /></th>
								<th><g:message code="controle.valorglicemiapos.label" /></th>
								<th><g:message code="controle.qtdinsulinarapidapos.label" /></th>
								<th><g:message code="controle.observacao.label"/></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						
						<g:set var="diaanterior" value="-1" />
						<g:each in="${itensControleGlicemicoInstanceList}" status="j" var="itensControleGlicemicoInstance">
								
								<g:hiddenField name="id" value="${itensControleGlicemicoInstance.id}" />
								<g:set var="diaatual" value="${itensControleGlicemicoInstance.controleglicemico.dia}" />
								
								<g:if test="${diaanterior!=diaatual}">
									<tr>
										<td><g:field class="dia" size="5" max="31" min="1" name="dia" value="${itensControleGlicemicoInstance.controleglicemico.dia}" type="number" required=""/></td>
										<td>
											<g:link onclick="return confirm('${message(code: 'excluirdia.confirm.message', default: 'Are you sure?')}');" id="${itensControleGlicemicoInstance.controleglicemico.id}" action="delete" controller="ControleGlicemico"><asset:image class="excluir" src="skin/remove.png" title="${message(code:'remove.label')}"/></g:link></li>
										</td>
									</tr>
								</g:if>
								<tr>
									
									<td colspan="2"></td>
									<td>
										<g:select id="refeicao" name="refeicao.id" from="${carboidratos.Refeicao.refeicaoUsuario(usuarioInstance)}" value="${itensControleGlicemicoInstance.refeicao.id}" optionValue="descricao" optionKey="id"/>
									</td>
									<td><g:field class="qtd" size="4" name="qtdinsulinelenta" type="number" value="${itensControleGlicemicoInstance.qtdinsulinelenta}"/></td>
									<td><g:field class="qtd" size="4" name="valorglicemiapre" type="number" value="${itensControleGlicemicoInstance.valorglicemiapre}"/></td>
									<td><g:field class="qtd" size="4" name="qtdinsulinarapidapre" type="number" value="${itensControleGlicemicoInstance.qtdinsulinarapidapre}"/></td>
									<td><g:field class="qtd" size="4" name="qtdcarboidrato" type="number" value="${itensControleGlicemicoInstance.qtdcarboidrato}"/></td>
									<td><g:field class="qtd" size="4" name="valorglicemiapos" type="number" value="${itensControleGlicemicoInstance.valorglicemiapos}"/></td>
									<td><g:field class="qtd" size="4" name="qtdinsulinarapidapos" type="number" value="${itensControleGlicemicoInstance.qtdinsulinarapidapos}"/></td>
									<td><g:textField name="observacao" class="obs" value="${itensControleGlicemicoInstance.observacao}"/></td>
									<td>
										<g:link onclick="return confirm('${message(code: 'excluirrefeicao.confirm.message', default: 'Are you sure?')}');" id="${itensControleGlicemicoInstance.id}" action="delete" controller="ItensControleGlicemico"><asset:image class="excluir" src="skin/remove.png" title="${message(code:'remove.label')}"/></g:link></li>
									</td>							
								</tr>
								<g:set var="diaanterior" value="${diaatual}" />
						</g:each>
						
					</tbody>	
					
					<tbody>	
							<tr class="nohover">
								<td colspan="11">
									<fieldset class="buttons">
										<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
									</fieldset>
								</td>
							</tr>
					</tbody>
					</table>
			</g:form>
			
			<div class="pagination">
				<g:paginate total="${controleGlicemicoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
