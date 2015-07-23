<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 21/07/2015, 07:16:22 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<div id="wrapper">
    <section>
        <br/>
        <div class="container">
            <div class="row">
                <div class="col-md-offset-1 col-md-3">
                    <a id="nueva-noticia" href="javascript:void(0);" class="btn btn-info">Nueva Noticia</a>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-md-offset-1 col-md-9">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr class="success">
                                <th>Titulo</th>
                                <th>Descripcion</th>
                                <th class="text-center">Ver</th>
                                <th class="text-center">Modificar</th>
                                <th class="text-center">Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="noticia" items="${noticias}">
                                <tr id="${noticia.id}">
                                    <td>${noticia.titulo}</td>
                                    <td>${noticia.descripcion}</td>
                                    <td class="text-center"><a href="${pageContext.request.contextPath}/noticias/${noticia.enlace}.html"><span class="glyphicon glyphicon-search"></span></a></td>
                                    <td class="text-center"><a href="javascript:void(0);" class="update"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                    <td class="text-center"><a href="javascript:void(0);" class="delete"><span class="glyphicon glyphicon-remove"></span></a></td>
                                </tr>
                            </c:forEach>               
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="push"></div>
    </section> 
</div>
<div id="dialog" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">&nbsp; Noticia</h4>
            </div>
            <div id="dialog-content" class="modal-body">
            </div>
        </div>
    </div>
</div>
<%@include file="../include/footer.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/editor.js"></script>
</body>
</html>
