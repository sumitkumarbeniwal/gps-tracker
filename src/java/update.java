
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s1=request.getParameter("f_name");
             String s2,s3,s4,s5,s6;
             s2 = request.getParameter("l_name");
             s3 = request.getParameter("user_name");
             s4 = request.getParameter("password");
              s5 = request.getParameter("c_number");
             s6 = request.getParameter("Email");
             System.out.println(s1);
         System.out.println(s2);
           System.out.println(s3);
             System.out.println(s4);
              System.out.println(s5);
             System.out.println(s6);
             try {
             database db=new database();
              Connection con=db.getCon();
                        PreparedStatement ps = con.prepareStatement("update register set f_name = ? , password = ? , c_number = ? ,user_name = ?,l_name = ?  where Email = ?");
                              //id
                         ps.setString(1,s1);  //s_name
                         ps.setString(2,s4);      //password
                         ps.setString(3,s5);
                         ps.setString(4,s3); //phone no
			 ps.setString(5,s2);
                         ps.setString(6,s6);
			 ps.executeUpdate();
                           
               }
         catch(SQLException ex)
         {
                System.out.println("exception occur");
               
         }
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
