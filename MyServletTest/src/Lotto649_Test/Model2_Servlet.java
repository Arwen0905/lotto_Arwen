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
    // 我是Controller ( Servlet )
	protected void service(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		
		String name = request.getParameter("user"); // 從網頁端那裡收集來的 "請求的參數"
		String message =  hello.doHead(name); // 委託 Hello 物件處理 ( 委託模型 )
		request.setAttribute("message", message); //將結果訊息設定至，請求物件成為屬性
		request.getRequestDispatcher("hello.jsp") 
		.forward(request, response); //轉發給 hello.jsp 進行回應
		
	}

}
