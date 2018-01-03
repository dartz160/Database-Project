<%-- 
    Document   : Menu
    Created on : 24/12/2017, 12:48:02 PM
    Author     : Dartz
--%>

<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Privilegio"%>
<%@page import="BD.Data"%>
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

               Data d = new Data();
               Usuario u = (Usuario)session.getAttribute("user");
               
               if(u==null){
                   response.sendRedirect("Error.jsp");
               }
               
               else{
               
                        out.println("Bienvenido Señor/a "+ u.getLogin());
                        out.println("<hr>");
                        out.println("DNI: "+u.getDni());
                        out.println("<br/>");
                        out.println("Privilegio: "+ u.getPrivilegio());
                        out.println("<hr>");
               
                        Privilegio p = d.getPrivilegio(u.getPrivilegio());
               
                        out.println("Privilegio: " + p.getDescripcion());
                        out.println("<hr>");

               }
               
               
               
        %>
        <hr/>
        <a href ="../CerrarSesion"> Cerrar Sesion </a>
    </body>
</html>
