package com.assimilate.employeeapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assimilate.employeeapp.database.EmployeeDao;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/delete-employee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
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
		employeeDao.deleteEmployee(employeeId);
		response.sendRedirect("welcome.jsp");
	}

}
