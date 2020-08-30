package Lotto649_Package;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");//可將字串內容打印成網頁格式
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8"); //獲取網頁傳輸的內容
        /** 設定響應頭允許ajax跨域訪問 **/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星號表示所有的異域請求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        // 接受屬性name的字串資料
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String n3 = request.getParameter("n3");
        String n4 = request.getParameter("n4");
        String n5 = request.getParameter("n5");
        String n6 = request.getParameter("n6");
        
        String n0[] = {n1,n2,n3,n4,n5,n6};
        lotto649_MySQL lottoGo = new lotto649_MySQL(n0);
        lottoGo.detect();
        
        System.out.println("MyServlet.java:頁面取得資料：");
        System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
		doGet(request, response);
	}

}
