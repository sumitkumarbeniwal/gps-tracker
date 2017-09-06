/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Beniwal
 */
public class getrecord extends HttpServlet {
String f_name;
            String l_name="";
            String user_name="";
            String pass_word="";
            String c_number="";
            String Email="";
            String a="";
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
         
        
        String phone=request.getParameter("cnumber");
        try
        {
         database db=new database();
              Connection con=db.getCon();
              PreparedStatement ps = con.prepareStatement("select * from register where c_number=?");
              ps.setString(1,phone);
              ResultSet rs = ps.executeQuery();
              if(rs.next())
              {
              f_name=rs.getString("f_name");
              l_name=rs.getString("l_name");
              user_name=rs.getString("user_name");
              pass_word=rs.getString("password");
              c_number=rs.getString("c_number");
              Email=rs.getString("Email");
              a="Record Found";
              }
              else
              {
                  a="Record not Found";
              }
        }catch(Exception e){System.out.print("in get record"+e);}
        
        String output="";
        
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
"                border-radius: 5px;\"></a></div>\n" ;
        output+="<div style=\"color:red\">"+a+"</div>";
output+="<h1> Update Form</h1>\n" +
"\n" +
"<form   method=\"post\" action=\"userupdate?flag=1\">\n" +
"    <table border='0'>\n" +
"\n" +
" <tr>\n" +
"\n"+
"  <td><LABEL for=\"firstname\">First Name:<sup style=\"color:#F00\">*</sup> </LABEL></td>\n" +
"\n";
output+="  <td><input type=\"text\" id=\"firstname\" name=\"fname\" value=\""+f_name+"\"></td>\n" +
" </tr>\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"lastname\">Last Name:<sup style=\"color:#F00\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"text\" id=\"lastname\" name=\"lname\" placeholder=\"l_name\" value=\""+l_name+"\"></td>\n" +
"\n" +
" </tr>\n" +
" <tr>\n" +
"     <td><label for=\"username\">User Name:<sup style=\"color:#F00\">*</sup>  </label></td>\n" +
"     <td><input type=\"text\" id=\"username\" name=\"username\" placeholder=\"enter user name\" value=\""+user_name+"\"></td>\n" +
"    </tr>\n" +
"    <tr>\n" +
"        <td><label for=\"password\">Password:</td>\n" +
"        <td><input  type=\"password\"  name=\"password\" value=\"\" placeholder=\"enter your \"/></td>\n" +
"    </tr>\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"contctno\">Contact Number:<sup style=\"color:#F00\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"text\" id=\"contactno\" name=\"cnumber\" value=\""+c_number+"\"></td>\n" +
"\n" +
" </tr>\n" +
"\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"email\">Email:<sup style=\"color:red;\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"email\" id=\"email\" name=\"email\" value=\""+Email+"\"></td>\n" +
"\n" +
" </tr>\n" +
"\n" +
" <tr>\n" +
"\n" +
"     <td><input type=\"submit\"  value=\"Update\"/></td><td><input type=\"reset\"/></td>\n" +
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
