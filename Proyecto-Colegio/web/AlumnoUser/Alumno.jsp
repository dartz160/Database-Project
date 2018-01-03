<%-- 
    Document   : Alumno
    Created on : 01/01/2018, 01:21:29 PM
    Author     : Dartz
--%>

<%@page import="BD.Data"%>
<%@page import="model.Usuario"%>
<%@page import="model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu Alumno</h1>
        <%
            Data d = new Data();
            
            Usuario us = (Usuario)session.getAttribute("user");
            
            if(us == null){
            
                response.sendRedirect("Error.jsp");
            }
            else{
             
                      Persona P = d.getPersona(us.getDni());
                      out.println("Bienvenido " + P.getNombre());
                      out.println("<hr>");
                      out.println("DNI: " + P.getDni());
                      out.println("<hr>");
                      out.println ("Nombre: "+" "+P.getNombre()+" "+P.getApellido1()+" "+P.getApellido2());
                      out.println("<hr>");
                      out.println("Sexo: " + P.getSexo());
                      out.println("<hr>");
                      out.println("Direccion: " + P.getDireccion());
                      out.println("<hr>");
                      out.println("Fecha: " + P.getFNacimiento());
                      out.println("<hr>");
                      out.println("Telefono: " + P.getTelefono());
                      out.println("<hr>");
                      out.println("E-Mail:" +P.getEMail());
                      out.println("<hr>");
                      
                      
            
            
            }
            
            
       %>
    </body>
</html>
