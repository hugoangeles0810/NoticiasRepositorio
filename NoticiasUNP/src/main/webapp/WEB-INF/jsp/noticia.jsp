<%-- 
    Document   : noticia
    Created on : 12/07/2015, 09:20:43 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Noticia</title>
    </head>
    <body>
        <img src="${DIR_IMAGE}${noticia.bannerLarge}" />
        <h1>${noticia.titulo}</h1>
        <p>${noticia.descripcion}</p>
        <br />
        <p>${noticia.contenido}</p>
    </body>
</html>
