package Lotto649_Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Model2_Servlet")
public class Model2_Servlet extends HttpServlet {
	
	private Hello hello;
	
	public Model2_Servlet() {
		 hello = new Hello();
	 } 
	 
	private static final long serialVersionUID = 1L;
    // �ڬOController ( Servlet )
	protected void service(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		
		String name = request.getParameter("user"); // �q�����ݨ��̦����Ӫ� "�ШD���Ѽ�"
		String message =  hello.doHead(name); // �e�U Hello ����B�z ( �e�U�ҫ� )
		request.setAttribute("message", message); //�N���G�T���]�w�ܡA�ШD���󦨬��ݩ�
		request.getRequestDispatcher("hello.jsp") 
		.forward(request, response); //��o�� hello.jsp �i��^��
		
	}

}
