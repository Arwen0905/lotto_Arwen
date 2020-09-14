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
<jsp:useBean id="emp" class="Lotto649_Test.nameBean" scope="request"/>
<jsp:setProperty name="emp" property="userName"/>
<h1>建立帳號</h1> 

<form name="ttt">
	<input type="text" name='tt' onkeyup="AjaxSearch()" />
	<input type="button" value="帳號檢查" onclick="AjaxSearch()"/>
</form>

<pre class="t1"></pre>
<h1 class="t2"></h1>
<form action="Age_Servlet" method="post">
	<input type="password" name="key_v">
	<input type="submit" value="建立送出">
</form>
<br><br>
<button onclick="CreateUser()">登入帳號</button>
<p id=viewRight></p>
<script>
// 檢查帳號是否重複
function AjaxSearch(){
	v = document.ttt.tt.value;
    $.ajax({
        type:"post",
        url:"./Age_Servlet",
        data:{key_v:v},
        success:function(message){
        	$(".t1").text(message);
        }
    });
}

// 建立帳號
let viewRight = document.querySelector('#viewRight')
function CreateUser(){
	let req = new XMLHttpRequest()
	req.open("get","Home.jsp")
	req.onload = function(){
		viewRight.innerHTML = this.responseText
	}
	req.send()
}
</script>
</body>
</html>