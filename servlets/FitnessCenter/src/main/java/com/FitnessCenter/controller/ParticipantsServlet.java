package com.FitnessCenter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;

import com.FitnessCenter.db.DB;
import com.FitnessCenter.model.Batch;
import com.FitnessCenter.model.Participants;

/**
 * Servlet implementation class ParticipantsServlet
 */
public class ParticipantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB();
		db.createConnection();
		
		ArrayList<Participants> result = db.getAllParticipant();
		
		StringBuffer buffer = new StringBuffer();
		
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("<h3>List of Participants </h3>");
		if(result.size()>0) {
			buffer.append("<table>");
			buffer.append("<th>");
			buffer.append("<td> ID</td>");
			buffer.append("<td>First Name</td>");
			buffer.append("<td>Last Name</td>");
			buffer.append("<td>Email </td>");
			buffer.append("<td>Phone number</td>");
			buffer.append("<td>Batch Registered</td>");
			buffer.append("</th>");
			
			for(Participants student : result) {
				buffer.append("<tr>");
				buffer.append("<td>"+student.getPid()+"</td>");
				buffer.append("<td>"+student.getStudentFName()+"</td>");
				buffer.append("<td>"+student.getStudentLName()+"</td>");
				buffer.append("<td>"+student.getStudentEmail()+"</td>");
				buffer.append("<td>"+student.getStudentPhone()+"</td>");
				buffer.append("<td>"+student.getBatchId()+"</td>");
				buffer.append("<td> <a href='DeleteParticipant?pId="+student.getPid()+"'>DELETE</a> |"
						+ " <a href='UpdateParticipant?pId="+student.getPid()+"'>UPDATE</a></td>");
				buffer.append("</th>");
			}
		}
		else {
			buffer.append("<h3>No Students Found.</h3>");
		}
		out.print(buffer.toString());
		out.println("<a href='Participants.html'>Back to Participants Menu</a>");
		out.println("<a href='index.html'>Back to Home </a>");
		out.print("</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Participants student = new Participants();
		student.setStudentFName(request.getParameter("txtfname"));
		student.setStudentLName(request.getParameter("txtlname"));
		student.setStudentEmail(request.getParameter("txtemail"));
		student.setStudentPhone(request.getParameter("txtphone"));
		student.setBatchId(Integer.parseInt(request.getParameter("txtbatch")));
		
		DB db = new DB();
		db.createConnection();
		int result = db.createParticipant(student);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		String message = "";
		if(result>0) {
			message = "New Participant added ";
		}
		else {
			message = "Not able to add new Participant..Please try later.";
		}
		out.print("<h3>"+message+"</h3>");
		out.println("<a href='Participants.html'>Participants List</a>");
		out.println("<a href='index.html'>Back to Home </a>");
		out.print("</center>");
		
	}
	

}
