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
        <title>Lista Productos</title>
    </head>
    <body>
        <div class="container">
        <h1>Lista Ventas</h1>
        

        <table  id="tabla" class="table table-responsive table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Fecha Compra</td>
                    <td>Descripcion </td>
                    <td>Estado</td>
                    <td>Cliente</td>
                    <td>Actualizar</td>
                    <td>Eliminar</td>

                    
                </tr>
            </thead>
            <tbody>
                <s:iterator value="ventas">
                    <tr>
                        <td><s:property value="fecha_compra"></s:property></td>
                        <td><s:property value="descripcion"></s:property></td>
                        <td><s:property value="estado"></s:property></td>
                        <td><s:property value="persona"></s:property></td>
                            
                            <td>
                            <s:submit value="actualizar"></s:submit>
                            </td>
                            
                             <td>
                            <s:submit value="borrar"></s:submit>
                            </td>
                        
                    </tr>
                </s:iterator>
               
            </tbody>



        </table>
        
         <s:form action="readCarrito">
                    <s:submit value="ir al carrito"></s:submit>
                </s:form>
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
