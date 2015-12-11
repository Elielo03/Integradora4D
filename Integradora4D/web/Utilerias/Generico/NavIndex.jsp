<%-- 
    Document   : NavIndex
    Created on : 10/12/2015, 08:37:04 PM
    Author     : Hermanos Saucedo
--%>
<%@page import="Beans.DepartamentoBean"%>
<%@page import="java.util.List"%>
<%@page import="Operaciones.Menus"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%Map objetos = ActionContext.getContext().getSession();%>
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

                    <li class="dropdown">
                        <div class="btn-group btn-group-warning">
                            <button class="btn btn-otro" type="button">Dapartamentos</button>
                            <button data-toggle="dropdown" class="btn btn-otro dropdown-toggle" type="button"><span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <%
                                    Menus menu = new Menus();
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
                    <li><a href="<s:url action="compras"/>">Compras temporal</a></li>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Buscar">
                        </div>
                        <button type="submit" class="btn btn-default">Buscar</button>
                    </form>
                    <%
                        if (objetos.get("estado") == null) {
                    %><%@include file="session.jsp"%><%
                    } else {
                    %>
                    <%@include file="cerrar.jsp"%>
                    <%                                }
                    %>

                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
