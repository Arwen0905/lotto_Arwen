<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<% String num = request.getParameter("number");%>
<jsp:useBean id="checker" class="Lotto649_Test.CheckPrimeBean2" scope="request"/>
<jsp:setProperty name="checker" property="number" value="<%= num %>" />
<h1><%= num %></h1>

<% if (!checker.isValidNumber ()) { %>
<% response.setHeader("Refresh", "2; url=prime2.html"); %>
  請輸入 2  到 10000 之間的整數。<p>
兩秒後跳回重新輸入
或按此
<% return; } %>

<% if (checker. isPrimeNumber ()) { %>
  <%= num %> 是質數
<% } else { %>
  <%= num %> 不是質數
<% } %>
<% response.setHeader("Refresh", "3; url=prime2.html"); %>
</body>
</html>