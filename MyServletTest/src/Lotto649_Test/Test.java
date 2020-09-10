package Lotto649_Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8"); //能顯示中文

		String key_v = request.getParameter("fff_name");
		
		PrintWriter out = response.getWriter();
		System.out.println(key_v);
		out.print("後端取到值");
		out.print(key_v);
		

	}

}
