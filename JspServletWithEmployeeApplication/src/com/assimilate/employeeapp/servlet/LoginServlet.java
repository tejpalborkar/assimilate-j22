package com.assimilate.employeeapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assimilate.employeeapp.model.Employee;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

		ServletContext context = getServletContext();

		Employee employee = (Employee) context.getAttribute(userName);
		response.setContentType("text/html");
		if (employee == null) {

			// employee is not registered

			// show error
			response.getWriter().write("<center><p color='red'>Incorect username or password </p></center>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

			rd.include(request, response);
		} else {
			// Employee is registered and found in context
			String employeeOriginalPassword = employee.getPassword();

			if (employeeOriginalPassword.equals(password)) {
				// login successful
				// redirect user to homepage

				response.sendRedirect("welcome.jsp");
				
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser", employee);

			} else {
				response.getWriter().write("<center><p color='red'>Incorect username or password </p></center>");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}

		}
	}

}
