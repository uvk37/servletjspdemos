package uservalidation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginChecker
 */
@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginChecker() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("txtUname");
		String pword = request.getParameter("txtPassword");
		PrintWriter out = response.getWriter();
		if (uname.equalsIgnoreCase("uvk@gmail.com") && pword.equals("Uvk@123")) {
			out.println("You are Welcomed");
		} else
			out.println("Invalid Username or Password");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String uname = request.getParameter("txtUname");
		String pword = request.getParameter("txtPassword");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		if (uname.equalsIgnoreCase("uvk@gmail.com") && pword.equals("Uvk@123")) {
			
			HttpSession session = request.getSession(true);// create a new object and store its reference in session
															// object
			session.setAttribute("username", uname);

			rd = request.getRequestDispatcher("Welcome");
			rd.forward(request, response);
		} else {
			out.println("Invalid UserID or Password");
			rd = request.getRequestDispatcher("LoginForm.html");
			rd.include(request, response);
		}
	}


}
