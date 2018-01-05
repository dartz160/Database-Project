
package OperacionesServlet;

import BD.Conexion;
import ColegioController.AlumnoController;
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

@WebServlet(name = "AddAlumnoServlet", urlPatterns = {"/AddAlumnoServlet"})
public class AddAlumnoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        AlumnoController alu =new AlumnoController();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;
        
        
        try{
            Conexion con = new Conexion();
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
        
            String consulta2 ="insert into Alumno(Persona_DNI,Estado) VALUES (?,?)";
            pst2 = con.getConexion().prepareStatement(consulta2);
            pst2.setString(1,request.getParameter("DNI"));
            pst2.setString(2,"Activo");

            pst2.execute();
            pst2.close();   
            
           /* int id = alu.getID_Alumno(request.getParameter("DNI"));
            
            int idGrado_Seccion = alu.getGrado_Seccion(request.getParameter("seccion"),request.getParameter("Grado"),request.getParameter("nivel"));
            String consulta3 ="insert into Cargo_Alumnos(Año,Aula_idAula,Grado_Seccion_idGrado_Seccion,Alumno_idAlumno) VALUES (?,?,?,?)";
        
            System.out.println(consulta3);
            pst3 = con.getConexion().prepareStatement(consulta3);
            pst3.setString(1,request.getParameter("año"));
            pst3.setString(2,request.getParameter("aula"));
            pst3.setInt(3,idGrado_Seccion);
            pst3.setInt(4,id);*/
        
            request.setAttribute("Confirmacion","Registro del Alumno  se Realizo correctamente");
            request.getRequestDispatcher("Admin/AddAlumno.jsp").forward(request, response);
            
        
        
        
        
        
        }catch(SQLException e){
        
           System.out.println(e.getMessage());
           request.setAttribute("Existe","La Persona con el DNI: "+" "+request.getParameter("DNI")+" "+"ya se encuentra registrada");
           request.getRequestDispatcher("Admin/AddAlumno.jsp").forward(request, response);
           
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
            Logger.getLogger(AddAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
