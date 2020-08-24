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

        // �U�����������r�ॿ�T���
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // �إ� userAge �ؤl����A�ë��w�@�� session �� attribute �P��ô��
        AgeBean userAge = new AgeBean();
        userAge.setAge(666);
        HttpSession session = request.getSession();
//      ����ШD����A�z�Lrequest.setAttribute() ��n�ǻ���JSP ���ѼƦr��"666" �x�s�brequest �����
        session.setAttribute("message", userAge);

        // �e�����w������
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/HelloWelcome.jsp");
        rd.forward(request, response);
    }
}