<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index_Ajax</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<input type="button" id="btn" name="btn" value="點我" onclick="jsonAjaxPost()">
<div id="resultJsonText"></div>
     
<script type="text/javascript">        
    function jsonAjaxPost(){     
        $.ajax({  
            type:"post", 
            url:"GsonServlet",   
            dataType:"json",//设置返回数据的格式 ，请求成功后的回调函数 data为json格式  
            success:
                function(data){  
                    $("#resultJsonText").text("name："+data.QQ+"  age:"+data.age);  
                },  
            error:
                function(xhr, ajaxOptions, thrownError){
                    alert(xhr.status+"\n"+thrownError);
                }
        });  
    }  
</script>

</body>
</html>