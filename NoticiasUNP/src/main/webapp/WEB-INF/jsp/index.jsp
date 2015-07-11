<%-- 
    Document   : index
    Created on : 03/07/2015, 01:16:23 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>


<section>
    <div class="container">
        <div class="list-group">
            <c:forEach var="noticia" items="${noticias}">
                <a href="#${noticia.id}" class="list-group-item">
                    <h4 class="list-group-item-heading">${noticia.titulo}</h4>
                    <img src="${DIR_IMAGE}${noticia.bannerSmall}" /><p class="list-group-item-text">${noticia.descripcion}</p>
                </a>
            </c:forEach>
        </div>
    </div>
</section> 



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
