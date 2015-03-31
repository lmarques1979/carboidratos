
<fieldset class="form">

		<legend><g:message code="selecionardia.label"/></legend>
		<div class="linksdia">
			<g:link class="${dia==0 ? 'atual' : '' }" action="${params.action}" controller="${params.controller}" params="[dia:'0']"><g:message code='todos.label'/></g:link>	
			<g:link class="${dia==1 ? 'atual' : '' }" action="${params.action}" controller="${params.controller}" params="[dia:'1']">1</g:link>	
			<g:link class="${dia==2 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'2']">2</g:link>	
			<g:link class="${dia==3 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'3']">3</g:link>	
			<g:link class="${dia==4 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'4']">4</g:link>	
			<g:link class="${dia==5 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'5']">5</g:link>	
			<g:link class="${dia==6 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'6']">6</g:link>	
			<g:link class="${dia==7 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'7']">7</g:link>	
			<g:link class="${dia==8 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'8']">8</g:link>	
			<g:link class="${dia==9 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'9']">9</g:link>	
			<g:link class="${dia==10 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'10']">10</g:link>	
			<g:link class="${dia==11 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'11']">11</g:link>	
			<g:link class="${dia==12 ? 'atual' : ''}"action="${params.action}" controller="${params.controller}" params="[dia:'12']">12</g:link>	
			<g:link class="${dia==13 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'13']">13</g:link>	
			<g:link class="${dia==14 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'14']">14</g:link>	
			<g:link class="${dia==15 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'15']">15</g:link>	
			<g:link class="${dia==16 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'16']">16</g:link>	
			<g:link class="${dia==17 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'17']">17</g:link>	
			<g:link class="${dia==18 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'18']">18</g:link>	
			<g:link class="${dia==19 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'19']">19</g:link>	
			<g:link class="${dia==20 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'20']">20</g:link>
			<g:link class="${dia==21 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'21']">21</g:link>	
			<g:link class="${dia==22 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'22']">22</g:link>	
			<g:link class="${dia==23 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'23']">23</g:link>	
			<g:link class="${dia==24 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'24']">24</g:link>	
			<g:link class="${dia==25 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'25']">25</g:link>	
			<g:link class="${dia==26 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'26']">26</g:link>	
			<g:link class="${dia==27 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'27']">27</g:link>	
			<g:link class="${dia==28 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'28']">28</g:link>	
			<g:link class="${dia==29 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'29']">29</g:link>
			<g:if test="${mes!=2}">
				<g:link class="${dia==30 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'30']">30</g:link>
				<g:if test="${mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12}">
					<g:link class="${dia==31 ? 'atual' : ''}" action="${params.action}" controller="${params.controller}" params="[dia:'31']">31</g:link>
				</g:if>
			</g:if>
		</div>
</fieldset>