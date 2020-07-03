package com.assimmilate.javafeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigDemo
 */
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConfigDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		ServletConfig servletConfig = getServletConfig();
		String dbUrl = servletConfig.getInitParameter("database-url");
		String user = servletConfig.getInitParameter("database-user");
		String password = servletConfig.getInitParameter("database-password");
		
		System.out.println("db url: " + dbUrl);
		System.out.println("user: " + user);
		System.out.println("password: " + password);
		
		ServletContext servletContext = getServletContext();
		String dbUrlfromContext = servletContext.getInitParameter("database-url");
		
		PrintWriter writer = response.getWriter();
		writer.append("db URL from context: "+dbUrlfromContext);
		
		servletContext.setAttribute("company-name", "Assimilate Technology");
		
		writer.append("Company Name: "+servletContext.getAttribute("company-name"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
