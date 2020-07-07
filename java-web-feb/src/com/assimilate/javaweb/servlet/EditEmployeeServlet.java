package com.assimilate.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		String id = request.getParameter("id");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String userFromSession = (String) session.getAttribute("loggedInUser");
		if (userFromSession == null) {

			writer.write("Please login first.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.include(request, response);
			return;
		} else {

			Connection connection = JdbcTest.getConnection();
			String query = "select * from employee where id=?";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					int empId = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String age = resultSet.getString("age");

					writer.write("<form action=\"EditEmployeeServlet\" method=\"post\">\n"
							+ "		<label for=\"fname\">Employee Id:</label><br>\n"
							+ "		 <input type=\"text\"	id=\"id\" name=\"id\" value=" + empId + "><br>\n"
							+ "		 \n" + "		  <label  for=\"name\">Employee name:</label><br>\n"
							+ "		  <input type=\"text\"	id=\"name\" name=\"name\" value='" + name + "'><br>\n"
							+ "		  \n" + "		   <label  for=\"name\">Employee age:</label><br>\n"
							+ "		   <input type=\"text\" id=\"age\" name=\"age\" value=" + age + " ><br> <br>\n"
							+ "		    \n" + "		   <input type=\"submit\" value=\"Submit\">\n" + "	</form>");

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		System.out.println("Id:" + id);
		System.out.println("name:" + name);
		System.out.println("age:" + age);

		JdbcTest jdbcTest = new JdbcTest();
		Connection connection = jdbcTest.getConnection();
		String sql = "update employee set name=?, age=? where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, age);
			prepareStatement.setString(3, id);
			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println("Employee updated: " + executeUpdate);

			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.append("Employee updated successfully");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllEmployeesServlet");
			requestDispatcher.include(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
