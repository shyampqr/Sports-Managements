package packagw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class data_get
 */
public class data_get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		PrintWriter out= response.getWriter();
		
		try
		{
			response.setContentType("text/html");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shyam","shyam");
			
			PreparedStatement ps=c.prepareStatement("select * from login2");
			rs=ps.executeQuery();
			out.println("<html><body><h3><a href='#'>Add</a></h3><h3><a href='#'>Delete</a></h3><br><br><table border='1'><tr><td>cricket</td><td>basketball</td><td>vollyball</td><td>kabaddi</td></td></tr>");
			while(rs.next())
			{
			out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>></tr>");
			}
			out.println("</table></body></html>");
			while(rs.next())
			{
				System.out.print(rs.getString(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getString(4)+" ");
				System.out.println("");
			
			}
			
			c.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		} 
	}	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
