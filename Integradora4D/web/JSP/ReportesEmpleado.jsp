<%-- 
    Document   : Reportes
    Created on : 28/11/2015, 05:54:49 AM
    Author     : Hermanos Saucedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/datepicker/css/datepicker.css"/>"/>
        <script src="https://code.jquery.com/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
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
            <h2>Reportes Empleado</h2>
            <div class="col-lg-5">
                <div class="panel panel-primary">
                    <div class="panel-heading">Productos Reporte</div>
                    <div class="panel-body">
                        <s:form action="EmployeeProductReport">
                            <s:submit cssClass="btn btn-default" value="Productos"/>
                        </s:form>
                    </div>
                </div>

            </div>
            <div class="col-lg-5">
                <div class="panel panel-primary">
                    <div class="panel-heading">Reporte con graficas</div>
                    <div class="panel-body">
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



            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="<s:url value="../Utilerias/datepicker/js/bootstrap-datepicker.js"/>"></script>

    </body>
</html>
