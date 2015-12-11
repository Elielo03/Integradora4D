<%-- 
    Document   : Departamento
    Created on : 10/10/2015, 08:38:59 PM
    Author     : Hermanos Saucedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <title>Departamento</title>
                <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <script src="https://code.jquery.com/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
    </head>
    <body>
        <%@include file="../Utilerias/Generico/Nav.jsp"%>
        <h1>Departamento</h1>
        <s:form action="addDepartamento" method="post" cssClass="form-horizontal" theme="simple">  
            <s:hidden name="departamento.idDepartamento"></s:hidden>
            
            <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Departamento:</label>  
            <div class="col-md-4">
                 <s:textfield name="departamento.nombre" label="Nombre" title="nombre de departamento" placeholder="Nombre"
                               cssClass="form-control input-md" required="true"/>
                 <span class="help-block">Ingresa el nombre del Departamento </span>  
            </div>
            </div>
            
            
             <div class="form-group">
            <label class="col-md-4 control-label" for="textarea">Descripción:</label>  
            <div class="col-md-6">
                <s:textarea name="departamento.descripcion" label="Descripcion" title="descripcion de departamento" placeholder="Descripcion"
                             cssClass="form-control"/>
                
            </div>
            </div>
            
             <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
            <s:submit id="singlebutton" value="Guardar" name="singlebutton" cssClass="btn btn-primary"></s:submit>
            </div>
            </div>
        </s:form>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
