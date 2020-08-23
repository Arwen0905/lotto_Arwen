package com.servlet;

import java.sql.*;
import java.util.TreeMap;

public class lotto649_Sqlite {

		public static String [] userLotto;
		
		lotto649_Sqlite(String ar[]){
			userLotto = ar;
		}
		public void detect() {
			String year = "2014";
	    	TreeMap<String,String> lottoData = new TreeMap<>();
	    	TreeMap<String,String> ansData = new TreeMap<>();
	    	
	    	
	        try {
	           String url = "jdbc:sqlite:../build/lotto649_BrowserDB.db";
	           Connection conn = DriverManager.getConnection(url);
	           
	           String query = "SELECT * FROM lotto649_"+year;
	           Statement stmt = conn.createStatement();
	           ResultSet rs = stmt.executeQuery(query);
	           while(rs.next()) {
	        	   lottoData.put("\n期別: "+rs.getInt("期別")+"\n",rs.getInt("獎號1")+","+
	        	   rs.getInt("獎號2")+","+rs.getInt("獎號3")+","+rs.getInt("獎號4")+","+
	        	   rs.getInt("獎號5")+","+rs.getInt("獎號6")+","+rs.getInt("特別號"));
	        	   
//	        	   System.out.println("獎號 :"+rs.getInt("獎號1")+" "+rs.getInt("獎號2")+" "+rs.getInt("獎號3")
//	        	   						+" "+rs.getInt("獎號4")+" "+rs.getInt("獎號5")+"\n特別號:["+rs.getInt("特別號")+"]");
	        	   
	           }
	        }catch(Exception e) {
	        	System.err.println(e);
	        }
	        
	        // todo.. 使用者的樂透號碼
			String ansLotto[] = new String[7];
			int bonus = 0;

	        
	        for(String key : lottoData.keySet()){
	        	String value = lottoData.get(key);
//				System.out.println(key+value);
//	        	System.out.println(value);
	        	ansLotto = value.split(","); // 轉成陣列
	        
		        boolean ticket = true; // 對獎門票
	    		for(int i=0; i<6; i++){
	    			for(int j=0; j<i; j++){
	    				if(userLotto[i].equals(userLotto[j])){
	    					System.out.println("請檢查重複號碼: "+userLotto[i]+"，請重新設定");
	    					ticket = false; // 有重複值就沒收門票
	    					break; // 終止對獎
	    				}
	    			}
	    		}
	
	    		if(ticket){ // 門票為 true 即符合對獎資格
	    			System.out.println("符合資格，進行對獎！");
	    		}
		        
	    		int checkbonus = 0;
				for(int i=0; i<7; i++){
					for(int j=0; j<6; j++){
						if(userLotto[j].equals(ansLotto[i])){
							checkbonus+=1;
							System.out.println(userLotto[j] + " 號碼符合! 目前累積 " + checkbonus + " 個號碼獎號\n");
						}
					}
				}

				if(checkbonus>=3){
					bonus += 1;
					ansData.put(key, value);
					System.out.println("恭喜中獎! " +key+ "\n獎號 "+value+" 共符合" + checkbonus + "個號碼\n");
				}else{
					System.out.println("可惜！沒有中獎，下去領500\n");
				}
	        }
	        System.out.println(year+"中獎 - 期號: "+ansData);
	        System.out.println(year+"中獎 - 總數: "+bonus);
		}
	    public static void main(String[] args) {
	    	String nar[] = {"22","31","34","9","12","15"};
	    	lotto649_Sqlite a1 = new lotto649_Sqlite(nar);
	    	a1.detect();
	        
	    }
}

