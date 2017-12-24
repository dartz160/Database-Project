
package Controller;

import BD.Data;
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
import javax.servlet.http.HttpSession;
import model.Usuario;


@WebServlet(name = "IniciarSesionServlet", urlPatterns = {"/IniciarSesionServlet"})
public class IniciarSesionServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        
        try {
            /*index.jsp -->IniciarSesionServlet---
            si el usuario se encuentra y para evaluar el nivel de privilegio y redireccionar a --> menu.jsp
            si el usuario no exite o es incorrecto nos redirecciona a error.jsp
            
            */
            
            

            
            
            Data d = new Data();
            //response.sendRedirect("Login/Error.jsp");

            String user =request.getParameter("user");
            String pass = request.getParameter("pass");
            
            Usuario u = d.getUsuario(user, pass);
            
              
            
            if(u==null)
            {
                /**mal*/
                response.sendRedirect("Login/Error.jsp");
                
            
            }else{
                
                /*Oka si existe*/

                /*iniciamos un sesion*/
                
                HttpSession sesion = request.getSession();
                sesion.setAttribute("user",u);
                
                
                
                
                
                response.sendRedirect("Login/Menu.jsp");
            
            }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(IniciarSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IniciarSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
