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
<form id="fff">
	<input type="text" name="fff_name" value="1111111">
	<input type="text" name="fff_age" value="2222222">
	<input type="button" value="Click" onclick="AjaxSearch()"/>
</form>
<h3 class="t1"></h3>
<h3 class="t2"></h3>
<h3 class="t3">serialize</h3>
<script type="text/javascript">
function AjaxSearch(){
    $.ajax({
        type:"post",
        url:"./Test",
        data:$('#fff').serialize(),
        success:function(message){
        	$(".t1").text(message);
        	$(".t2").text("QQQQQQQQQQQQQQQQ");
        }
    });
}
</script>
</body>
</html>