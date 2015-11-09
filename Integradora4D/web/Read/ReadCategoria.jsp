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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
       
        
        <!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.css">
  
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
  
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.js"></script>






<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json">






        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json">
        <title>Categoria</title>
    </head>
    <body>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#tabla1').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.7/i18n/Spanish.json"
                    }
                });
            });
        </script>



        <h1>Categorias: </h1>

        <table  id="tabla1" class="table table-responsive table-striped table-bordered table-hover">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Estado</td>
                <td>Departamento</td>
                <td>Actualizar</td>
                <td>Eliminar</td>
            </tr>
            <s:iterator value="categorias">
                <tr>
                    <td><s:property value="idCategoria"></s:property></td>
                    <td><s:property value="nombre"></s:property></td>
                    <td><input id="edo" onClick="cambiarEstado()" type="text" value="${estado}"> 
                        
                         
                        </input></td>
                    <td><s:property value="departamento.nombre"></s:property></td>
                    <td>  <s:form action="botonUpdate">
                            <s:hidden name="idCategoria"></s:hidden>
                            <s:submit value="Actualizar"></s:submit>
                        </s:form>
                    </td>
                    <td><s:form action="deleteCategoria">
                            <s:hidden name="idCategoria"></s:hidden>
                            <s:submit value="Eliminar" id="eliminar"></s:submit>
                        </s:form></td>
                </tr>
                
                
                <script type="text/javascript">
                    function cambiarEstado(){
                        var hola=document.getElementById("edo").value;
                        alert("Holaaaa"+hola);
                        
                       
            }
                </script>

            </s:iterator>

        </table>


        



    </body>
</html>
