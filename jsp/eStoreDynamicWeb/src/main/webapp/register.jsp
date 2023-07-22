
<%@page import="com.eStore.db.DB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.eStore.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	Users user = new Users();
	user.name = request.getParameter("txtName");
	user.email = request.getParameter("txtEmail");
	user.password = request.getParameter("txtPassword");
	
	DB db = DB.getDB();
	
	String sql = "insert into users values(null, ?,?,?)";
	PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
	preparedStatement.setString(1,user.email);
	preparedStatement.setString(2,user.password);
	preparedStatement.setString(3,user.name);
	
	int result = db.executeUpdate(preparedStatement);
	
	if(result>1){
%>   
	<h3>Thank you for Registration <%= user.name %></h3>
<%
	}
	else{
%>	
	<h3>Registration Failed <%= user.name %></h3>

<%	
	}
	
%>