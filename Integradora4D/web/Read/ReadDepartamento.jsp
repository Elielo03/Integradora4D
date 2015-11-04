<%-- 
    Document   : ReadCategoria
    Created on : 14-oct-2015, 10:58:45
    Author     : Eliel David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria</title>
    </head>
    <body>
        <h1>Categorias: </h1>
        
        <table  border="1">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                 <td>Descripcion</td>
                <td>Estado</td>
               
                <td>Actualizar</td>
                <td>Eliminar</td>
            </tr>
            <s:iterator value="departamentos">
            <tr>
                <td><s:property value="idDepartamento"></s:property></td>
                <td><s:property value="nombre"></s:property></td>
                 <td><s:property value="descripcion"></s:property></td>
                <td><s:property value="estado"></s:property></td>
                
                <td>  <s:form action="btnUpdateDepartamento">
                        <s:hidden name="idDepartamento"></s:hidden>
                        <s:submit value="Actualizar"></s:submit>
                    </s:form>
                </td>
                <td><s:form action="deleteDepartamento">
                        <s:hidden name="idDepartamento"></s:hidden>
                        <s:submit value="Eliminar" id="eliminar"></s:submit>
                    </s:form></td>
            </tr>
            
            
            
        </s:iterator>
            
            </table>
        
        
        <script type="text/javascript">
            
            function cambiar(x){
                $(".eliminar").click(function (){
                    
                }
                        )
            }
            
            
        </script>
        
        
        
    </body>
</html>
