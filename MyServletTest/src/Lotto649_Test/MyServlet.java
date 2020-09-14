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

import org.json.JSONObject;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyServlet() {
        super();
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
        
        String userLotto[] = {n1,n2,n3,n4,n5,n6};
        String Year = request.getParameter("Year");
        System.out.println("取得年份；"+Year);
        
        lotto649_MySQL lottoGo = new lotto649_MySQL(userLotto,Year);
        Map<String, String> ansData = new TreeMap<>();
        
        ansData = lottoGo.detect();
                
        PrintWriter out = response.getWriter();
       
//      將結果儲存於session 供前端使用
        HttpSession session = request.getSession();
        session.setAttribute("QQ", ansData); //設定name為"QQ"

        Object QQ = session.getAttribute("QQ");     
        System.out.println(QQ); //儲存物件
        
        System.out.println("投注獎號：");
        System.out.println(n1+","+n2+","+n3+","+n4+","+n5+","+n6);
        
        out.println("投注獎號：" + n1+","+n2+","+n3+","+n4+","+n5+","+n6);
        out.println("年份：" + Year);
        
        try {			
        	JSONObject responseLotto = new JSONObject();
        	out.println(responseLotto);
		} catch (Exception e) {}
        
        if(ansData.isEmpty()) {
			out.println("沒有中獎");
			System.out.println("沒有中獎");
		}
        
        
		for(String key : ansData.keySet()){
			String value = ansData.get(key);
			System.out.println(key + " " + value);
			out.println(key + " " +value); //寫到前端
			
		}
		
        out.println("中獎數："+lottoGo.bonusAll);
// ================================================================================================        
        
        
	}

}
