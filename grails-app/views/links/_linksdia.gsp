<g:if test="${(((ano%4==0) && (ano%100!=0)) || (ano%400==0))}">
	<g:set var="bisexto" value="${1.toInteger()}" />
</g:if>
<g:else>
	<g:set var="bisexto" value="${0.toInteger()}" />
</g:else>

<fieldset class="form">

		<legend><g:message code="selecionardia.label"/></legend>
		<div class="linksdia">
			<g:link class="${dia==0 ? 'atual' : 'dia' }" action="${params.action}" controller="${params.controller}" params="[dia:'0' , mes:mes , ano:ano]"><g:message code='todos.label'/></g:link>	
			<g:link class="${dia==1 ? 'atual' : 'dia' }" action="${params.action}" controller="${params.controller}" params="[dia:'1', mes:mes , ano:ano]">1</g:link>	
			<g:link class="${dia==2 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'2', mes:mes , ano:ano]">2</g:link>	
			<g:link class="${dia==3 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'3', mes:mes , ano:ano]">3</g:link>	
			<g:link class="${dia==4 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'4', mes:mes , ano:ano]">4</g:link>	
			<g:link class="${dia==5 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'5', mes:mes , ano:ano]">5</g:link>	
			<g:link class="${dia==6 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'6', mes:mes , ano:ano]">6</g:link>	
			<g:link class="${dia==7 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'7', mes:mes , ano:ano]">7</g:link>	
			<g:link class="${dia==8 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'8', mes:mes , ano:ano]">8</g:link>	
			<g:link class="${dia==9 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'9', mes:mes , ano:ano]">9</g:link>	
			<g:link class="${dia==10 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'10', mes:mes , ano:ano]">10</g:link>	
			<g:link class="${dia==11 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'11', mes:mes , ano:ano]">11</g:link>	
			<g:link class="${dia==12 ? 'atual' : 'dia'}"action="${params.action}" controller="${params.controller}" params="[dia:'12', mes:mes , ano:ano]">12</g:link>	
			<g:link class="${dia==13 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'13', mes:mes , ano:ano]">13</g:link>	
			<g:link class="${dia==14 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'14', mes:mes , ano:ano]">14</g:link>	
			<g:link class="${dia==15 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'15', mes:mes , ano:ano]">15</g:link>	
			<g:link class="${dia==16 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'16', mes:mes , ano:ano]">16</g:link>	
			<g:link class="${dia==17 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'17', mes:mes , ano:ano]">17</g:link>	
			<g:link class="${dia==18 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'18', mes:mes , ano:ano]">18</g:link>	
			<g:link class="${dia==19 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'19', mes:mes , ano:ano]">19</g:link>	
			<g:link class="${dia==20 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'20', mes:mes , ano:ano]">20</g:link>
			<g:link class="${dia==21 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'21', mes:mes , ano:ano]">21</g:link>	
			<g:link class="${dia==22 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'22', mes:mes , ano:ano]">22</g:link>	
			<g:link class="${dia==23 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'23', mes:mes , ano:ano]">23</g:link>	
			<g:link class="${dia==24 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'24', mes:mes , ano:ano]">24</g:link>	
			<g:link class="${dia==25 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'25', mes:mes , ano:ano]">25</g:link>	
			<g:link class="${dia==26 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'26', mes:mes , ano:ano]">26</g:link>	
			<g:link class="${dia==27 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'27', mes:mes , ano:ano]">27</g:link>	
			<g:link class="${dia==28 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'28', mes:mes , ano:ano]">28</g:link>	
			
			<g:if test="${ ((mes==2 && bisexto) || (mes!=2))}">
				<g:link class="${dia==29 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'29', mes:mes , ano:ano]">29</g:link>
			</g:if>
			
			<g:if test="${mes!=2}">
				<g:link class="${dia==30 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'30', mes:mes , ano:ano]">30</g:link>
				<g:if test="${mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12}">
					<g:link class="${dia==31 ? 'atual' : 'dia'}" action="${params.action}" controller="${params.controller}" params="[dia:'31', mes:mes , ano:ano]">31</g:link>
				</g:if>
			</g:if>
		</div>
</fieldset>