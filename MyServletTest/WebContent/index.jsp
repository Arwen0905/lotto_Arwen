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
<%=request.getAttribute("myname") %>
<h1>���\�n���I</h1>
</body>
</html>