package com.samplePrj.controller;

import jakarta.servlet.ServletConfig;
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
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	
    	System.out.println("[Hello Servlet] init executed");
    	
    	//String url = config.getInitParameter("url");
    	
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[Hello Servlet] - service executed");
		System.out.println("Welcome to servlet");
		
		response.setContentType("text/html");
		String htmlResponse = "<center><h3>Welcome to Home Admin</h3>"
				+ "<p>Request Served at "+new Date() +"</p>"
						+ "<p><a href='add-products.html'>ADD PRODUCT</a><p></center>";
		
		/*
		PrintWriter out = response.getWriter();
		out.print(htmlResponse);
		
		Cookie[] array = request.getCookies();
		for(Cookie cookie : array) {
			out.print("<center><p>"+cookie.getName()+" - "+cookie.getValue()+"</p></center>");
		}
		*/
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("[Hello Servlet] - destroy executed");
	}

}
