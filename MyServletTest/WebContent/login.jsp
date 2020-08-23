<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method=post>
	<div >
		<table>
		<tr>
		<td>
	  		<h1>User Name:</h1><input type="text" name="name"  />
		</td>
		</tr>
		<tr>
	 	<td>
	   		<h2>Password:</h2><input type="password" name="mypassword" >
	   		<input type="submit" value="submit">
		</td>
		</tr>
		</table>
	</div>
	
	<div>
		<label class="checkbox">
			<input type="checkbox" checked name="v" value="a">a
		</label>
	</div>
	</form>

</body>
</html>