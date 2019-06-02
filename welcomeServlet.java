package packagw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class welcomeServlet
 */
public class welcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig con = getServletConfig();
		//String img = con.getInitParameter("img");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String name3=request.getParameter("name1");
		String np=request.getParameter("n2");
		String nc=request.getParameter("n3");
		String nc1=request.getParameter("n4");
		
		 try{
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			
 			 Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shyam","shyam");
 			
 			Statement st=c.createStatement();
 			st.executeUpdate("insert into admin2 values('"+name3+"','"+np+"','"+nc+"','"+nc1+"')");
 					out.println("<h3>your registration successfully completed</h3>");
 					session.setAttribute("name2", name3);
 					session.setAttribute("n2", np);
 					session.setAttribute("n3", nc);

 					session.setAttribute("n4", nc1);
 					out.println("<html>");
 					out.println("<body background='"+"'>");
 					out.println("   "+name3+"     ");
 					out.println("    "+np+"       ");
 					out.println("    "+nc+"        ");
 					out.println("    "+nc1+"        ");
 					out.println("<br> <a href='index.html'> taur</a>");
 					out.println("</body>");
 					out.println("</html>");

 					RequestDispatcher rd = request.getRequestDispatcher("signin.html");
 					rd.include(request, response);
 			//response.sendRedirect("signin.html");
 		//	response.sendRedirect("<h3>your registration successfully completed</h3>");
 		}
 	 
 	 catch(SQLException e){
 			System.out.println(e);

 			response.sendRedirect("index.html");
 			e.printStackTrace();
 		    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

 	 			response.sendRedirect("index.html");
			e.printStackTrace();
		}
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
