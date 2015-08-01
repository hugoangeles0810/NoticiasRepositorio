<%-- 
    Document   : index
    Created on : 03/07/2015, 01:16:23 AM
    Author     : Hugo
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<%@include file="include/nav.jsp" %>


<div id="wrapper">
    <br />
    <div class="container">
        <section id="pinBoot">
        <c:forEach var="noticia" items="${noticias}">
            <article class="white-panel"><a href="${pageContext.request.contextPath}/noticias/${noticia.enlace}.html"><img src="${DIR_IMAGE}${noticia.bannerSmall}" alt="" class="white-img"></a>
                <h4><a href="${pageContext.request.contextPath}/noticias/${noticia.enlace}.html">${noticia.titulo}</a></h4>
                <p><fmt:formatDate type="both" pattern="dd MMMM 'de' yyyy, HH:mm" value="${noticia.fechaPublicacion}"/></p>
                <p>${noticia.descripcion}</p>
            </article>
        </c:forEach>
    </section> 
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