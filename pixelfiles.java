package packagw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pixelfiles
 */
public class pixelfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pixelfiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		Scanner sc=new Scanner(System.in);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shyam","shyam");
			Statement s=c.createStatement();
			System.out.println("enter the id of employee");
			int id=sc.nextInt();
			System.out.println("enter the name of employee");
			String name=sc.next();
			System.out.println("enter the email of employee");
			String d_id=sc.next();
			int x=s.executeUpdate("create table Employee18(E_id number(28),Name varchar2(23),Email varchar2(23),D_id varchar2(90))");
			System.out.println(x);
			c.close();
		}catch(SQLException e){
			System.out.println(e);
			e.printStackTrace();
		    }
		catch(Exception i){
			
			System.out.println(i.getMessage());
			
			i.printStackTrace();
			
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("hello do post");
	}

}
