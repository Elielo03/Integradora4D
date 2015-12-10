<%-- 
    Document   : cerrar
    Created on : 10/12/2015, 12:49:22 AM
    Author     : Hermanos Saucedo
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%Map objetosSesion1 = ActionContext.getContext().getSession();%>
<ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-user"></span> 
            <strong>Mi cuenta</strong>
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
                            <p class="text-left"><strong><%=objetosSesion1.get("nombre")%></strong></p>
                            <p class="text-left small"></p>
                            <p class="text-left">
                                <%
                                    if ((Integer) objetosSesion1.get("tipo") == 4) {
                                %>
                                <a href="<s:url action="readCarrito"/>" class="btn btn-primary btn-block btn-sm">Carrito</a>
                                <%
                                    }
                                %>
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