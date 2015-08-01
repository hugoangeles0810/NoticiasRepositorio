<%-- 
    Document   : footer
    Created on : 04/07/2015, 05:07:29 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer id="footer" class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3  col-md-3 col-sm-5 col-xs-6">
                <h3> Equipo de desarrollo </h3>
                <ul>
                    <li> <a href="#"> Carlos Adrianzen Adanaque </a> </li>
                    <li> <a href="#"> Hugo Angeles Chavez </a> </li>
                    <li> <a href="#"> Roberto Correa Mantilla </a> </li>
                </ul>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 text-center">
                <h3> &copy; Noticias UNP 2015 </h3>
                <h5>Todos los derechos reservados</h5>
            </div>
            <div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 ">
                <h3> Suscribete </h3>
                <ul>
                    <li>
                        <div class="input-append newsletter-box text-center">
                            <input type="text" class="full text-center" placeholder="Email ">
                            <button class="btn bg-gray" type="button"> Registrar <i class="fa fa-long-arrow-right"> </i> </button>
                        </div>
                    </li>
                </ul>
                <ul class="social">
                    <li> <a href="#"> <i class=" fa fa-facebook">   </i> </a> </li>
                    <li> <a href="#"> <i class="fa fa-twitter">   </i> </a> </li>
                    <li> <a href="#"> <i class="fa fa-google-plus">   </i> </a> </li>
                    <li> <a href="#"> <i class="fa fa-pinterest">   </i> </a> </li>
                    <li> <a href="#"> <i class="fa fa-youtube">   </i> </a> </li>
                </ul>
            </div>
        </div>
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

