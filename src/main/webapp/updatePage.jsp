<%@ page import ="com.techpalle.model.Student" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<form action="update">
<% Student s=(Student)request.getAttribute("student"); %>

<h1 align="center">Update Form</h1>

<table align="center">
<tr>
<td></td>
<td><input type="text" value="<%= s.getSno()%>" name="sno" hidden="hidden"/></td>
</tr>
<tr>
<td>NAME</td>
<td><input type="text" value="<%= s.getName() %>" name="tbname"/></td>
</tr>

<tr>
<td>EMAIL</td>
<td><input type="email" value="<%= s.getEmail() %>"name="tbemail"/></td>
</tr>
<tr>
<td>PASSWORD</td>
<td><input type="password" value="<%= s.getPassword() %>"name="tbpw"/></td>
</tr>
<tr>
<td>MOBILE NO</td>
<td><input type="tel" value="<%= s.getMobile() %>"name="tbmob"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="UPDATE"/></td>
</tr>

</table>
</form>

</body>
</html>