package com.FitnessCenter.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

import com.FitnessCenter.db.DB;
import com.FitnessCenter.model.Batch;
import com.FitnessCenter.model.Participants;

/**
 * Servlet implementation class UpdateParticipantServlet
 */
public class UpdateParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("<h3>Update Participant Details </h3>");
		out.print("<p>Student with ID "+request.getParameter("pId")+"</p>");
		int id =Integer.parseInt(request.getParameter("pId"));
		
		
		DB db = new DB();
		db.createConnection();

		Participants result = db.getParticipants(id);
		
		db.closeConnection();
		
		out.println("<form action='UpdateParticipant' method='post'>");
		
		out.println("<label>Participant Id </label><br>");
		out.println(" <input type='text' name='txtpid' value='"+result.getPid()+"' readonly><br/><br/>");
		
		out.println("<label>Enter First Name Slot</label><br>");
		out.println(" <input type='text' name='txtfname' value='"+result.getStudentFName()+"'><br/><br/>");
		
		out.println("<label>Enter Last Name </label><br>");
		out.println(" <input type='text' name='txtlname' value='"+result.getStudentLName()+"' ><br/><br/>");
		
		out.println("<label>Enter Email </label><br>");
		out.println(" <input type='text' name='txtemail' value='"+result.getStudentEmail()+"' ><br/><br/>");
		
		out.println("<label>Enter Phone Number </label><br>");
		out.println(" <input type='text' name='txtphone' value='"+result.getStudentPhone()+"' ><br/><br/>");
		
		out.println("<label>Enter BatchID</label><br>");
		out.println(" <input type='text' name='txtbid' value='"+result.getBatchId()+"' ><br/><br/>");
		
		out.println("<input type='submit' value='Update Participant' >");
		
		out.println("</form>");
		out.print("<a href='index.html'>Home</a>");
		out.print("</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Participants student = new Participants();
	
		student.setPid(Integer.parseInt(request.getParameter("txtpid")));
		student.setStudentFName(request.getParameter("txtfname"));
		student.setStudentLName(request.getParameter("txtlname"));
		student.setStudentEmail(request.getParameter("txtemail"));
		student.setStudentPhone(request.getParameter("txtphone"));
		student.setBatchId(Integer.parseInt(request.getParameter("txtbid")));
		
		DB db = new DB();
		db.createConnection();

		int update = db.updateParticipant(student);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		String message ="";
		
		if(update>0) {
			message = "New Participant Updated with time slot";
		}
		else {
			message = "Not able to Update Participant...Please try later.";
		}
		
		out.println("<h3>"+message+"</h3>");
		out.println("<a href='Participants.html'>Participants List</a>");
		out.println("<a href='index.html'>Back to Home </a>");
		out.print("</center>");
	}
	

}
