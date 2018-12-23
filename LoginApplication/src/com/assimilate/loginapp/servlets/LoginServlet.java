package com.assimilate.loginapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assimilate.loginapp.database.UserDboperations;
import com.assimilate.loginapp.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserDboperations userDb = new UserDboperations();

		User user = userDb.getUserByUserName(userName, password);

		if (user != null) {
			// credentials matched


			System.out.println("Inside login servlet User: " + user);

			HttpSession session = request.getSession();

			session.setAttribute("loggedInuser", user);

			request.setAttribute("user", user);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
			requestDispatcher.forward(request, response);
		} else {
			// credentials does not matched

			PrintWriter printWriter = response.getWriter();
			printWriter.write("<center>Sorry, username or password is incorrect </center>");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.include(request, response);

		}

	}

}
