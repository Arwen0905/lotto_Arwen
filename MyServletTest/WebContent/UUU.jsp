<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userBean" class="Lotto649_Test.UserBean" scope="session"/>
<jsp:setProperty name="userBean" property="userName" value="阿文"/>
<jsp:getProperty name="userBean" property="userName"/>
<h1>取得當前姓名<br><%= userBean.getUserName() %></h1>
<h1>五秒後，更新頁面</h1>
<% response.setHeader("Refresh", "5; url=helloUser.jsp"); %>
<form action="User_Servlet" method="post">
	<input type="text" name="UU" value="<%=userBean.getUserName()%>">設定姓名：
	<input type="submit" name="UU" value="Submit">
</form>
</body>
</html>