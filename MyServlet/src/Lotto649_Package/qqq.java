package Lotto649_Package;

import java.sql.*;

public class qqq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:../build/lotto649_BrowserDB.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM lotto649_2014");
			while(rs.next()) {
				System.out.println(rs.getInt("´Á§O"));
			}
		} catch (Exception e) {}
//      String []nar = {"2","8","27","40","41","47"};
////      lotto649_MySQL lottoGo = new lotto649_MySQL(nar);
//      lotto649_Sqlite lottoGo = new lotto649_Sqlite(nar);
//      lottoGo.detect();
      
	}

}
