<%-- 
    Document   : register
    Created on : 08/07/2015, 02:41:28 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="login-error-msg" class="alert alert-danger alert-dismissible" role="alert" style="display: none;">
    <div id="error-msg"></div>
</div>
<form id="register-form" class="form-horizontal">
    <div class="form-group">
        <label for="nombre" class="col-sm-3 control-label">Nombre</label>
        <div class="col-sm-7">
            <input id="nombre" type="text" name="nombre" class="form-control" autofocus required/>
        </div> 
    </div>
    <div class="form-group">
        <label for="apellidos" class="col-sm-3 control-label">Apellidos</label>
        <div class="col-sm-7">
            <input id="apellidos" type="text" name="apellidos" class="form-control" required />
        </div> 
    </div>
    <div class="form-group">
        <label for="correo" class="col-sm-3 control-label">Correo</label>
        <div class="col-sm-7">
            <input id="correo" type="text" name="correo" class="form-control"  required/>
        </div> 
    </div>
    <div class="form-group">
        <label for="clave" class="col-sm-3 control-label">Clave</label>
        <div class="col-sm-7">
            <input id="clave" type="password" name="clave" class="form-control" required/>
        </div> 
    </div>
    <div>
        <div class="row">
            <div class="col-sm-offset-2 col-sm-8">
                <input type="submit" value="Registrate" class="btn btn-block btn-primary" />
                <a class="btn btn-block btn-social btn-facebook" href="${pageContext.request.contextPath}/auth/facebook?scope=email">
                    <i class="fa fa-facebook"></i>Entra con Facebook
                </a>
            </div>
        </div>
    </div>
</form>
