<%@page import="entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询学生信息页面</title>
</head>
<body>
	<form action="Query" methed="post">
		<h1>查询学生信息</h1>
		请输入需要查询的编号：<input type="text" name="id" value=""/>
		<input type="submit" value="查询">
	</form>
	<table>
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
		<%
			List<Student> list=(List<Student>)request.getAttribute("list");
		 	
			if(list!=null){
				for(Student s:list){
					%>
					<tr>
						<td><%=s.getId() %></td>
						<td><%=s.getName() %></td>
						<td><%=s.getAge() %></td>
					</tr>
					<%
				}
			}
		%>
	</table>
</body>
</html>