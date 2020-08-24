package Lotto649_Package;

import java.sql.*;

public class qqq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    String url =  "jdbc:mysql://localhost:3307/lotto649?serverTimezone=UTC";
		    Connection conn = DriverManager.getConnection(url,"root","root");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM lotto649_2014");
			while(rs.next()) {
				System.out.println(rs.getString("¶}¼ú¤é´Á"));
			}
		} catch (Exception e) {}
      
	}

}
