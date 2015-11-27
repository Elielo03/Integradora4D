<%-- 
    Document   : ReadProducto
    Created on : 21-oct-2015, 22:51:38
    Author     : Comodin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                   
                    <td>Codigo Producto</td>
                    <td>Precio Venta</td>

                   
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaProductos">
                     <tr>
                <td>
                    <s:property value="codigo"/> 
                </td>
                <td>
                    <s:property value="precio_v" />
                </td>
                     </tr>
                     
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
