<%@ page import="seguranca.Usuario" %>
<html>
<head>
	<meta name='layout' content='main'/>
	<title><g:message code="esqueceusenha.label"/></title>
</head>

<body>
<div id='login'>
	<div class='inner'>
		
		<g:if test='${flash.message}'>
			<g:each in="${flash.message}" status="i" var="mensagem">
				<div class='login_message'>${mensagem}</div>
			</g:each>
		</g:if>
		
		<g:if test='${flash.erros}'>
			<ul class="errors" role="alert">
				<g:each in="${flash.erros}" status="i" var="error">
					<li>${error}</li>
				</g:each>
			</ul>
		</g:if>

		<form action='enviarsenha' method='POST' id='loginForm' class='cssform' autocomplete='off'>
		
		 <fieldset class="form">	
				<legend><g:message code="esqueceusenha.label"/></legend>
				
				<div class="fieldcontain  required">
						<label for="username">
						<g:message code="dadosusuario.label"/>
						<span class="required-indicator">*</span>
					</label>
					<g:textField id="username" name="username"  placeholder="${message(code:'usuario.username.label') }"/>
				</div>
				
				<div class="fieldcontain  required">
					<label for="username">
						<g:message code="usuario.email.label"/>
						<span class="required-indicator">*</span>
					</label>
					<g:textField id="email" name="email"  placeholder="${message(code:'usuario.email.label') }"/>		
				</div>
				<br>
				
			</fieldset>
			<g:submitButton id="submit" name="create" value="${message(code: "usuario.enviarsenha")}" />
		</form>
	</div>
</div>
<script type='text/javascript'>
	(function() {
		document.forms['loginForm'].elements['username'].focus();
	})();
</script>
</body>
</html>
