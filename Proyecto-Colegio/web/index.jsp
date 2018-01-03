

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--
    HttpSession sesion = request.getSession(true);
    sesion.invalidate();;

--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de Incio</h1>
        
   
        
        <form action = "Login/Login.jsp" method="post">
            <input type ="submit" name="Login" value="Iniciar Sesion"/>
        </form>
    </body>
</html>
