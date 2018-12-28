package com.assimilate.loginapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assimilate.loginapp.database.EmployeeDbOperations;
import com.assimilate.loginapp.model.Employee;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/RegisterEmployeeServlet")
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

		response.sendRedirect("register-employee.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String department = request.getParameter("department");

		try {
			EmployeeDbOperations employeeDbOperations = new EmployeeDbOperations();

			employeeDbOperations.insert(name, Integer.parseInt(salary), department);
			response.sendRedirect("employees.jsp");
			return;

		} catch (Exception e) {

			System.out.println("Invalid salary: " + salary);
			e.printStackTrace();
		}

		response.sendRedirect("employees.jsp");

	}

}
