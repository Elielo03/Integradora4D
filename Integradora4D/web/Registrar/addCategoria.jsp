<%-- 
    Document   : Categoria
    Created on : 11/10/2015, 03:30:33 PM
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
        <h1>Categoria</h1>

        <s:form action="addDepartamento">         
            <s:textfield name="nombre" label="Nombre" title="nombre de departamento" placeholder="Nombre"/>   
            <%-- <s:combobox name="idDepartamento" label="Combo" list="" readonly="true"/> Error necesita una lista --%>    
            
            <s:submit value="Guardar"/>
        </s:form>
    </body>
</html>
