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
	        	   lottoData.put("\n���O:"+rs.getInt("���O")+"\n",rs.getInt("����1")+","+
	        	   rs.getInt("����2")+","+rs.getInt("����3")+","+rs.getInt("����4")+","+
	        	   rs.getInt("����5")+","+rs.getInt("����6")+","+rs.getInt("�S�O��"));
	        	   
//	        	   System.out.println("���� :"+rs.getInt("����1")+" "+rs.getInt("����2")+" "+rs.getInt("����3")
//	        	   						+" "+rs.getInt("����4")+" "+rs.getInt("����5")+"\n�S�O��:["+rs.getInt("�S�O��")+"]");
	        	   
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
