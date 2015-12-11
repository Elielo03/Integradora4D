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
    </head>
    <body>
        <div class="container">
          
           
            
            
        <h1>Lista Carrito Usuario</h1>
      

        <table   id="tabla" class="table table-responsive table-striped table-bordered table-hover" >
            <thead>
                <tr>
                   
                    <td>Producto</td>
                    <td>Persona</td>
                    
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
                    <s:property value="idPersona"/> 
                </td>
                
                
               
                
                <td>
                    <s:form action="eliminarElemento">
                        <s:hidden name="idProducto"></s:hidden> 
                        <button onclick="eliminar()" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Eliminar del Carrito</button>
                        
                        
                    </s:form>
                    
                </td>
                
                
                     </tr>
                     
                    </s:iterator>
            </tbody>



        </table>
         <s:form action="realizarCompra">
             
            <s:submit value="realizar Compra"></s:submit>
            
        </s:form>
        
        </div>
        
       
        <script>
            function eliminar(){
                document.eliminarElemento.submit();
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
