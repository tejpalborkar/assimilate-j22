package com.assimilate.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
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

		if ("tejpal".equals(userName) && "test123".equals(password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome-servlet");
			dispatcher.forward(request, response);

		} else {
			response.setContentType("text/html");
			response.getWriter()
					.write("<center><b><p> style='color:red'>Incorrect userName or password..</p></b></center>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);

		}

	}

}
