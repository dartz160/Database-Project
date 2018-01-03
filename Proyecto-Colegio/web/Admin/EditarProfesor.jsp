<%-- 
    Document   : EditarProfesor
    Created on : 01/01/2018, 10:59:38 PM
    Author     : Dartz
--%>

<%@page import="ColegioController.EmpleadoController"%>
<%@page import="model.Profesor"%>
<%@page import="model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Informacion del Profesor</h1>
        
        <%
            EmpleadoController emp =  new EmpleadoController();
            Persona per = new Persona();
            Profesor Pro = new Profesor();
            per = (Persona)request.getAttribute("Persona");
            Pro = emp.getProfesor(per.getDni());
        %>
        <form action="EditarDatosProfesor" method="">
            
            <input class="" type="hidden" name ="DNI" value= "<%= per.getDni() %>">
            <label form = "Nombre ">  Nombre </label>
            <input class="" type ="text" name ="nombre" value= "<%= per.getNombre() %>">
            <br>
            <label form = "apellido1">  Apellido Paterno </label>
            <input class="" type ="text" name ="apellido1" value= "<%= per.getApellido1()%>">
            <br>
            <label form = "apellido2">  Apellido Materno:</label>
            <input class="" type ="text" name ="apellido2" value= "<%= per.getApellido2() %>">
            <br>
            <label form = "direccion">  Direccion:</label>
            <input class="" type ="text" name ="direccion" value= "<%= per.getDireccion() %>">
            <br>
            <label form = "telefono">  Telefono:</label>
            <input class="" type ="text" name ="telefono" value= "<%= per.getTelefono() %>">
            <br>
            <label form = "correo">  Correo:</label>
            <input class="" type ="text" name ="correo" value= "<%= per.getEMail() %>">
            <br>
            <label form = "especialidad1 ">  Especialidad: </label>
            <input class="" type ="text" name ="especialidad1" value= "<%= Pro.getEspecialidad()%>">
            <br>
            <label form = "Nombre ">  Especialidad: </label>
            <input class="" type ="especialidad2" name ="especialidad2" value= "<%= Pro.getEspecialidad2()%>">
            <br>
            <label form = "blog">  Blog </label>
            <input class="" type ="text" name ="blog" value= "<%= Pro.getBlog()%>">
            <br>
            <label form = "estado">  Estado </label>
            <input class="" type ="text" name ="estado" value= "<%= Pro.getEstado()%>">
            <br>
            
            <button name="Gurdar" type="submit"> Guarda Cambios</button>
        </form>
        
    </body>
</html>
