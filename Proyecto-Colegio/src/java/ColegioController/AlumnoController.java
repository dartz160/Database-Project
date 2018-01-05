
package ColegioController;

import BD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Apoderado;
import model.FichaMedica;
import model.Perfil_A;
import model.Persona;

public class AlumnoController {
    
    private Conexion con;
    private String consulta;
    private String consultaP;
    private ResultSet rs;

    public AlumnoController() throws SQLException, ClassNotFoundException {

        con = new Conexion();
    }

 

    public Persona getPersona(String dni) throws SQLException
    {
        consultaP = "select * from Persona where DNI = " + dni;
        
        Persona P = null;
        rs = con.ejecutarSelect(consultaP);
        
        if(rs.next()){
            P = new Persona();
            
            P.setDni(rs.getString(1));
            P.setNombre(rs.getString(2));
            P.setApellido1(rs.getString(3));
            P.setApellido2(rs.getString(4));
            P.setSexo(rs.getString(5));
            P.setDireccion(rs.getString(6));
            P.setFNacimiento(rs.getString(7));
            P.setTelefono(rs.getString(8));
            P.setEMail(rs.getString(9));
            
            
        }
        con.desconectar();
        rs.close();
        return P;
        
    }
    
    public Apoderado getApoderado(int id) throws SQLException
    {
        String consultaA = "select * from InfoApoderado where Alumno_idAlumno  =" + id;
        Apoderado ap = null;
        
        rs = con.ejecutarSelect(consultaA);
        
        if (rs.next())
        {
            ap = new Apoderado();
            
            ap.setAlumno_idAlumno(rs.getInt(1));
            ap.setNombre(rs.getString(2));
            ap.setApellidoPaterno(rs.getString(3));
            ap.setApellidoMaterno(rs.getString(4));
            ap.setDNI(rs.getString(5));
            ap.setDireccion(rs.getString(6));
            ap.setRelacion(rs.getString(7));
            ap.setNumEmergencia(rs.getString(8));
            ap.setNumEmergencia2(rs.getString(9));
            ap.setAlumno_idAlumno(rs.getInt(10));
         
        }
        con.desconectar();
        rs.close();
        return ap;

    }
    public FichaMedica getFichaMedica(String dni ) throws SQLException{
    
        String consultaFM = "select * from FichaMedica where Persona_DNI ="+dni;
        
        rs = con.ejecutarSelect(consultaFM);
        
        FichaMedica fm = null;
        
        if(rs.next()){
            fm = new FichaMedica();
            fm.setIdFichaMedica(rs.getInt(1));
            fm.setAlergias(rs.getString(2));
            fm.setTipo_Sangre(rs.getString(3));
            fm.setAntecedentes(rs.getString(4));
            fm.setAntecedentes(rs.getString(5));
            fm.setPersona_DNI(rs.getString(6));
            
        }
        con.desconectar();
        rs.close();
        
        return fm;
        
    }
    
    public Perfil_A getPerfilAlumno(int id) throws SQLException{
        
        String consultaPA = "select * from Perfil_A where Alumno_idAlumno =" +id;
        
        rs = con.ejecutarSelect(consultaPA);
        
        Perfil_A pa = null;
        
        if(rs.next()){
            pa = new Perfil_A();
            
            pa.setIdPerfilAlumno(rs.getInt(1));
            pa.setPasaTiempo(rs.getString(2));
            pa.setDeporte(rs.getString(3));
            pa.setIdioma(rs.getString(4));
            pa.setObservacion(rs.getString(5));
            pa.setAlumno_idAlumno(rs.getInt(6));
      
        }
        con.desconectar();
        rs.close();
    
        return pa;
   
    }
    
    public int getID_Alumno(String dni) throws SQLException{
        
        int id = 0;
        
        String consultaID = "select * from Alumno where Persona_DNI =" +dni;
        
        rs = con.ejecutarSelect(consultaID);
        
        if(rs.next()){
            
            id = rs.getInt("idAlumno");
        }
        
        con.desconectar();
        rs.close();
        return id;
    
    }
    
    public int getGrado_Seccion(String Seccion, String Grado,String Nivel) throws SQLException{
        
     int id= 0;
    
    String consultaGra= "select * from Grado_Seccion where Seccion ="+"A"+" and Grado = "+ Grado +" and Nivel = "+Nivel; 
    
    
    System.out.println(consultaGra);
    rs = con.ejecutarSelect(consultaGra);
    if(rs.next()){
            
        id = rs.getInt("idGrado_Seccion");
     } 
    return id;
    
    
    }

    
    
    
    
    
    
}
