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
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/datepicker/css/datepicker.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
        <script src="https://code.jquery.com/jquery.js"></script>
    </head>
    <body>
        <%@include file="../Utilerias/Generico/Nav.jsp"%>

        <s:form action="addPersona" theme="simple" cssClass="form-horizontal" >
            <div class="container well" >
                <h1>Persona Empleado</h1>
                <s:hidden name="persona.idPersona" />

                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Nombre: </label>
                    <div class="col-md-4">
                        <s:textfield id="nombre" onkeyup="validar('nombre');"  name="persona.nombre" cssClass="form-control" title="nombre de Persona" placeholder="Nombre"/> 
                        <span class="help-block"></span>                
                    </div>
                </div>
                <div class="form-group  ">
                    <label class="col-md-4 control-label" for="textinput">Apellido Paterno: </label>
                    <div class="col-md-4">
                        <s:textfield id="paterno" onkeyup="validar('paterno');" name="persona.app" cssClass="form-control" title="Apellido paterno persona" placeholder="Apellido paterno"/>
                        <span class="help-block"></span>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Apellido Materno: </label>
                    <div class="col-md-4">
                        <s:textfield id="materno"  name="persona.apm" cssClass="form-control" title="Apellido materno persona" placeholder="Apellido materno"/>
                        <span class="help-block"></span>
                    </div>
                </div>
                <div class=" form-group ">
                    <label class="col-md-4 control-label" for="textinput">Fecha de Nacimiento: </label>     
                    <div class="col-md-4">
                        <s:textfield id="fecha"   name="persona.fechaNac" cssClass="datepicker form-control"  />
                        <span class="help-block"></span>
                    </div>
                </div>

                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Direccion: </label>
                    <div class="col-md-4">
                        <s:textarea id="direccion" onkeyup="validar('direccion');" name="persona.direccion" cssClass="form-control" title="direccion persona" placeholder="Direccion"/>
                        <span class="help-block"></span>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Correo: </label>
                    <div class="col-md-4">
                        <s:textfield id="correo"  name="persona.correoE" cssClass="form-control" title="correoE persona" placeholder="Correo"/>
                        <span class="help-block"></span>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Telefono: </label>
                    <div class="col-md-4">
                        <s:textfield id="telefono" onkeyup="validar('telefono');"  name="persona.telefono" cssClass="form-control"  title="telefono persona" placeholder="Telefono"/>
                        <span class="help-block"></span>
                    </div>
                </div>
                <div class="form-group ">
                    <label class="col-md-4 control-label" for="textinput">Contraseña: </label>
                    <div class="col-md-4">
                        <s:textfield id="contraseña"  name="persona.pass" cssClass="form-control"  title="contraseña de persona" placeholder="contraseña"/>
                        <span class="help-block"></span>
                    </div>
                </div>  
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Departamento: </label>
                    <div class="col-md-4">
                        <s:select cssClass="form-control" name="departamento.idDepartamento"  list="listaDepartamento" listValue="nombre"
                                  listKey="idDepartamento"></s:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textinput">Tipo usuario: </label>
                        <div class="col-md-4">
                        <s:select cssClass="form-control" name="usuario.idTipoUsuario" list="listaTipo" listValue="tipo"
                                  listKey="idTipoUsuario"></s:select>
                        </div>
                    </div>
                    <button id="Guardar" type="button" onclick="submitform();"  class="btn btn-default">Guardar</button>
                </div>
        </s:form>

        <script type="text/javascript" src="<s:url value="../Utilerias/bootstrap-3.3.5-dist/js/jQuery1.11.3.js"/> "></script>
        <script type="text/javascript" src=" <s:url value="../Utilerias/bootstrap-3.3.5-dist/js/bootstrap.min.js"/>"></script>
        <script type="text/javascript" src="<s:url value=" ../Utilerias/Otros/ValPersona.js"/> "></script>
        <script type="text/javascript" src="<s:url value="../Utilerias/datepicker/js/main.js"/>"></script>
        <script type="text/javascript" src="<s:url value="../Utilerias/datepicker/js/bootstrap-datepicker.js"/>"></script>

    </body>
</html>
