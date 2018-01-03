<%-- 
    Document   : Admin
    Created on : 24/12/2017, 12:25:32 PM
    Author     : Dartz
--%>
<%@page import="model.Persona"%>
<%@page import="model.Privilegio"%>
<%@page import="model.Usuario"%>
<%@page import="BD.Data"%>
<%--
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:if test="${sessionScope['user']!=null}">
      <% response.sendRedirect("index.jsp");%>
</t:if>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <%
            Data d = new Data();
            
            Usuario us = (Usuario)session.getAttribute("user");
            
            if(us == null){
            
                response.sendRedirect("Error.jsp");
            }
            else{
                Persona P = d.getPersona(us.getDni());
                out.println("<h1>");
                out.println("Bienvenido Administrador  " + P.getNombre() );
                out.println();
                out.println("</h1>");
                
                
                                    
                        /*out.println("Bienvenido Seor/a "+ us.getLogin());
                        out.println("<hr>");
                        out.println("DNI: "+us.getDni());
                        out.println("<br/>");
                        out.println("Privilegio: "+ us.getPrivilegio());
                        out.println("<hr>");
                        
                        Privilegio p = d.getPrivilegio(us.getPrivilegio());
                        
                        out.println("Privilegio: " + p.getDescripcion());
                        out.println("<hr>");    */ 
              
                      /*Persona P = d.getPersona(us.getDni());
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
                      out.println("<hr>");*/
            
            }
            
            
       %>
        <hr/>
        <a href ="AdmiAlumno.jsp"> Administrar Alumnos  </a>  &nbsp &nbsp &nbsp &nbsp;
        
        <a href ="VerProfesores.jsp"> Administrar Profesores </a> &nbsp &nbsp &nbsp &nbsp;
        
        <a href =""> Administrar Informacion </a> &nbsp &nbsp &nbsp &nbsp;
        
        <a href ="../CerrarSesion"> Cerrar Sesion </a> &nbsp &nbsp &nbsp &nbsp;
        
        
    
</html>
