<%-- 
    Document   : Jump
    Created on : 11/12/2015, 02:06:38 AM
    Author     : Hermanos Saucedo
--%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%Map objetos67 = ActionContext.getContext().getSession();%>
<div class="">
    <div class="jumbotron">
        <%
            if (objetos67.get("estado") != null) {
                if ((Integer) objetos67.get("tipo") == 1) {
        %>
        <h1 class="texto1">Bienvenido SuperAdministrador</h1>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%
        } else if ((Integer) objetos67.get("tipo") == 2) {
        %>
        <h1 class="texto1">Bienvenido Administrador</h1>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%
        } else if ((Integer) objetos67.get("tipo") == 3) {
        %>
        <h1 class="texto1">Bienvenido Empleado</h1>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%
        } else if ((Integer) objetos67.get("tipo") == 4) {
        %>
        <h1 class="texto1">Bienvenido Cliente</h1>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%
            }

        } else {
        %>
        <h1 class="texto1">Bienvenido Usuario</h1>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%
            }
        %>
    </div>
</div>