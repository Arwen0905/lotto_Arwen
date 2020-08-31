package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Age_Servlet")
public class Age_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // 接受Ajax發來的值
        String key_v = request.getParameter("key_v");
        
        // 建立AgeBean種子物件，指定 session 以 attribute 設定儲存
        AgeBean userAge_Ajax = new AgeBean(); //建立物件
        userAge_Ajax.setAge(key_v); // 以前端傳來的值，作為設定年齡
        
        // Ajax 寫入響應
        PrintWriter out = response.getWriter();
        out.print("Servletd："+userAge_Ajax.getAge());

        request.getSession().setAttribute("sss", userAge_Ajax.getAge()); //以session物件儲存
        getServletContext().getRequestDispatcher("/HelloWelcome.jsp").forward(request, response); // 並前往指定JSP頁面
    }
}