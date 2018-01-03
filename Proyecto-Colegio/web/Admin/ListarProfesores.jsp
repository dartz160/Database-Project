<%-- 
    Document   : ListarProfesores
    Created on : 28/12/2017, 07:45:38 AM
    Author     : Dartz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Persona"%>
<%@page import="java.util.List"%>
<%@page import="model.Profesor"%>
<%@page import="ColegioController.EmpleadoController"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Veremos la Lista de Profesores que trabajan</h1>
        
        <%
        if(request.getAttribute("MsnError") != null)
        {
            %>
            <b><%=request.getAttribute("MsnError")%></b>
            <%
        }

        
        %>
        
        
        <form action = "VerProfesoresServlet" method="">
            <input type="text" name="DNI" placeholder="DNI" />  
            <input type ="submit" name="btnIniciar" value="Buscar"/>

        </form> 
        
        <%
        
            Usuario us = (Usuario)session.getAttribute("user");
            
            if(us == null){
            
                response.sendRedirect("Error.jsp");
            }
            else{
                
                EmpleadoController n_prosor = new EmpleadoController();
                
                List<Profesor> Profesores = new ArrayList();
                        
                Profesores = (ArrayList)request.getAttribute("lista");
                Persona u ;
                out.println("<table border='1'>");
                    out.println("<tr>");
                        out.println("<td>DNI</td>");
                        out.println("<td>Nombre completo</td>");
                        out.println("<td>Especialidad</td>");
                        out.println("<td>Correo</td>");
                        out.println("<td>Telefono</td>");
                        out.println("<td>estado</td>");
                        out.println("<td>  </td>");
                        out.println("<td>  </td>");
                        
                    out.println("</tr>");

                for(Profesor w:Profesores){
                    
                    u = n_prosor.getPersona(w.getDni());
                    
                    
                    
                    out.println("<tr>");
                    
                        out.println("<form action ='InfoProfesor'>");
                        out.println("<td>"+w.getDni()+"</td>");
                        out.println("<td>"+u.getNombre()+" "+u.getApellido1()+" "+u.getApellido2()+"</td>");
                        out.println("<td>"+w.getEspecialidad()+"</td>");
                        out.println("<td>"+u.getEMail()+"</td>");
                        out.println("<td>"+u.getTelefono()+"</td>");
                        
                        out.println("<td>"+w.getEstado()+"</td>");
                        
                        out.println("<td> <input name = DNI type = hidden value = '"+w.getDni()+"'> </td>");
                        out.println("<td> <button type='submit' > Ver</button> </td>");
                    out.println("</form>");
                    out.println("<form action = 'EditarPersona'>");
                        out.println("<td> <input name = DNI2 type = hidden value = '"+w.getDni()+"'> </td>");
                        out.println("<td> <button type='submit' > Editar</button> </td>");
                    out.println("</form>");
                        
                    out.println("</tr>");
                    
                
        
                    u=null;
                }
                
                
            
            
            
            }
        
        
        %>
        
        
    </body>
</html>
