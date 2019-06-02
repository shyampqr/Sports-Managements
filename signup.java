package packagw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	        String username1=request.getParameter("name");
			String email1=request.getParameter("email");
			String password1=request.getParameter("pass");
			String contact1=request.getParameter("cont");
			        	 try{
			        			Class.forName("oracle.jdbc.driver.OracleDriver");
			        			
			        			 Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shyam","shyam");
			        			
			        			Statement st=c.createStatement();
			        			st.executeUpdate("insert into register values('"+username1+"','"+email1+"','"+password1+"','"+contact1+"')");
			        					System.out.println("<h3>your registration successfully completed</h3>");
			        			
			        			response.sendRedirect("signin.html");
			        			response.sendRedirect("<h3>your registration successfully completed</h3>");
			        		}
			        	 
			        	 catch(SQLException e){
			        			System.out.println(e);
			        			e.printStackTrace();
			        		    } catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
