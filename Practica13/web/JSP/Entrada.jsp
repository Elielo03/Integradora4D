<%-- 
    Document   : Entrada
    Created on : 13-oct-2015, 19:10:14
    Author     : Eliel David
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
        <h1>Formulario con objetos</h1>
        <s:form action="registrar" >
            <s:textfield name="Persona.nombre" placehoder="Nombre"></s:textfield>
            <s:textfield name="Persona.apellidos" placehoder="Apellidos"></s:textfield>
            <s:textfield name="Persona.correo" placehoder="correo Elelctronico"></s:textfield>
            <s:submit value="Enviar"></s:submit>
            
        </s:form>
        
        
    </body>
</html>
