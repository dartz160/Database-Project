<%-- 
    Document   : AddAlumno
    Created on : 04-ene-2018, 19:21:26
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
        <h1>Agregar Alumno</h1>
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
        
        <form action="../AddAlumnoServlet">
            
                <label>Datos Personales Alumno</label>
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
                <label form="seccion">Seccion</label>
                <select name="seccion" id="">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option valur="C">C</option>
		</select>
                <br>  
                <br> 
                <label form="nivel">Nivel</label>
                <select name="nivel" id="">
                    <option value="Primaria">Primaria</option>
                    <option value="Secundaria">Secundaria</option>		
		</select>
                <br>  
                <br>  
                <label form="Grado">Grado</label>
                <select name="Grado" id="">
                    <option value="Primero">Primero</option>
                    <option value="Segundo">Segundo</option>
                    <option value="Tercero">Tercero</option>
                    <option value="Cuarto">Cuarto</option>
                    <option value="Quinto">Quinto</option>
                    <option value="Sexto">Sexto</option>
		</select>
                <br> 
                <label form="año">Año</label>
		<input class="" type="text" name="año" maxlength="40" placeholder="" >
                <br>
                 <label form="aula">Aula</label>
		<input class="" type="number" name="aula" maxlength="40" placeholder="" >
                <br>
                
		<button class="boton" type="submit" >Guardar</button>

	</form>        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
