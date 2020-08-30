<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="emp" class="Lotto649_Test.AgeBean" scope="request"/>
<jsp:setProperty name="emp" property="age" value="30" />
	<h1>員工的年齡是:</h1> 
<jsp:getProperty name="emp" property="age" />
<form name="formAge">
	<input type="text" name="age" value="123">
	<input type="button" value="Click" onclick="ageAjax()">
</form>
<div class="t1"></div>
<div class="t2"></div>
<script type="text/javascript">
let v = document.formAge.age.value;
v="QQQ"
$('.t1').text(message)
$('.t2').text(v)
function ageAjax(){
	$.ajax({
		type:"post",
		url:"./Age_Servet",
		data:v,
		success:function(message){
			$('.t1').text(message)
		}
		
	})
}

</script>
</body>
</html>