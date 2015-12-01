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
                        if (objetosSesion.get("estado") == null || (Integer) objetosSesion.get("tipo") == 4) {


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
                    <li><a href="<s:url action="reportesEmpleado"/>">Reportes</a></li>
                    <p style="color: white"> estas como empleado</p>
                    <%
                    } else if ((Integer) objetosSesion.get("tipo") == 1) {
                    %>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Registro de Personal <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<s:url action="LlenarEmpleado"/>">Agregar</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url action="LlenarPersona"/>">Consultar</a></li>         
                        </ul>
                    </li>
                    <p style="color: white"> estas como superadmin</p>
                    <%
                    } else if ((Integer) objetosSesion.get("tipo") == 2) {
                    %>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Registro de Empleados <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="<s:url action="LlenarEmpleado"/>">Agregar</a></li>
                            <li class="divider"></li>
                            <li><a href="<s:url action="LlenarPersona"/>">Consultar</a></li>         
                        </ul>
                    </li>
                    <li><a href="<s:url action="reportes"/>">Reportes</a></li>
                    <p style="color: white"> estas como admin</p>
                    <%
                            }
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
                %>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span> 
                            <strong><%=objetosSesion.get("nombre")%></strong>
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="navbar-login">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <p class="text-center">
                                                <span class="glyphicon glyphicon-user icon-size"></span>
                                            </p>
                                        </div>
                                        <div class="col-lg-8">
                                            <p class="text-left"><strong>Nombre Apellido</strong></p>
                                            <p class="text-left small"></p>
                                            <p class="text-left">
                                                <a href="#" class="btn btn-primary btn-block btn-sm">Actualizar Datos</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="navbar-login navbar-login-session">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <p>
                                                <s:form action="cerrar"  theme="simple" >
                                                    <button type="submit" class="btn btn-danger btn-block">Cerrar Sesion</button>
                                                </s:form>             
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
                <%
                    }
                %>


            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>

<div class="container">
    <div class="jumbotron">
        <%
         if (objetosSesion.get("estado") != null) {

                if ((Integer) objetosSesion.get("tipo") == 1) {
        %>
        <h1>Bienvenido SuperAdministrador</h1>
        <%
        } else if ((Integer) objetosSesion.get("tipo") == 2) {
        %>
        <h1>Bienvenido Administrador</h1>
        <%
        } else if ((Integer) objetosSesion.get("tipo") == 3) {
        %>
        <h1>Bienvenido Empleado</h1>
        <%
        } else if ((Integer) objetosSesion.get("tipo") == 4) {
        %>
        <h1>Bienvenido Cliente</h1>
        <%
            }
        } else {
        %>
        <h1>Bienvenido Usuario</h1>
        <%
            }
        %>

        <p>This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.</p>
    </div>
</div>