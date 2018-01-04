
package Controller;

import BD.Conexion;
import ColegioController.EmpleadoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Persona;


@WebServlet(name = "BusquedaAlumnoServlet", urlPatterns = {"/BusquedaAlumnoServlet"})
public class BusquedaAlumnoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
            //EmpleadoController Profesor = new EmpleadoController();
            //PreparedStatement pst = null;
            ResultSet rs;
        
        
        try{
            
            
            List<Persona> L_alumnos = new ArrayList(); 
            Conexion con = new Conexion();
            
            String consulta = "Select *from Persona INNER JOIN Alumno on Persona.DNI = Alumno.Persona_DNI where Persona_DNI = '"+request.getParameter("DNI")+"'";
            System.out.println(consulta);
            rs = con.ejecutarSelect(consulta);
            
            if (rs.next()){
                
                Persona P = new Persona();

                P.setDni(rs.getString(1));
                P.setNombre(rs.getString(2));
                P.setApellido1(rs.getString(3));
                P.setApellido2(rs.getString(4));
                P.setSexo(rs.getString(5));
                P.setDireccion(rs.getString(6));
                P.setFNacimiento(rs.getString(7));
                P.setTelefono(rs.getString(8));
                P.setEMail(rs.getString(9));
                
                L_alumnos.add(P);
                
                request.setAttribute("lista", L_alumnos);
                request.getRequestDispatcher("Admin/ListarAlumnos.jsp").forward(request, response);
           
            }else{
            
                request.setAttribute("NoEncontro", "No se encontro al usuario verifique los datos de busqueda");
                request.getRequestDispatcher("AlumnoControllerServlet").forward(request, response);
            
            }
            
            con.getConexion().close();
        
        
        }catch(SQLException m){ 
        
                    System.out.println("error" + m);
        
        
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BusquedaAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BusquedaAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
