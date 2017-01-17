/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletregisterprocessing;

import dblib.Enrollment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jieun
 */
@WebServlet(name = "List", urlPatterns = {"/List"}, initParams = {
    @WebInitParam(name = "uid", value = "ism6236"),
    @WebInitParam(name = "pass", value = "ism6236bo")})
public class List extends HttpServlet {

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

        String headerstuff = "<meta charset=\"UTF-8\">\n "
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "          <link rel=\"stylesheet\" type =\"text/css\" href =\"servlet.css\" /> ";

        String stuNo = request.getParameter("snum");
        int Stu = Integer.parseInt(stuNo);
        String semester = request.getParameter("sem");
        String year = request.getParameter("y");

        java.util.List<String> od = mdb.List(Stu, semester, year);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Enrollment List</title>");
            out.println("<link rel = \"stylesheet\" type =\"text/css\" href =\"servlet.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Enrollment List</h2>");
            out.println("<link rel = \"stylesheet\" type =\"text/css\" href =\"servlet.css\" />");

            //formstuf
            out.println("<form ACTION=\"List\" METHOD=\"GET\"> ");
            out.println("<fieldset id=\"info\"style = \"width:250px;\">");
            out.println("<legend > Student's Course: </legend>");
            String line = String.format("<label for=\"no\"> Student No: </label> <INPUT id= \"no\" type=text size=3  name=\"snum\" value=\"%s\"> <br>", stuNo);
            out.println(line);
            line = String.format("<label for=\"name\"> Semester: </label> <INPUT id= \"name\" type=text size=5 name=\"sem\" value=\"%s\"> <br>  ", semester);
            out.println(line);
            line = String.format("<label for=\"name\"> Year: </label> <INPUT id= \"name\" type=text size=10 name=\"y\" value=\"%s\"> <br>  ", year);
            out.println(line);
            out.println("<label for=\"orderlist\"> Enrolled Courses: </label> <br> ");
           // out.println("<select id = \"orders\" name =\"orderlist\" size=\"6\"> ");

            
            for (String s : od) {
                String result = String.format("<option> %s </option>", s);
                out.print(result);
            }
            
            
           
            System.out.println("\n");

            out.println("</select> <br>");

            out.println("</fieldset>");
            out.println(" <br><INPUT TYPE =\"submit\" formaction=\"List.html\" VALUE=\"Go Back\"> ");
            out.println(" <INPUT TYPE =\"submit\" formaction=\"index.html\" value=\"Main Menu\">");
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
