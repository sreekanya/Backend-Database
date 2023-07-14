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

/**
 * Servlet implementation class BatchServlet
 */
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB db = new DB();
		db.createConnection();
		
		ArrayList<Batch> result = db.getAllBatches();
		
		StringBuffer buffer = new StringBuffer();
		
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		out.print("<h3>List of Batches </h3>");
		if(result.size()>0) {
			buffer.append("<table>");
			buffer.append("<th>");
			buffer.append("<td>BatchId</td>");
			buffer.append("<td>Time Slot</td>");
			buffer.append("<td>Total Slots</td>");
			buffer.append("<td>Available Slots</td>");
			buffer.append("</th>");
			
			for(Batch batch : result) {
				buffer.append("<tr>");
				buffer.append("<td>"+batch.getBatchId()+"</td>");
				buffer.append("<td>"+batch.getTimeSlot()+"</td>");
				buffer.append("<td>"+batch.getTotalslots()+"</td>");
				buffer.append("<td>"+batch.getAvailslots()+"</td>");
				buffer.append("<td> <a href='DeleteBatch?batchId="+batch.getBatchId()+"'>DELETE</a> |"
						+" <a href='UpdateBatch?batchId="+batch.getBatchId()+"'>UPDATE</a></td>");
				buffer.append("</th>");
			}
		}
		else {
			buffer.append("<h3>No Batches Found.</h3>");
		}
		out.print(buffer.toString());
		out.println("<a href='Batch.html'>Back to Batch Menu</a>");
		out.println("<a href='index.html'>Back to Home </a>");
		out.print("</center>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Batch batch = new Batch();
		batch.setTimeSlot(Time.valueOf(request.getParameter("txttimeslot")));
		batch.setTotalslots(Integer.parseInt(request.getParameter("txttotalslot")));
		batch.setAvailslots(Integer.parseInt(request.getParameter("txttotalslot")));
		
		DB db = new DB();
		db.createConnection();
		int result = db.createBatch(batch);
		db.closeConnection();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center>");
		String message = "";
		if(result>0) {
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
