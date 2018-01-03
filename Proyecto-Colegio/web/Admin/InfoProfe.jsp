<%-- 
    Document   : InfoProfe
    Created on : 28/12/2017, 12:48:51 PM
    Author     : Dartz
--%>

<%@page import="model.Profesor"%>
<%@page import="model.Persona"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>veremos la informacion del profesor </h1>
        
        <%
            Usuario us = (Usuario)session.getAttribute("user");
            
            if(us == null){
            
                response.sendRedirect("Error.jsp");
            }else{
            
                Persona per = (Persona)request.getAttribute("InfoPersonal");
                Profesor pro = (Profesor)request.getAttribute("InfoProfesor");
                                          
                out.println("Bienvenido " + per.getNombre());
                out.println("<hr>");
                out.println("DNI: " + per.getDni());
                out.println("<hr>");
                out.println ("Nombre: "+" "+per.getNombre()+" "+per.getApellido1()+" "+per.getApellido2());
                out.println("<hr>");
                out.println("Sexo: " + per.getSexo());
                out.println("<hr>");
                out.println("Direccion: " + per.getDireccion());
                out.println("<hr>");
                out.println("Fecha: " + per.getFNacimiento());
                out.println("<hr>");
                out.println("Telefono: " + per.getTelefono());
                out.println("<hr>");
                out.println("E-Mail:" +per.getEMail());
                out.println("<hr>");
                out.println("Id: " +pro.getId());
                out.println("<hr>");
                out.println("Especialidad 1 : " +pro.getEspecialidad());
                out.println("<hr>");
                out.println("Especialidad 2 :" + pro.getEspecialidad2());
                out.println("<hr>");
                out.println("Blog :" + pro.getBlog());
                out.println("<hr>");
                out.println("Idioma :" + pro.getIdioma());
                out.println("<hr>");
                out.println("Estado :" + pro.getEstado());
                out.println("<hr>");
                
                
                
                
                
            
            
            }
        
        
        
        %>
    </body>
</html>
