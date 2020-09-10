package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");//�i�N�r�ꤺ�e���L�������榡
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8"); //��������ǿ骺���e
        /** �]�w�T���Y���\ajax���X�� **/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* �P����ܩҦ�������ШD���i�H�����A */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");


        // �����ݩ�name���r����
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String n3 = request.getParameter("n3");
        String n4 = request.getParameter("n4");
        String n5 = request.getParameter("n5");
        String n6 = request.getParameter("n6");

        String userLotto[] = {n1,n2,n3,n4,n5,n6};
        lotto649_MySQL lottoGo = new lotto649_MySQL(userLotto);
        Map<String, String> ansData = new TreeMap<>();
        
        ansData = lottoGo.detect();
                
        PrintWriter out = response.getWriter();
       
//      �N���G�x�s��session �ѫe�ݨϥ�
        HttpSession session = request.getSession();
        session.setAttribute("QQ", ansData); //�]�wname��"QQ"

        Object QQ = session.getAttribute("QQ");     
        System.out.println(QQ);
        System.out.println("��`�����G");
        System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6);
        
        if(ansData.isEmpty()) {
			out.println("�S������");
			System.out.println("�S������");
		}
        
        
		for(String key : ansData.keySet()){
			String value = ansData.get(key);
			System.out.println(key + " " + value);
			out.println(key + " " +value); //�g��e��
			
		}
		
        out.println("�����ơG"+lottoGo.bonusAll);
// ================================================================================================        
        
        
	}

}
