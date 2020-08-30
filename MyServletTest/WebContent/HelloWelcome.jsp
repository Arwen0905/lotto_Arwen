<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
 <h1>從Servlet 傳過來的訊息:</h1>
<jsp:useBean id="aaa" class="Lotto649_Test.AgeBean" scope="session"/>
 <h1>重新設定的年齡：</h1>
 <% String ag = aaa.getAge(); %>
 <h1><%= ag %></h1>
</body>
</html>