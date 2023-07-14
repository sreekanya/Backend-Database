package com.FitnessCenter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.FitnessCenter.db.DB;

/**
 * Servlet implementation class DeleteParticipantServlet
 */
public class DeleteParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteParticipantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		
		int id =Integer.parseInt(request.getParameter("pId"));
		
		DB db = new DB();
		db.createConnection();
		
		int result = db.deleteParticipant(id);
		db.closeConnection();
		
		if(result>0) {
			out.print("<h3>Participant Deleted Successfully</h3>");
		}
		else{
			out.print("<h3>Not Able to Delete.. Please try again later.</h3>");
		}
		out.print("<a href='index.html'>Home</a>");
		out.print("</center>");
		
	}
	

}
