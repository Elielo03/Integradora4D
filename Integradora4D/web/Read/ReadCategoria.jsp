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
        <%@include file="../Utilerias/metas.jsp" %>
        <title>Lista de Categorias</title>



    </head>
    <body>



        <h1>Lista de Categorias </h1>
        <div class="container">

            <table  id="tabla" class="table table-responsive table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        
                        <td>Nombre</td>
                        <td>Estado</td>
                        <td>Departamento</td>
                        <td>Actualizar</td>
                        <td>Eliminar</td>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator   value="categorias"  >
                       
                        
                        <tr>
                           
                            <td><s:property value="nombre"></s:property></td>
                            
                            <td>
                                <form action="updateEstadoCategoria">
                                 <s:hidden name="idCategoria"></s:hidden>
                                
                                
                                
                                <%
                                   String estado=""+pageContext.findAttribute("estado");
                                    String strclass;
                                   
                                    if(estado.equals("true")){
                                        
                                        strclass="btn btn-success";
                                    }else{
                                         
                                        strclass="btn btn-danger";
                                    }
                                    %>
                                    <button  onclick="updateCategoria()" name="button2id" class="<%=strclass%>"> <%=estado%> </button>

                                </form>




                            </td>
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
                        </tr
                    </s:iterator>
                </tbody>


            </table>
        </div>
        
        


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
