$(document).on("click","#btnnuevo",function(){//alert("Hola JavaSCRIPTS")
$("#txtdescestado").val("");
$("#hddidestado").val("0");
$("#modalregistro").modal("show");
});

$(document).on("click",".btnactualizar",function(){//alert("Hola JavaSCRIPTS")
$("#txtdescestado").val($(this).attr("data-descestado"));
$("#hddidestado").val($(this).attr("data-idestado"));
$("#modalregistro").modal("show");
});

$(document).on("click","#btnguardar",function(){
console.log("xd");
$.ajax({
type:"POST",
contentType:"application/json",
url:"/admi/estado/registrar",
data:JSON.stringify({
idestado:$("#hddidestado").val(),
descestado:$("#txtdescestado").val()}),
success:function(resultado){
if(resultado.respuesta){listarEstados();}
alert(resultado.mensaje);
$("#modalregistro").modal("hide");
}
});
});

function listarEstados(){
$.ajax({
type:"GET",
url:"/admi/estado/listar",
dataType:"json",
success:function(resultado){
//console.log(resultado);
$("#tblestado>tbody").html("");
$.each(resultado,function(index,value){
$("#tblestado>tbody").append("<tr>"+
"<td>"+value.idestado+"</td>"+
"<td>"+value.descestado+"</td>"+
"<td>"+
"<button type='button' class='btn btn-info btnactualizar'"+
"data-idestado='"+value.idestado+"'"+
"data-descestado='"+value.descestado+"'>"+
"<i class='bi bi-pencil-square'></i></button>"+
"</td>"+
"<td>"+
"<button type='button' class='btn btn-danger btneliminar' data-idestado='"+value.idestado+"'"+
"data-descestado='"+value.descestado+"' ><i class='bi bi-trash3'></i></button>"

+"</td>"+
"</tr>");
});}
});
}

$(document).on("click",".btneliminar",function(){//alert("Hola JavaSCRIPTS")
$("#lblmensajeeliminar").text("¿Estas seguro de eliminar:"+$(this).attr("data-descestado")+"?");
$("#hiddeneliminar").val($(this).attr("data-idestado"));
$("#modaleliminar").modal("show");
//$("#txtdescestado").val($(this).attr("data-descestado"));
//$("hddidestado").val($(this).attr("data-idestado"));
});

$(document).on("click","#btneliminar",function(){
console.log("xd");
$.ajax({
type:"DELETE",
contentType:"application/json",
url:"/admi/estado/eliminar",
data:JSON.stringify({
idestado:$("#hiddeneliminar").val()}),
success:function(resultado){
if(resultado.respuesta){listarEstados();}
alert(resultado.mensaje);
$("#modaleliminar").modal("hide");
}
});
});