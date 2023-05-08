<%@ page import ="com.techpalle.model.Student" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Page</title>
</head>
<body>
<center>
<h1>Student Details</h1>
<table border="1">
<thead>
	<tr>
	   <th> Sno</th>
		<th> Name</th>
		<th> Email</th>
		<th> Password</th>
		<th> Mobile</th>
	</tr>
</thead>
<tbody>
<%ArrayList<Student>s=(ArrayList<Student>)request.getAttribute("student");%>
<%for(Student item : s)
	{
%>
	<tr>
		<td><c:out value="<%= item.getSno()%>"></c:out></td>
		<td><c:out value="<%= item.getName()%>"></c:out></td>
		<td><c:out value="<%= item.getEmail()%>"></c:out></td>
		<td><c:out value="<%= item.getPassword()%>"></c:out></td>
		<td><c:out value="<%= item.getMobile()%>"></c:out></td>
		<td>
			<a href="editForm?sno=<c:out value="<%= item.getSno()%>"></c:out>">Edit</a>&nbsp;&nbsp;
			<a href="deleteForm?sno=<c:out value="<%= item.getSno()%>"></c:out>">Delete</a>
		</td>
	</tr>
<%
    }
%>
</tbody>
</table>
</center>
</body>
</html>