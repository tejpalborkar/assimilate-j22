package com.assimilate.employeeapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assimilate.employeeapp.model.Employee;

/**
 * Servlet implementation class RegisterEmployeeServlet
 */
@WebServlet("/register-employee")
public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterEmployeeServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setPassword(password);
		emp.setUserName(userName);

		ServletContext context = getServletContext();

		// <user-name>, emp
		context.setAttribute(emp.getUserName(), emp);

		List<Employee> alreadyRegisteredEmployees = (List<Employee>) context.getAttribute("registeredUsers");
		if (alreadyRegisteredEmployees == null) {
			List<Employee> employeeList = new ArrayList<>();
			employeeList.add(emp);
			context.setAttribute("registeredUsers", employeeList);
		} else {
			alreadyRegisteredEmployees.add(emp);
		}

		HttpSession session = request.getSession();

		if (session == null) {
			response.sendRedirect("login.jsp");
		} else {
			Employee loggedInUser = (Employee) session.getAttribute("loggedInUser");
			if (loggedInUser == null) {
				response.sendRedirect("login.jsp");
			} else {
				response.sendRedirect("welcome.jsp");
			}

		}

	}

}
