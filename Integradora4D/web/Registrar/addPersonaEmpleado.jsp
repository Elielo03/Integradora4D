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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Persona Empleado</h1>
        <s:form action="addPersona">
            <s:hidden name="persona.idPersona" />

            <s:textfield name="persona.nombre" label="Nombre" title="nombre de Persona" placeholder="Nombre"/>
            <s:textfield name="persona.app" label="Apellido Paterno" title="Apellido paterno persona" placeholder="Apellido paterno"/>
            <s:textfield name="persona.apm" label="Apellido Materno" title="Apellido materno persona" placeholder="Apellido materno"/>
            <s:textarea name="persona.direccion" label="direccion" title="direccion persona" placeholder="Direccion"/>

            <s:textfield name="persona.correoE" label="correo" title="correoE persona" placeholder="Correo"/>
            <s:textfield name="persona.telefono" label="telefono" title="telefono persona" placeholder="Telefono"/>
            <s:textfield name="persona.pass" label="contraseña" title="contraseña de persona" placeholder="contraseña"/>
            
            <s:select name="departamento.idDepartamento" label="Selecciona un Departamento" list="listaDepartamento" listValue="nombre"
                      listKey="idDepartamento"></s:select>
            
            <s:select name="usuario.idTipoUsuario" label="Selecciona un TipoUsuario" list="listaTipo" listValue="idTipoUsuario"
                      listKey="idTipoUsuario"></s:select>
           

            <s:submit value="Guardar"/>
        </s:form>
    </body>
</html>
