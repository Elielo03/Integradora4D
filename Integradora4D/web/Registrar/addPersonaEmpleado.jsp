<%-- 
    Document   : Persona
    Created on : 10/10/2015, 08:38:40 PM
    Author     : Hermanos Saucedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/datepicker/css/datepicker.css"/>"/>
        <script src="<s:url value="../Utilerias/datepicker/js/main.js"/>"></script>
        <script src="<s:url value="../Utilerias/datepicker/js/bootstrap-datepicker.js"/>"></script>
        <script>
            $(function () {
                $('.datepicker').datepicker();
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Persona Empleado</h1>
        <s:form action="addPersona" theme="simple" >
            <div class="container well" >
                <s:hidden name="persona.idPersona" />

                <div class="form-group ">
                    <label>Nombre: </label>
                    <s:textfield name="persona.nombre" cssClass="form-control" title="nombre de Persona" placeholder="Nombre"/>
                </div>
                <div class="form-group ">
                    <label>Apellido Paterno: </label>
                    <s:textfield name="persona.app" cssClass="form-control" title="Apellido paterno persona" placeholder="Apellido paterno"/>
                </div>
                <div class="form-group ">
                    <label>Apellido Materno: </label>
                    <s:textfield name="persona.apm" cssClass="form-control" title="Apellido materno persona" placeholder="Apellido materno"/>
                </div>
                <div class=" form-group ">
                    <label>Fecha de Nacimiento: </label>
                    <s:textfield name="persona.fechaNac"  cssClass="datepicker form-control" />
                </div>
                <div class="form-group ">
                    <label>Direccion: </label>
                    <s:textarea name="persona.direccion" cssClass="form-control" title="direccion persona" placeholder="Direccion"/>
                </div>
                <div class="form-group ">
                    <label>Correo: </label>
                    <s:textfield name="persona.correoE" cssClass="form-control" title="correoE persona" placeholder="Correo"/>
                </div>
                <div class="form-group ">
                    <label>Telefono: </label>
                    <s:textfield name="persona.telefono" cssClass="form-control"  title="telefono persona" placeholder="Telefono"/>
                </div>
                <div class="form-group ">
                    <label>Contraseña: </label>
                    <s:textfield name="persona.pass" cssClass="form-control"  title="contraseña de persona" placeholder="contraseña"/>
                </div>             
                <div>
                    <label>Departamento: </label>
                     <s:select cssClass="form-control" name="departamento.idDepartamento" label="Selecciona un Departamento" list="listaDepartamento" listValue="nombre"
                          listKey="idDepartamento"></s:select>
                </div>
                <br>
                <div>
                    <label>Tipo usuario: </label>
                     <s:select cssClass="form-control" name="usuario.idTipoUsuario" label="Selecciona un TipoUsuario" list="listaTipo" listValue="tipo"
                          listKey="idTipoUsuario"></s:select>
                </div>
               <button type="submit" class="btn btn-default">Guardar</button>
            </div>
        </s:form>
    </body>
</html>
