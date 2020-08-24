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
 <% String msg = (String)request.getAttribute("message"); %>>
 <%= msg %>>
</body>
</html>