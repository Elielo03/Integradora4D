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
        <script src="https://code.jquery.com/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/reportes.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../Utilerias/Generico/Nav.jsp" %>
        <script>
            $(function () {
                $('div.product-chooser').not('.disabled').find('div.product-chooser-item').on('click', function () {
                    $(this).parent().parent().find('div.product-chooser-item').removeClass('selected');
                    $(this).addClass('selected');
                    $(this).find('input[type="radio"]').prop("checked", true);

                });
            });
        </script>


        <div class="container">
            <h2>Reportes</h2>
            <div class="row form-group product-chooser">

                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item selected">
                        <img src="../Utilerias/Imagenes/Reporte I.png" class="img-rounded col-xs-4 col-sm-4 col-md-12 col-lg-12" alt="Mobile and Desktop">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span class="title">Reportes por Empleado</span>
                            <span class="description">Lorem.</span>
                            <a class="btn btn-default" href="<s:url action="EmployeeSalesReport"/>">Reportes</a>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item">
                        <img src="../Utilerias/Imagenes/informes.png" class="img-rounded col-xs-4 col-sm-4 col-md-12 col-lg-12" alt="Desktop">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span class="title">Desktop</span>
                            

                        </div>
                        <s:form action = "AdminSalesReportGraph">
                                Fecha Inicio: <s:textfield cssClass="form-control" name="desde"/>
                                Fecha Final: <s:textfield name="hasta"/>
                                <s:submit value="Ventas + Grafica"/>
                            </s:form>
                        <div class="clear"></div>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="product-chooser-item">
                        <img src="" class="img-rounded col-xs-4 col-sm-4 col-md-12 col-lg-12" alt="Mobile">
                        <div class="col-xs-8 col-sm-8 col-md-12 col-lg-12">
                            <span class="title">f</span>
                            <span class="description">f</span>
                            
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>

            </div>
        </div>






        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    </body>
</html>
