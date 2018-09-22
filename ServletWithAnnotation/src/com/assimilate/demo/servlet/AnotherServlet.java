package com.assimilate.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnotherServlet
 */
@WebServlet("/another-servlet")
public class AnotherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		
		Employee e =(Employee) getServletContext().getAttribute("tejpal");
		
		
		response.getWriter().write("Employee: "+e.getName());
		
		
		/*response.getWriter().write("Executing Another Servlet");
		Employee employee =(Employee) request.getAttribute("employee");
		response.getWriter().write("Employee name: "+employee.getName());*/
		
		
	}

	}
