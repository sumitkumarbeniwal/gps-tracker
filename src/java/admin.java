
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class admin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String output="<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>welcome to admin panel </title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
"        <script src=\"jquery/jquery-3.1.1.min.js\"></script>\n" +
"        <script src=\"js/bootstrap.min.js\"></script>\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js\"></script>\n" +
"        <link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css\">\n" +
"        <script src=\"scripts/time.js\"></script>\n" +
"        <style> \n" +
"          body\n" +
"          {\n" +
"              background-image: url(\"images/backimage.jpg\");\n" +
"              background-repeat:no-repeat;\n" +
"               background-size:cover;\n" +
"              \n" +
"          }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body onload=\"startTime()\">\n" +
"        <div class=\"container\">\n" +
"            <div class=\"row\" style=\"background-color:#999999;padding: 0px; border-radius: 15px;\">\n" +
"                <div>\n" +
"                <div class=\"col-lg-2\" style=\"background:transparent; text-align: center \" >\n" +
"                        <img src=\"images/images (1).jpg\" class=\"img-rounded\" class=\"img-responsive\" alt=\"Cinque Terre\" width=\"150\" height=\"150\"> \n" +
"                </div>\n" +
"                    <div class=\"col-lg-8\" style=\"text-align: center\"> <h1 style=\"color: #fff ;font-variant:small-caps; font-style:normal; \">GPS TRACKING</h1>\n" +
"                      \n" +
"                      </p>\n" +
"                </div>\n" +
"                <div class=\"col-lg-2\" style=\"text-align: right; float: right\"> \n" +
"                        <p id=\"time\" style=\"padding-top:30px; padding-bottom: 0px; color: #fff;font-variant:small-caps; font-style:normal;  \"></p>\n" +
"                        <p id=\"txt\" style=\"color: #fff; padding-top: 0px ;font-variant:small-caps; font-style:normal;\" ></p>\n" +
"                        \n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"            \n" +
"        </div>\n" +
"        <div class=\"container\" style=\"padding: 0px;\">\n" +
"                <nav class=\"navbar navbar-default\" style=\"background-color:#999999; border-radius: 15px; margin-top: 2px; border-color:#999999 \">\n" +
"                    <div class=\"container\" >\n" +
"              <!-- Brand and toggle get grouped for better mobile display -->\n" +
"               <div class=\"navbar-header\">\n" +
"                  <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\n" +
"                     <span class=\"sr-only\">Toggle navigation</span>\n" +
"                     <span class=\"icon-bar\"></span>\n" +
"                     <span class=\"icon-bar\"></span>\n" +
"                     <span class=\"icon-bar\"></span>\n" +
"                  </button>\n" +
"                   <a class=\"navbar-brand\" href=\"admin\" style=\"color: #fff\">Home</a>\n" +
"               </div>\n" +
"\n" +
"            <!-- Collect the nav links, forms, and other content for toggling -->\n" +
"            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\" style=\"color: #999999;\">\n" +
"           <ul class=\"nav navbar-nav\">\n" +
"               <li ><a href=\"aboutus\" style=\"color: #fff\">About us <span class=\"sr-only\">(current)</span></a></li>\n" +
"               <li class=\"dropdown\">\n" +
"                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\" style=\"color: #fff\">Admin<span class=\"caret\"></span></a>\n" +
"                   <ul class=\"dropdown-menu\" style=\"background-color: #999999; \">\n" +
"                       <li><a href=\"adminregister\" >Add Admin</a></li>\n" +
"                    <li role=\"separator\" class=\"divider\"></li>\n" +
"                     <li><a href=\"adminupdate\" style=\"color:#06213F\">Update Details</a></li>\n" +
"                     <li role=\"separator\" class=\"divider\"></li>\n" +
"                     <li><a href=\"adminremove\" style=\"color:  #06213F\">Delete Records</a></li>\n" +
"                   </ul>\n" +
"              </li>\n" +
"               <li class=\"dropdown\">\n" +
"                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\" style=\"color: #fff\">User<span class=\"caret\"></span></a>\n" +
"                <ul class=\"dropdown-menu\" style=\"background-color:#999999; \">\n" +
"                    <li><a href=\"userregisteration\" style=\"color: #06213F\">New user Registration</a></li>\n" +
"                     <li role=\"separator\" class=\"divider\"></li>\n" +
"                     <li><a href=\"userupdate\" style=\"color: #06213F\">Update Details</a></li>\n" +
"                     <li role=\"separator\" class=\"divider\"></li>\n" +
"                     <li><a href=\"userdelete\" style=\"color: #06213F\">Delete Records</a></li>\n" +
"                   </ul>\n" +
"               </li>\n" +
"              <li ><a href=\"getlocation?flag=1\" target=\" blank\" style=\"color: #fff\">Location<span class=\"sr-only\">(current)</span></a></li>\n" +
"           <li ><a href=\"userlog\" target=\" blank\" style=\"color: #fff\">Logged User<span class=\"sr-only\">(current)</span></a></li>\n" +
"                  \n" +
"           </ul>\n" +
"             \n" +
"              <ul class=\"nav navbar-nav navbar-right\">\n" +
"                 <li><a href=\"adminhome.html\" style=\"color: #fff\">Logout</a></li>\n" +
"              </ul>\n" +
"    </div><!-- /.navbar-collapse -->\n" +
"  </div><!-- /.container-fluid -->\n" +
"</nav>\n" +
"            </div>\n" +
"           </body>\n" +
"</html>";
        out.println(output);
        
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
