package com.samplePrj.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String EMAIL = "admin@sample.com"; 
	private final String PASSWORD = "Admin*123"; 
	
	private final String NAME = "John";
	private final int TOTAL_SALES = 3000;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtpassword");
		
		//System.out.println("[Login servlet ] user Details :"+email+" "+password);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("<p>Welcome to Home<br /><a href='Home'>Click to Navigate to Home</a></p></center>");
		
		/*String message = "";
		
		if(email.equals(EMAIL)&&password.equals(PASSWORD)) {
			
			Cookie cookie1 = new Cookie("KEY_NAME",NAME);
			Cookie cookie2 = new Cookie("KEY_SALES",String.valueOf(TOTAL_SALES));
			
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			message = "<p>Welcome to Home</p><a href='Home'>Click here to navigate to Home</a>";
		}
		else {
			message = "<b>Invalid username and password</b>";
		}
		
		String loginTimeStamp = new Date().toString();
		String htmlResponse = "<center><h3>Welcome "+ email+"</h3> <p>You logged in at "
				+loginTimeStamp +"</p><p>"+message+"</p></center>";
		
		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
		*/
	}
	

}
