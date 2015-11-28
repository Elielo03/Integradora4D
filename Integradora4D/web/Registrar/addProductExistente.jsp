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
        <s:form action="addExist" enctype="multipart/form-data" method="POST" >
            
            
            
            
           

             <s:select name="bean.codigo"   label="Seleccionar una Producto" list="productos" listValue="nombre"
                      listKey="codigo"></s:select>
            
            <s:textfield name="bean.existencias" label="Existancia" title="existencias producto" placeholder="existencias"/>
            <s:textfield name="bean.stock" label="stock" title="stock producto" placeholder="stock"/>
            
            
             
             
            <s:hidden name="url"></s:hidden>
             
            
           
            <s:file name="archivo" label="Selecciona tu imagen"/>
            
            
            <s:submit value="Guardar"/>

        </s:form>
    </body>
</html>
