package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Age_Servlet")
public class Name_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // ����Ajax�o�Ӫ���
        String key_v = request.getParameter("key_v");
        
        // �إ�AgeBean�ؤl����A���w session �H attribute �]�w�x�s
        nameBean userName_Ajax = new nameBean(); //�إߪ���
        userName_Ajax.setuserName(key_v); // �ǨӪ��Ȱe�ܸ�Ʈw�d��
        
        // Ajax �g�J�T��
        PrintWriter out = response.getWriter();
        out.print("Servletd�G"+userName_Ajax.getuserName());

        request.getSession().setAttribute("sss", userName_Ajax.getuserName()); //�Hsession�����x�s
        getServletContext().getRequestDispatcher("/HelloWelcome.jsp").forward(request, response); // �ëe�����wJSP����
    }
}