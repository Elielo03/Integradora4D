<%-- 
    Document   : Administrador
    Created on : 11-nov-2015, 16:54:40
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <script src="https://code.jquery.com/jquery.js"></script>

        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/datepicker/css/datepicker.css"/>"/>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/panel.css"/>
        <script>
            $(function hola() {
                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd'
                });
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="../Utilerias/Generico/Nav.jsp" %>
        <div class="container">
            <div class="jumbotron">
                <%            if (objetosSesion.get("estado") != null) {

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
                        }
                    }
                %>
            </div>
        </div>

        <%
            if ((Integer) objetosSesion.get("tipo") == 2) {
        %>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel with-nav-tabs panel-primary">
                        <div class="panel-heading">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1primary" data-toggle="tab">Reportes Administrador</a></li>
                                <li><a href="#tab2primary" data-toggle="tab">Reporte con graficas</a></li>
                                <li><a href="#tab3primary" data-toggle="tab">AdminSalesReport</a></li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab1primary">
                                    <s:form action="AdminProductReport">
                                        <s:submit cssClass="btn btn-default" value="Productos"/>
                                    </s:form>
                                </div>

                                <div class="tab-pane fade" id="tab2primary">
                                    <s:form action = "AdminSalesReportGraph"  theme="simple" cssClass="form-horizontal">
                                        <div class="col-md-5">
                                            Fecha Inicio:
                                            <s:textfield  cssClass="datepicker form-control" name="desde"/>
                                        </div>
                                        <div class="col-md-5">
                                            Fecha Final:
                                            <s:textfield  cssClass="datepicker form-control" name="hasta"/>
                                        </div>

                                        <div class="col-md-5">
                                            <br>
                                            <s:submit cssClass="btn btn-default" value="Crear"/>
                                        </div>
                                    </s:form>
                                </div>
                                <div class="tab-pane fade" id="tab3primary">
                                    <s:form action = "AdminSalesReport"  theme="simple" cssClass="form-horizontal">
                                        <div class="col-md-5">
                                            Fecha Inicio:
                                            <s:textfield  cssClass="datepicker form-control" name="desde"/>
                                        </div>
                                        <div class="col-md-5">
                                            Fecha Final:
                                            <s:textfield  cssClass="datepicker form-control" name="hasta"/>
                                        </div>

                                        <div class="col-md-3">
                                            <br>
                                            <s:submit cssClass="btn btn-default" value="Crear"/>
                                        </div>
                                    </s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%
        } else if ((Integer) objetosSesion.get("tipo") == 3) {
        %>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel with-nav-tabs panel-primary">
                        <div class="panel-heading">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1primary" data-toggle="tab">Reportes Empleado</a></li>
                                <li><a href="#tab2primary" data-toggle="tab">Reporte con graficas</a></li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab1primary">
                                    <s:form action="EmployeeProductReport">
                                        <s:submit cssClass="btn btn-default" value="Productos"/>
                                    </s:form>
                                </div>
                                <div class="tab-pane fade" id="tab2primary">
                                    <s:form action = "EmployeeSalesReport"  theme="simple" cssClass="form-horizontal">
                                        <div class="col-md-5">
                                            Fecha Inicio:
                                            <s:textfield  cssClass="datepicker form-control" name="desde"/>
                                        </div>
                                        <div class="col-md-5">
                                            Fecha Final:
                                            <s:textfield  cssClass="datepicker form-control" name="hasta"/>
                                        </div>

                                        <div class="col-md-5">
                                            <br>
                                            <s:submit cssClass="btn btn-default" value="Crear"/>
                                        </div>
                                    </s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%
            }
        %>


        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<s:url value="../Utilerias/datepicker/js/bootstrap-datepicker.js"/>"></script>
    </body>
</html> 
