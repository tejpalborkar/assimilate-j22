package com.assimilate.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assimilate.sms.model.Student;
import com.assimilate.sms.model.User;
import com.assimilate.sms.service.StudentService;
import com.assimilate.sms.service.UserService;
import com.assimilate.sms.service.ValidationUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("AddStudent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String rollNo = request.getParameter("rollNo");
		String mobile = request.getParameter("mobile");
		String course = request.getParameter("course");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setRollNo(Integer.valueOf(rollNo));
		student.setMobile(mobile);
		student.setCourse(course);
		
		User user = new User();
		user.setPassword(password);
		user.setUserName(userName);
		user.setRole("Student");
		
		
		
		boolean isStudentValid = ValidationUtil.validateStudent(student);
		boolean isUserValid = ValidationUtil.validateUser(user,confirmPassword);
		
		if(isStudentValid && isUserValid) {
			// create user
			UserService userService = new UserService();
			User userCreated =userService.createUser(user);
			// get the id of the newly created user and set it to the student
			
			StudentService studentService = new StudentService();
			studentService.createStudent(student);
			//create student 
			response.setContentType("text/html");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
			response.getWriter().write("Student record added");
			requestDispatcher.include(request, response);
			
		}else {
			response.setContentType("text/html");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddStudent.jsp");
			response.getWriter().write("Invalid student data");
			requestDispatcher.include(request, response);
		}

	}

}
