/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Beniwal
 */
public class home extends HttpServlet {

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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String output="";
        output+="<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <title>home page</title>\n" +
"                <script src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script>\n" +
"        <!-- Latest compiled and minified CSS -->\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
"\n" +
"<!-- Optional theme -->\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n" +
"\n" +
"<!-- Latest compiled and minified JavaScript -->\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +
"<script src=\"scripts/time.js\"></script>       \n" +
"<style>\n" +
"  .carousel-inner > .item > img,\n" +
"  .carousel-inner > .item > a > img {\n" +
"      width: 70%;\n" +
"      margin: auto;\n" +
"  }\n" +
"  </style>\n" +
"  <script type=\"text/javascript\">\n" +
"alert(\"Incorrect login Retry\");\n" +
"</script>\n" +
"    </head>\n" +
"    <body onload=\"startTime()\" >\n" +
"         <div class=\"modal fade\" id=\"myModal\" role=\"dialog\" style=\"margin-top:200px;\">\n" +
"            <div class=\"modal-dialog modal-sm\" style=\" border-radius: 10px;\">\n" +
"            <div class=\"modal-content\">\n" +
"            <div class=\"modal-header bg-info\">\n" +
"            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
"            <h4 class=\"modal-title text-center\">Login with us</h4>\n" +
"            </div>\n" +
"         <div class=\"modal-body\">\n" +
"               <form role=\"form\" action=\"Login\" method=\"post\">\n" +
"                  <div class=\" form-group\">\n" +
"                    <label>Username</label>\n" +
"                    <input type=\"text\" class=\"form-control\" placeholder=\"Username\" id=\"name\" name=\"username\"/>\n" +
"                 </div>\n" +
"                 <div class=\" form-group\">\n" +
"                      <label>Password</label>\n" +
"                 <input type=\"password\" class=\"form-control\" placeholder=\"password\" id=\"pass\" name=\"password\"/>\n" +
"                </div>            \n" +
"              <div class=\" btn-group\">\n" +
"                 <input type=\"submit\" class=\"btn btn-info\" value=\"Login\"/>\n" +
"                 <input type=\"reset\" class=\"btn btn-primary\" value=\"Reset\" style=\"margin-left:10px;\"/>\n" +
"                </div> \n" +
"                  </form>\n" +
"        </div>\n" +
"        <div class=\"modal-footer bg-info\">\n" +
"          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n" +
"        </div>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"        <div class=\"container\" style=\" padding: 0px; padding-left: 130px; \">\n" +
"            <div class=\"row\">\n" +
"            <div class=\"navbar-header\" class=\" col-lg-3\">\n" +
"         <a class=\"navbar-brand\" href=\"#\">\n" +
"             <img src=\"images\\images (1).jpg\" alt=\"\" height=\"70\" width=\"70\"></a>\n" +
"               \n" +
"            </div>\n" +
"                <div class=\" col-lg-6\">\n" +
"                    <h1 style=\" text-align: center; padding-left: 150px\"> GPS TRACKER </h1></div>\n" +
"                    <div class=\" col-lg-3\" style=\" text-align: center\">\n" +
"                        <div>\n" +
"                            <div style=\" float: left; padding-left: 50px\">  <p id=\"time\" style=\" padding-top:30px; padding-bottom: 0px; color: black;font-variant:small-caps; font-style:normal;\"></p>\n" +
"                         <p id=\"txt\" style=\"color: black; padding-top: 0px ;font-variant:small-caps; font-style:normal;\" ></p>\n" +
"                        </div><div style=\" float: left ; padding: 20px; padding-top: 30px\"> <a  style=\" text-align: center\"><button class=\"btn btn-danger navbar-btn pull-right\" data-target=\"#myModal\" data-toggle=\"modal\">Login</button></a>\n" +
"                        </div>\n" +
"                        </div>   </div>   </div>     </div>              \n" +
"  \n" +
"    <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
"  <!-- Indicators -->\n" +
"  <ol class=\"carousel-indicators\">\n" +
"    <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
"    <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n" +
"    <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n" +
"    <li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\n" +
"    <li data-target=\"#myCarousel\" data-slide-to=\"4\"></li>\n" +
"  </ol>\n" +
"\n" +
"  <!-- Wrapper for slides -->\n" +
"  <div class=\"carousel-inner\" role=\"listbox\">\n" +
"    <div class=\"item active\">\n" +
"        <img src=\"images\\map-with-pin.jpg\" alt=\"\"style=\" height:500px \"/>\n" +
"           </div>\n" +
"      \n" +
"    <div class=\"item\">\n" +
"        <img src=\"images\\MAP WITH PHONE.jpg\" alt=\"\"style=\" height:500px \"/>\n" +
"</div>\n" +
"\n" +
"    <div class=\"item\">\n" +
"        <img src=\"images\\images(2).jpg\" alt=\"\"style=\" height:500px \"/>\n" +
"         </div>\n" +
"      \n" +
"    <div class=\"item\">\n" +
"        <img src=\"images\\Delhi-To-Pilani-4.png\" alt=\"\"style=\" height:500px \"/>\n" +
"           </div>\n" +
"      <div class=\"item\">\n" +
"          <img src=\"images\\info image.jpg\" alt=\"\"style=\" height:500px \"/>\n" +
"          \n" +
"      </div>\n" +
"     \n" +
"\n" +
"  <!-- Left and right controls -->\n" +
"  <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n" +
"    <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n" +
"    <span class=\"sr-only\">Previous</span>\n" +
"  </a>\n" +
"  <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n" +
"    <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n" +
"    <span class=\"sr-only\">Next</span>\n" +
"  </a>\n" +
"</div>  \n" +
"</body>\n" +
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
