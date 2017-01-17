/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletregisterprocessing;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dblib.Enrollment;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
/**
 *
 * @author jieun
 */
@WebServlet(name = "Registerlnit", urlPatterns = {"/lnit"}, initParams = {
    @WebInitParam(name = "uid", value = "ism6236"),
    @WebInitParam(name = "pass", value = "ism6236bo")})

public class lnit extends HttpServlet {

        private Enrollment mdb;
       
       
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String uid = config.getInitParameter("uid");
        String pass = config.getInitParameter("pass");
        mdb = new Enrollment(uid, pass);
}
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
        
        String headerstuff = "<meta charset=\"UTF-8\">\n " +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"          <link rel=\"stylesheet\" type =\"text/css\" href =\"servlet.css\" /> ";
        
        PrintStream cout = System.out;
        Scanner cin = new Scanner(System.in);
        String pass = cin.nextLine();
        
      
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet lnit</title>");   
            out.println(headerstuff);
            
            //formstuff
            out.println("<form ACTION=\"Customer\" METHOD=\"GET\"> ");
            out.println("<fieldset id=\"info\">");
            out.println("<legend > Customer: </legend>");
    
           
             List<String> aclist = mdb.Init("Student");
            for (String s : aclist) {                                                
            //String p = db.List(s)
            cout.println(s);
            }
            System.out.println("  ");
           
                    
            List<String> clist = mdb.Init("Course");
            for (String s : clist) {                                                
            //String p = db.List(s)
            cout.println(s);
            }
             System.out.println(" ");
          
            out.println("</select> <br>");
           // out.println(" <INPUT TYPE=\"submit\" VALUE=\"Get List\"> ");
          //  out.println(" <Input TYPE =\"submit\" formaction=\"index.html\" value=\"Main Menu\">");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
