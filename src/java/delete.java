import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String s1=request.getParameter("cnumber");
         String a="";
         int flag=1;
             try {
                database db=new database();
                Connection con=db.getCon();
                PreparedStatement ps1 = con.prepareStatement("select  user_name from register where c_number=?");           //for select an id 
		ps1.setString(1,s1);
		ResultSet rs = ps1.executeQuery();
	              if( rs.next())                                   //check weather id is present or not in database                                             
			 {			 
		            PreparedStatement ps = con.prepareStatement("delete from register where c_number=?");
                            ps.setString(1, s1);                              
                            int rs1 = ps.executeUpdate();
                          a="data is deleted successfully";
                          
                         }
        		else
					{
						a="enter user not present in the database";
				        }        
                  }
              catch(Exception ex)
                 {
                       System.out.println("exception in the code ");
                       System.out.println(ex);
                 }
             PrintWriter out = response.getWriter();
             String output="";
             
             
             output+="<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>USER Delete</title>\n" +
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
"               \n";
        if(flag==1)
        {
        output+="<div style=\"color:red\">"+a+"</div>";
        
        }
        output+="<h1>User Delete </h1>\n" +
"\n" +
"<form   method=\"post\" action=\"delete\">\n" +
"    <table border='0'>\n" +
"\n" +
" <tr>\n" +
"\n" +
"  <td><LABEL for=\"contctno\">Contact Number:<sup style=\"color:#F00\">*</sup> </LABEL></td>\n" +
"\n" +
"  <td><input type=\"text\" id=\"contactno\" name=\"cnumber\" value=\"\"></td>\n" +
"\n" +
" </tr>\n" +
"\n" +
"\n" +
" <tr>\n" +
"\n" +
"     <td><input type=\"submit\"  value=\"Search\"/></td><td><input type=\"reset\"/></td>\n" +
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
        out.println(output);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request, response);
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
