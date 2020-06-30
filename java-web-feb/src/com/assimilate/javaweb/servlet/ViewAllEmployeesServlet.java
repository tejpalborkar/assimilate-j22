package com.assimilate.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllEmployeesServlet
 */
@WebServlet("/ViewAllEmployeesServlet")
public class ViewAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = JdbcTest.getConnection();
		String query = "select * from employee";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			printWriter.write("<table \"width:50%, border=1\">");
			printWriter.write("<tr>\n" + 
					"    <th>Id</th>\n" + 
					"    <th>name</th>\n" + 
					"    <th>Age</th>\n" + 
					"  </tr>");
			while (resultSet.next()) {
				printWriter.write("<tr>\n" + 
						"    <td>"+resultSet.getInt("id")+"</td>\n" + 
						"    <td>"+resultSet.getString("name")+"</td>\n" + 
						"    <td>"+ resultSet.getInt("age") + "</td>\n"
						+ "  </tr>");
			}
			printWriter.write("</table>");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
