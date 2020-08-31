<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="myname" class="Lotto649_Test.Login_Servlet" scope="session"></jsp:useBean>
<h1>登錄成功！進入遊戲中...</h1>
<% response.setHeader("Refresh", "2; url=lotto_Home.jsp"); %>
</body>
</html>