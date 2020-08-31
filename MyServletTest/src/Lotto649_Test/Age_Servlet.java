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

        // ����Ajax�o�Ӫ���
        String key_v = request.getParameter("key_v");
        
        // �إ�AgeBean�ؤl����A���w session �H attribute �]�w�x�s
        AgeBean userAge_Ajax = new AgeBean(); //�إߪ���
        userAge_Ajax.setAge(key_v); // �H�e�ݶǨӪ��ȡA�@���]�w�~��
        
        // Ajax �g�J�T��
        PrintWriter out = response.getWriter();
        out.print("Servletd�G"+userAge_Ajax.getAge());

        request.getSession().setAttribute("sss", userAge_Ajax.getAge()); //�Hsession�����x�s
        getServletContext().getRequestDispatcher("/HelloWelcome.jsp").forward(request, response); // �ëe�����wJSP����
    }
}