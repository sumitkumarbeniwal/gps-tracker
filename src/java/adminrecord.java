import java.sql.*;
class adminrecord
{

String Register(String username,String password,String phone)
{             database db=new database();
              Connection con=db.getCon();
              String a="";
               try{PreparedStatement ps = con.prepareStatement("insert into adminlogin values(?,?,?)");
                         ps.setString(1,username );     
                         ps.setString(2,password);      
                    	 ps.setString(3,phone);  
                  			   ps.executeUpdate();
               a="Record Updated";
               }
			   catch(SQLIntegrityConstraintViolationException e)
               {
                   a="Record Already Exist";
              
               }
	  catch(   Exception  ex1)
                         {     a="unable to add";
	                      System.out.println(ex1);
						    System.out.println(" catch");
			              }
               return a;
}

 String delete(String username)
 {String b="";
	  try {
                database db=new database();
                Connection con=db.getCon();
                System.out.println(username);
                
                PreparedStatement ps1 = con.prepareStatement("select  username from adminlogin where phone=?");           
		ps1.setString(1,username);
		ResultSet rs = ps1.executeQuery();
	              if( rs.next())                                                                           
			 {			 
		            PreparedStatement ps = con.prepareStatement("delete from adminlogin where phone=?");
                            ps.setString(1,username);                              
                            int rs1 = ps.executeUpdate();
                            b="data is deleted successfully";
                            
                            
                         }
        		else
					{
						b="enter id not present in the database";
					}       
                  }
              catch(Exception ex)
                 {   b="Something error";
                       System.out.println("exception in the code ");
                       System.out.println(ex);
                 }
          return b;
 }
 void update(String username,String password,String phone)
 {
	  try {
             database db=new database();
              Connection con=db.getCon();
			  System.out.println("in update");
			  PreparedStatement ps1 = con.prepareStatement("select  * from stuent_login where student_id=?");
                 ps1.setString(1,username);
						     System.out.println(username);
					  ResultSet rs = ps1.executeQuery();
					   if(rs.next())
						  {
                        PreparedStatement ps = con.prepareStatement("update adminlogin set password = ? , phone= ? where username = ?");
                              
                         ps.setString(3,username);  
                         ps.setString(1,password);      
                         ps.setString(2,phone);
                    ps.executeUpdate();
                             
	  }      
else{
	                    //go for the new register
}	  
	  }
         catch(SQLException ex)
         {System.out.println("exception occur");
                System.out.println(ex);
                
         }
 }/*
 public static void main(String [] abc)
 {
  admin ob=new admin();
  //ob.Register("a","a","a");
  
  ob.update("a","b","b");
  }*/
 }