$(document).on("click","#btnnuevo",function(){//alert("Hola JavaSCRIPTS")
$("#txtdescestado").val("");
$("#hddidestado").val("0");
$("#modalregistro").modal("show");
});

$(document).on("click",".btnactualizar",function(){//alert("Hola JavaSCRIPTS")
$("#txtdescestado").val($(this).attr("data-descestado"));
$("#hddidestado").val($(this).attr("data-idestado"));
});

$(document).on("click","#btnguardar",function(){
console.log("xd");
$.ajax({type:"POST",contentType:"application/json",url:"/admi/estado/registrar",data:JSON.stringify({
idestado:$("#hddidestado").val(),descestado:$("#txtdescestado").val()}),
success:function(resultado){
if(resultado.respuesta){listarEstados();}
alert(resultado.mensaje),
$("#modalregistro").modal("hide");
}



});
});

function listarEstados(){
$ajax({
type:"GET",
url:"/admi/estado/listar",
dataType:"json",
success:function(resultado){console.log(resultado);}})

};

$(document).on("click",".btneliminar",function(){//alert("Hola JavaSCRIPTS")
$("#txtdescestado").val($(this).attr("data-descestado"));
$("hddidestado").val($(this).attr("data-idestado"));
});