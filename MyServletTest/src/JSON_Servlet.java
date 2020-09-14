
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


@WebServlet("/JSON_Servlet")
public class JSON_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JSON_Servlet() {
        super();
    }
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		String user = request.getParameter("j");
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    System.out.println(user);
	    //JSONª«¥ó
	     
	    try {
	    	JSONObject jsonObject = new JSONObject();
	    	jsonObject.accumulate("password", password).accumulate("name", "www");
	    	response.setContentType("application/json");
	    	response.getWriter().write(jsonObject.toString());
		} catch (Exception e) {}
	}

}
