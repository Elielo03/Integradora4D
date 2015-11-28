<%-- 
    Document   : Nav
    Created on : 25/11/2015, 09:43:40 AM
    Author     : Hermanos Saucedo
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%Map objetosSesion = ActionContext.getContext().getSession();%>
<div class="container">
    <nav class="navbar navbar-default navbar-inverse" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Liverpool</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                    <%
                        if (objetosSesion.get("estado") == null) {


                    %>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Departamentos <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                    <%                        }
                        if (objetosSesion.get("estado") != null) {

                            if ((Integer) objetosSesion.get("tipo") == 3) {
                    %>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Departamentos <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<s:url action="addDepa"/>">Agregar</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url action="readDepartamento"/>">Consultar</a></li>         
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categoria <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<s:url action="llenarLista"/>">Agregar</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url action="readCategoria"/>">Consultar</a></li>         
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Personal/Clientes <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<s:url action="llenarVacio"/>">Agregar</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url action="LlenarPersona"/>">Consultar</a></li>         
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Productos <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<s:url action="addPro"/>">Agregar</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url action="readProducto"/>">Consultar</a></li>         
                        </ul>
                    </li>
                    <li><a href="<s:url action="reportes"/>">Reportes</a></li>
                        <%                            }
                            }
                           
                        %>
                   






                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Buscar">
                    </div>
                    <button type="submit" class="btn btn-default">Buscar</button>
                </form>
                <%                    if (objetosSesion.get("estado") == null) {
                %><%@include file="session.jsp"%><%
                } else {
                %><%@include file="Cerrar.jsp"%><%
                    }
                %>


            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>