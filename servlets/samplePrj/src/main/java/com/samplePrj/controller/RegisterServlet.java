package com.samplePrj.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("txtName");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtpassword");
		
		System.out.println("[Register Servlet] user Details :"+ userName +" "+email+" "+password);
		
		response.setContentType("text/html");
		String registerTimeStamp = new Date().toString();
		String htmlResponse = "<center><h3>Welcome "+userName +" You Registerd with "+ email+"</h3> You Registered in at "+registerTimeStamp +"</center>";
		
		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
	}

}
