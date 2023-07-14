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

/**
 * Servlet implementation class UpdateBatchServlet
 */
public class UpdateBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("<h3>Update Batch Details </h3>");
		out.print("<p>Student with ID "+request.getParameter("batchId")+"</p>");
		int id =Integer.parseInt(request.getParameter("batchId"));
		
		
		DB db = new DB();
		db.createConnection();

		Batch result = db.getBatch(id);
		
		db.closeConnection();
		
		out.println("<form action='UpdateBatch' method='post'>");
		out.println("<label>Batch Id </label><br>");
		out.println(" <input type='text' name='txtbatchid' value='"+result.getBatchId()+"' readonly><br/><br/>");
		out.println("<label>Time Slot</label><br>");
		out.println(" <input type='text' name='txttimeslot' value='"+result.getTimeSlot()+"' readonly><br/><br/>");
		out.println("<label>Total Slots </label><br>");
		out.println(" <input type='text' name='txttotalslot' value='"+result.getTotalslots()+"' ><br/><br/>");
		out.println("<label>Available Slots </label><br>");
		out.println(" <input type='text' name='txtavailslot' value='"+result.getAvailslots()+"' ><br/><br/>");
		out.println("<input type='submit' value='Add Batch' >");
		out.println("</form>");
		out.print("<a href='index.html'>Home</a>");
		out.print("</center>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Batch batch = new Batch();
		
		batch.setBatchId(Integer.parseInt(request.getParameter("txtbatchid")));
		batch.setTimeSlot(Time.valueOf(request.getParameter("txttimeslot")));
		batch.setTotalslots(Integer.parseInt(request.getParameter("txttotalslot")));
		batch.setAvailslots(Integer.parseInt(request.getParameter("txtavailslot")));
		
		DB db = new DB();
		db.createConnection();
		System.out.println("before updateBatch");
		int update = db.updateBatch(batch);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		String message ="";
		
		if(update>0) {
			message = "New Batch added with time slot"+batch.getTimeSlot();
		}
		else {
			message = "Not able to add new batch..Please try later.";
		}
		
		out.println("<h3>"+message+"</h3>");
		out.println("<a href='Batch.html'>Batch List</a>");
		out.println("<a href='index.html'>Back to Home </a>");
		out.print("</center>");
	}
}


