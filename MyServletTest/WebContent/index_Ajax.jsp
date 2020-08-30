<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index_Ajax</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
    <input type="text" id="text" onkeyup="search()"/>
    <h3 class="t1"></h3>
    <h1 class="t2"></h1>

    <script>
        function search(){
            var value = $("#text").val();
            $.ajax({
                type:"post",
                url:"./Ajax_let",
                data:{key_v:value},
                statusCode:{
                404:function(){
                    alert("404")},
                500:function(){
                    alert("500")}
                },
                success:function(resLotto){
                	resLotto = resLotto.split(",");
                	$(".t1").text(resLotto[0]+resLotto[1]);
                	$(".t2").text(resLotto[2]+resLotto[3]);
                }
            });
    	}
    </script>
</body>
</html>