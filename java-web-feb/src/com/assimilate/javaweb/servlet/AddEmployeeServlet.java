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
import javax.servlet.http.HttpSession;

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

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String userFromSession = (String) session.getAttribute("loggedInUser");
		if (userFromSession == null) {
			response.getWriter().write("Please login first.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			return;
		} else {

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			System.out.println("Id:" + id);
			System.out.println("name:" + name);
			System.out.println("age:" + age);

			JdbcTest jdbcTest = new JdbcTest();
			Connection connection = jdbcTest.getConnection();
			String sql = "insert into employee(name,age,username,password) values(?,?,?,?)";
			try {
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, age);
				prepareStatement.setString(3, userName);
				prepareStatement.setString(4, password);
				int executeUpdate = prepareStatement.executeUpdate();
				System.out.println("Employee inserted: " + executeUpdate);

				

				response.getWriter().append("Employee created");

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllEmployeesServlet");
				// requestDispatcher.forward(request, response);
				// include

				response.sendRedirect("ViewAllEmployeesServlet");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
