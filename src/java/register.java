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

/**
 *
 * @author A
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
        int dflag=0;
        PrintWriter out = response.getWriter();
        String output="";
        String a="";
        try{
        dflag=Integer.parseInt(request.getParameter("dflag"));
        }catch(Exception e){}
        
        
        /* TODO output your page here. You may use following sample code. */
            Connection con=null;
            String f_name;
            String l_name;
            String user_name;
            String pass_word;
            String c_number;
            String Email;
            PreparedStatement p=null;
            String url="jdbc:mysql://localhost/gps";
             f_name=request.getParameter("fname");
             l_name=request.getParameter("lname");  
              user_name=request.getParameter("username");
              pass_word=request.getParameter("password"); 
              c_number=request.getParameter("cnumber");
              Email=request.getParameter("email");
             database db =new database();
            try{
               Class.forName("com.mysql.jdbc.Driver");
              
               con=db.getCon();
                p=con.prepareStatement("insert  into register(f_name,l_name,user_name,password,c_number,Email) values(?,?,?,?,?,?)");
                p.setString(1,f_name);
                p.setString(2,l_name);
                p.setString(3,user_name);
                p.setString(4,pass_word);
                p.setString(5,c_number);
                p.setString(6,Email);
               int result=p.executeUpdate();
               a="Record Update Successfully ";
                if(result==1)
                {
                    response.sendRedirect("register?dflag=1");
                    
                   }
                else
                {
                    response.sendRedirect("register?dflag=1");
                
                }
               }
              catch(SQLIntegrityConstraintViolationException e)
               {
                   a="Record Already Exist";
                 dflag=1;
               }
            catch(Exception ed)
            {
                a="Record Update UnSuccessfully ";
              System.out.println(ed);
            }
            output+="<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>REGISTER</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        \n" +
"        <style>\n" +
"         input[type='text'],input[type='password'],input[type='email']\n" +
"         {\n" +
"             \n" +
"               height:30px; \n" +
"                width: 200px; \n" +
"                border-radius: 5px;\n" +
"                outline:  none;\n" +
"                padding: 5px;\n" +
"                margin: 10px;\n" +
"                \n" +
"         }\n" +
"         #login{\n" +
"                box-shadow:10px 10px 10px 10px antiquewhite;   \n" +
"             \n" +
"             \n" +
"             }\n" +
"         input[type='submit'],input[type='reset']\n" +
"         {\n" +
"             \n" +
"               height: 50px;\n" +
"                width:100px;\n" +
"                border:1px solid #000;\n" +
"                border-radius: 5px;\n" +
"                background-color: brown;\n" +
"                 margin: 20px;\n" +
"                 float:  left;\n" +
"                 box-shadow:10px 10px  5px activeborder; \n" +
"                 \n" +
"         }     \n" +
"             \n" +
"       </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div style=\"border: 1px solid #000; width: 500px; margin:  auto; margin-top:40px;\" id=\"login\">\n" +
"            \n" +
"            \n" +
"            <center>\n" +
"                <div style=\" text-align: left\"> <a href=\"admin\"> <input type=\"button\" value=\"Home\" style=\" height: 40px; width: 90px; color: blue;  border:1px solid #000;\n" +
"                border-radius: 5px;\"></a></div>\n";
            if(dflag==1)
            { 
                output+=" <div style=\" color: red\">"+a+"</div>\n";

            }
                output+="<h1> Registration Form</h1>\n" +
"\n" +
"<form   method=\"post\" action=\"register\">\n" +
"    <table border='0'>\n" +
"\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"firstname\">First Name:<sup style=\"color:#F00\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"text\" id=\"firstname\" name=\"fname\" value=\"\"></td>\n" +
" </tr>\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"lastname\">Last Name:<sup style=\"color:#F00\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"text\" id=\"lastname\" name=\"lname\" placeholder=\"l_name\" value=\"\"></td>\n" +
"\n" +
" </tr>\n" +
" <tr>\n" +
"     <td><label for=\"username\">User Name:<sup style=\"color:#F00\">*</sup>  </label></td>\n" +
"     <td><input type=\"text\" id=\"username\" name=\"username\" placeholder=\"enter user name\" value=\"\"></td>\n" +
"    </tr>\n" +
"    <tr>\n" +
"        <td><label for=\"password\">Password:</td>\n" +
"        <td><input  type=\"password\"  name=\"password\" value=\"\" placeholder=\"enter your password\"/></td>\n" +
"    </tr>\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"contctno\">Contact Number:<sup style=\"color:#F00\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"text\" id=\"contactno\" name=\"cnumber\" value=\"\"></td>\n" +
"\n" +
" </tr>\n" +
"\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"email\">Email:<sup style=\"color:red;\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"email\" id=\"email\" name=\"email\" value=\"\"></td>\n" +
"\n" +
" </tr>\n" +
"\n" +
" <tr>\n" +
"\n" +
"     <td><input type=\"submit\"  value=\"Submit\"/></td><td><input type=\"reset\"/></td>\n" +
"\n" +
" </tr>\n" +
" <tr>\n" +
"  <td></td><td style=\"font-size:12px;text-align:right;\"><br/><i style=\"color:red;font-size:12px;align:right;\" >* - Mandatory</i></td>\n" +
" </tr>\n" +
"    </table>\n" +
" </form></center>\n" +
"</div>\n" +
"    </body>\n" +
"</html>\n" +
"\n" +
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
