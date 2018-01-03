<%-- 
    Document   : AddProfesor
    Created on : 28/12/2017, 03:00:29 PM
    Author     : Dartz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario de Registro de Profesor</h1>
        <%
        if(request.getAttribute("Confirmacion") != null)
        {
            %>
            <b><%=request.getAttribute("Confirmacion")%></b>
            <%
        }
        if(request.getAttribute("Existe") != null)
        {
            %>
            <b><%=request.getAttribute("Existe")%></b>
            <%
        }
        
        %>
        <form action="../AddProfe">
            
                <label>Datos Personales</label>
                <br>
                <br>
		<label form="DNI">DNI:</label>
		<input class="" type="text" name="DNI" maxlength="8" placeholder="DNI">
                </br>
                <label form="nombre">Nombre</label>
		<input class="" type="text" name="nombre" maxlength="12" placeholder="">
                </br>
                <label form="apellido1">Apellido1</label>
		<input class="" type="text" name="apellido1" maxlength="12" placeholder="">
                <label form="apellido2">Apellido2</label>
		<input class="" type="text" name="apellido2" maxlength="8" placeholder="">
                <br>
                <label form="sexo">Sexo</label>
                <select name="sexo" id="">
                    <option value="F">F</option>
                    <option value="M">M</option>		
		</select>
                <br>
                <label form="direccion">Direccion</label>
		<input class="" type="text" name="direccion" maxlength="30" placeholder="">
                <br>
                <label form="fechaN">Fecha Nacimiento</label>
		<input class="" type="date" name="fechaN" maxlength="" placeholder="" >
                <br>
		<label form="telefono">Telefono</label>
		<input class="" type="text" name="telefono" maxlength="9" placeholder="">
                <br>
                <label form="e-mail">E-Mail</label>
		<input class="" type="e-mail" name="e-mail" maxlength="40" placeholder="" >
                <br>
                <br>
                <label>Datos Academicos</label>
                <br>
                <br>
                <label form="especialidad">Especialidad</label>
		<input class="" type="text" name="especialidad" maxlength="20" placeholder="" >
                <br>
                <label form="especialidad2">Especialidad2</label>
		<input class="" type="text" name="especialidad2" maxlength="20" placeholder="" >
                <br>
                <label form="blog">Blog</label>
		<input class="" type="text" name="blog" maxlength="20" placeholder="" >
                <br>
                <label form="idioma">Idioma</label>
		<input class="" type="text" name="idioma" maxlength="10" placeholder="" >
                <br>
                <label form="estado">Estado</label>
		<input class="" type="text" name="estado" maxlength="20" placeholder="" >
                <br>
                
		<button class="boton" type="submit" >Guardar</button>

	</form>
        <hr/>
            <a href ="../ProfesorController">Listar todos los profesores </a>
        <hr/>

    </body>
</html>
