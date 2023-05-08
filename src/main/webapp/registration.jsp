<%@ page import ="com.techpalle.model.Student" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<form action="insert" method="post">
<h1 align="center">Welcome to Registration</h1><br><br> 
<table align="center">
<tr>
<td></td>
<td><input type="text" name="sno" hidden="hidden"/></td>
</tr>
<tr>
<td>NAME</td>
<td><input type="text" name="tbname"/></td>
</tr>
<tr>
<td>EMAIL</td>
<td><input type="email" name="tbemail"/></td>
</tr>
<tr>
<td>PASSWORD</td>
<td><input type="password" name="tbpw"/></td>
</tr>
<tr>
<td>MOBILE NO</td>
<td><input type="tel" name="tbmob"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="SAVE"/></td>
</tr>

</table>
</form>

</body>
</html>