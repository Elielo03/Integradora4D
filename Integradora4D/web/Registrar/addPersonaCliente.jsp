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
                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd',
                });
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Persona cliente</h1>
        <s:form action="addPersona" theme="simple" cssClass="form-horizontal" >
            <div class="well  container" >

                <s:hidden name="persona.idPersona" />
                <div class="form-group  ">
                    <label class="col-md-4 control-label" for="textinput">Nombre: </label>
                    <div class="col-md-4">
                        <s:textfield   name="persona.nombre" cssClass="form-control" title="nombre de Persona" placeholder="Nombre"/>    
                    </div>
                </div>
                <div class="form-group  ">
                    <label class="col-md-4 control-label" for="textinput">Apellido Paterno: </label>
                    <div class="col-md-4">
                        <s:textfield  name="persona.app" cssClass="form-control" title="Apellido paterno persona" placeholder="Apellido paterno"/>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Apellido Materno: </label>
                    <div class="col-md-4">
                        <s:textfield  name="persona.apm" cssClass="form-control" title="Apellido materno persona" placeholder="Apellido materno"/>
                    </div>
                </div>
                <div class=" form-group ">
                    <label class="col-md-4 control-label" for="textinput">Fecha de Nacimiento: </label>     
                    <div class="col-md-4">
                        <s:textfield  name="persona.fechaNac" cssClass="datepicker form-control"  />
                    </div>
                </div>

                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Direccion: </label>
                    <div class="col-md-4">
                        <s:textarea  name="persona.direccion" cssClass="form-control" title="direccion persona" placeholder="Direccion"/>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Correo: </label>
                    <div class="col-md-4">
                        <s:textfield  name="persona.correoE" cssClass="form-control" title="correoE persona" placeholder="Correo"/>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Telefono: </label>
                    <div class="col-md-4">
                        <s:textfield  name="persona.telefono" cssClass="form-control"  title="telefono persona" placeholder="Telefono"/>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Contraseña: </label>
                    <div class="col-md-4">
                        <s:textfield  name="persona.pass" cssClass="form-control"  title="contraseña de persona" placeholder="contraseña"/>
                    </div>
                </div>             
                <s:hidden name="usuario.idTipoUsuario"/> 
                <s:hidden name="Departamento.idDepartamento"/> 

                <button type="submit" class="btn btn-default">Guardar</button>
            </div>
        </s:form>

    </body>
</html>
