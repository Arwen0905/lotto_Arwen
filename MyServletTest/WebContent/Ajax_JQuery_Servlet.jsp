<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index_Ajax</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
     <input type="button" id="but_json_json" name="ajs" value="確認"/>
<script>
                 $('#but_json_json').click(function(){
                     let j ={"name":"王","password":123456};
                   
                     $.ajax(
                             {
                                 url:"JSON_Servlet", //訪問路徑
                                 type:"POST",    //訪問方式
                                 data:j, //傳入服務端的資料
                                 dataType:"json",
                                 contentType:"application/json;charset=utf-8",
                                 success : function(data){
                                     alert(data);
                                       alert(data.name);
                                       
                                        
                                         alert(data.password);
                                 }
                                  
                             }       
                             );
                 });
</script> 
    </body>
 
</html>