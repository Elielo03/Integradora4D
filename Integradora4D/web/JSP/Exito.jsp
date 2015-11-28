<%-- 
    Document   : Exito
    Created on : 13-oct-2015, 20:41:58
    Author     : Eliel David
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

       

        <h1>AddCategoria</h1>
        <s:form action="readCategoria">
            <s:submit value="Aceptar"></s:submit>
        </s:form>
        <h1>Llenas Categoria</h1>
        <s:form action="llenarLista">
            <s:submit value="Aceptar"></s:submit>
        </s:form>
        <h1>-----persona------</h1>
        <s:form action="llenarVacio">
            <s:submit value="AddPersona"></s:submit>
        </s:form>
        <s:form action="LlenarPersona">
            <s:submit value="llenar tabla"></s:submit>
        </s:form>
        <s:form action="LlenarEmpleado">
            <s:submit value="add personaempleado"></s:submit>
        </s:form>
        <h1>-----fin persona------</h1>
        <s:form action="readProducto">
            <s:submit value="Read producto"></s:submit>
        </s:form>

        <s:form action="addPro">
            <s:submit value="aDD producto"></s:submit>
        </s:form>

        <s:form action="addDepa">
            <s:submit value="Add Departamento"></s:submit>
        </s:form>

        <s:form action="readDepartamento">
            <s:submit value="Read Departamento"></s:submit>
        </s:form>

        <s:form action="compras">
            <s:submit value="Compras"></s:submit>
        </s:form>
        
        <s:form action="readVentas">
            <s:submit value="readVentas"></s:submit>
        </s:form>

<<<<<<< HEAD



=======
        <h1>-------Reportes--------</h1>  
        <h1>ADMINISTRADOR</h1>
        <s:form action="AdminProductReport">
            <s:submit value="Productos"/>
        </s:form>

        <s:form action = "AdminSalesReportGraph">
            Fecha Inicio: <s:textfield name="desde"/>
            Fecha Final: <s:textfield name="hasta"/>
            <s:submit value="Ventas + Grafica"/>
        </s:form>

        <s:form action = "AdminSalesReport">
            Fecha Inicio: <s:textfield name="desde"/>
            Fecha Final: <s:textfield name="hasta"/>
            <s:submit value="Ventas"/>
        </s:form>
        <h1>EMPLEADO</h1>
        <s:form action = "EmployeeProductReport">
            <s:submit value="Productos"/>
        </s:form>
        <s:form action = "EmployeeSalesReport">
            Desde: <s:textfield name="desde"/>
            Hasta: <s:textfield name="hasta"/>
            <s:submit value="Ventas"/>
        </s:form>


    </body>
</html>
