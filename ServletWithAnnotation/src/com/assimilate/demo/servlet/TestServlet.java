package com.assimilate.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test-servlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().write("Executing Test Servlet");
		String user = request.getParameter("user");

		System.out.println("Logged in user: " + user);

		Employee employee = new Employee();
		employee.setMobile(123456);
		employee.setName("Tejpal Borkar");

		System.out.println("Employee in first servlet: " + employee);

		response.getWriter().write("Employeee : "+employee.getName());
		RequestDispatcher rd = request.getRequestDispatcher("another-servlet");

		
		request.setAttribute("employee", employee);
		
		getServletContext().setAttribute("employee", employee);
//		rd.forward(request, response);
		
		

	}

}
