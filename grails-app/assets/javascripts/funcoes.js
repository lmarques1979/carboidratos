function inserirLinha(){
	  var row = document.getElementById("clone");
	  var table = document.getElementById("tabelainclusao");
	  var clone = row.cloneNode(true);
	  table.appendChild(clone);
	  ($(clone).closest( "tr" ).find('#qtdalimento')).val('');
	  ($(clone).closest( "tr" ).find('#alimentoforalista')).val('');
	  ($(clone).closest( "tr" ).find('#carboidratos')).val('');
	  
	  ($(clone).closest( "tr" ).find('#alimentoforalista')).removeAttr('readonly');
	  ($(clone).closest( "tr" ).find('#carboidratos')).removeAttr('readonly');
}

$(document).on('change', '.alimento', function(e) {
	
    e.preventDefault;
    var value = this.value;
    var $cell = $(this).parent();
    var $row = $cell.parent();
    
    if(value=='-1'){
    	$row.find('#alimentoforalista').removeAttr('readonly');
    	$row.find('#carboidratos').removeAttr('readonly');
    }else{
    	($row.find('#alimentoforalista')).attr('readonly','readonly');
    	($row.find('#alimentoforalista')).val('');
    	($row.find('#carboidratos')).attr('readonly','readonly');
    	($row.find('#carboidratos')).val('');
    }
            
});

$(document).on('change', '#refeicaoins', function(e) {
	
    e.preventDefault;  
    var refeicaoid= this.value;
    var form=$("#formins");
    var dia=($("#formins").find('.dia')).val(); 
    var mes=($("#formins").find('#mes')).val(); 
    var ano=($("#formins").find('#ano')).val(); 
    
    $.ajax({
    	type:"POST",
    	url:"/contagemcarboidratos/itensControleGlicemico/buscatotalrefeicao/",
    	data:{dia:dia, mes:mes, ano:ano, refeicaoid:refeicaoid},
    	dataType: "json",
    	success:function(data, textStatus, jqXHR)
	    {
    		if( data.total!=null){
    			($("#formins").find('#qtdcarboidratos')).val('');
    			var totaldia = data.total.toFixed(2);
    			($("#formins").find('#qtdcarboidratos')).val(totaldia);	
    		}    
	    },
	    error: function(jqXHR, textStatus, errorThrown)
        {
	        	
        }
    });
 });

function carregaContagem() {  
	
	var form=$("#formins");
    var dia=($("#formins").find('.dia')).val(); 
    var mes=($("#formins").find('#mes')).val(); 
    var ano=($("#formins").find('#ano')).val(); 
    var refeicaoid=($("#formins").find('#refeicaoins')).val();;
    
    $.ajax({
    	type:"POST",
    	url:"/contagemcarboidratos/itensControleGlicemico/buscatotalrefeicao/",
    	data:{dia:dia, mes:mes, ano:ano, refeicaoid:refeicaoid},
    	dataType: "json",
    	success:function(data, textStatus, jqXHR)
	    {
    		if( data.total!=null){
    			($("#formins").find('#qtdcarboidratos')).val('');
    			var totaldia = data.total.toFixed(2);
    			($("#formins").find('#qtdcarboidratos')).val(totaldia);
    		}
		        
	    },
	    error: function(jqXHR, textStatus, errorThrown)
        {
	        	
        }
    });
};

function carregaContagemIns(tipo, objeto) {  
	
	var linha=$(objeto).closest("tr"); 
	var dia=($(linha).find('.dia')).val(); 
	var valorglicemiapre=($(linha).find('#valorglicemiapre')).val(); 
    var valorglicemiapos=($(linha).find('#valorglicemiapos')).val(); 
    var qtdcarboidratos=($(linha).find('#qtdcarboidratos')).val(); 
    var refeicaoid=($(linha).find('#refeicaoins')).val();
    var mes=($("#formins").find('#mes')).val(); 
    var ano=($("#formins").find('#ano')).val();  
    
    
    $.ajax({
    	type:"POST",
    	url:"/contagemcarboidratos/itensControleGlicemico/carregaCalculoIns",
    	data:{tipo:tipo , dia:dia, mes:mes, ano:ano, refeicaoid:refeicaoid , valorglicemiapre:valorglicemiapre , valorglicemiapos:valorglicemiapos ,qtdcarboidratos:qtdcarboidratos},
    	dataType: "json",
    	success:function(data, textStatus, jqXHR)
	    {
    		if(tipo=='0'){
    			
    			if(data.totalpre!=null){
    				($(linha).find('#qtdinsulinarapidapre')).val('');
    				var totalpre = data.totalpre.toFixed(0);
    				($(linha).find('#qtdinsulinarapidapre')).val(totalpre);
    			}
    		}  
    		if(tipo=='1'){
    			
    			if(data.totalpos!=null){
	    			($(linha).find('#qtdinsulinarapidapos')).val('');
		    		var totalpos = data.totalpos.toFixed(0);
		    		($(linha).find('#qtdinsulinarapidapos')).val(totalpos);
    			}
    		}  
    	},
	    error: function(jqXHR, textStatus, errorThrown)
        {
	        	var mensagem='';
	        	var i=0;
	        	while (i<jqXHR.responseJSON.length) {
	        		mensagem = mensagem + jqXHR.responseJSON[i] ;
	        		i++;
	        	}
	    }
    	
    });
};

function carregaContagemAlt(tipo , objeto) {  
	
	var valorid = $(objeto).attr('data-index');
	var linha=$(objeto).closest("tr");
	
	var dia=($(linha).find("#diaatual"+valorid)).val();
	var valorglicemiapre=($(linha).find("#valorglicemiaprealt"+valorid)).val();
	var valorglicemiapos=($(linha).find("#valorglicemiaposalt"+valorid)).val();
	var qtdcarboidratos=($(linha).find("#qtdcarboidratoalt"+valorid)).val(); 
	var refeicaoid=($(linha).find("#refeicaoalt"+valorid)).val(); 
	var mes=($("#formupd").find('#mesalt')).val(); 
    var ano=($("#formupd").find('#anoalt')).val(); 
   
    $.ajax({
    	type:"POST",
    	url:"/contagemcarboidratos/itensControleGlicemico/carregaCalculoIns",
    	data:{tipo:tipo , dia:dia, mes:mes, ano:ano, refeicaoid:refeicaoid , valorglicemiapre:valorglicemiapre , valorglicemiapos:valorglicemiapos ,qtdcarboidratos:qtdcarboidratos},
    	dataType: "json",
    	success:function(data, textStatus, jqXHR)
	    {
    		if(tipo=='0'){
    			($(linha).find('#qtdinsulinarapidaprealt')).val('');
				if(data.totalpre!=null && data.totalpre!=""){
    				var totalpre = data.totalpre.toFixed(0);
    				($(linha).find('#qtdinsulinarapidaprealt')).val(totalpre);
    			}
    		}  
    		if(tipo=='1'){
    			($(linha).find('#qtdinsulinarapidaposalt')).val('');
    			if(data.totalpos!=null && data.totalpos!=""){
	    			var totalpos = data.totalpos.toFixed(0);
		    		($(linha).find('#qtdinsulinarapidaposalt')).val(totalpos);
    			}
    		}  
    	},
	    error: function(jqXHR, textStatus, errorThrown)
        {
	        	var mensagem='';
	        	var i=0;
	        	while (i<jqXHR.responseJSON.length) {
	        		mensagem = mensagem + jqXHR.responseJSON[i] ;
	        		i++;
	        	}
	    }
    	
    });
};

$(document).on('change', '.valorglicemiaprealt', function(e) {
	e.preventDefault;  
	
	carregaContagemAlt(0 , this);
});

$(document).on('change', '.valorglicemiaposalt', function(e) {
	e.preventDefault;  
	carregaContagemAlt(1 , this);
});

$(document).on('change', '#valorglicemiapre', function(e) {
	e.preventDefault;  
	carregaContagemIns(0 , this);
});

$(document).on('change', '#valorglicemiapos', function(e) {
	e.preventDefault;  
	carregaContagemIns(1 , this);
});