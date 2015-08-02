<%-- 
    Document   : noticia
    Created on : 12/07/2015, 09:20:43 PM
    Author     : Hugo
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
