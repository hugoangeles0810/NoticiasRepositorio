<%-- 
    Document   : noticia
    Created on : 12/07/2015, 09:20:43 PM
    Author     : Hugo
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-lg-offset-1 col-lg-10 col-sm-12">
            <h1>${noticia.titulo}</h1>
            <p><span class="glyphicon glyphicon-time"></span> Publicado el <fmt:formatDate type="both" pattern="dd MMMM 'de' yyyy, HH:mm" value="${noticia.fechaPublicacion}"/></p>
            <div class="col-lg-12 col-sm-12">
                <div class="banner-container">
                    <img src="${DIR_IMAGE}${noticia.bannerLarge}" class="img-responsive" width="650px" height="300px" style="" />
                    <div class="banner-descripcion">
                        <span class="banner-descripcion-text" >${noticia.descripcion}</span>
                    </div>

                </div>

            </div>
            <br />
            <p>${noticia.contenido}</p> 
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-1 col-lg-6 col-sm-12">
            <h3>${fn:length(noticia.comentarios)} Comentarios</h3>
            <hr/>
        </div>
    </div>
    <div class="row">
        <sec:authorize access="!isAuthenticated()">
            <div class="col-lg-offset-1 col-lg-3 col-sm-3">
                <button class="btn btn-success login">Iniciar sessión para comentar</button>
            </div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <div class="col-lg-offset-1 col-lg-6 col-sm-12">
                <div class="well">
                    <h4>Has un comentario:</h4>
                    <form id="form-comment" role="form">
                        <input type="hidden" value="${noticia.id}" name="noticiaId" />
                        <div class="form-group">
                            <textarea id="contenido" name="contenido" class="form-control" rows="3" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
        </sec:authorize>
    </div>
    <br/>
    <div class="row">
        <div id="comentarios" class="col-lg-offset-1 col-lg-6 col-sm-12">
            <c:forEach var="comentario" items="${noticia.comentarios}">
                <div class="row">
                    <div class="col-sm-2">
                        <div class="thumbnail">
                            <c:if test="${comentario.usuario.foto == null}">
                                <img class="img-responsive user-photo" src="${pageContext.request.contextPath}/resources/img/user.png"> 
                            </c:if>
                            <c:if test="${comentario.usuario.foto != null}">
                                <img class="img-responsive user-photo" src="${comentario.usuario.foto}"> 
                            </c:if>

                        </div>
                    </div>

                    <div class="col-sm-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <strong>${comentario.usuario.nombre} ${comentario.usuario.apellidos}</strong> <span class="text-muted">&nbsp;<fmt:formatDate type="both" pattern="dd/MM/yyyy HH:mm" value="${comentario.fecha}"/></span>
                            </div>
                            <div class="panel-body">
                                ${comentario.contenido}
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</div>
<div id="dialog" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel"><span class="glyphicon glyphicon-user"></span>&nbsp; Iniciar Sesión / Registrate</h4>
            </div>
            <div id="dialog-content" class="modal-body">
            </div>
        </div>
    </div>
</div>
<%@include file="include/footer.jsp" %>
</body>
</html>
