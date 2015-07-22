<%-- 
    Document   : footer
    Created on : 04/07/2015, 05:07:29 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer id="footer">
    <div class="text-center">
        <p>Noticias UNP</p>
        <p>&copy; 2015 Todos los derechos reservados</p>
    </div>
</footer>

<script src="${pageContext.request.contextPath}/resources/libs/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/js/jquery.jsonify.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script>
    var enlace = '${enlace_categoria}';
    $("#" + enlace).addClass('active');
</script>

