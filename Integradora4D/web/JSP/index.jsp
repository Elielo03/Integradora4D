<%-- 
    Document   : index
    Created on : 11-nov-2015, 15:55:44
    Author     : Xavier
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
        <h1>index</h1>
        <s:form action="login">
            <s:textfield name="usuario.userName" /> 
            <s:textfield name="usuario.pass" />     
            <s:submit value="login"/>
        </s:form>          
    </body>
</html>
