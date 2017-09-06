import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class data extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String longitute=request.getParameter("longitute");
            String latitute=request.getParameter("latitute");
         try {
                
                database db=new database();
                Connection con=db.getCon();
                PreparedStatement ps1 = con.prepareStatement("select  * from cordinate where longi=?");
		ps1.setString(1,longitute);
		ResultSet rs = ps1.executeQuery();
                System.out.println(longitute);
		         if(rs.next())
		        	 {
	                                    longitute= rs.getString("longi");
	                                    latitute= rs.getString("lati");
                                 }
         }
         catch(Exception ex)
         { System.out.println("1111111");
         System.out.println(ex);
             
         }
         response.sendRedirect("index.html");
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
