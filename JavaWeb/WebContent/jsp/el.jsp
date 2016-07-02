<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,myjava.page.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Student student=new Student("张哈哈",20);
	//放入域中
	pageContext.setAttribute("student",student);
%>
<%--
	${student.name}  => <%=(Student)(pageContext.findAttribute("student")).getName()%> 
	
	student.name  =>name是方法getName() 后面Name小写，不是成员变量name
--%>

<h1>${student.name} -  ${student.age}</h1>

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
<hr />

	<ul>
		<li>${list[0].name} - ${list[0].age}</li>
		<li>${list[1].name} - ${list[1].age}</li>
		<li>${list[2].name} - ${list[2].age}</li>
	</ul>

	<ul>
		<li>${map['100'].name} - ${map['100'].age}</li>
		<li>${map['101'].name} - ${map['101'].age}</li>
		<li>${map['102'].name} - ${map['102'].age}</li>
	</ul>
	${true && false}
	${10>5}
</body>
</html>