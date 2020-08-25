<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="emp" class="Lotto649_Test.AgeBean" scope="request"/>
<jsp:setProperty name="emp" property="age" value="30" />
	<h1>員工的年齡是:</h1> 
<jsp:getProperty name="emp" property="age" />

<form action="Age_Servlet" method="post">
	<input type="text" name="age" value="<%= emp.getAge() %>">
	<input type="submit" value="Sbumit">
</form>

</body>
</html>