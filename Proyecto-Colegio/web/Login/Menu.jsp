<%-- 
    Document   : Menu
    Created on : 24/12/2017, 12:48:02 PM
    Author     : Dartz
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Menu Principal</h1>
        
        <%
               Usuario u = (Usuario)session.getAttribute("user");
              

             
        %>
    </body>
</html>
