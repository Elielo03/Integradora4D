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
        <h1>Lista de Productos</h1>
        <table  id="tabla" class="table table-responsive table-striped table-bordered table-hover">
            <thead>
            <tr>
                
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
                <td>Actualizar</td>
                <td>Eliminar</td>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="productos">
                <tr>
                    
                    <td><s:property value="bean.nombre"></s:property></td>
                    <td><s:property value="codigo"></s:property></td>
                    <td><s:property value="descripcion"></s:property></td>
                    <td><s:property value="existencias"></s:property></td>
                    <td><s:property value="stock"></s:property></td>
                   
                    <td><s:property value="precio_c"></s:property></td>
                    <td><s:property value="precio_v"></s:property></td>
                    <td>
                        <form action="updateEstadoProducto" name="updateEstadoProducto">
                            <s:hidden name="idProducto"></s:hidden>
                        <%
                                   String estado=""+pageContext.findAttribute("estado");
                                    String strclass;
                                   
                                    if(estado.equals("true")){
                                        
                                        strclass="btn btn-success";
                                    }else{
                                         
                                        strclass="btn btn-danger";
                                    }
                                    %>
                                    <button onclick="updateEstado()"   name="button2id" class="<%=strclass%>"> <%=estado%> </button>
                        
                        </form>
                        
                    </td>
                    <td><s:property value="marca"></s:property></td>
                    <td><img src="<s:url value="%{imagen}"/>" width="120" height="120"/></td>
                    <td><s:property value="categoria.nombre"></s:property></td>
                    <td>
                        
                    <s:form action="updateProducto">
                        <s:hidden name="idProducto"></s:hidden>
                       
                        <s:submit value="Actualizar"></s:submit>
                    </s:form>
                    
                    </td>
                    <td>
                    <s:form action="deleteProducto">
                        <s:hidden name="idProducto"></s:hidden>
                        <s:submit value="Eliminar"></s:submit>
                    </s:form>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
            
            
            
        </table>
        
        
        <script>
            function updateEstado(){
                document.updateEstadoProducto.submit();
            }
            </script>
        
         <script type="text/javascript">
        $(document).ready( function () {
    $('#tabla').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
            }
        } );
} );
</script>
        
        
    </body>
</html>
