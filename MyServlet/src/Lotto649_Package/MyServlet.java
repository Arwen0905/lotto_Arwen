package Lotto649_Package;
//package Lotto649_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Test
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");//�i�N�r�ꤺ�e���L�������榡
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8"); //��������ǿ骺���e
        /** �]�w�T���Y���\ajax���X�� **/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* �P����ܩҦ�������ШD���i�H�����A */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");


/**      =================================================================
         * ����*/
        // �����ݩ�name���r����
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String n3 = request.getParameter("n3");
        String n4 = request.getParameter("n4");
        String n5 = request.getParameter("n5");
        String n6 = request.getParameter("n6");
        
        String n0[] = {n1,n2,n3,n4,n5,n6};
        lotto649_MySQL lottoGo = new lotto649_MySQL(n0);
        lottoGo.detect();
        
        System.out.println("MyServlet.java:�������o��ơG");
        System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6);
/**		=================================================================
         * ��^*/


//        �b�r�ꪺ��m�i�H�令html�{���X�A�Y�ॴ�L�X�@�Ӻ���
        PrintWriter out = response.getWriter();
        String title = "��Ʀ^��";
        String docType = "<!DOCTYPE html> \n";
        out.println(
                docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
                        + "<h1 align=\"center\">" + title + "</h1>\n" + "���o����\r\n" +n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6+ "</body>\r\n" + "</html>");
        out.close();

		doGet(request, response);
	}

}
