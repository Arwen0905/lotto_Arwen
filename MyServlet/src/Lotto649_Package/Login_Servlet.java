package Lotto649_Package;

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
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        
	  	//JSP��J���b���K�X
	  	String name = request.getParameter("name");
	  	String password= request.getParameter("mypassword");

	  	//init-paramn�ҳ]�w���b���K�X
	  	String secretName = getServletConfig().getInitParameter("name");
	  	String secretPassword = getInitParameter("password");

	  	if(secretName.equals(name) && secretPassword.equals(password) )
	  	{
		  	System.out.println("�n�J���\!");	
	  		request.setAttribute("myname",name);
	  		request.getRequestDispatcher("index.jsp").forward(request, response); 
	  		return;
	  	}
	  	else
	  	{
		  	System.out.println(name);
		  	System.out.println(password);
		  	
		  	//�i�H�bServlet���Xcontext-param,�A��JSP���X
	  		String strError = getServletContext().getInitParameter("ERROR");
	  		request.setAttribute("strMsg",strError);
		  	System.out.println(request.getAttribute("strMsg"));
		  	
	  		request.getRequestDispatcher("Home.jsp").forward(request, response);
	  	}
	  	doGet(request, response);

	}

}
