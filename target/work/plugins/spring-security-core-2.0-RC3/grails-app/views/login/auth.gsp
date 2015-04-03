<html>
<head>
	<meta name='layout' content='main'/>
	<title><g:message code="springSecurity.login.title"/></title>
	<style type='text/css' media='screen'>
	
	</style>
</head>

<body>
<div id='login'>
	<div class='inner'>
		
		<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
		</g:if>

		<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
		
		 <fieldset class="form">	
				<legend><g:message code="loginaplicacao.label"/></legend>
				
				<div class="fieldcontain">
						<label for="username">
						<g:message code="springSecurity.login.username.label"/>
						<span class="required-indicator">*</span>
					</label>
					<g:textField id="username" name="j_username"  placeholder="${message(code:'usuario.username.label') }"/>
				</div>
				
				<div class="fieldcontain">
					<label for="username">
						<g:message code="springSecurity.login.password.label"/>
						<span class="required-indicator">*</span>
					</label>
					<g:passwordField id="password" name="j_password"  placeholder="${message(code:'usuario.password.label') }"/>		
				</div>
				<br>
				
				<div class="fieldcontain">
					<g:link class="esqueceu" controller="Usuario" action="esqueceusenha"><g:message code="esqueceusenha.label"/></g:link> 
				</div>
			</fieldset>
			<g:submitButton id="submit" name="create" value="${message(code: "springSecurity.login.button")}" />
		</form>
	</div>
</div>
<script type='text/javascript'>
	<!--
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
	// -->
</script>
</body>
</html>