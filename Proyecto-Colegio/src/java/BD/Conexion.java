
package BD;
import java.sql.*;

//Clase Conexion : establecer la conexion entre la base de datos y la pagina
public class Conexion {
    private Connection  con;   // Lo usamos parra establecer la conexion
    private Statement  Sen;  // Ejecutar la consulta 
    private ResultSet rs; //Recorrer los resultados (Tabla) guarda el resultado de la consulta 

    public Conexion(String server, String bd, String user, String pass) throws SQLException, ClassNotFoundException {
        String protocolo ="jdbc:mysql://";
        String lineaUser = "user="+user;
        String lineaPass = "password="+pass;
        
        
        
        String url = protocolo+server+"/"+bd+"?"+lineaUser+"&"+lineaPass;
        
        System.out.println(url);
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url);

    }
    
    public void ejecutar(String consulta) throws SQLException{
    
        Sen = con.createStatement();
        Sen.executeUpdate(consulta);
    
    }
    
    public ResultSet ejecutarSelect(String consulta) throws SQLException{
    
        Sen = con.createStatement();
        rs = Sen.executeQuery(consulta);
        return rs;
    }
    
    public void desconectar() throws SQLException{
    
        Sen.close();
        
    }
    
    
}
