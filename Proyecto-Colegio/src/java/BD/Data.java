
package BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Privilegio;
import model.Usuario;


public class Data {

    private Conexion con;
    private ResultSet rs;
    private String consulta;
    
    public Data() throws SQLException, ClassNotFoundException
    {
        con = new Conexion("localhost","bd_colegio","root","avefenix");
        
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
            
            u.setDni(rs.getString(4));
            u.setPrivilegio(rs.getInt(5));

        }
        
        con.desconectar();
        
        return u;
        
        

    }
    
    
    public Privilegio getPrivilegio(int id ) throws SQLException
    {
        consulta = "select * from tipo_usuario where id = " +id;
        
        Privilegio p = null;
        
        rs = con.ejecutarSelect(consulta);
        
        if(rs.next()){
            p = new Privilegio();
            
            p.setId(id);
            p.setDescripcion(rs.getString(2));
        
        
        }
        
        con.desconectar();
        return p;
    
    
    
    
    }
    
}
