package com.assimmilate.javafeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnotherServlet
 */
public class AnotherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnotherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		writer.append("Company Name: "+servletContext.getAttribute("company-name"));
		servletContext.removeAttribute("company-name");
		
		//set attributes at application scope
		servletContext.setAttribute("user", "Tejpal");
		
		//Set attributes in request scope
		request.setAttribute("user", "Tejpal");
		
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		session.invalidate();
		//set attributes in session scope
		session.setAttribute("loggedinuser", "Tejpal");
		
		String loggedInUser = (String) session.getAttribute("loggedinuser");
		writer.append("Logged in user : "+loggedInUser);
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
