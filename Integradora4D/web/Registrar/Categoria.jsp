<%-- 
    Document   : Categoria
    Created on : 11/10/2015, 03:30:33 PM
    Author     : Hermanos Saucedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <title>Categoria</title>
    </head>
    <body>
        
        <div class="container">
            <h1>Categoria</h1>

        <s:form action="addCategoria" cssClass="form-horizontal" theme="simple">      


           <s:hidden name="categoria.idCategoria"></s:hidden>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Categoria:</label>  
            <div class="col-md-4">
            <s:textfield  name="categoria.nombre" type="text"   cssClass="form-control input-md" required=""></s:textfield>
                <span class="help-block">Ingresa el nombre de la categoría </span>  
            </div>
        </div>

        <!-- Select Basic -->
        
            <label class="col-md-4 control-label" for="departamento.idDepartamento">Departamento</label>
            <div class="col-md-4">
                <s:select id="departamento.idDepartamento" name="departamento.idDepartamento" 
                          list="departamentos" listValue="nombre" listKey="idDepartamento" cssClass="form-control"></s:select>
                   
               <s:submit id="singlebutton" value="Guardar" name="singlebutton" cssClass="btn btn-primary" theme="simple"></s:submit>
            </div>
            
            
       

        <!-- Button -->
       
        
            
                
                    
              
        </div>
           
    </s:form>






</body>
</html>
