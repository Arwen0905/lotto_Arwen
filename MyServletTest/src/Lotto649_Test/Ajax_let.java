package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ajax_let")
public class Ajax_let extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8"); //能顯示中文

        String value = request.getParameter("key_v"); //取得前端的值
        
    	資料庫連線_Database_Test DD = new 資料庫連線_Database_Test(value);
        PrintWriter out = response.getWriter(); //寫入響應
        
        
        TreeMap<String, String> accept = new TreeMap<>();
        accept = DD.DataTest();
        
        if(value==null || value.trim().equals("")) {
        	out.print("請輸入期別關鍵字");
        }else {
        out.print(" 期別:" + accept.get("期別")+","); //寫回去網頁
        out.print(" 開獎日期:"+ accept.get("開獎日期")+",");
        out.print("獎號:" + accept.get("獎號1"));
        out.print(" " + accept.get("獎號2"));
        out.print(" " + accept.get("獎號3"));
        out.print(" " + accept.get("獎號4"));
        out.print(" " + accept.get("獎號5"));
        out.print(" " + accept.get("獎號6")+",");
        out.print(" 特別號:" + accept.get("特別號"));
        }
    }
}
