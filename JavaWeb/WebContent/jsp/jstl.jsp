<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,myjava.page.*"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Student> list=new ArrayList<Student>();
	list.add(new Student("rose",18));
	list.add(new Student("jack",28));
	list.add(new Student("luck",38));
	//放入域中
	pageContext.setAttribute("list",list);
	

	Map<String,Student> map=new HashMap<String,Student>();
	map.put("100",new Student("mark",20));
	map.put("101",new Student("maxwell",29));
	map.put("102",new Student("narci",10));
	//放入域中
	pageContext.setAttribute("map",map);
%>
<ul>
<c:forEach items="${list}" var="student" varStatus="varSta">
	<li>序号：${varSta.count }  姓名：${student.name }  年龄：${student.age }</li>
</c:forEach>
</ul>
<ul>
<c:forEach items="${map}" var="entry" >
	<li>序号：${entry.key }  姓名：${entry.value.name }  年龄：${entry.value.age }</li>
</c:forEach>
</ul>

<%
	String str="java-php-net";
	pageContext.setAttribute("str",str);
%>
<ul>
<c:forTokens items="${str}" delims="-" var="s">
	<li>${s}</li>
</c:forTokens>

<%-- <c:redirect url="http://www.baidu.com"></c:redirect> --%>
</ul>
</body>
</html>