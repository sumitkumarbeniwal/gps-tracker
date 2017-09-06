import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class showrecord extends HttpServlet {
 static String longitute,latitute,id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             id=request.getParameter("id");
              System.out.println("statement id ok   "+id);
               try {
                  database db=new database();
                  Connection con=db.getCon();
                  System.out.println("statement 11 ok");
                  PreparedStatement ps1 = con.prepareStatement("select  * from data where phone=?");
		  System.out.println("statement 1 ok");
                  ps1.setString(1,id);
		  ResultSet rs = ps1.executeQuery();
                  System.out.println("statement 2 ok");
                  System.out.println(id);
		            if(rs.next())
		    {   
                                             System.out.println("sucess ");
                                             id=rs.getString("phone");
	                                     longitute= rs.getString("lag");
	                                     latitute= rs.getString("lat");
                                             System.out.println(id);
                                             System.out.println(longitute);
                                             System.out.println(latitute);
                                         }
                   }
         catch(Exception ex)
         { System.out.println("1111111");
         System.out.println(ex);
                     
         }
         PrintWriter w=response.getWriter();
    // show output from record 
    String output="";
    output+="<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Location Page</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
"        <!-- Optional theme -->\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n" +
"        <!-- Latest compiled and minified JavaScript -->\n" +
"         <script type=\"text/javascript\" src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyD5mXdtJc57xXCtqwTJy-eRSq-QZHjtXXw&libraries=places\"></script>\n" +
"\n" +
"    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js\"></script>\n" +
"    \n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +
"        <style>\n" +
"body {\n" +
"    background-color:#cccccc ;\n" +
"}\n" +
"</style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"container\">\n" +
"            <div style=\" padding-top: 20px\"> \n" +
"                <h1 style=\" text-align: center; font-family:Times New Roman \">Welcome To Map</h1>\n" +
"                <a href=\"admin\">  <input type=\"submit\" value=\"Home\" id=\"logout\" class=\"btn btn-primary btn-lg\" style=\" float: right;margin: -5px; width: 100px;height:40px; font-size:17px;background:#cc0000\"></a>\n" +
"        </div>\n" +
"            <div style=\"padding-top: 100px; padding-bottom: 20px; text-align: center;font-family:Times New Roman; color: black; \"> \n" +
"                \n" +
"                <lable><font size=\"4\" > Enter Your phone number:</font></lable> <input type=\"text\" id=\"data\" value=\" "+id+" \" style=\"padding-left: 10px\"> </div>\n" +
"                \n" +
"                <div style=\"text-align: center; padding-left:35px\">\n" +
"                <input style=\"color: blue; padding-left: -20px\" type=\"button\" value=\"Find\" onclick=\"find()\" id=\"find\">\n" +
"                </div>\n" +
"                <div style=\" text-align: center ; padding-top: 20px; \">\n" +
"                    <label style=\" padding-right: 20px; font-family:Times New Roman; color: black;\"><font size=\"4\" >Latitude:</font> </label>\n" +
"                <input type=\"text\" id=\"latitude\" name=\"Latitude\" value=\" "+longitute +" \" float=left> \n" +
"                <label style=\" padding-left: 20px; padding-right: 10px;font-family:Times New Roman; color: black;\"><font size=\"4\" >Longitude:</font> </label>\n" +
"                <input type=\"text\" id=\"Longitude\" name=\"Longitude\" value=\" "+ latitute+" \" float=left>\n" +
"                </div>\n" +
"                \n" +
"            <div style=\"text-align: center ; padding-top: 20px; padding-left: 30px\"> <a href=\"locationshow?lat="+latitute+"&log="+longitute+"\"><input type=\"Button\"  onclick=\"\" value=\"Show map\" id=\"btnShow\"  style=\" width:150px; font-size: 17px\"></a></div>\n" +
"            <div id=\"dialog\" style=\"display: none\">\n" +
"        <div id=\"dvMap\" style=\"height: 380px; width: 580px;\">\n" +
"        </div>\n" +
"    </div>\n" +
"        </div>\n" +
"         <script type=\"text/javascript\" src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyD5mXdtJc57xXCtqwTJy-eRSq-QZHjtXXw&libraries=places\"></script>\n" +
"         <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js\"></script>\n" +
"         <script src=\"http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js\" type=\"text/javascript\"></script>\n" +
"         <link href=\"http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css\"\n" +
"         rel=\"stylesheet\" type=\"text/css\" />\n";
    

output+="    </body>\n" +
"</html>\n" +
"";
    w.print(output);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
