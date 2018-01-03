
package OperacionesServlet;

import BD.Conexion;
import ColegioController.EmpleadoController;
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


@WebServlet(name = "AddProfe", urlPatterns = {"/AddProfe"})
public class AddProfe extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        EmpleadoController Empleado = new EmpleadoController();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
       
       try{
            Conexion con = new Conexion("localhost","colegio","root","avefenix");
            String consulta = "insert into Persona(DNI, Nombre, Apellido1, Apellido2, Sexo, Direccion, FNacimiento, Telefono, Correo) values (?,?,?,?,?,?,?,?,?)";
            pst = con.getConexion().prepareStatement(consulta);
            
 
            pst.setString(1,request.getParameter("DNI"));
            pst.setString(2,request.getParameter("nombre"));
            pst.setString(3,request.getParameter("apellido1"));
            pst.setString(4,request.getParameter("apellido2"));
            pst.setString(5,request.getParameter("sexo"));
            pst.setString(6,request.getParameter("direccion"));
            pst.setString(7,request.getParameter("fechaN"));
            pst.setString(8,request.getParameter("telefono"));
            pst.setString(9,request.getParameter("e-mail"));
            pst.execute();
            pst.close();
            
            String consulta2 ="insert into Profesor(Especialidad1,Especialidad2,Blog,Idiomas,Estado,Persona_DNI) VALUES (?,?,?,?,?,?)";
            pst2 = con.getConexion().prepareStatement(consulta2);
            pst2.setString(1,request.getParameter("especialidad"));
            pst2.setString(2,request.getParameter("especialidad2"));
            pst2.setString(3,request.getParameter("blog"));
            pst2.setString(4,request.getParameter("idioma"));
            pst2.setString(5,request.getParameter("estado"));
            pst2.setString(6,request.getParameter("DNI"));
            pst2.execute();
            pst2.close();
            
            request.setAttribute("Confirmacion","Registro del Profesor  se Realizo correctamente");
            request.getRequestDispatcher("Admin/AddProfesor.jsp").forward(request, response);
            
            
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
           request.setAttribute("Existe","La Persona con el DNI: "+" "+request.getParameter("DNI")+" "+"ya se encuentra registrada");
           request.getRequestDispatcher("Admin/AddProfesor.jsp").forward(request, response);
           
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
            Logger.getLogger(AddProfe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddProfe.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddProfe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddProfe.class.getName()).log(Level.SEVERE, null, ex);
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



    