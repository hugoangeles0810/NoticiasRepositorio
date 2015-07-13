<%-- 
    Document   : index
    Created on : 03/07/2015, 01:16:23 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>


<div id="wrapper">
    <section>
        <br/>
        <div class="container">
            <c:forEach var="noticia" items="${noticias}">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="noticias/${noticia.enlace}.html"><img src="${DIR_IMAGE}${noticia.bannerSmall}" alt="242x200" style="height: 300px; width: 100%; display: block;" /></a>
                        <div class="caption">
                            <a href="noticias/${noticia.enlace}.html"><h4>${noticia.titulo}</h4></a>
                            <p>${noticia.descripcion}.</p>
                            <p style="text-align: right"><a href="noticias/${noticia.enlace}.html" class="btn btn-primary" role="button">Ver más</a></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div id="push"></div>
    </section> 
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
