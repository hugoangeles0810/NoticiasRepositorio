<%-- 
    Document   : header
    Created on : 04/07/2015, 05:05:34 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.:Noticias UNP:.</title>
        <link rel="icon" type="image/png" href="resources/img/favicon.png" />
        <link rel="stylesheet" href="resources/libs/css/bootstrap.min.css" />
        <link rel="stylesheet" href="resources/css/estilos.css" />
    </head>
    <body>

        <header id="header">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <a href="index.html" class="no-decoration">
                            <div>
                                <img id="logo-img" src="resources/img/logounp.jpg" alt="Noticias UNP" />
                                <h1 id="logo-text">Noticias UNP</h1>
                            </div>
                        </a>
                        <div class="col-sm-offset-6">
                            <h4 id="fecha" ></h4>
                        </div>
                    </div>


                    <div class="col-sm-3">
                        <div class="row">
                            <div id="cont_9f268cf89ca109e29bfe522526f33921">
                                <span id="h_9f268cf89ca109e29bfe522526f33921">El Tiempo en Piura</span>
                                <script type="text/javascript" async src="http://www.tiempo.com/wid_loader/9f268cf89ca109e29bfe522526f33921"></script>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3 login-controls">
                        <sec:authorize access="!isAuthenticated()">
                        <div class="row">
                            <a id="btn-logup" class="btn btn-primary btn-login">Registrarse</a>
                        </div>
                        <div class="row">
                            <a id="btn-login" class="btn btn-primary btn-login">Inicia Sesión</a>
                        </div>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <p>Usuario: <sec:authentication property="principal.username" /> </p>
                            <a href="logout" class="btn btn-danger btn-sm">Salir</a>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </header>
