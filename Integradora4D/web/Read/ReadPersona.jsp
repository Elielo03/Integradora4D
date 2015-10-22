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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consultar Persona</h1>
        <table border="1">
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
                    <th>idUsuario</th>
                    <th>idDepartamento</th>
                    <th>Estado</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>           
                </tr>
            </thead>
            <s:iterator value="listaPersona">
                <tbody>
                    <tr>  
                        <td><s:property value="persona.idPersona"/></td>
                        <td><s:property value="persona.nombre"/></td>
                        <td><s:property value="persona.app"/></td>
                        <td><s:property value="persona.apm"/></td>
                        <td><s:property value="persona.direccion"/></td>
                         <td><s:property value="persona.fechaNac"/></td>
                        <td><s:property value="persona.correoE"/></td>
                        <td><s:property value="persona.telefono"/></td>     
                        <td><s:property value="persona.idUsuario"/></td>
                        <td><s:property value="persona.idDepartamento"/></td>
                        <td><s:property value="persona.estado"/></td>
                        <td>actualizar</td>
                        <td>elimina</td>




                    </tr>
                </tbody>
            </s:iterator>

        </table>
    </body>
</html>
