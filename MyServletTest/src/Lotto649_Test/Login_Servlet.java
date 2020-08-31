package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login_Servlet() {
        super();
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        
	  	//JSP輸入的帳號密碼
	  	String name = request.getParameter("name");
	  	String password= request.getParameter("password");

	  	System.out.println("帳戶:"+name);
	  	System.out.println("密碼:"+password);
	  	PrintWriter out = response.getWriter();

	  	//init-paramn所設定的帳號密碼
	  	String secretName = getServletConfig().getInitParameter("name");
	  	String secretPassword = getInitParameter("password");
	  	
	  	if(secretName.equals(name) && secretPassword.equals(password) )
	  	{	
	  		
	  		out.print(secretName+""+secretPassword);
	  		System.out.println(secretName+""+secretPassword);
		  	System.out.println("登入成功");	
	  		request.setAttribute("myname",name); //輸入的帳號
	  		request.setAttribute("mypassword",password); //輸入的密碼
//	  		request.getRequestDispatcher("index.jsp").forward(request, response); //跳轉 
	  		return;
	  	}
	  	else
	  	{
	  		
		  	out.print("輸入錯誤，請重新輸入");
		  	//可以在Servlet取出context-param,再由JSP取出
	  		String strError = getServletContext().getInitParameter("ERROR"); // web.xml的報錯訊息
	  		request.setAttribute("strMsg",strError); // 以物件形式儲存
		  	System.out.println(request.getAttribute("strMsg"));
		  	
		  	// 採用Ajax時不可以跳轉
//	  		request.getRequestDispatcher("Home.jsp").forward(request, response);
	  	}

	}

}
