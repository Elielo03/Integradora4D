<%-- 
    Document   : Producto
    Created on : 10/10/2015, 08:46:36 PM
    Author     : Hermanos Saucedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Producto</h1>
        <s:form action="addProducto" enctype="multipart/form-data" method="POST" >
            <s:textfield name="bean.idProducto"></s:textfield>

            <s:textfield name="bean.nombre" label="Nombre" title="nombre de Producto" placeholder="Nombre"/>
            <s:textfield name="bean.codigo" label="Codigo" title="codigo producto" placeholder="Codigo"/>
            <s:textarea name="bean.descripcion" label="Descripcion" title="descripcion producto" placeholder="Descripcion"/>
            <s:textfield name="bean.existencias" label="Existancia" title="existencias producto" placeholder="existencias"/>
            <s:textfield name="bean.stock" label="stock" title="stock producto" placeholder="stock"/>
            <s:textfield name="bean.precio_c" label="precio_c" title="precio_c producto" placeholder="precio_c"/>
            <s:textfield name="bean.precio_v" label="precio_v" title="precio_v producto" placeholder="precio_v"/>
            <s:textfield name="bean.marca" label="marca" title="marca producto" placeholder="marca"/> 
             <s:select name="idCategoria"   label="Seleccionar una Categoria" list="categorias" listValue="nombre"
                      listKey="idCategoria"></s:select>
             
             
            <s:textfield name="bean.imagen"></s:textfield>>
             
            
           
            <s:file name="archivo" label="Selecciona tu imagen"/>
            
            
            <s:submit value="Guardar"/>

        </s:form>
    </body>
</html>
