<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Home" method=post>
	  		<h1>User Name:</h1><input type="text" name="name"  />
	   		<h2>Password:</h2><input type="password" name="mypassword" >
	   		<input type="submit" value="click">
	</form>
	<div class="Error_info"><%= request.getAttribute("strMsg") %></div>
	
	<script type="text/javascript">
		Error_info = document.querySelector('.Error_info');
		if(Error_info.text != null){
			Error_info.innerHTML = <%= request.getAttribute("strMsg") %>
		}else{
			Error_info.innerHTML = ""
		}
		
	</script>
	
</body>
</html>