package crudoperation;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String  param=request.getParameter("id");
		
		//converting string to int
		int  id=  Integer.parseInt(param);
		
		String name=request.getParameter("pname");	
		BigDecimal price=new BigDecimal(request.getParameter("pprice"));
		
		Properties props= new Properties();
		
		InputStream  in= getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
	
		Connection  conn=DBConfig.getConnection(props);
		
		if(conn!=null) {
			
			try {
				
				//update operation
				PreparedStatement  stmt= conn.prepareStatement("update eproduct set name=?,price=? where id=?");
				
			
				stmt.setString(1, name);
				stmt.setBigDecimal(2, price);
				stmt.setInt(3, id);
				int rs=stmt.executeUpdate();
				
				
				
				if(rs>0) {
					System.out.println(rs+ "Row updated successfully");
					 response.sendRedirect("list");
				}else {
					System.out.println("Error  while updating data");
					response.sendRedirect("index.html");
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
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
