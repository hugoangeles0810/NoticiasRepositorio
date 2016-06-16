<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/css/font-awesome.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/css/bootstrap-social.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/css/bootstrap-table.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css" />
    </head>
    <body>

        <header id="header">
            <div class="container">
                <div class="row">
                    <div class="col-sm-5">
                        <a href="${pageContext.request.contextPath}/index.html" class="no-decoration">
                            <div>
                                <img id="logo-img" src="${pageContext.request.contextPath}/resources/img/logounp.jpg" alt="Noticias UNP" />
                                <h1 id="logo-text">Noticias UNP</h1>
                            </div>
                        </a>
                        <div class="col-sm-offset-5">
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
                    <div class="col-sm-4 login-controls">
                        <sec:authorize access="!isAuthenticated()">
                            <div class="row">
                                <a id="btn-register" class="btn btn-primary btn-login">Registrarse</a>
                            </div>
                            <div class="row">
                                <a id="btn-login" class="btn btn-primary btn-login login">Inicia Sesión</a>
                            </div>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <div class="col-sm-12">
                                <div class="row">
                                    <sec:authentication property="principal.imageUrl" var="image" />
                                    <c:if test="${image==null}">
                                        <img src="${pageContext.request.contextPath}/resources/img/user.png" class="img-circle" height="50" width="50" /> 
                                    </c:if>
                                    <c:if test="${image!=null}">
                                        <img src="${image}" class="img-circle"  height="50" width="50" /> 
                                    </c:if> 
                                        &nbsp;<sec:authentication property="principal.firstName" /> <sec:authentication property="principal.lastName" />
                                </div>
                                <div class="row" style="margin-top: 5px;">
                                    <div class="col-sm-8 text-right">
                                        <a href="/NoticiasUNP/logout" class="btn btn-danger btn-sm">Salir</a>
                                    </div>
                                </div>
                            </div>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </header>
