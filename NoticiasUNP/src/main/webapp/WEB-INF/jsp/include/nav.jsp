<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : nav
    Created on : 04/07/2015, 05:06:25 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="nav navbar-inverse nav-container">
    <div class="container">
        <ul class="nav navbar-nav navbar-left">
            <c:forEach var="categoria" items="${categorias}">
                <li id="inicio"><a href="">${categoria.nombre}</a></li>
            </c:forEach>
        </ul>
    </div>
</nav>
