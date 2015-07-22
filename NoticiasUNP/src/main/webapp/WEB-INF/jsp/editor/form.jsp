<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 10/07/2015, 12:02:41 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editor</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css" />
    </head>
    <body>
        <br/>
        <div class="container-fluid">
            <div class="row">
                <div>
                    <div class="row">
                        <div class="col-sm-offset-1 col-sm-7">
                            <div id="alert-error" class="alert alert-danger alert-dismissible" role="alert" style="display: none;">
                                <div id="error-msg"></div>
                            </div>  
                        </div>
                    </div>
                    <form id="form-noticia" action="${pageContext.request.contextPath}/editor/guardar-noticia.html" method="POST" enctype="multipart/form-data" class="form-horizontal">
                        <div class="form-group">
                            <label for="titulo" class="col-sm-2 control-label">Titulo</label>
                            <div class="col-sm-6">
                                <input type="text" name="titulo" class="form-control" required autofocus/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="descripcion" class="col-sm-2 control-label">Descripcion</label>
                            <div class="col-sm-4">
                                <textarea id="descripcion" name="descripcion" cols="55" rows="3" required ></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contenido" class="col-sm-2 control-label">Contenido</label>
                            <div class="col-sm-4">
                                <textarea id="contenido" name="contenido" cols="55" rows="10" required ></textarea>  
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categoria" class="col-sm-2 control-label">Categoria</label>
                            <div class="col-sm-4">
                                <select multiple name="categoria" class="form-control" required>
                                    <c:forEach var="categoria" items="${categorias}">
                                        <c:if test="${categoria.id != 7}">
                                            <option value="${categoria.id}">${categoria.nombre}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="enlace" class="col-sm-2 control-label">Enlace</label>
                            <div class="col-sm-6">
                                <input id="enlace" type="text" name="enlace" class="form-control" required />
                                <span class="glyphicon form-control-feedback"><img id="mini-loader" src="${pageContext.request.contextPath}/resources/img/mini-loader.gif" class="mini-loader" style="display: none;" /></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bannerSmall" class="col-sm-2 control-label">Banner small</label>
                            <div class="col-sm-4">
                                <input id="bannerSmall" type="file" name="bannerSmall" required />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bannerLarge" class="col-sm-2 control-label">Banner Large</label>
                            <div class="col-sm-4">
                                <input id="bannerLarge" type="file" name="bannerLarge" required />
                            </div>
                        </div>
                        <div class="col-sm-offset-4">
                            <br/>
                            <input type="reset" value="Limpiar" class="btn btn-default" />&nbsp;&nbsp;&nbsp;
                            <input type="submit" value="Guardar" class="btn btn-primary" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/resources/libs/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/libs/js/jquery.jsonify.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/libs/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/editor.js"></script>
    </body>
</html>
