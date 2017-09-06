/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author A
 */
@WebServlet(urlPatterns = {"/lgoin"})
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection con=null;
           
            String user_name;
            String pass_word;
            int flag1=0;
            int flag2=0;
            int s=0;
            
            PreparedStatement p=null;
            String url="jdbc:mysql://localhost/gps";
              user_name=request.getParameter("username");
              System.out.println("user name"+user_name);
              pass_word=request.getParameter("password");
              System.out.println("password is "+pass_word);
           try{
                 database db = new database();
                  con=db.getCon();
                  p=con.prepareStatement("select * from adminlogin where username=?");
                  p.setString(1,user_name);
                  ResultSet set=p.executeQuery();
                      while(set.next())
                           { 
                         String user=set.getString("username");
                         String pass=set.getString("password");  
                          if(user.equals(user_name))
                            { 
                                flag1=1;
                                System.out.print("Step 1");
                                if(pass.equals(pass_word))
                                {
                                    flag2=1;
                                    System.out.println("step 2 ok");
                                    response.sendRedirect("admin?id="+user_name);
                                }
                            }
                           }
                   }
            catch(Exception ex)
                {
                     out.println("<h1>F_name" + ex+ "</h1>");
                    }
           if(flag1==0||flag2==0)
           {
           s=1;
           response.sendRedirect("home");
           }
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
