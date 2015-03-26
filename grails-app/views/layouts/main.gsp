<%@ page import="seguranca.Usuario" %>
<sec:ifLoggedIn>
	<g:set var="usuarioInstance" value="${Usuario.get(sec.loggedInUserInfo(field: 'id'))}" />
</sec:ifLoggedIn>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>
		<div id="header">
			
			<div id="logo">
				
				<div class="nacionalizacao">
					<g:link id="${params.id}" action="${params.action ? params.action : 'index'}" controller="${params.controller ? params.controller : 'index'}" params="[lang: 'pt_BR']"><asset:image class="internacionalizacao" src="bandeiras/24/Brazil.png" title="${message(code:'portuguesbrasil.label')}"/></g:link>
					<g:link id="${params.id}" action="${params.action ? params.action : 'index'}" controller="${params.controller ? params.controller : 'index'}" params="[lang: 'en']"><asset:image class="internacionalizacao" src="bandeiras/24/britain.png" title="${message(code:'english.label')}"/></g:link>	
					<g:link id="${params.id}" action="${params.action ? params.action : 'index'}" controller="${params.controller ? params.controller : 'index'}" params="[lang: 'es']"><asset:image class="internacionalizacao" src="bandeiras/24/spain.png" title="${message(code:'spain.label')}"/></g:link>
				</div>				
				
			</div>
			
			<div id="menu">
				<ul>
						
					<sec:ifNotLoggedIn>
						<li><g:link class="${params.controller=='alimento' && params.action=='index' ? 'active' : '' }" controller="Alimento" action="index"><g:message code="listaalimentos.label"/></g:link></li>
						<li><g:link class="${params.controller=='usuario' && params.action=='create' ? 'active' : '' }" controller="Usuario" action="create"><g:message code="cadastrousuario.label"/></g:link></li>
						<li><g:link class="${params.controller=='login' && params.action=='auth' ? 'active' : '' }" controller="login" action="auth"><g:message code="login.label"/></g:link></li>
					</sec:ifNotLoggedIn>
					<sec:ifLoggedIn>
						<g:if test="${sec.loggedInUserInfo(field: 'username') == 'admin'}">
							<li><g:link class="${params.controller=='usuario' ? 'active' : '' }" controller="Usuario" action="index"><g:message code="usuario.list.label"/></g:link></li>
							<li><g:link class="${params.controller=='alimento'  && params.action!='create' ? 'active' : '' }" controller="Alimento" action="index"><g:message code="listaalimentos.label"/></g:link></li>
							<li><g:link class="${params.controller=='alimento'  && params.action=='create' ? 'active' : '' }" controller="Alimento" action="create"><g:message code="cadastroalimento.label"/></g:link></li>
							<li><g:link class="${params.controller=='configuracoes' ? 'active' : '' }" controller="Configuracoes" action="index"><g:message code="configuracoes.label"/></g:link></li>
						</g:if>
						<g:else>
							<li><g:link class="${params.controller=='configuracao' ? 'active' : '' }" controller="Configuracao" action="index"><g:message code="configuracao.label"/></g:link></li>
							<li><g:link class="${params.controller=='refeicao' ? 'active' : '' }" controller="Refeicao" action="index"><g:message code="refeicao.label"/></g:link></li>
							<li><g:link class="${params.controller=='alimento' ? 'active' : '' }" controller="Alimento" action="index"><g:message code="listaalimentos.label"/></g:link></li>
							<li><g:link class="${params.controller=='itensControleGlicemico' ? 'active' : '' }" controller="ItensControleGlicemico" action="index"><g:message code="controle.label"/></g:link></li>
							<li><g:link class="${params.controller=='contagemCarboidratosAlimento' && params.action=='index'? 'active' : '' }" controller="ContagemCarboidratosAlimento" action="index"><g:message code="contagem.label"/></g:link></li>
						</g:else>
						<li><g:link controller="Logout" action="index"><g:message code="logout.label"/></g:link></li>
					</sec:ifLoggedIn>
				</ul>
				
				<sec:ifLoggedIn>
					<div class="logousuario">
						<g:if test="${usuarioInstance.imagem}">
							<g:link controller="usuario" action="show" id="${usuarioInstance.id}">
								<asset:image height="40" width="40" src="${usuarioInstance.imagem}" title="${usuarioInstance.buscaNome(usuarioInstance) + ' [ ' + usuarioInstance.username + ' ] '}"/>
							</g:link>
						</g:if>	
						<g:else>
							<g:link class="usuario" controller="Usuario" action="show" id="${sec.loggedInUserInfo(field:"id")}">
								<asset:image height="40" width="40" src="noimage.jpg" title="${usuarioInstance.buscaNome(usuarioInstance) + ' [ ' + usuarioInstance.username + ' ] '}"/>
							</g:link>
						</g:else>
					</div>
				</sec:ifLoggedIn>
			</div>
		</div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo"><g:message code="footer.label"/></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
