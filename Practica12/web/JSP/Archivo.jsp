<%-- 
    Document   : Archivo
    Created on : 09-oct-2015, 14:23:23
    Author     : Eliel David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carga de archivos!!</h1>
        <s:form action="subirArchivo" enctype="multipart/form-data">
            
            <s:file name="archivo" label="Selecciona el archivo">
                
            </s:file>
            <s:submit value="SUBIR "></s:submit>
        </s:form> 
        
         <s:form action="subirArchivo2" enctype="multipart/form-data">
        
         <s:file name="archivo" label="Selecciona el archivo">
                
            </s:file>
            <s:submit value="CSV "></s:submit>
        </s:form> 
    </body>
</html>
