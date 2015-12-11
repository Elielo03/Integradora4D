<%-- 
    Document   : index
    Created on : 11-nov-2015, 15:55:44
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <script src="https://code.jquery.com/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
        <title>Liverpool</title>
    </head>
    <body>
        <%Map objetos1 = ActionContext.getContext().getSession();%>
        <%@include file="../Utilerias/Generico/Nav.jsp"%>
        <div class="container">
            <div class="jumbotron">
                <%
                    if (objetos1.get("estado") != null) {

                        if ((Integer) objetos1.get("tipo") == 4) {
                %>
                <h1>Bienvenido Cliente</h1>
                <%
                } else {
                %>
                <h1>Otros</h1>
                <%
                    }
                } else {
                %>
                <h1>Bienvenido a Liverpool </h1>
                <p>poner un mensaje para los usuarios no clientes</p>
                <%
                    }
                %>
            </div>
        </div>




        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    </body>
</html>
