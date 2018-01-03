
package BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Persona;
import model.Privilegio;
import model.Usuario;


public class Data {

    private Conexion con;
    private ResultSet rs;
    private String consulta;
    private String consultaP;
    
    public Data() throws SQLException, ClassNotFoundException
    {
        con = new Conexion("localhost","colegio","root","avefenix");
        
    }
    
    public Usuario getUsuario(String rut, String pass) throws SQLException
    {
        /*si el usuario no se encuentra retorna null
          si el usuario se encuentra me entrega un objeto usuario
        */
        
        consulta = "Select * from usuario "+"where Login = '"+rut+"' and Password = '"+pass+"';";
        
        rs = con.ejecutarSelect(consulta);
        
        Usuario u = null;
        
        if(rs.next())
        {
            u = new Usuario();
            
            
            u.setId(rs.getInt(1));
            u.setLogin(rs.getString(2));
            /*u.setPassword(rs.getString(3));*/
            
            u.setDni(rs.getString(5));
            u.setPrivilegio(rs.getInt(6));
        }    
        con.desconectar();
        
        return u;
        
    }
    
    public Privilegio getPrivilegio(int id ) throws SQLException
    {
        consulta = "select * from tipo_usuario where idTipoUsuario = " +id;
        Privilegio p = null;
        rs = con.ejecutarSelect(consulta);
        if(rs.next()){
            p = new Privilegio();
            
            p.setId(id);
            p.setDescripcion(rs.getString(2));
        }
        con.desconectar();
        rs.close();
        return p;
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
    
}
