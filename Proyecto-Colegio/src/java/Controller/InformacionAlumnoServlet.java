
package Controller;

import ColegioController.AlumnoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Apoderado;
import model.FichaMedica;
import model.Perfil_A;
import model.Persona;


@WebServlet(name = "InformacionAlumnoServlet", urlPatterns = {"/InformacionAlumnoPersonal","/InformacionAlumnoFM","/InformacionAlumnoApo"})
public class InformacionAlumnoServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        switch (request.getServletPath()){
            
            case "/InformacionAlumnoPersonal" :
                
                InfoAlumnoP(request,response);
                
                break;
            case "/InformacionAlumnoFM" :
                FichaMedicaAlu(request,response);
                
                break;
            case "/InformacionAlumnoApo" :
                Apoderado(request, response);
                break;
      
        
        
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
            Logger.getLogger(InformacionAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InformacionAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InformacionAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InformacionAlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    private void InfoAlumnoP(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException{

        String dni = request.getParameter("DNI");
        AlumnoController InfoAlu = new AlumnoController();
        
        Persona alu = InfoAlu.getPersona(dni);
        
        request.setAttribute("AluPersona",alu);
        
        request.getRequestDispatcher("Admin/InfoAlumno.jsp").forward(request, response);
 
    }
    
    private void FichaMedicaAlu(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException{
    
         AlumnoController InfoAlu = new AlumnoController();
        int id = InfoAlu.getID_Alumno(request.getParameter("DNI"));
        
        FichaMedica AluFM = InfoAlu.getFichaMedica(request.getParameter("DNI"));
        
        request.setAttribute("FMAlu",AluFM);
        
        request.getRequestDispatcher("Admin/InfoAlumno.jsp").forward(request, response);
 
    }
    
    private void Apoderado(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException{
    
         AlumnoController InfoAlu = new AlumnoController();
        int id = InfoAlu.getID_Alumno(request.getParameter("DNI"));

            Apoderado AluFM = InfoAlu.getApoderado(id);
            
            if(AluFM == null){
                
                    request.setAttribute("apoderado","a");
                    request.setAttribute("ErrorApo","No se a encontrado informacion del Apoderado");       
                    request.getRequestDispatcher("Admin/InfoAlumno.jsp").forward(request, response);
            
                    System.out.println("msn: no se encontro informacuion" );
            
            }else{
            
                    request.setAttribute("apoderado",AluFM);
        
                    request.getRequestDispatcher("Admin/InfoAlumno.jsp").forward(request, response);
              
            }

    }

    
    private void Perfil_A(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException{
    
    AlumnoController perfilAlu = new AlumnoController();
    
    
    
    
    
    
    
    }

}
