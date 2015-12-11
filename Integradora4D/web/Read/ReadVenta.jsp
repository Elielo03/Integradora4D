<%-- 
    Document   : ReadProducto
    Created on : 21-oct-2015, 22:51:38
    Author     : Comodin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../Utilerias/metas.jsp" %>
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <script src="https://code.jquery.com/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
        <title>Lista de Ventas</title>
    </head>
    <body>
        <%@include file="../Utilerias/Generico/Nav.jsp"%>
        <div class="container">
            <h1>Lista de Ventas</h1>


            <table  id="tabla" class="table table-responsive table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Fecha Compra</td>
                        <td>Descripcion </td>

                        <td>Cliente</td>


                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="ventas">
                        <tr>
                            <td><s:property value="idVenta"></s:property></td>
                            <td><s:property value="fecha_compra"></s:property></td>
                            <td><s:property value="descripcion"></s:property></td>

                                <td><s:property value="persona.nombre"></s:property></td>



                            </tr>
                    </s:iterator>

                </tbody>



            </table>






            <script type="text/javascript">
                $(document).ready(function () {
                    $('#tabla').DataTable({
                        "language": {
                            "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
                        }
                    });
                });
            </script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    </body>
</html>
