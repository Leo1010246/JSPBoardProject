<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post">
<table>
    <tr><td>Name:</td><td><input type="text" name="name" placeholder="홍길동"/></td></tr>
    <tr><td>Gender:</td><td><input type="radio" id="male" name="gender" value="남">
                            <label for="male">남 </label>
                            <input type="radio" id="female" name="gender" value="여">
                            <label for="female">여 </label></td></tr>
    <tr><td>Phone Number:</td><td><input type="text" name="phone_number" placeholder="000-0000-0000"/></td></tr>
    <tr><td>Email:</td><td><input type="text" name="email" placeholder="email"/></td></tr>
    <tr><td>Address:</td><td><input type="text" name="address" placeholder="address"/></td></tr>
    <tr><td>Birthday:</td><td><input type="text" name="birthday" placeholder="YYYY-MM-DD"/></td></tr>

    <tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>