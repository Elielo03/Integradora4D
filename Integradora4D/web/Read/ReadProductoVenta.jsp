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
        <title>Lista de Produtos</title>
    </head>
    <body>
        <div class="container">
            <h1>Lista Productos</h1>


            <table  id="tabla" class="table table-responsive table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <td>Imagen</td>
                        <td>Nombre</td>
                        <td>Existencias</td>
                        <td>Precio Venta</td>
                        <td>Cantidad</td>

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
                                

                            
                                    
                                <td> <s:textfield name="cantidad" ondblclick="setValue()" name="cantidad"  size="1" theme="simple"></s:textfield>

                                


                                <td>
                               <s:form action="agregarCarro">
                                   <s:textfield id="cantidadHidden"    name="cantidadHidden"></s:textfield>
                                    <s:hidden name="idProducto"></s:hidden>

                                    <s:submit  value="agregar al Carro"/> 
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
            function setValue(){
                
               document.getElementByName("cantidad").value=document.getElementByName("cantidadHidden").value;
                      
                
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


    </body>
</html>
