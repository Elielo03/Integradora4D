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
        <title>Lista de Produtos</title>
    </head>
    <body>
        <%@include file="../Utilerias/Generico/Nav.jsp"%>
        <div class="container">
            <h1>Lista Productos</h1>


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
                    <s:iterator value="productos">

                        <tr>
                            <td><img src="<s:url value="%{imagen}"/>" width="120" height="120"/></td>
                            <td><s:property value="nombre"></s:property></td>
                            <td><s:property value="existencias"></s:property></td>
                            <td><s:property value="precio_v"></s:property></td>








                                <td>
                                <s:form action="agregarCarro">
                                <td> <s:textfield  name="cantidadHidden"   value="1" size="16" theme="simple">

                                    </s:textfield>
                                </td>

                                <s:hidden name="idProducto"></s:hidden>

                            <button onclick="formulario()" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span> Agregar al carro</button>
                    </s:form>
                    </td>

                    </tr>


                </s:iterator>

                </tbody>



            </table>


            <s:form action="readCarrito">
                <s:submit value="ir al carrito"></s:submit>
            </s:form>
        </div>


        <script>
            function formulario() {
                alert("Elemento agregado al carro de Compras!");
                document.agregarCarro.submit();
            }

        </script>


        <script>
            function setValue() {

                document.getElementById("cantidadHidden").value = document.getElementById("cantidad").value;



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
