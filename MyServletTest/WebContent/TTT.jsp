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
<jsp:setProperty name="emp" property="age" value="<%= 168 %>" />
	<h1>員工的年齡是:</h1> 
<jsp:getProperty name="emp" property="age" />

</body>
</html>