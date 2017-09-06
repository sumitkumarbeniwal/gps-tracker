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
public class homegps extends HttpServlet {

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
       PrintWriter out = response.getWriter();
       String phone=request.getParameter("id");
       String output="";
       //define output String '
       output+="<html>\n" +
"    <head>\n" +
"        <title>\n" +
"            \n" +
"        </title>\n" +
"        \n" +
"        \n" +
"        <style>\n" +
"            body{\n" +
"                  margin: 0px;\n" +
"                  padding: 0px;\n" +
"            }\n" +
"        .first{\n" +
"           height:70px;\n" +
"           width:auto;\n" +
"            background-color: cadetblue; \n" +
"            margin: 0px;\n" +
"            padding: 0px;\n" +
"           }\n" +
"           .first p{\n" +
"                   \n" +
"                  text-align:  center;\n" +
"                  font-size: 50px;\n" +
"                  font-family: monospace;\n" +
"           } \n" +
"           .center-block p{\n" +
"                    \n" +
"             font-size: 50px; \n" +
"             \n" +
"                 }\n" +
"                 .row1{\n" +
"                     \n" +
"                     \n" +
"                        height:510px;\n" +
"                         width:  auto;\n" +
"                          background-color: darkcyan;  \n" +
"                           padding-top:50px;\n" +
"                           margin: 0px;\n" +
"                            text-transform:  capitalize;\n" +
"                            \n" +
"                 }\n" +
"                 .center-block{\n" +
"                       text-align:  center;\n" +
"                     \n" +
"                 }\n" +
"                 .btn{\n" +
"                       \n" +
"                         height:50px;\n" +
"                         width: 200px;\n" +
"                        \n" +
"                         background-color:  darkred;\n" +
"                         border:1px solid  #F00;\n" +
"                         border-radius:5px;\n" +
"                         color: white;\n" +
"                 }\n" +
"                 .btn:hover{\n" +
"                        background-color: crimson;\n" +
"                 \n" +
"                 }\n" +
"                 .input-lg,.input-lt{\n" +
"                     \n" +
"                         height:50px;\n" +
"                         border:1px solid #F00;\n" +
"                          border-radius: 8px;\n" +
"                        width: 400px;\n" +
"                         margin-left: 80px;\n" +
"                         margin-top: 50px;\n" +
"                          font-size: 20px;\n" +
"                           color: #F00;\n" +
"                         \n" +
"                 }\n" +
"                 .input-lg,.input-lt:focus{\n" +
"                     \n" +
"                            outline: none;\n" +
"                            border:3px solid #000;\n" +
"                 }\n" +
"           </style>\n" +
"    </head>\n" +
"<body>\n" +
"<div class=\"container first\">\n" +
"     <p>Welcome to location tracker </p>\n" +
"   </div>   \n" +
"    <div class=\"container\">\n" +
"        <div class=\"row row1\">\n" +
"             \n" +
"            <div class=\"center-block\">\n" +
"              <p>Get your location  </p>\n" +
"             \n" +
"              <button onclick=\"getLocation()\" class=\"btn\">Get Location</button>\n" +
"              \n" +
"              </div>\n" +
"            <div>\n" ;
                    output+="<form class=\" form-inline\" action=\"locationgps?id="+phone+"\" method=\"post\">\n" +
"                  <div class=\"form-group\">\n" +
"                       \n" +
"                      <input type=\"text\" class=\"form-control input-lt\" value=\"\" name=\"demo\" id=\"demo\" placeholder=\"latitude\"/>   \n" +
"                  \n" +
"                      <input type=\"text\" class=\"form-control input-lg\" value=\"\" name=\"demo1\" id=\"demo1\" placeholder=\"longitude\"/>   \n" +
"                 \n" +
"                      <input type=\"submit\" class=\"btn\"   style=\" margin-left: 50px;\"/>   \n" +
"                 \n" +
"                  </div>\n" +
"                 \n" +
"              \n" +
"                 </form>\n" +
"                 \n" +
"          </div>\n" +
"        \n" +
"       </div>\n" +
"   \n" +
"<script>\n" +
"var x = document.getElementById(\"demo\");\n" +
"var y = document.getElementById(\"demo1\");\n" +
"\n" +
"\n" +
"function getLocation() {\n" +
"    if (navigator.geolocation) {\n" +
"        navigator.geolocation.watchPosition(showPosition);\n" +
"    } else { \n" +
"        x.innerHTML = \"Geolocation is not supported by this browser.\";}\n" +
"    }\n" +
"    \n" +
"function showPosition(position) {\n" +
"    x.value=position.coords.latitude;\n" +
"    y.value=position.coords.longitude;\n" +
"   \n" +
"}\n" +
"</script>\n" +
"\n" +
"</body>\n" +
"</html>\n" +
"";
       out.print(output);
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
