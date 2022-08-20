package com.samples.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.samples.domain.Product;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		super();
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// reading values from the form
		Integer id = Integer.parseInt(request.getParameter("productId"));
		String price = request.getParameter("price");
		String category = request.getParameter("productCategory");
		String name = request.getParameter("productName");
		// Object for class
		Product pro = new Product();
		pro.setProductId(id);
		pro.setPrice(price);
		pro.setProductCategory(category);
		pro.setProductName(name);
		HttpSession session = request.getSession();
		session.setAttribute("Product", pro);
		response.sendRedirect("view.jsp");
		}
}