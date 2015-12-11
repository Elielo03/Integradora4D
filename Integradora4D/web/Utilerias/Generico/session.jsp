<%-- 
    Document   : session
    Created on : 28/11/2015, 02:43:34 AM
    Author     : Hermanos Saucedo
--%>


<%@taglib prefix="s" uri="/struts-tags" %>
<ul class="nav navbar-nav navbar-right">
    <li><p class="navbar-text"></p></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"style="color: white;"><b>Iniciar sesión</b> <span class="caret"></span></a>
        <ul id="login-dp" class="dropdown-menu">
            <li>
                <div class="row">
                    <div class="col-md-12">

                        <s:form action="login"  theme="simple" >
                            <div class="form-group">                                  
                                <input required="" id="Usuario"  name="usuario.userName" class="form-control" placeholder="Correo Electronico" />

                            </div>
                            <div class="form-group">                                         
                                <input required="" id="Contraseña" type="password"  name="usuario.pass" class="form-control" placeholder="Contraseña" /> 

                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Iniciar</button>
                            </div>
                        </s:form> 

                    </div>

                    <div class="bottom text-center">
                        No tienes cuenta créate una <a href="<s:url action="llenarVacio"/> "><b>Aqui</b></a>
                    </div>
                </div>
            </li>
        </ul>
    </li>
</ul>


               