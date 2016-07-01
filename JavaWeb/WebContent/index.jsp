<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
	import="java.util.*,java.text.*"
    pageEncoding="UTF-8"
    errorPage="error.jsp"
    isErrorPage="false"
 	buffer="100kb"
 	session="true"
 	isELIgnored="false"   
    
   %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="common/header.jsp" %>
<%
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String curDate=sdf.format(new Date());
	out.write("当前时间为："+curDate);	
	
	int a=20,b=30;
%>
<h1><%=curDate %></h1>

<h5><%=a+b %></h5>

<ul>
	<% for(int i=1;i<=6;i++){%>
		<li>标题<%=i %></li>
	<%} %>
</ul>
<hr>
<!--九九乘法表  -->
	<%	for(int i=1;i<=9;i++){ //行
			for(int j=1;j<=i;j++){//公式
	%>
				<%=i%>x<%=j %>=<%=(i*j) %>&nbsp;
		<%}%>
		<br>
	<%	
		}
	%>
</body>
</html>