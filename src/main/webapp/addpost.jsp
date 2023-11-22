<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.crud.dao.BoardDAO"%>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<% request.setCharacterEncoding("utf-8"); %>

<html>
<head>
	<title>Title</title>
</head>
<body>
<jsp:useBean id="u" class="com.crud.bean.BoardVO" />
<jsp:setProperty property="*" name="u"/>
<%
	BoardDAO boardDAO = new BoardDAO();
	int i = boardDAO.insertBoard(u);
	//String msg = "데이터 추가 성공 !";
	//if(i == 0) msg = "[에러] 데이터 추가 ";
%>
<form action="addpost2.jsp" method="post" enctype="multipart/form-data">
	Photo: <input type="file" name="photo"/>
	<input type="submit" value="upload" />
</form>
</body>
</html>

<%--<script>--%>
<%--	alert('<%=msg%>');--%>
<%--	location.href='posts.jsp';--%>
<%--</script>--%>