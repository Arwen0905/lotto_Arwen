<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
	<form name="LoginForm" id="LoginForm">
	  		<h1>帳戶:</h1><input type="text" name="name"  />
	   		<h1>密碼:</h1><input type="password" name="password" >
	   		<input type="submit" value="登入" >
	   		<input type="reset" value="重置">
	</form>
	<div class="Error_info"></div>
	<h1 class="loginInfo"></h1>


<script type="text/javascript">

$('#LoginForm').submit(function(e){	
	   	var form = $(this);
		$.ajax({
			type:"post",
			url:"./Login_Servlet",
			data:$(this).serialize(),
			success:function(message){
				if(message==document.LoginForm.name.value+""+document.LoginForm.password.value){
				$('.loginInfo').text("管理員登入成功")
				window.location.href = "index.jsp"
				}else{
					$('.loginInfo').text(message)
				}
			}
		})
		e.preventDefault();
})

</script>
	
</body>
</html>