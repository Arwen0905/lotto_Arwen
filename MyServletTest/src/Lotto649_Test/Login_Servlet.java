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
        
	  	//JSP��J���b���K�X
	  	String name = request.getParameter("name");
	  	String password= request.getParameter("password");

	  	System.out.println("�b��:"+name);
	  	System.out.println("�K�X:"+password);
	  	PrintWriter out = response.getWriter();

	  	//init-paramn�ҳ]�w���b���K�X
	  	String secretName = getServletConfig().getInitParameter("name");
	  	String secretPassword = getInitParameter("password");
	  	
	  	if(secretName.equals(name) && secretPassword.equals(password) )
	  	{	
	  		
	  		out.print(secretName+""+secretPassword);
	  		System.out.println(secretName+""+secretPassword);
		  	System.out.println("�n�J���\");	
	  		request.setAttribute("myname",name); //��J���b��
	  		request.setAttribute("mypassword",password); //��J���K�X
//	  		request.getRequestDispatcher("index.jsp").forward(request, response); //���� 
	  		return;
	  	}
	  	else
	  	{
	  		
		  	out.print("��J���~�A�Э��s��J");
		  	//�i�H�bServlet���Xcontext-param,�A��JSP���X
	  		String strError = getServletContext().getInitParameter("ERROR"); // web.xml�������T��
	  		request.setAttribute("strMsg",strError); // �H����Φ��x�s
		  	System.out.println(request.getAttribute("strMsg"));
		  	
		  	// �ĥ�Ajax�ɤ��i�H����
//	  		request.getRequestDispatcher("Home.jsp").forward(request, response);
	  	}

	}

}
