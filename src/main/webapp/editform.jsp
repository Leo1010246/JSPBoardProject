<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.crud.dao.BoardDAO, com.crud.bean.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post">
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
<table>
	<tr><td>Name:</td><td><input type="text" name="name" placeholder="홍길동" value="<%= u.getName()%>"/></td></tr>
	<tr><td>Gender:</td><td><input type="radio" id="male" name="gender" value="남">
		                    <label for="male">남 </label>
		                    <input type="radio" id="female" name="gender" value="여">
		                    <label for="female">여 </label></td></tr>
	<tr><td>Phone Number:</td><td><input type="text" name="phone_number" placeholder="000-0000-0000" value="<%= u.getPhone_number()%>"/></td></tr>
	<tr><td>Email:</td><td><input type="text" name="email" placeholder="email" value="<%= u.getEmail()%>"/></td></tr>
	<tr><td>Address:</td><td><input type="text" name="address" placeholder="address" value="<%= u.getAddress()%>"/></td></tr>
	<tr><td>Birthday:</td><td><input type="text" name="birthday" placeholder="YYYY-MM-DD" value="<%= u.getBirthday()%>"/></td></tr>

    <tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>