<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Accessing elements from Declarative Tag from beginning of the page.</h2>
	<%
		out.print("App name..."+appName+"<br />");
		out.print(punchLine+"<br />");
		out.print("Discount .... "+getDiscount("JUMBO")+"<br />");
	%>

	<h2>Scriptlet Tag</h2>
	<%
		String s = "Welcome Taniya";
		String c = "Welcome to JSP";
		out.print(s+"........"+c);
	%>
	<h3>Declarative Tags</h3>
	<%!
		String appName = "eStore";
		String punchLine = "We deliver in no time";
		
		double getDiscount(String promocode){
			if(promocode.equals("JUMBO")){
				return 0.40;
			}
			return 0.20;
		}
	%>
	<%
		out.print("Name is :"+s);
		out.print("Discount is :"+getDiscount("APPY"));
	%>
	
	<h3>Expression Tags</h3>
	
	App Name is : <%= appName %>

</body>
</html>