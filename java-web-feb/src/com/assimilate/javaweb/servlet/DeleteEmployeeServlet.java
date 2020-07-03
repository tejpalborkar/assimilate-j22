package com.assimilate.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.JdbcConnection;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("id");
		Connection connection = JdbcTest.getConnection();
		String query = "delete from employee where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, id);
			int rowsDeleted= prepareStatement.executeUpdate();
			if(rowsDeleted >0) {
				System.out.println("Employee deleted successully..");
				writer.append("Employee deleted successully..");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllEmployeesServlet");
				requestDispatcher.include(request, response);
				
			}else {
				System.out.println("Employee not deleted..");
				writer.append("Employee not deleted..");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAllEmployeesServlet");
				requestDispatcher.include(request, response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
