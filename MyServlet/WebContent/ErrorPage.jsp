<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%=request.getAttribute("strMsg")%>
	</h1>
	<form action='Home.jsp'>
		<input name="button" type="submit" id="button" value="Home">
	</form>

</body>
</html>