package packagw;


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


public class user_login_java extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public user_login_java() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ResultSet rs;
		PrintWriter out= response.getWriter();
		try
		{
			response.setContentType("text/html");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shyam","shyam");
			PreparedStatement ps=c.prepareStatement("select * from login where username=? and password=?");
			String  user_id=request.getParameter("email");
			String password=request.getParameter("password");

			
			ps.setString(1, user_id);
			ps.setString(2, password);
			rs=ps.executeQuery();
	       	 out.println("<html><body><h1 align='center'> BOOKING SUCCESSFULLY </h1><h3 align='center'>YOUR DETAILS</h3>");
	       	 
	       	out.println("<html><body><h3><a href='admin2.html'>Add</a></h3><h3><a href='#'>Delete</a></h3>");
			out.println("<table border='1'><tr><td>firstName</td><td>lastName</td><td>email</td><td>password</td><td>con_password</td><td>phoneNumber</td><td>travel from</td><td>travel to</td></tr>");

			if(rs.next())
			{
					out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
					ps=c.prepareStatement("select * from admin2");
					
			}
			else
			{
				out.println("hello");
			}
		out.println("</table></body></html>");
		

			c.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			out.println("hello");
			e.printStackTrace();
		} 
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
