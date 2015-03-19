
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
			
			<g:hasErrors bean="${controleGlicemicoInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${controleGlicemicoInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
						
			<div class="filtro"> 
				<g:form url="[resource:controleGlicemicoInstance, action:'index']" >
					<g:select onchange="this.form.submit()" value="${mes}" name="mes" from="${[message(code:'1.label'),message(code:'2.label'),message(code:'3.label'),message(code:'4.label'),message(code:'5.label'),message(code:'6.label'),message(code:'7.label'),message(code:'8.label'),message(code:'9.label'),message(code:'10.label'),message(code:'11.label'),message(code:'12.label')]}" keys="${['1','2','3','4','5','6','7','8','9','10','11','12']}"/>
					<g:field onchange="this.form.submit()" class="ano" min="2000" name="ano" value="${ano}" type="number"/>
				</g:form>				
			</div><div class="clearer"></div>
				
			<g:form class="formtable" url="[resource:controleGlicemicoInstance, action:'save']" > 
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
			<div class="pagination">
				<g:paginate total="${controleGlicemicoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
