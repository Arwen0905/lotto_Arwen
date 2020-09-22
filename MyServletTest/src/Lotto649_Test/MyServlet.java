package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;
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
        // �]�w�T���Y���\ajax���X��
        response.setHeader("Access-Control-Allow-Origin", "*");
        // �P����ܩҦ�������ШD���i�H����
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");


        // �����ݩ�name���r����
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String n3 = request.getParameter("n3");
        String n4 = request.getParameter("n4");
        String n5 = request.getParameter("n5");
        String n6 = request.getParameter("n6");
        
        String userLotto[] = {n1,n2,n3,n4,n5,n6};
        String Year = request.getParameter("Year");
        System.out.println("���o�~���F"+Year);
        
        lotto649_MySQL lottoGo = new lotto649_MySQL(userLotto,Year);
//        Map<String, String> ansData = new TreeMap<>();
        String ansData;
        
        ansData = lottoGo.detect();
                
        PrintWriter out = response.getWriter();
       
//      �N���G�x�s��session �ѫe�ݨϥ�
        HttpSession session = request.getSession();
        session.setAttribute("QQ", ansData); //�]�wname��"QQ"

        Object QQ = session.getAttribute("QQ");     
        System.out.println(QQ); //�x�s����
        
        System.out.println("��`�����G");
        System.out.println(n1+","+n2+","+n3+","+n4+","+n5+","+n6);
        
//        out.println("��`�����G" + n1+","+n2+","+n3+","+n4+","+n5+","+n6);
//        out.println("�~���G" + Year);
//        out.println("�����ơG"+lottoGo.bonusAll);
//        out.println("<FONT size='12' color='#ff2244'>CSS�y�k�g�e��</FONT>");
        if(ansData.isEmpty()) {
			out.println("�S������");
			System.out.println("�S������");
		}
//        Gson gson = new Gson();
//        String json_Data = gson.toJson(ansData);
//        System.out.println(json_Data);
//        out.print(json_Data);
        out.print(ansData);
        
//		for(String key : ansData.keySet()){
//			String value = ansData.get(key);
//			System.out.println(key + " " + value);
//			out.println(key + " " +value); //�g��e��
//			
//		}

// ================================================================================================        
        
        
	}

}
