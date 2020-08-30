package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;

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

        // �U�����������r�ॿ�T���
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // �إ� userAge �ؤl����A�ë��w�@�� session �� attribute �P��ô��
//        String aaa = request.getParameter("age");
//        AgeBean userAge = new AgeBean();
//        userAge.setAge(aaa);

        String v = request.getParameter("v");
        AgeBean userAge_Ajax = new AgeBean();
        userAge_Ajax.setAge(v);
        System.out.println(userAge_Ajax+"<<<<<<<<");
        
        HttpSession session = request.getSession();
//      ����ШD����A�z�Lrequest.setAttribute() ��n�ǻ���JSP ���Ѽ� �x�s�brequest �����
//        session.setAttribute("aaa", userAge_Ajax); //userAge
        // Ajax �B�z�T��
        PrintWriter out = response.getWriter();
        out.print(session);
        
//		request.getRequestDispatcher("TTT_Age.jsp") .forward(request, response); //��o�� hello.jsp �i��^��
//        request.setAttribute("message", userAge_Ajax); //�N���G�T���]�w�ܡA�ШD���󦨬��ݩ�
		
        // �e�����w������
//        RequestDispatcher rd;
//        rd = getServletContext().getRequestDispatcher("/HelloWelcome.jsp");
//        rd.forward(request, response);
    }
}