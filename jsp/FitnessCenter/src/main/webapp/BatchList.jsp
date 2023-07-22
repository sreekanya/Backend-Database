<%@ page import = "com.FitnessCenter.model.Batch" %>
<%@ page import = "com.FitnessCenter.DB.DB" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	DB db = DB.getDB();
	
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
	

%>