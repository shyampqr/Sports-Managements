package packagw;

import java.sql.*;

public class login {
Connection c;
PreparedStatement ps;
ResultSet rs;
String username;
public login() {
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		 c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shyam","shyam");
		
		
	}catch(SQLException e){
		System.out.println(e);
		e.printStackTrace();
	    }
	catch(Exception i){
		
		System.out.println(i.getMessage());
		
		i.printStackTrace();
		
	}
}
public String getlogin(String userid,String pass){
try{

	ps=c.prepareStatement("select username,contact from register where email=? and passoword=?");
	ps.setString(1, userid);
	ps.setString(2,pass);
   rs=ps.executeQuery();
   if(rs.next()){
	   username=rs.getString(1);
	   System.out.println(username);
   }
   c.close();
}
catch(Exception e){
	System.out.println(e.getMessage());
	
	e.printStackTrace();
	
}
return username;
}}
	
