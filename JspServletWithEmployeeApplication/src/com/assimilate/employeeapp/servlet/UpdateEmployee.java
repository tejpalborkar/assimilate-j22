package com.assimilate.employeeapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assimilate.employeeapp.database.EmployeeDao;
import com.assimilate.employeeapp.model.Employee;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/update-employee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id =request.getParameter("employeeId");
		
		Integer employeeId= Integer.parseInt(id);
		
		
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee =employeeDao.getEmployeeById(employeeId);
		
		request.setAttribute("employee", employee);
		
		RequestDispatcher rd =request.getRequestDispatcher("register-employee.jsp");
		rd.forward(request, response);
		
	}

}
