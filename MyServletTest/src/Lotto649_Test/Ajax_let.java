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
        response.setCharacterEncoding("UTF-8"); //����ܤ���

        String value = request.getParameter("key_v"); //���o�e�ݪ���
        
    	��Ʈw�s�u_Database_Test DD = new ��Ʈw�s�u_Database_Test(value);
        PrintWriter out = response.getWriter(); //�g�J�T��
        
        
        TreeMap<String, String> accept = new TreeMap<>();
        accept = DD.DataTest();
        
        if(value==null || value.trim().equals("")) {
        	out.print("�п�J���O����r");
        }else {
        out.print(" ���O:" + accept.get("���O")+","); //�g�^�h����
        out.print(" �}�����:"+ accept.get("�}�����")+",");
        out.print("����:" + accept.get("����1"));
        out.print(" " + accept.get("����2"));
        out.print(" " + accept.get("����3"));
        out.print(" " + accept.get("����4"));
        out.print(" " + accept.get("����5"));
        out.print(" " + accept.get("����6")+",");
        out.print(" �S�O��:" + accept.get("�S�O��"));
        }
    }
}
