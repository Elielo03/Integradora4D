<%-- 
    Document   : Cerrar
    Created on : 28/11/2015, 02:39:45 AM
    Author     : Hermanos Saucedo
--%>


<ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-user"></span> 
            <strong>Nombre</strong>
            <span class="glyphicon glyphicon-chevron-down"></span>
        </a>
        <ul class="dropdown-menu">
            <li>
                <div class="navbar-login">
                    <div class="row">
                        <div class="col-lg-4">
                            <p class="text-center">
                                <span class="glyphicon glyphicon-user icon-size"></span>
                            </p>
                        </div>
                        <div class="col-lg-8">
                            <p class="text-left"><strong>Nombre Apellido</strong></p>
                            <p class="text-left small"></p>
                            <p class="text-left">
                                <a href="#" class="btn btn-primary btn-block btn-sm">Actualizar Datos</a>
                            </p>
                        </div>
                    </div>
                </div>
            </li>
            <li class="divider"></li>
            <li>
                <div class="navbar-login navbar-login-session">
                    <div class="row">
                        <div class="col-lg-12">
                            <p>
                            <s:form action="cerrar"  theme="simple" >
                                <button type="submit" class="btn btn-danger btn-block">Cerrar Sesion</button>
                            </s:form>             
                            </p>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </li>
</ul>