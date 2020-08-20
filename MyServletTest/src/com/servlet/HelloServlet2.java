package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.servlet.UserInfoBean;

public class HelloServlet2 extends HttpServlet {
    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // 下面兩行讓中文字能正確顯示
        response.setContentType("text/html; charset=big5");
        request.setCharacterEncoding("big5");

        // 建立 userInfo 物件，並指定一個 session 的 attribute 與之繫結
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setUserName("令狐沖");
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);

        // 前往指定的網頁
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/HelloFromServlet2.jsp");
        rd.forward(request, response);
    }
}