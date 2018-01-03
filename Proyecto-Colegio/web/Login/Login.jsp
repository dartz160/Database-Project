<%-- 
    Document   : Login
    Created on : 24/12/2017, 12:24:31 PM
    Author     : Dartz


    Pagina de Distribucion del login
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
    HttpSession sesion = request.getSession(true);
    sesion.invalidate();

--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Iniciar Sesion</h1>
        <form action = "../IniciarSesionServlet" method="post">
            <input type="text" name="user" placeholder="Rut:" />
            <input type="password" name="pass" placeholder="Pass:"/>
            
            <input type ="submit" name="btnIniciar" value="Iniciar Sesion"/>

        </form>
        
        
        
    </body>
</html>
