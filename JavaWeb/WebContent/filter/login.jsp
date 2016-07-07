<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frmLogin" action="${pageContext.request.contextPath }/LoginServlet" method="post">
  	   用户名: <input type="text" name="userName"><br/>
  	  <input type="submit" value="POST提交" >
  	</form>
  	<hr/>
  	<form name="frmLogin" action="${pageContext.request.contextPath }/LoginServlet" method="get">
  	   用户名: <input type="text" name="userName"><br/>
  	  <input type="submit" value="GET提交" >
  	</form>
</body>
</html>