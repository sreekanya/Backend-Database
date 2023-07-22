<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.FitnessCenter.db.*" %>
<%@ page import = "java.sql.Time" %>
<%@ page import ="com.FitnessCenter.model.Participants" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//Time.valueOf(request.getParameter("txtbtime"));
	//select b.*  from Batch a, Participants b where a.batchId=b.batchId and a.timeslot='17:00:00';
	String batchTime = request.getParameter("txtbtime");
	
	ArrayList<Participants> participants = new ArrayList<Participants>();
	
	DB db = new DB();
	db.createConnection();
	
	try {
		
		//SimpleDateFormat timePattern = new SimpleDateFormat("hh-mm-ss");
		//LocalTime lt = LocalTime.parse("8:00");
	
		String sql = "select b.* from Batch a, Participants b where a.batchId=b.batchId and a.timeslot='"+batchTime+"'";
		System.out.println(sql);
		
		db.preparedStatement = db.connection.prepareStatement(sql);
		
		ResultSet set = db.preparedStatement.executeQuery(sql);
		
		while(set.next()) {
			Participants participant = new Participants();
			
			participant.setPid((set.getInt(1)));
			participant.setStudentFName(set.getString(2));
			participant.setStudentLName(set.getString(3));
			participant.setStudentEmail(set.getString(4));
			participant.setStudentPhone(set.getString(5));
			participant.setBatchId(set.getInt(6));
			
			participants.add(participant);
		}
		
		db.closeConnection();
		
	} catch (Exception e) {
		System.out.println("Exception Occured"+e);
	}
	StringBuffer buffer = new StringBuffer();
	response.setContentType("text/html");
	PrintWriter outPrintWriter = response.getWriter();
	outPrintWriter.print("<center>");
	outPrintWriter.print("<h3>List of Participants </h3>");
	if(participants.size()>0) {
		buffer.append("<table>");
		buffer.append("<th>");
		buffer.append("<td> ID</td>");
		buffer.append("<td>First Name</td>");
		buffer.append("<td>Last Name</td>");
		buffer.append("<td>Email </td>");
		buffer.append("<td>Phone number</td>");
		buffer.append("<td>Batch Registered</td>");
		buffer.append("</th>");
		
		for(Participants student : participants) {
			buffer.append("<tr>");
			buffer.append("<td>"+student.getPid()+"</td>");
			buffer.append("<td>"+student.getStudentFName()+"</td>");
			buffer.append("<td>"+student.getStudentLName()+"</td>");
			buffer.append("<td>"+student.getStudentEmail()+"</td>");
			buffer.append("<td>"+student.getStudentPhone()+"</td>");
			buffer.append("<td>"+student.getBatchId()+"</td>");
			
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
	
	

%>