<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="com.eStore.db.DB"%>
<%@ page import="com.eStore.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Users user = new Users();
	user.email = request.getParameter("txtEmail");
	user.password = request.getParameter("txtPassword");
	
	DB db =  DB.getDB();
	
	String sql = "select * from users where email = ? and password = ?";
	
	PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
	preparedStatement.setString(1,user.email);
	preparedStatement.setString(2,user.password);
	
	ResultSet set = db.executeQuery(preparedStatement);
	
	if(set != null && set.next()){
		user.name = set.getString("name");
		//user.uid =  set.getInt("uid");
%>		
	<h3>Welcome Back....... <%=  user.name %> </h3>
<%
	}
	else{
%>	
	<h3>Login Failed...Please try again later</h3>
<%		
	}

%>