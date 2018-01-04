<%-- 
    Document   : OpcionesInformacionAlum
    Created on : 04-ene-2018, 8:40:45
    Author     : DartzPC-2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             
        <hr/>
        
        <form action="../InformacionAlumnoPersonal">
        <td> <input name = DNI type = hidden value = "<%= request.getParameter("DNI") %>"> </td>
        <td> <button type='submit' >Informacion Personal</button> </td>
        </form>
        
        <form action="../InformacionAlumnoFM">
        <td> <input name = DNI type = hidden value = "<%= request.getParameter("DNI") %>"> </td>
        <td> <button type='submit' >Ficha Medica</button> </td>
        </form>
        
        <form action="../InformacionAlumnoApo">
        <td> <input name = DNI type = hidden value = "<%= request.getParameter("DNI") %>"> </td>
        <td> <button type='submit' >Informacion Apoderado</button> </td>
        </form>
        
    </body>
</html>
