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
        <title>Lista Productos</title>
    </head>
    <body>
        <h1>Lista Productos</h1>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Codigo</td>
                <td>Descripción</td>
                <td>Existencias</td>
                <td>Stock</td>
                <td>Precio Compra</td>
                <td>Precio Venta</td>
                <td>Status</td>
                <td>Marca</td>
                <td>Imagen</td>
                <td>Categoria</td>
            </tr>
            <s:iterator value="productos">
                <tr>
                    <td><s:property value="idProducto"></s:property></td>
                    <td><s:property value="nombre"></s:property></td>
                    <td><s:property value="codigo"></s:property></td>
                    <td><s:property value="descripcion"></s:property></td>
                    <td><s:property value="existencias"></s:property></td>
                    <td><s:property value="stock"></s:property></td>
                   
                    <td><s:property value="precio_c"></s:property></td>
                    <td><s:property value="precio_v"></s:property></td>
                    <td><s:property value="estado"></s:property></td>
                    <td><s:property value="marca"></s:property></td>
                    <td><s:property value="imagen"></s:property></td>
                    <td><s:property value="categoria.nombre"></s:property></td>
                </tr>
            </s:iterator>
            
            
            
        </table>
        
    </body>
</html>
