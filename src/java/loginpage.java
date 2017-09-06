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
public class loginpage extends HttpServlet {

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
        
        String username=null;
        String password=null;
        String mob = null;
        int flag1=0;
int flag2=0;
int flag3=0;
//getting paprameter from requested url
        username=request.getParameter("username");
        String admin=username.substring(0,2);
        System.out.println("user is "+admin);
                     if((admin).equals("ad"))
                          {
                              System.out.println("login home");
                          response.sendRedirect("adminhome.html");
                          }
                        
        password=request.getParameter("password");
        mob=request.getParameter("mobnumber");
        Connection con=null;
        PreparedStatement p=null;
        String url="jdbc:mysql://localhost/gps";
        response.setContentType("text/html;charset=UTF-8");
 
        try{
                  database db = new database();
                  con=db.getCon();
                  p=con.prepareStatement("select * from register where user_name=?");
                  p.setString(1,username);
                  ResultSet set=p.executeQuery();
                      while(set.next())
                           { 
                          String user=set.getString("user_name");
                          System.out.println("login home");
                          String pass=set.getString("password");
                          String contact=set.getString("c_number");  
                            if(user.equals(username))
                               {  flag1=1;
                                  System.out.println("step1");
                                    if(pass.equals(password))
                                      {
                                          flag2=1;
                                         System.out.println("step2");
                                       if(contact.equals(mob))
                                        {
                                            flag3=1;
                                         System.out.println("step3 loged gps");
                                         response.sendRedirect("homegps?id="+mob+""); 
                                        }
                                      }
                               }
                              if(flag1==0||flag2==0||flag3==0)
                              {
                              response.sendRedirect("Login.html");
                              
                              }
                              }
                   }catch(Exception e){System.out.println(e);}
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
