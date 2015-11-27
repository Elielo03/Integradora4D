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
        <title>Lista Carrito</title>
    </head>
    <body>
        <div class="container">
        <h1>Lista Carrito</h1>
        

        <table  id="tabla" class="table table-responsive table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <td>Imagen</td>
                    <td>Nombre</td>
                    <td>Existencias</td>
                    <td>Precio Venta</td>

                    <td>Compra</td>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="productos" var="carrito">
                    <s:iterator>
                    <tr>
                        <td><img src="<s:url value="%{imagen}"/>" width="120" height="120"/></td>
                        <td><s:property value="carrito.nombre"></s:property></td>
                        <td><s:property value="carrito.existencias"></s:property></td>
                            <td><s:property value="carrito.precio_v"></s:property></td>
                            <td>
                            <s:hidden value="carrito.idProducto"></s:hidden>
                                <a href="<s:url action="agregarCarro"/>" class="btn btn-primary btn-primary"><span class="glyphicon glyphicon-tag"></span> Agregar Al Carrito</a>
                        </td>
                    </tr>
                </s:iterator>
                    </s:iterator>
            </tbody>



        </table>
        </div>

        


        <script type="text/javascript">
            $(document).ready(function () {
                $('#tabla').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
                    }
                });
            });
        </script>


    </body>
</html>
