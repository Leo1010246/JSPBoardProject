<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.crud.dao.BoardDAO"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="com.crud.bean.BoardVO" />
<jsp:setProperty property="*" name="u"/>

<%
	BoardDAO boardDAO = new BoardDAO();
	int i=boardDAO.updateBoard(u);
	response.sendRedirect("posts.jsp");
%>

<html>
<head>
	<title>Title</title>
</head>
<body>
<form action="editpost2.jsp" method="post" enctype="multipart/form-data">
	Photo: <input type="file" name="photo" value="<%= u.getPhoto()%>"/>
	<input type="submit" value="upload" />
	<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</form>
</body>
</html>