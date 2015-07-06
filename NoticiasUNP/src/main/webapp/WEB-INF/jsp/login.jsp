<%-- 
    Document   : login
    Created on : 05/07/2015, 07:41:20 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="j_spring_security_check" method="POST">
            <input type="text" placeholder="Email" name="j_username" /><br>
            <input type="password" placeholder="Password" name="j_password" /><br>
            <input type="submit" value="Ingresar"/>
    </body>
</html>
