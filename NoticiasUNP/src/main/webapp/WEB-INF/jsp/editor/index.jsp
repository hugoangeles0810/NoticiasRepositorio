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
        <link rel="icon" type="image/png" href="resources/img/favicon.png" />
        <link rel="stylesheet" href="../resources/libs/css/bootstrap.min.css" />
        <link rel="stylesheet" href="../resources/css/estilos.css" />
    </head>
    <body>
        <form action="guardar-noticia.html" method="POST" enctype="multipart/form-data" class="form-horizontal">
            <div class="form-group">
                <label for="titulo" class="col-sm-2 control-label">Titulo</label>
                <div class="col-sm-4">
                    <input type="text" name="titulo" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="descripcion" class="col-sm-2 control-label">Descripcion</label>
                <div class="col-sm-4">
                    <textarea id="descripcion" name="descripcion" cols="58" rows="3"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="contenido" class="col-sm-2 control-label">Contenido</label>
                <div class="col-sm-4">
                    <textarea id="contenido" name="contenido" cols="58" rows="10"></textarea>  
                </div>
            </div>
            <div class="form-group">
                <label for="categoria" class="col-sm-2 control-label">Categoria</label>
                <div class="col-sm-4">
                    <select multiple name="categoria" class="form-control">
                        <c:forEach var="categoria" items="${categorias}">
                            <c:if test="${categoria.id != 7}">
                                <option value="${categoria.id}">${categoria.nombre}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="enlace" class="col-sm-2 control-label">Enlace</label>
                <div class="col-sm-4">
                    <input id="enlace" type="text" name="enlace" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="bannerSmall" class="col-sm-2 control-label">Banner small</label>
                <div class="col-sm-4">
                    <input id="bannerSmall" type="file" name="bannerSmall" />
                </div>
            </div>
            <div class="form-group">
                <label for="bannerLarge" class="col-sm-2 control-label">Banner Larger</label>
                <div class="col-sm-4">
                    <input id="bannerLarge" type="file" name="bannerLarge" />
                </div>
            </div>
            <div class="col-sm-offset-3">
                <br/>
                <input type="reset" value="Limpiar" class="btn btn-default" />&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Guardar" class="btn btn-primary" />
            </div>
        </form>
        <script src="../resources/libs/js/jquery.min.js"></script>
        <script src="../resources/libs/js/jquery.jsonify.min.js"></script>
        <script src="../resources/libs/js/bootstrap.min.js"></script>
        <script src="../resources/js/main.js"></script>
    </body>
</html>
