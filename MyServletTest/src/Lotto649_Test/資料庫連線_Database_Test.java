package Lotto649_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;

public class 資料庫連線_Database_Test {
	String s;
	
    TreeMap<String, String> ansLotto = new TreeMap<>();
    
	資料庫連線_Database_Test(String s){
		this.s = s;
	}

	public TreeMap<String, String> DataTest() {

		try {
	           Connection conn = DriverManager.getConnection(
//	        		   "jdbc:mysql://localhost:3307/mdb?serverTimezone=UTC","root","root");
	        		   "jdbc:mysql://localhost:3307/lotto649?serverTimezone=UTC","root","root");
	           
//	           ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM emp");
	           PreparedStatement ps = conn.prepareStatement("select * from lotto649_2014 where 期別=?");

           String y = "103000";
           while ((y+s).length()!=9) {
				y += "0";
			}
           y += s;
           System.out.println("期別:"+ y);
   			
           	ps.setString(1, y);
   	    	ResultSet rs = ps.executeQuery();
   	    	
            while(rs.next()) {
            	System.out.println("獎號：[ "+rs.getString(7)+" "+rs.getString(8)+
			            			" "+rs.getString(9)+" "+rs.getString(4)+
			            			" "+rs.getString(5)+" "+rs.getString(6)+
			            			" ] 特別號："+rs.getString(2)); //console顯示
            	
            	ansLotto.put("期別",rs.getString(17)); //寫進字典
            	ansLotto.put("開獎日期",rs.getString(1));
            	ansLotto.put("獎號1",rs.getString(7));
            	ansLotto.put("獎號2",rs.getString(8));
            	ansLotto.put("獎號3",rs.getString(9));
            	ansLotto.put("獎號4",rs.getString(4));
            	ansLotto.put("獎號5",rs.getString(5));
            	ansLotto.put("獎號6",rs.getString(6));
            	ansLotto.put("特別號",rs.getString(2));
            }
		} catch (Exception e) {
			System.out.println("資料庫連線錯誤! "+e);
		}
		System.out.println("資料載入："+ansLotto);
		return ansLotto;
	}
//	public static void main(String[] args) {
//		資料庫連線_Database_Test dd = new 資料庫連線_Database_Test("50");
//		dd.DataTest();
//	}
}
