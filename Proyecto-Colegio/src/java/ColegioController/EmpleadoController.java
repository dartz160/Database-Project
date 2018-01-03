
package ColegioController;

import BD.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Persona;
import model.Profesor;

public class EmpleadoController {
    
    private Conexion con;
    private String consulta;
    private String consultaP;
    private ResultSet rs;
    public EmpleadoController() throws SQLException, ClassNotFoundException {
        
        con = new Conexion("localhost","colegio","root","avefenix");
    }
    
    
    public List<Profesor> ListarProfesor() throws SQLException
    {
        List<Profesor> lista = new ArrayList<>();
        consulta = "Select *from Persona INNER JOIN Profesor on Persona.DNI =Profesor.Persona_DNI  ";
        
   
        rs = con.ejecutarSelect(consulta);
        
        while(rs.next())
        {
            Profesor n_pro = new Profesor();
            
            n_pro.setId(rs.getInt(10));
            n_pro.setEspecialidad(rs.getString(11));
            n_pro.setEspecialidad2(rs.getString(12));
            n_pro.setBlog(rs.getString(13));
            n_pro.setIdioma(rs.getString(14));
            n_pro.setDni(rs.getString("Persona_DNI"));
            n_pro.setEstado(rs.getString(15));
            
            lista.add(n_pro);
        }
        
        con.desconectar();
        rs.close();    
        return  lista;

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
    
    public Profesor getProfesor(String dni) throws SQLException
    {   
        String consultaPro = "select * from Profesor where Persona_DNI =" +dni;
        rs = con.ejecutarSelect(consultaPro);
        
        Profesor pr = null;
        
        if(rs.next()){
        
            pr= new Profesor();
            pr.setId(rs.getInt(1));
            pr.setEspecialidad(rs.getString(2));
            pr.setEspecialidad2(rs.getString(3));
            pr.setBlog(rs.getString(4));
            pr.setIdioma(rs.getString(5));
            pr.setDni(rs.getString(7));
            pr.setEstado(rs.getString(6));
        }
        
        con.desconectar();
        rs.close();
        
        return pr;
        
    }
    
    public boolean ExitenciaPersona (String DNI) throws SQLException{
    
    String  consultaEx = "select DNI from Persona where DNI ="+DNI;
    
    rs = con.ejecutarSelect(consultaEx);
    boolean Existe = false;
    
    if(rs.getRow()==0)
    {
        return Existe;
    }
    Existe = true;
    return Existe ;
    
    }
   
   
}
