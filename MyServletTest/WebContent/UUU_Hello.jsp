<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userName" class="Lotto649_Test.UserBean" scope="session" />
<h1>�q Servlet �ǨӪ� UserBean.userName �T��</h1>
<% String na = userName.getUserName(); %>
<h1><%= na %></h1>
</body>
</html>