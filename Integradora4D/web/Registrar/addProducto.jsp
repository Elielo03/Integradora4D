<%-- 
    Document   : Producto
    Created on : 10/10/2015, 08:46:36 PM
    Author     : Hermanos Saucedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
                <link rel="stylesheet" type="text/css" href="<s:url value="../Utilerias/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>"/>
        <script src="https://code.jquery.com/jquery.js"></script>
        <link rel="stylesheet" type="text/css" href="../Utilerias/Otros/otros.css"/>
    </head>
    <body>
        <%@include file="../Utilerias/Generico/Nav.jsp"%>
        <div class="form-group">
        <h1>Agregar Producto</h1>
        <a href="<s:url action="addExistente"/>">Agregar Existente</a>
        <s:form action="addProducto" enctype="multipart/form-data" method="POST" cssClass="form-horizontal" theme="simple">
            
            
            
            
           
             <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Nombre:</label>  
            <div class="col-md-4">
            <s:textfield name="bean.nombre" type="text"   cssClass="form-control input-md" required=""/>
            </div>
        </div>
            
            
           <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Codigo</label>  
            <div class="col-md-4">
            <s:textfield name="bean.codigo" type="text"   cssClass="form-control input-md" required=""/>
             </div>
        </div>
            
            <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Descripcion</label>  
            <div class="col-md-4">
          <s:textarea name="bean.descripcion" type="text"   cssClass="form-control input-md" required=""/>
          </div>
        </div>
          
           
                
                
                <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Existencias:</label>  
            <div class="col-md-4">
          <s:textfield name="bean.existencias" type="text"   cssClass="form-control input-md" required=""/>
           </div>
        </div>
          
          <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Stock</label>  
            <div class="col-md-4">
          <s:textfield name="bean.stock" type="text"   cssClass="form-control input-md" required=""/>
            </div>
        </div>
          
          <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Precio Compra</label>  
            <div class="col-md-4">
          <s:textfield name="bean.precio_c" type="text"   cssClass="form-control input-md" required=""/>
           </div>
        </div>
          
          <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Precio Venta</label>  
            <div class="col-md-4">
          <s:textfield name="bean.precio_v" type="text"   cssClass="form-control input-md" required=""/>
           </div>
        </div>
          
          <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Marca: </label>  
            <div class="col-md-4">
          <s:textfield name="bean.marca" type="text"   cssClass="form-control input-md" required=""/> 
          </div>
        </div>   
          
          
           <!-- Select Basic -->
        
            <label class="col-md-4 control-label" for="departamento.idDepartamento">Categoria</label>
            <div class="col-md-4">
          <s:select name="categoria.idCategoria"   label="Seleccionar una Categoria" list="categorias" listValue="nombre"
                      listKey="idCategoria" cssClass="form-control"></s:select>
                 
             
             
            <s:hidden name="url"></s:hidden>
             
            
            <div class="form-group">
                <div class="col-md-4">
                    
            <s:file name="archivo" label="Selecciona tu imagen"/>
            
            
            
            <s:submit value="Guardar"/>
            </div>
            </div>
            </div>

        </s:form>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
