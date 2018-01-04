<%-- 
    Document   : ListarAlumnos
    Created on : 02/01/2018, 01:27:31 PM
    Author     : Dartz
--%>

<%@page import="model.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ColegioController.EmpleadoController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alumnos Matriculados</h1>
        
        
        
        
        <form action = "" method="">
            <input type="text" name="DNI" placeholder="DNI" />  
            <input type ="submit" name="btnIniciar" value="Buscar"/>

        </form> 

       <%
            EmpleadoController n_alumno = new EmpleadoController();

            List<Persona> Alumnos = new ArrayList();
            Persona u;
            Alumnos = (ArrayList)request.getAttribute("Lista");
            
                out.println("<table border='1'>");
                    out.println("<tr>");
                        out.println("<td>DNI</td>");
                        out.println("<td>Nombre completo</td>");
                        out.println("<td>estado</td>");
                        out.println("<td>  </td>");
                        out.println("<td>  </td>");
                        
                    out.println("</tr>");
            for(Persona w:Alumnos){
                    out.println("<tr>");
                    
                        out.println("<form action ='InfoProfesor'>");
                        out.println("<td>"+w.getDni()+"</td>");
                        out.println("<td>"+w.getNombre()+" "+w.getApellido1()+" "+w.getApellido2()+"</td>");
                        out.println("<td> <input name = DNI type = hidden value = '"+w.getDni()+"'> </td>");
                        out.println("<td> <button type='submit' > Ver</button> </td>");
                        out.println("</form>");
                        out.println("<form action = 'EditarPersona'>");
                        out.println("<td> <input name = DNI2 type = hidden value = '"+w.getDni()+"'> </td>");
                        out.println("<td> <button type='submit' > Editar</button> </td>");
                    out.println("</form>");
                        
                    out.println("</tr>");
                 
            
            
            
            
            
            
            }
            

            

            

            
            


       
       
       
       %>


        
    </body>
</html>
