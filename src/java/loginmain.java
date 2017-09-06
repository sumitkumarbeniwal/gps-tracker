/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author A
 */
public class loginmain extends HttpServlet {

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
        
        String user = request.getParameter("name");
        String pass = request.getParameter("pass");
        
          Connection con=null;
          PreparedStatement p=null;
          
       
            try{
                 Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost/gps";
                  con=DriverManager.getConnection(url,"root","TAMRAYAT");
                  p=con.prepareStatement("select * from register where user_name=?");
                  p.setString(1,user);
                  ResultSet set=p.executeQuery();
                      while(set.next())
                           { 
                          String userget=set.getString("user_name");
                          String passget=set.getString("password");
                         if(user.equals(userget))
                            {
                                if(pass.equals(passget))
                                {
                                   response.sendRedirect("admin.html"); 
                                
                                }
                            }
                          else{
                                response.sendRedirect("home_1.html");
                               
                                     } 
                              }
                   }
            catch(Exception ex)
                {
                     System.out.println("<h1>F_name" + ex+ "</h1>");
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
