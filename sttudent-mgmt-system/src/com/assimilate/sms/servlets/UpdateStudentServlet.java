package com.assimilate.sms.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assimilate.sms.business.StudentService;
import com.assimilate.sms.model.Student;

/**
 * Servlet implementation class RegisterStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentServlet() {
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String rollNumber = request.getParameter("rollNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Student student = new Student();

		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setMobile(mobile);
		student.setRollNo(Integer.parseInt(rollNumber));
		student.setEmail(email);
		student.setPassword(password);
		System.out.println(student);
		StudentService studentService = new StudentService();
		studentService.update(student);

		response.sendRedirect("home.jsp");

	}

}
