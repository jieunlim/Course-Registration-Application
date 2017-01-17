

<%-- 
    Document   : List
    Created on : 2016. 4. 6, 오후 6:36:07
    Author     : jieun
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dblib.Enrollment, java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type ="text/css" href ="servlet.css" />
    </head>
    <body>

        <fieldset id="info" style = "width:400px;">
            <%
                Enrollment mdb = new Enrollment("ism6236", "ism6236bo");
                
                out.println("<label for=\"studentlist\"> Student: </label> <br> ");

                java.util.List<String> od = mdb.Init("Student");
                for (String s : od) {
                    out.println(s + "<br>");
                }
                out.println("<br>");
                out.println("<label for=\"courselist\"> Course: </label> <br> ");
                out.println();

                java.util.List<String> cd = mdb.Init("Course");
                for (String s : cd) {
                    out.println(s + "<br>");
                }


            %>
        </fieldset>
        <br>
        <form>
            <INPUT TYPE ="submit" formaction="index.html" value="Main Menu">
        </form>
    </body>
</html>
