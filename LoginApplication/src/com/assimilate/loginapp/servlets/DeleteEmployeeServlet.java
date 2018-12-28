package com.assimilate.loginapp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assimilate.loginapp.database.EmployeeDbOperations;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empId = request.getParameter("employeeId");

		if (empId == null) {
			System.out.println("Employeed id is null");
			response.sendRedirect("employees.jsp");
		}
		try {
			Integer employeeId = Integer.parseInt(empId);

			EmployeeDbOperations employeeDbOperations = new EmployeeDbOperations();
			employeeDbOperations.delete(employeeId);
		} catch (Exception e) {

			System.out.println("Invalid employee id: " + empId);
		}
		response.sendRedirect("employees.jsp");

	}
}
