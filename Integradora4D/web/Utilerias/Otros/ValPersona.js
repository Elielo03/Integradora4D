//$(document).on("ready", inicio);
////
//function inicio() {
//    $("span.help-block").hide();
//  
//                $('.datepicker').datepicker({
//                    format: 'yyyy-mm-dd'
//                });
//            
////   $("#Guardar").click(function(){
////		if(verificar()===false)
////			alert("los campos no estan validados");
////		else{
////			alert("los campos estan validados");
////		}
////	});
//
////    $("#nombre").keyup(verificar);
//
//}


$(function hola() {
    $('.datepicker').datepicker({
        format: 'yyyy-mm-dd'
    });
});


function submitform()
{
    if (verificar()) {
        document.addPersona.submit();
    } else {
        alert("Existen campos vacios");
    }

}

function verificar() {
    var v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0, v6 = 0, v7 = 0, v8 = 0;
    v1 = validar('nombre');
    v2 = validar('paterno');
//    v3 = validar('apellido2');
    v4 = validar('fecha');
    v5 = validar('direccion');
//    v6 = validar('correo');
    v7 = validar('telefono');
//    v8 = validar('contraseña');

    if (v1 === false || v2 === false || v4 === false || v5 === false || v7 === false) {
        $("#exito").hide();
        $("#error").show();
        return false;
    } else {
        $("#error").hide();
        $("#exito").show();
        return true;
    }

}

function validar(campo) {

    if (campo === 'nombre') {
        var valor = document.getElementById(campo).value;//recupera lo que contenga el elemento se busca por medio del su nombre de id
        if (valor === null || valor.length === 0 || /^\s+$/.test(valor)) {//verifica lo que recupero esta vacio o null
            $("#icono" + campo).remove();//eliminar el span que se crea en la validacion
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");//entra en el campo y busca a su padre en este caso es un div y attr busca la etiqueta que quieres modificar y lo siguiente es lo que quieres poner
            $("#" + campo).parent().children("span").text("El campo " + campo + " esta vacio").show();//busca el padre div y cuando hubico en div busca a el hijo del campo que busca y agrega text para agregar texto 
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");// busca el div y append permite agregar codigo html
            return false;
        } else if (!isNaN(valor)) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $("#" + campo).parent().children("span").text("No se aceptan numero").show();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");
            return false;

        } else {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $("#" + campo).parent().children("span").text("").hide();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-ok form-control-feedback'></span>");
            return true;
        }

    }

    else if (campo === 'paterno') {
        var valor = document.getElementById(campo).value;
        if (valor === null || valor.length === 0 || /^\s+$/.test(valor)) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $("#" + campo).parent().children("span").text("El campo apellido " + campo + " esta vacio").show();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");
            return false;
        } else if (!isNaN(valor)) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $("#" + campo).parent().children("span").text("No se aceptan numero").show();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");
            return false;

        } else {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $("#" + campo).parent().children("span").text("").hide();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-ok form-control-feedback'></span>");
            return true;
        }
    }

    else if (campo === 'fecha') {
        var valor = document.getElementById(campo).value;
        if (valor === null || valor.length === 0 || /^\s+$/.test(valor)) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $("#" + campo).parent().children("span").text("El campo " + campo + " esta vacio").show();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");
            return false;
        } else if (!isNaN(valor)) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $("#" + campo).parent().children("span").text("").hide();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-ok form-control-feedback'></span>");
            return true;
        }
    }

    else if (campo === 'direccion') {
        var valor = document.getElementById(campo).value;//recupera lo que contenga el elemento se busca por medio del su nombre de id
        if (valor === null || valor.length === 0 || /^\s+$/.test(valor)) {//verifica lo que recupero esta vacio o null
            $("#icono" + campo).remove();//eliminar el span que se crea en la validacion
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");//entra en el campo y busca a su padre en este caso es un div y attr busca la etiqueta que quieres modificar y lo siguiente es lo que quieres poner
            $("#" + campo).parent().children("span").text("El campo " + campo + " esta vacio").show();//busca el padre div y cuando hubico en div busca a el hijo del campo que busca y agrega text para agregar texto 
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");// busca el div y append permite agregar codigo html
            return false;
        } else {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $("#" + campo).parent().children("span").text("").hide();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-ok form-control-feedback'></span>");
            return true;
        }
    }

    else if (campo === 'correo') {
        valor = document.getElementById(campo).value;
        if (!(/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)/.test(valor))) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $("#" + campo).parent().children("span").text("Es necesario un correo electronico").show();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");
            return false;
        } else {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $("#" + campo).parent().children("span").text("").hide();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-ok form-control-feedback'></span>");
            return true;
        }
    }

    else if (campo === 'telefono') {
        valor = document.getElementById(campo).value;
        if (valor === null || valor.length === 0 || /^\s+$/.test(valor)) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $("#" + campo).parent().children("span").text("El campo " + campo + " esta vacio").show();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");
            return false;
        } else if (!(/^\d{9}$/.test(valor))) {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-error has-feedback");
            $("#" + campo).parent().children("span").text("Se necesitan 9 caracteres").show();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-remove form-control-feedback'></span>");
            return false;
        } else {
            $("#icono" + campo).remove();
            $("#" + campo).parent().parent().attr("class", "form-group has-success has-feedback");
            $("#" + campo).parent().children("span").text("").hide();
            $("#" + campo).parent().append("<span id='icono" + campo + "' class='glyphicon glyphicon-ok form-control-feedback'></span>");
            return true;
        }
    }

}
