package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.servlet.UserInfoBean;

public class HelloServlet2 extends HttpServlet {
    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // �U�����������r�ॿ�T���
        response.setContentType("text/html; charset=big5");
        request.setCharacterEncoding("big5");

        // �إ� userInfo ����A�ë��w�@�� session �� attribute �P��ô��
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setUserName("�O���R");
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);

        // �e�����w������
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/HelloFromServlet2.jsp");
        rd.forward(request, response);
    }
}