<%-- 
    Document   : ReadPersona
    Created on : 21/10/2015, 01:47:51 AM
    Author     : Hermanos Saucedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@include file="../Utilerias/metas.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consultar Persona</h1>
         <table  id="tabla" class="table table-responsive table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th>idPersona</th>
                    <th>nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>Direccion</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Tipo usuario</th>
                    <th>idDepartamento</th>
                    <th>Estado</th>
                    <th>pass</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>           
                </tr>
            </thead>
            <s:iterator value="listaPersona">
                <tbody>
                    <tr>  
                        <td><s:property value="idPersona"/></td>
                        <td><s:property value="nombre"/></td>
                        <td><s:property value="app"/></td>
                        <td><s:property value="apm"/></td>
                        <td><s:property value="direccion"/></td>
                        <td><s:date name="fechaNac" format="dd.MM.yyyy"/></td>
                        <td><s:property value="correoE"/></td>
                        <td><s:property value="telefono"/></td>     
                        <td><s:property value="Usuario.idTipoUsuario"/></td>
                        <td><s:property value="Departamento.nombre"/></td>
                        <td>
                            <%
                                   String estado=""+pageContext.findAttribute("estado");
                                    String strclass;
                                   
                                    if(estado.equals("true")){
                                        
                                        strclass="btn btn-success";
                                    }else{
                                         
                                        strclass="btn btn-danger";
                                    }
                                    %>
                                    <button    name="button2id" class="<%=strclass%>"> <%=estado%> </button>
                            
                            
                            
                        </td>
                       <td><s:property value="pass"/></td>
                        <td>
                            <s:form action="updatePersona">
                                <s:hidden name="idPersona" />
                                <s:submit value="Actualizar"/>
                            </s:form>                   
                        </td>
                        <td>
                            <s:form action="deletePersona">
                                <s:hidden name="idPersona" />
                                <s:submit value="Eliminar"/>
                            </s:form>
                        </td>
                    </tr>
                </tbody>
            </s:iterator>

        </table>
        
        
        
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
