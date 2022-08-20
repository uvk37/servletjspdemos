
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DBOperation
 */
@WebServlet("/DBOperation")
public class DBOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//to read and show html content on web page this is required
		response.setContentType("text/html");
		
		InputStream input=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		Properties props=  new Properties();
		props.load(input);
		
		
		Connection conn=DBConfig.getConnection(props);
		
		try {
			
			
			Statement stmt=conn.createStatement();
			
			
			//SQL  query
			int  x= stmt.executeUpdate("create database db");
			
			if(x>0)
				out.print("Database Created Successfully<br>");
			else
				out.print("Database already exist<br>");
			
			//SQL  query
			stmt.execute("use db");
			
			out.print("Database is Selected<br>");
			
			//SQL  query
			stmt.execute("drop database db");
			
			out.print("Database Dropped Successfully<br>");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
