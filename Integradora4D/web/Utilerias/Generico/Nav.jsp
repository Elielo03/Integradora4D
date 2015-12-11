<%-- 
    Document   : Nav
    Created on : 25/11/2015, 09:43:40 AM
    Author     : Hermanos Saucedo
--%>
<%@page import="Beans.DepartamentoBean"%>
<%@page import="java.util.List"%>
<%@page import="Operaciones.Menus"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%Map objetosSesion = ActionContext.getContext().getSession();%>

<div class="container">
    <nav class="navbar navbar-default navbar-default" role="navigation">
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
                    <li class="dropdown" style="padding-top: 8px; padding-right: 5px; ">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Departamentos</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <%                                    Menus menu = new Menus();
                                    List<DepartamentoBean> lista = menu.departamentos();
                                    for (DepartamentoBean lista1 : lista) {
                                %>      
                                <s:form action="buscar" theme="simple" >    
                                    <div class="container col-lg-12">
                                        <input name="id" type="hidden" value="<%=lista1.getIdDepartamento()%>">
                                        <li><button type="submit" class="btn btn-link2"><%=lista1.getNombre()%></button></li>
                                    </div>      
                                </s:form>
                                <%                                }
                                %>
                            </ul>
                        </div>
                    </li>


                    <%                        }
                        if (objetosSesion.get("estado") != null) {

                            if ((Integer) objetosSesion.get("tipo") == 3) {
                    %>
                    <li class="dropdown" style="padding-top: 8px;  padding-right: 5px; ">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Departamentos</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<s:url action="addDepa"/>">Agregar</a></li>
                                <li class="divider"></li>
                                <li><a href="<s:url action="readDepartamento"/>">Consultar</a></li>   

                            </ul>
                        </div>
                    </li>

                    <li class="dropdown" style="padding-top: 8px;  padding-right: 5px; ">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Categoria</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<s:url action="llenarLista"/>">Agregar</a></li>
                                <li class="divider"></li>
                                <li><a href="<s:url action="readCategoria"/>">Consultar</a></li>   

                            </ul>
                        </div>
                    </li>

                    <li class="dropdown" style="padding-top: 8px;  padding-right: 5px; ">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Personal/Clientes</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<s:url action="llenarVacio"/>">Agregar</a></li>
                                <li class="divider"></li>
                                <li><a href="<s:url action="LlenarPersona"/>">Consultar</a></li>  

                            </ul>
                        </div>
                    </li>
                    <li class="dropdown" style="padding-top: 8px; padding-right: 5px; ">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Productos</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<s:url action="addPro"/>">Agregar</a></li>
                                <li class="divider"></li>
                                <li><a href="<s:url action="readProducto"/>">Consultar</a></li>  

                            </ul>
                        </div>
                    </li>

                    <%
                    } else if ((Integer) objetosSesion.get("tipo") == 1) {
                    %>
                    <li class="dropdown" style="padding-top: 8px; padding-right: 5px; ">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Registro de Empleados</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<s:url action="LlenarEmpleado"/>">Agregar</a></li>
                                <li class="divider"></li>
                                <li><a href="<s:url action="LlenarPersona"/>">Consultar</a></li>        

                            </ul>
                        </div>
                    </li>

                    <%
                    } else if ((Integer) objetosSesion.get("tipo") == 2) {
                    %>

                    <li class="dropdown" style="padding-top: 8px; padding-right: 5px; ">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Registro de Empleados</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="<s:url action="LlenarEmpleado"/>">Agregar</a></li>
                                <li class="divider"></li>
                                <li><a href="<s:url action="LlenarPersona"/>">Consultar</a></li>         

                            </ul>
                        </div>
                    </li>
                    <%
                    } else if ((Integer) objetosSesion.get("tipo") == 4) {
                    %>

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
                <%@include file="cerrar.jsp"%>
                <%                    }
                %>


            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>

