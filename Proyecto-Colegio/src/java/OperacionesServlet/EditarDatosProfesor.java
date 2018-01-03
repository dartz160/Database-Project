
package OperacionesServlet;

import BD.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditarDatosProfesor", urlPatterns = {"/EditarDatosProfesor"})
public class EditarDatosProfesor extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

         PreparedStatement pst = null;
        
        
       try{
           Conexion con = new Conexion("localhost","colegio","root","avefenix");
           String Consulta = "update Persona set Nombre=?, Apellido1=?, Apellido2=?, Direccion=?, Telefono=?,Correo =? where DNI =?";
           
           pst = con.getConexion().prepareStatement(Consulta);
           
           
           pst.setString(1,request.getParameter("nombre"));
           pst.setString(2,request.getParameter("apellido1"));
           pst.setString(3,request.getParameter("apellido2"));
           pst.setString(4,request.getParameter("direccion"));
           pst.setString(5,request.getParameter("telefono"));
           pst.setString(6,request.getParameter("correo"));
           pst.setString(7,request.getParameter("DNI"));

           pst.execute();
           pst.close();

           String Consulta2 = "update Profesor set ";
           
           con.getConexion().close();
           
            
        
        }catch(SQLException e){
        
            System.out.println("Erro -->" +e.getMessage());
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
            Logger.getLogger(EditarDatosProfesor.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditarDatosProfesor.class.getName()).log(Level.SEVERE, null, ex);
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
