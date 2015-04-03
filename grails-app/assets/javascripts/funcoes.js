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

function carregaContagemIns(tipo) {  
	
	var form=$("#formins");
    var dia=($("#formins").find('.dia')).val(); 
    var mes=($("#formins").find('#mes')).val(); 
    var ano=($("#formins").find('#ano')).val(); 
    var valorglicemiapre=($("#formins").find('#valorglicemiapre')).val(); 
    var valorglicemiapos=($("#formins").find('#valorglicemiapos')).val(); 
    var qtdcarboidratos=($("#formins").find('#qtdcarboidratos')).val(); 
    var refeicaoid=($("#formins").find('#refeicaoins')).val();;
    
    $.ajax({
    	type:"POST",
    	url:"/contagemcarboidratos/itensControleGlicemico/carregaCalculoIns",
    	data:{tipo:tipo , dia:dia, mes:mes, ano:ano, refeicaoid:refeicaoid , valorglicemiapre:valorglicemiapre , valorglicemiapos:valorglicemiapos ,qtdcarboidratos:qtdcarboidratos},
    	dataType: "json",
    	success:function(data, textStatus, jqXHR)
	    {
    		if(tipo=='0'){
    			
    			if(data.totalpre!=null){
    				($("#formins").find('#qtdinsulinarapidapre')).val('');
    				var totalpre = data.totalpre.toFixed(0);
    				($("#formins").find('#qtdinsulinarapidapre')).val(totalpre);
    			}
    		}  
    		if(tipo=='1'){
    			
    			if(data.totalpos!=null){
	    			($("#formins").find('#qtdinsulinarapidapos')).val('');
		    		var totalpos = data.totalpos.toFixed(0);
		    		($("#formins").find('#qtdinsulinarapidapos')).val(totalpos);
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

function carregaContagemAlt(tipo) {  
	
	var $cell = $("#formalt").parent();
	var $row = $cell.parent();
	    
	var dia=($row.find('#diaatual')).val(); 
    var mes=($row.find('#mesalt')).val(); 
    var ano=($row.find('#ano')).val(); 
    var valorglicemiapre=($row.find('#valorglicemiaprealt')).val(); 
    var valorglicemiapos=($row.find('#valorglicemiaposalt')).val(); 
    var qtdcarboidratos=($row.find('#qtdcarboidratoalt')).val(); 
    var refeicaoid=($row.find('#refeicaoalt')).val();;
    
    $.ajax({
    	type:"POST",
    	url:"/contagemcarboidratos/itensControleGlicemico/carregaCalculoIns",
    	data:{tipo:tipo , dia:dia, mes:mes, ano:ano, refeicaoid:refeicaoid , valorglicemiapre:valorglicemiapre , valorglicemiapos:valorglicemiapos ,qtdcarboidratos:qtdcarboidratos},
    	dataType: "json",
    	success:function(data, textStatus, jqXHR)
	    {
    		if(tipo=='0'){
    			
    			if(data.totalpre!=null){
    				($row.find('#qtdinsulinarapidaprealt')).val('');
    				var totalpre = data.totalpre.toFixed(0);
    				($row.find('#qtdinsulinarapidaprealt')).val(totalpre);
    			}
    		}  
    		if(tipo=='1'){
    			
    			if(data.totalpos!=null){
	    			($row.find('#qtdinsulinarapidaposalt')).val('');
		    		var totalpos = data.totalpos.toFixed(0);
		    		($row.find('#qtdinsulinarapidaposalt')).val(totalpos);
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

$(document).on('change', '#valorglicemiaprealt', function(e) {
	e.preventDefault;  
	carregaContagemAlt(0);
});

$(document).on('change', '#valorglicemiaposalt', function(e) {
	e.preventDefault;  
	carregaContagemAlt(1);
});

$(document).on('click', '#calculapre', function(e) {
	carregaContagemIns(0);
});

$(document).on('click', '#calculapos', function(e) {
	carregaContagemIns(1);
});