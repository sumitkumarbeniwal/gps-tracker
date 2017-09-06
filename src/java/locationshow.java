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
public class locationshow extends HttpServlet {

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
        String lat=request.getParameter("lat");
        String log=request.getParameter("log");
        
        //show map 
        String output="";
        output+="<!DOCTYPE html>\n" +
"<html>\n" +
"  <head>\n" +
"    <title>Geolocation</title>\n" +
"    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n" +
"    <meta charset=\"utf-8\">\n" +
"    <style>\n" +
"      /* Always set the map height explicitly to define the size of the div\n" +
"       * element that contains the map. */\n" +
"      #map {\n" +
"        height: 100%;\n" +
"      }\n" +
"      /* Optional: Makes the sample page fill the window. */\n" +
"      html, body {\n" +
"        height: 100%;\n" +
"        margin: 0;\n" +
"        padding: 0;\n" +
"      }\n" +
"    </style>\n" +
"  </head>\n" +
"  <body>\n" +
"    <div id=\"map\"></div>\n" +
"    <script>\n" +
"      // Note: This example requires that you consent to location sharing when\n" +
"      // prompted by your browser. If you see the error \"The Geolocation service\n" +
"      // failed.\", it means you probably did not give permission for the browser to\n" +
"      // locate you.\n" +
"      var map, infoWindow;\n" +
"      function initMap() {\n" +
"        map = new google.maps.Map(document.getElementById('map'), {\n" ;
output+="center: {lat: ";
output+=lat+", lng: ";
output+=log+"},\n" ;
output+="zoom: 6\n" +
"        });\n" +
"        infoWindow = new google.maps.InfoWindow;\n" +
"\n" +
"        // Try HTML5 geolocation.\n" +
"        if (navigator.geolocation) {\n" +
"          navigator.geolocation.getCurrentPosition(function(position) {\n" +
"            var pos = {\n" +
"              lat: position.coords.latitude,\n" +
"              lng: position.coords.longitude\n" +
"            };\n" +
"\n" +
"            infoWindow.setPosition(pos);\n" +
"            infoWindow.setContent('Location found.');\n" +
"            infoWindow.open(map);\n" +
"            map.setCenter(pos);\n" +
"          }, function() {\n" +
"            handleLocationError(true, infoWindow, map.getCenter());\n" +
"          });\n" +
"        } else {\n" +
"          // Browser doesn't support Geolocation\n" +
"          handleLocationError(false, infoWindow, map.getCenter());\n" +
"        }\n" +
"      }\n" +
"\n" +
"      function handleLocationError(browserHasGeolocation, infoWindow, pos) {\n" +
"        infoWindow.setPosition(pos);\n" +
"        infoWindow.setContent(browserHasGeolocation ?\n" +
"                              'Error: The Geolocation service failed.' :\n" +
"                              'Error: Your browser doesn\\'t support geolocation.');\n" +
"        infoWindow.open(map);\n" +
"      }\n" +
"    </script>\n" +
"    <script async defer\n" +
"    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyD5mXdtJc57xXCtqwTJy-eRSq-QZHjtXXw&callback=initMap\">\n" +
"    </script>\n" +
"  </body>\n" +
"</html>";
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
