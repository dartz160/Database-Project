

<%@page import="model.Apoderado"%>
<%@page import="model.FichaMedica"%>
<%@page import="model.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Veremos la informacion del Alumno  </h1>
        <%
            
            
            if(request.getAttribute("AluPersona")!=null){
                
                
                Persona per = (Persona)request.getAttribute("AluPersona");
              
                                          
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
         

            }
            if(request.getAttribute("FMAlu")!=null)
            {
                FichaMedica fm = (FichaMedica)request.getAttribute("FMAlu");
                
                out.println("Infomacion Medica Alumno" + fm.getPersona_DNI());
                out.println("<hr>");
                out.println("Alergias: "+ fm.getAlergias() );
                out.println("<hr>");
                out.println ("Tipo de Sangre "+" "+fm.getAntecedentes());
                out.println("<hr>");
                out.println ("observaciones : "+" "+fm.getObservacion());
                out.println("<hr>");
            
            }
            if (request.getAttribute("apoderado")!=null){

                if(request.getAttribute("ErrorApo") != null)
                {
                        out.println(request.getAttribute("ErrorApo"));
                }else{
                
                out.println("asdas");
                Apoderado Apo = (Apoderado)request.getAttribute("apoderado");
            
                out.println("Nombre "+Apo.getNombre() );
                out.println("<hr>");
                out.println("Apellido Paterno :" +Apo.getApellidoPaterno());
                out.println("<hr>");
                out.println ("Apellido Materno :"+Apo.getApellidoMaterno());
                out.println("<hr>");
                out.println("DNI " +Apo.getDNI());
                out.println("<hr>");
                out.println("Direccion: " + Apo.getDireccion());
                out.println("<hr>");
                out.println("Relacion " +Apo.getRelacion());
                out.println("<hr>");
                out.println("Numero Emergencia : " +Apo.getNumEmergencia());
                out.println("<hr>");
                out.println("Numero Emergencia2 :" +Apo.getNumEmergencia2());
                out.println("<hr>");
                
                
                }


                
            
            }
        %>
        
        
    </body>
</html>
