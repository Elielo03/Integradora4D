<%-- 
    Document   : Usuario
    Created on : 10/10/2015, 08:38:23 PM
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
        <h1>Usuario</h1>
        <s:form action="registrarUsuario">
            <s:textfield name="userName" label="Nombre" title="nombre del usuario"/>
            <s:textfield name="pass" label="Contraseña" title="contraseña de usuario"/>
            <%-- <s:combobox name="idTipoUsuario" label="Tipos de usuario" list="" readonly="true"/> Error necesita una lista --%> 
            <s:submit value="Guardar" />
        </s:form>

    </body>
</html>
