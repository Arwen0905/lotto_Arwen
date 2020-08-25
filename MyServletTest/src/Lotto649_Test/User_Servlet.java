package Lotto649_Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/User_Servlet")
public class User_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 下面兩行讓中文字能正確顯示
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String UU = request.getParameter("UU");
        System.out.println("取得到UUU傳過來的名字"+UU);
        
        // 建立 userName 物件，並指定一個session 的attribute 與之繫結
        UserBean userName = new UserBean();
        userName.setUserName(UU);
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        
        // 前往指定的網頁
//        response.sendRedirect("UUU_Hello.jsp"); // 其中一種跳轉方式，較不建議!
        request.getRequestDispatcher("/UUU_Hello.jsp")
        .forward(request, response);
    }
}