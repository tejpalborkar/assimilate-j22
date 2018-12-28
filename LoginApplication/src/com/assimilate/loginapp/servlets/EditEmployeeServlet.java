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
@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEmployeeServlet() {
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
			Employee employee = employeeDbOperations.getEmployeeByEmployeeId(employeeId);

			if (employee == null) {
				System.out.println("Employee not found");
			} else {
				request.setAttribute("employee", employee);
				RequestDispatcher rd = request.getRequestDispatcher("edit-employee.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {

			System.out.println("Invalid employee id: " + empId);
		}
		response.sendRedirect("employees.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("employeeId");
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String department = request.getParameter("department");
		
		
		try {
			Integer employeeId = Integer.parseInt(empId);
			EmployeeDbOperations employeeDbOperations = new EmployeeDbOperations();
			
			employeeDbOperations.update(employeeId,name, salary, department);
			response.sendRedirect("employees.jsp");

			
		} catch (Exception e) {

			System.out.println("Invalid employee id: " + empId);
		}

	}

}
