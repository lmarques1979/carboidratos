<%@ page import="seguranca.Usuario" %>
<legend><g:message code="dadosusuario.label"/></legend>
<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="usuario.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${usuarioInstance?.username}" placeholder="${message(code:'usuario.username.label') }"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="usuario.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="password" required="" value="${usuarioInstance?.password}" placeholder="${message(code:'usuario.password.label') }"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="usuario.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${usuarioInstance?.email}" placeholder="${message(code:'usuario.email.label') }"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'primeironome', 'error')} required">
	<label for="primeironome">
		<g:message code="usuario.primeironome.label" default="Primeironome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="primeironome" required="" value="${usuarioInstance?.primeironome}" placeholder="${message(code:'usuario.primeironome.label') }"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'sobrenome', 'error')} ">
	<label for="sobrenome">
		<g:message code="usuario.sobrenome.label" default="Sobrenome" />
		
	</label>
	<g:textField name="sobrenome" value="${usuarioInstance?.sobrenome}" placeholder="${message(code:'usuario.sobrenome.label') }"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'imagem', 'error')} ">
	<label for="imagem">
		<g:message code="usuario.imagem.label" default="Imagem" />
	</label>
	<input type="file" name="arquivo" placeholder="${message(code:'usuario.imagem.label') }"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="usuario.enabled.label" default="Enabled" />
	</label>
	<g:checkBox name="enabled" value="${usuarioInstance?.enabled}" />
</div>

<!--
<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="usuario.accountExpired.label" default="Account Expired" />
		
	</label><div class="clearer"></div>
	<g:checkBox name="accountExpired" value="${usuarioInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="usuario.accountLocked.label" default="Account Locked" />
		
	</label><div class="clearer"></div>
	<g:checkBox name="accountLocked" value="${usuarioInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="usuario.passwordExpired.label" default="Password Expired" />
		
	</label><div class="clearer"></div>
	<g:checkBox name="passwordExpired" value="${usuarioInstance?.passwordExpired}" />

</div>

-->