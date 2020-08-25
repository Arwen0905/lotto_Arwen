package Lotto649_Test;

import java.io.IOException;


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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	//也可以在Servlet取出context-param,再由JSP取出
	  	//String strError = getServletContext().getInitParameter("Error");
	  	//JSP輸入的帳號密碼
	  	String name = request.getParameter("name");
	  	String password= request.getParameter("mypassword");

	  	//init-paramn所設定的帳號密碼
	  	String secretName = getServletConfig().getInitParameter("name");
	  	String secretPassword = getInitParameter("password");

	  	if(secretName.equals(name) && secretPassword.equals(password) )
	  	{
		  	System.out.println("登入成功!");	
	  		request.setAttribute("myname",name);
	  		System.out.println(request.getAttribute("myname"));
	  		request.getRequestDispatcher("index.jsp").forward(request, response); 
	  		return;
	  	}
	  	else
	  	{
	  		//也可以在Servlet取出context-param,再由JSP取出
	  		//request.setAttribute("strMsg",strError);
		  	System.out.println(name);
		  	System.out.println(password);
	  		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
	  	}
	  	doGet(request, response);

	}

}
