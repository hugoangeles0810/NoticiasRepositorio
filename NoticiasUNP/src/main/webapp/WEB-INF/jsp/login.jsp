<%-- 
    Document   : login
    Created on : 05/07/2015, 07:41:20 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="login-error-msg" class="alert alert-danger alert-dismissible" role="alert" style="display: none;">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <div id="error-msg">Usuario y/o password incorrecto.</div>
</div>
<form id="login-form" class="form-horizontal" method="POST" action="j_spring_security_check">
    <div class="form-group">
        <label for="usuario" class="col-sm-3 control-label">Usuario</label>
        <div class="col-sm-7">
            <input id="usuario" type="text" name="j_username" class="form-control" autofocus required/>
        </div> 
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-3 control-label">Password</label>
        <div class="col-sm-7">
            <input id="password" type="password" name="j_password" class="form-control" required /><br>
        </div> 
    </div>

    <div>
        <div class="row">
            <div class="col-sm-offset-2 col-sm-8">
                <input type="submit" value="Entrar" class="btn btn-block btn-primary" />
                <a class="btn btn-block btn-social btn-facebook" href="${pageContext.request.contextPath}/auth/facebook?scope=email">
                    <i class="fa fa-facebook"></i>Entra con Facebook
                </a>
            </div>
        </div>
    </div>
</form>

