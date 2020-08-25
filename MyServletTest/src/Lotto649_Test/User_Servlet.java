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

        // �U�����������r�ॿ�T���
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String UU = request.getParameter("UU");
        System.out.println("���o��UUU�ǹL�Ӫ��W�r"+UU);
        
        // �إ� userName ����A�ë��w�@��session ��attribute �P��ô��
        UserBean userName = new UserBean();
        userName.setUserName(UU);
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        
        // �e�����w������
//        response.sendRedirect("UUU_Hello.jsp"); // �䤤�@�ظ���覡�A������ĳ!
        request.getRequestDispatcher("/UUU_Hello.jsp")
        .forward(request, response);
    }
}