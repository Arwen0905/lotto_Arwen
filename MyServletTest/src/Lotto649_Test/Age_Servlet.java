package Lotto649_Test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Age_Servlet")
public class Age_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 下面兩行讓中文字能正確顯示
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // 建立 userAge 種子物件，並指定一個 session 的 attribute 與之繫結
        String aaa = request.getParameter("age");
        AgeBean userAge = new AgeBean();
        userAge.setAge(Integer.parseInt(aaa));

        HttpSession session = request.getSession();
//      收到請求之後，透過request.setAttribute() 把要傳遞給JSP 的參數字串"666" 儲存在request 物件裡
        session.setAttribute("aaa", userAge);
        // 前往指定的網頁
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/HelloWelcome.jsp");
        rd.forward(request, response);
    }
}