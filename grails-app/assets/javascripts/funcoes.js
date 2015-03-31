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
    		($("#formins").find('#qtdcarboidratos')).val('');
    		var totaldia = data.total.toFixed(2);
    		($("#formins").find('#qtdcarboidratos')).val(totaldia);	
		        
	    },
	    error: function(jqXHR, textStatus, errorThrown)
        {
	        	
        }
    });
 });


jQuery(function($) {  
		
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
	    		($("#formins").find('#qtdcarboidratos')).val('');
	    		var totaldia = data.total.toFixed(2);
	    		($("#formins").find('#qtdcarboidratos')).val(totaldia);	
			        
		    },
		    error: function(jqXHR, textStatus, errorThrown)
	        {
		        	
	        }
	    });
})(jQuery);
