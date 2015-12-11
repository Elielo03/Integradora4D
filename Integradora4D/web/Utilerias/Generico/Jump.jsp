<%-- 
    Document   : Jump
    Created on : 11/12/2015, 02:06:38 AM
    Author     : Hermanos Saucedo
--%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%Map objetos67 = ActionContext.getContext().getSession();%>
<div class="container">
    <div class="jumbotron">
        <%                    if (objetos67.get("estado") != null) {

                if ((Integer) objetos67.get("tipo") == 4) {
        %>
        <h1 style="color: black">Bienvenido Cliente</h1>
        <%
        } else {
        %>
        <h1 style="color: black">Otros</h1>
        <%
            }
        } else {
        %>
        <h1 style="color: black">Bienvenido a Liverpool.com </h1>
       
        <p style="color: black">poner un mensaje para los usuarios no clientes</p>
        <%
            }
        %>
    </div>
</div>