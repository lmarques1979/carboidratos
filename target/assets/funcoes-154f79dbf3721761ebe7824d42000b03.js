function inserirLinha(){var a=document.getElementById("clone"),b=document.getElementById("tabelainclusao"),a=a.cloneNode(!0);b.appendChild(a);$(a).closest("tr").find("#qtdalimento").val("");$(a).closest("tr").find("#alimentoforalista").val("");$(a).closest("tr").find("#carboidratos").val("");$(a).closest("tr").find("#alimentoforalista").removeAttr("readonly");$(a).closest("tr").find("#carboidratos").removeAttr("readonly")}
$(document).on("change",".alimento",function(a){a.preventDefault;a=this.value;var b=$(this).parent().parent();"-1"==a?(b.find("#alimentoforalista").removeAttr("readonly"),b.find("#carboidratos").removeAttr("readonly")):(b.find("#alimentoforalista").attr("readonly","readonly"),b.find("#alimentoforalista").val(""),b.find("#carboidratos").attr("readonly","readonly"),b.find("#carboidratos").val(""))});
$(document).on("change","#refeicaoins",function(a){a.preventDefault;a=this.value;$("#formins");var b=$("#formins").find(".dia").val(),c=$("#formins").find("#mes").val(),d=$("#formins").find("#ano").val();$.ajax({type:"POST",url:"/contagemcarboidratos/itensControleGlicemico/buscatotalrefeicao/",data:{dia:b,mes:c,ano:d,refeicaoid:a},dataType:"json",success:function(a,b,c){$("#formins").find("#qtdcarboidratos").val("");a=a.total.toFixed(1);$("#formins").find("#qtdcarboidratos").val(a)},error:function(a,
b,c){}})});
function carregaContagem(){$("#formins");var a=$("#formins").find(".dia").val(),b=$("#formins").find("#mes").val(),c=$("#formins").find("#ano").val(),d=$("#formins").find("#refeicaoins").val();$.ajax({type:"POST",url:"/contagemcarboidratos/itensControleGlicemico/buscatotalrefeicao/",data:{dia:a,mes:b,ano:c,refeicaoid:d},dataType:"json",success:function(a,b,c){$("#formins").find("#qtdcarboidratos").val("");a=a.total.toFixed(1);$("#formins").find("#qtdcarboidratos").val(a)},error:function(a,b,c){}})}
;