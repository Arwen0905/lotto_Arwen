package Lotto649_Package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ��Ʈw�s�u_Database_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	           Connection conn = DriverManager.getConnection(
	        		   "jdbc:mysql://localhost:3307/mdb?serverTimezone=UTC","root","root");
	           String query = "SELECT * FROM emp";
	           
	           Statement stmt = conn.createStatement();
	           ResultSet rs = stmt.executeQuery(query);
	           
	           while(rs.next()) {
	        	   System.out.println(rs.getInt("id")+rs.getString("�m�W"));
	           }
		} catch (Exception e) {
			System.out.println("GG: "+e);
		}
	}

}
