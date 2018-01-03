
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
import model.Profesor;


@WebServlet(name = "VerProfesoresServlet", urlPatterns = {"/VerProfesoresServlet"})
public class VerProfesoresServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
            EmpleadoController Profesor = new EmpleadoController();
            PreparedStatement pst = null;
            ResultSet rs;
            
        
        try {
            
            
            List<Profesor> Profesores = new ArrayList();
            

            Conexion con = new Conexion("localhost","colegio","root","avefenix");
           // String consulta = "Select *from Persona INNER JOIN Profesor on Persona.DNI = Profesor.Persona_DNI where DNI=43321455" ;
            String consulta = "select * from Profesor where  Persona_DNI = + '"+request.getParameter("DNI")+"' ";
           
            /*pst = con.getConexion().prepareStatement(consulta);
            
            pst.setString(1,request.getParameter("DNI"));*/
            
            rs = con.ejecutarSelect(consulta);
            
            if(rs.next())
            {
                Profesor n_pro = new Profesor();
                
                n_pro.setId(rs.getInt(1));
                n_pro.setEspecialidad(rs.getString(2));
                n_pro.setEspecialidad2(rs.getString(3));
                n_pro.setBlog(rs.getString(4));
                n_pro.setIdioma(rs.getString(5));
                n_pro.setDni(rs.getString("Persona_DNI"));
                n_pro.setEstado(rs.getString(6));
                
                Profesores.add(n_pro);
                request.setAttribute("lista", Profesores);
                request.getRequestDispatcher("Admin/ListarProfesores.jsp").forward(request, response);
                //pst.close();
            }
            else{
            
                request.setAttribute("NoEncontro", "No se encontro al usuario verifique los datos de busqueda");
                request.getRequestDispatcher("ProfesorController").forward(request, response);
            }
            
            
           
            con.getConexion().close();

        } catch (SQLException ex) {
            System.out.println("error" + ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(VerProfesoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerProfesoresServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(VerProfesoresServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerProfesoresServlet.class.getName()).log(Level.SEVERE, null, ex);
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
