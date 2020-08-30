<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*"%>

<%  
	
	String s = request.getParameter("TOT");//從html端傳來到的onkeyup值，藉由 name值 導到url*=?傳遞而來
	
	String title_url = "期別";
	if( s==null || s.trim().equals("") ){  
	    out.print("請輸入"+title_url);  
	}else{
	    int id=Integer.parseInt(s); // s = onkeyup
	    		
	String y = "103";
	while ((y+s).length()!=9) {
			y += "0";
		}
	y += s;
	System.out.println("期別:"+ y);
	
	try{
	    Connection con=DriverManager.getConnection(
//	    		"jdbc:mysql://localhost:3307/mdb?serverTimezone=UTC","root","root");  
	    		"jdbc:mysql://localhost:3307/lotto649?serverTimezone=UTC","root","root");  
//			    PreparedStatement ps = con.prepareStatement("select * from emp where "+title_url+"=?");  
				PreparedStatement ps = con.prepareStatement("select * from lotto649_2014 where "+title_url+"=?");

	    ps.setString(1, y);
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()){  
	        out.print("期別:"+rs.getString(17)+",");
	        out.print(" 開獎日期:"+rs.getString(1)+",");
	        out.print("獎號:"+rs.getString(7));
	        out.print(" "+rs.getString(8));
	        out.print(" "+rs.getString(9));
	        out.print(" "+rs.getString(4));
	        out.print(" "+rs.getString(5));
	        out.print(" "+rs.getString(6)+",");
	        out.print(" 特別號:"+rs.getString(2));
	        
	        System.out.println("獎號：[ "+rs.getString(7)+" "+rs.getString(8)+
        			" "+rs.getString(9)+" "+rs.getString(4)+
        			" "+rs.getString(5)+" "+rs.getString(6)+
        			" ] 特別號："+rs.getString(2)); 
		
	    }
	    con.close();
	}catch(Exception e){e.printStackTrace();}  
	}
%>
</body>
</html>