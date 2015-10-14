<%-- 
    Document   : Departamento
    Created on : 10/10/2015, 08:38:59 PM
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
        <h1>Departamento</h1>
        <s:form action="addDepartamento">         
            <s:textfield name="nombre" label="Nombre" title="nombre de departamento" placeholder="Nombre"/>   
            <s:textarea name="descripcion" label="Descripcion" title="descripcion de departamento" placeholder="Descripcion"/>
            <s:submit value="Guardar"/>
        </s:form>
    </body>
</html>
