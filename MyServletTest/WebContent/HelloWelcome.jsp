<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>設定帳戶：</h1>
<jsp:useBean id="QQ" class="Lotto649_Test.AgeBean" scope="session"/> 
 <% String message = (String)session.getAttribute("sss");%>
<jsp:setProperty name="QQ" property="age" value="<%= message %>"/>

 <h1>你的名字: <%= message %></h1>

 <input onclick="jump()" type="button" value="返回">

 <script>
 function jump(){
	 window.location = "TTT_Age.jsp"
 }
 </script>
</body>
</html>