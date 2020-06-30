package com.assimilate.javaweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("Id:"+id);
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		
		JdbcTest jdbcTest = new JdbcTest();
		Connection connection = jdbcTest.getConnection();
		String sql = "insert into employee values(?,?,?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setString(3, age);
			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println("Employee inserted: "+executeUpdate);
			response.setContentType("text/html");
			response.getWriter().append("Employee created");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllEmployeesServlet");
		//	requestDispatcher.forward(request, response);
			
			response.sendRedirect("ViewAllEmployeesServlet");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
