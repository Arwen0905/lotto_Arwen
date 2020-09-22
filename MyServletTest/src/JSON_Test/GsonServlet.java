package JSON_Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/GsonServlet")
public class GsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GsonServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    	response.setContentType("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
        Gson gson = new Gson();
        GsonCreate test_tojson = new GsonCreate("§A¦n",24);
        String jsonObject = gson.toJson(test_tojson);
        
        System.out.println(jsonObject);
        PrintWriter out = response.getWriter();
        out.print(jsonObject);           
    }

}
