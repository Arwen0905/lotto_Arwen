<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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
			<input type="checkbox" name="v" value="aaa">a
			<input type="checkbox" name="v" value="bbb">b
			<input type="checkbox" name="v" value="ccc">c
		</label>
	</div>
	</form>

	<script type="text/javascript">
		$.ajax({
			method:"get",
			url:"MyServlet",
			data:{
				name:"john",
				age:"30"
			}
		}).done(function(msg){
			alert("data:"+ msg)
		})
	</script>
</body>
</html>