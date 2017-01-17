/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletregisterprocessing;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dblib.Enrollment;



/**
 *
 * @author jieun
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"}, initParams = {
    @WebInitParam(name = "uid", value = "ism6236"),
    @WebInitParam(name = "pass", value = "ism6236bo")})
public class Register extends HttpServlet {

    Enrollment mdb;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String uid = config.getInitParameter("uid");
        String pass = config.getInitParameter("pass");
        
        mdb = new Enrollment(uid,pass);
        
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
        
        String stuNo = request.getParameter("stuNo");
        int Stu = Integer.parseInt(stuNo);
        String courseNo = request.getParameter("courseNo");
        String sectionNo = request.getParameter("sectionNo");
        int SectionNo = Integer.parseInt(sectionNo);
        String semester = request.getParameter("semester");
        String year = request.getParameter("year");
       
        
        int n = mdb.Register(Stu, courseNo, SectionNo, semester, year);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Enrollment Result</h2>");
            out.println("<link rel = \"stylesheet\" type =\"text/css\" href =\"servlet.css\" />");
            //formstuff
            out.println("<form ACTION=\"register\" METHOD=\"GET\"> ");
            out.println("<fieldset id=\"info\"style = \"width:250px;\">");
            out.println("<legend > Result: </legend>");
            
            String result = String.format("%d records got updated",n);
            out.println(result);
            out.println("</fieldset>");
            out.println("<br> <Input TYPE =\"submit\" formaction=\"index.html\" value=\"Main Menu\">");
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
