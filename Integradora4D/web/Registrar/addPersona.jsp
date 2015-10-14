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
        <h1>Persona</h1>
        <s:form action="addPersona">

            <s:textfield name="nombre" label="Nombre" title="nombre de Persona" placeholder="Nombre"/>
            <s:textfield name="app" label="Apellido Paterno" title="Apellido paterno persona" placeholder="Apellido paterno"/>
            <s:textfield name="apm" label="Apellido Materno" title="Apellido materno persona" placeholder="Apellido materno"/>
            <s:textarea name="direccion" label="direccion" title="direccion persona" placeholder="Direccion"/>
            <s:textfield name="fechaNac" label="fechaNac" title="fechaNac persona" placeholder="fechaNac"/>
            <%-- <s:combobox name="idUsuario" label="Combo" list="" readonly="true"/> Error necesita una lista --%>  
            <%-- <s:combobox name="idDepartamento" label="Combo" list="" readonly="true"/> Error necesita una lista --%>      
            <s:textfield name="correoE" label="correo" title="correoE persona" placeholder="Correo"/>
            <s:textfield name="telefono" label="telefono" title="telefono persona" placeholder="Telefono"/>
            
            <s:textfield name="userName" label="Usuario" title="usuario persona" placeholder="usuario"/>
            <s:textfield name="pass" label="contraseña" title="contraseña de persona" placeholder="contraseña"/>
            <s:hidden name="idTipoUsuario"/> //no estoy seguro de este

            <s:submit value="Guardar"/>

        </s:form>
    </body>
</html>
