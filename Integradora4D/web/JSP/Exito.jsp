<%-- 
    Document   : Exito
    Created on : 13-oct-2015, 20:41:58
    Author     : Eliel David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AddCategoria</h1>
        <s:form action="readCategoria">
            <s:submit value="Aceptar"></s:submit>
        </s:form>
        <h1>Llenas Categoria</h1>
        <s:form action="readCategoria">
            <s:submit value="Aceptar"></s:submit>
        </s:form>
         <s:form action="llenarVacio">
            <s:submit value="AddPersona"></s:submit>
        </s:form>
        <s:form action="LlenarPersona">
            <s:submit value="llenar tabla"></s:submit>
        </s:form>
        
          <s:form action="readProducto">
            <s:submit value="Read producto"></s:submit>
        </s:form>
        
          <s:form action="addPro">
            <s:submit value="aDD producto"></s:submit>
        </s:form>
        
         <s:form action="addPro">
            <s:submit value="Prueba"></s:submit>
        </s:form>

    </body>
</html>
