<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userBean" class="Lotto649_Test.UserBean" scope="session"/>
<jsp:setProperty name="userBean" property="userName" value="小夫"/>
<jsp:getProperty name="userBean" property="userName"/>

<h1>當前姓名<br><%= userBean.getUserName() %></h1>

<form action="User_Servlet" method="post">
	<h1>設定姓名：</h1>
	<input type="text" name="UU">
	<input type="submit" value="Submit">
</form>

</body>
</html>