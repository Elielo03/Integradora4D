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
        <title>Lista Carrito User</title>
        <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <script src="https://code.jquery.com/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
    </head>
    <body>
        <%@include file="../Utilerias/Generico/Nav.jsp"%>
        <div class="container">




            <h1>Lista Carrito Usuario</h1>


            <table   id="tabla" class="table table-responsive table-striped table-bordered table-hover" >
                <thead>
                    <tr>

                        <td>Producto</td>
                        <td>Cantidad</td>
                        <td>Compra</td>
                        <td>Eliminar </td>       


                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="carrito">
                        <tr>
                            <td>
                                <s:property value="producto.nombre"/> 
                            </td>


                            <td>
                                <s:form action="buyCar" theme="simple">
                                    <s:hidden name="producto.idProducto"></s:hidden>
                                    <s:textfield  name="cantidadHidden"   value="1" size="16" theme="simple"></s:textfield>



                                    </td>

                                    <td>
                                        <button onclick="buyCar()" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Realizar compra </button>
                                    </td>
                            </s:form>



                            <td>
                                <s:form action="deleteCar">
                                    <s:hidden name="Producto.idProducto"></s:hidden> 
                                        <button onclick="eliminar()" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Eliminar del Carrito</button>


                                </s:form>

                            </td>


                        </tr>

                    </s:iterator>
                </tbody>



            </table>


        </div>

        <script>
            function eliminar() {
                document.buyCar.submit();
            }

        </script>


        <script>
            function eliminar() {
                document.deleteCar.submit();
            }

        </script>



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
