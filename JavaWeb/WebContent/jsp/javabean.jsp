<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,myjava.page.Student"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Student stu=new Student();
	stu.setName("rose");
	stu.setAge(20);
	stu.getName();
%>

<!-- 创建对象 -->
<jsp:useBean id="student" class="myjava.page.Student"></jsp:useBean>

<!--赋值  setName()-->
<jsp:setProperty property="name" name="student" value="jacky"/>

<!--获取  getName()-->
<jsp:getProperty property="name" name="student"/>
</body>
</html>