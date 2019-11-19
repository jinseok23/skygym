<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<%
	String msg=(String)request.getAttribute("msg");
	String loc=request.getContextPath()+(String)request.getAttribute("loc");
	String script=(String)request.getAttribute("script");
%>
<body>
	<script>
		<%if(msg != null)
		{%>
		alert('<%= msg %>');
		<%}%>
		
		location.href="<%=loc%>"; 
		<%= script!=null?script:""%>;
	</script>
</body>
</html>
