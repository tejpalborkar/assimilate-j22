package com.assimilate.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo-servlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("User name and password from get request: " + userName + ":" + password);
		
		response.getWriter().write("Welcome, "+userName);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Executing doPost");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("User name and password from get request: " + userName + ":" + password);
		
		
		if("tejpal".equals(userName) && "test123".equals(password)) {
			response.getWriter().write("Welcome, "+userName);
		}else
			response.getWriter().write("Incorrect username or password... ");

		
	}

}
