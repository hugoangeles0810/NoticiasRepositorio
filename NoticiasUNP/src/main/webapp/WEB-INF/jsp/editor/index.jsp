<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 21/07/2015, 07:16:22 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<style>
    #wrapper
    {
        background: white;
    }
</style>
<div id="wrapper">
    <section>
        <br/>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a id="nueva-noticia" href="javascript:void(0);" class="btn btn-info">Nueva Noticia</a>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="container">
                    <table id="table"
                           data-toggle="table"
                           data-url="${pageContext.request.contextPath}/editor/noticias/paginacion.json"
                           data-height="500"
                           data-side-pagination="server"
                           data-pagination="true"
                           data-page-list="[5, 10, 15]"
                           data-unique-id="id"
                           data-locale="es-SP"
                           data-search="true">
                        <thead>
                            <tr>
                                <th data-field="posicion">#</th>
                                <th data-field="titulo">Titulo</th>
                                <th data-field="descripcion">Descripcion</th>
                                <th data-field="enlace" data-formatter="showFormatter" data-align="center" >Ver</th>
                                <th data-formatter="modifyFormatter" data-align="center" >Modificar</th>
                                <th data-formatter="deleteFormatter" data-align="center" >Eliminar</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
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
