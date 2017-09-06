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
public class userlog extends HttpServlet {

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
        PrintWriter out = response.getWriter() ;
            String user_name[]=new String[100];
            String c_number[]=new String[100];
            String Email[]=new String[100];
            String output="";
            int i=0;
            try
        {
         database db=new database();
              Connection con=db.getCon();
              PreparedStatement ps = con.prepareStatement("select * from register");
              ResultSet rs = ps.executeQuery();
              i=0;
              while(rs.next())
              {
              user_name[i]=rs.getString("user_name");
              c_number[i]=rs.getString("c_number");
              Email[i]=rs.getString("Email");
              i++;
              }
    System.out.println("Stetus ohk "+i);
        }catch(Exception e){System.out.print("in get record"+e);}
            
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
"                border-radius: 5px;\"></a></div>\n" +
"<h1> User Record </h1>\n" +
"\n" +
"<form   method=\"post\" action=\"#\">\n" +
"    <table border='0'>\n" +
"\n" +
" \n"+
            "     <td style=\" padding: 10px; color:black\"><label for=\"username\"><b>User Name</b> </label></td>\n" +
"      <td style=\" padding: 10px; color:black\"><label for=\"username\"><b>Phone Number</b></label></td>\n" +
"       <td style=\" padding: 10px; color:black\"><label for=\"username\"><b>Phone Number</b></label></td><br>\n" ;
output+=" <tr>\n";
i=0;
try{
  while(!(Email[i].equals("")))
  {      
       output+="<td style=\" padding: 10px\"><label for=\"username\">"+user_name[i]+"</label></td>\n" +
       "<td style=\" padding: 10px\"><label for=\"username\"><a href=\"showrecord?id="+c_number[i]+"\" >"+c_number[i]+"</a></label></td>\n" +
       "<td style=\" padding: 10px\"><label for=\"username\">"+Email[i]+"</label></td>\n";
       output+=" </tr>\n";
       i++;
  }}catch(Exception e){System.out.println(e);}
output+="\n" +
"    </table>\n" +
"\n" +
" </form></center>\n" +
"</div>\n" +
"    </body>\n" +
"</html>\n" +
"\n";
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
