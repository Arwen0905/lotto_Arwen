package Lotto649_Package;

import java.sql.*;
import java.util.TreeMap;
public class lotto649_MySQL {

	    public static void main(String[] args) {
	    	
			TreeMap<String,String> lottoData = new TreeMap<>();

	        try {
	           Connection conn = DriverManager.getConnection(
	        		   "jdbc:mysql://localhost/lotto649?serverTimezone=UTC","root","root");
	           String query = "SELECT * FROM lotto649_2014";
	           
	           Statement stmt = conn.createStatement();
	           ResultSet rs = stmt.executeQuery(query);

	           while(rs.next()) {
	        	   lottoData.put("\n期別:"+rs.getInt("期別")+"\n",rs.getInt("獎號1")+","+
	        	   rs.getInt("獎號2")+","+rs.getInt("獎號3")+","+rs.getInt("獎號4")+","+
	        	   rs.getInt("獎號5")+","+rs.getInt("獎號6")+","+rs.getInt("特別號"));
	        	   
//	        	   System.out.println("獎號 :"+rs.getInt("獎號1")+" "+rs.getInt("獎號2")+" "+rs.getInt("獎號3")
//	        	   						+" "+rs.getInt("獎號4")+" "+rs.getInt("獎號5")+"\n特別號:["+rs.getInt("特別號")+"]");
	        	   
	           }
	        }catch(Exception e) {
	        	System.err.println(e);
	        }
	        
	        
			for(String key : lottoData.keySet()){
				String value = lottoData.get(key);
				System.out.println(key+value);
			}
	        
	    }
}
