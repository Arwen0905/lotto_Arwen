package Lotto649_Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class lotto649_MySQL {
		public static String []useLotto;
		public static TreeMap<String,String> ansData;
		public static TreeMap<String,String> ansAjax;
		int bonusAll; //給前端容器 只顯示符合號碼
		private String Year; //年份設定
		public lotto649_MySQL(String ar[],String Year){
			useLotto = ar;
			this.Year = Year;
		}
		public TreeMap<String,String> detect() {
			TreeMap<String,String> lottoData = new TreeMap<>();

	        try {
	           Connection conn = DriverManager.getConnection(
	        		   "jdbc:mysql://localhost:3307/lotto649?serverTimezone=UTC","root","root");
	           
//	           String Year = "2019"; 
	           String query = "SELECT * FROM lotto649_" + Year;
	           Statement stmt = conn.createStatement();
	           ResultSet rs = stmt.executeQuery(query);

	           while(rs.next()) {
	        	   lottoData.put(
    			     "期別" + rs.getInt("期別") ,
    				 "獎號" + rs.getInt("獎號1") +","+ rs.getInt("獎號2") +","+
    						rs.getInt("獎號3") +","+ rs.getInt("獎號4") +","+
    						rs.getInt("獎號5") +","+ rs.getInt("獎號6") +","+ 
    						rs.getInt("特別號"));
	        	   
//	        	   System.out.println("獎號 :"+rs.getInt("獎號1")+" "+rs.getInt("獎號2")+" "+rs.getInt("獎號3")
//	        	   						+" "+rs.getInt("獎號4")+" "+rs.getInt("獎號5")+"\n特別號:["+rs.getInt("特別號")+"]");
	        	   
	           }
	        }catch(Exception e) {
	        	System.err.println(e);
	        }
	        // 樂透獎號 ansLotto
	        String ansLotto[] = new String[7];
//	        TreeMap<String,String> ansData = new TreeMap<>();
	        ansData = new TreeMap<>();
	        
			

			//每一期比對都會從這開始 (forEach)
			for(String key : lottoData.keySet()){
				String value = lottoData.get(key);

				ansLotto = value.split(",");
				
			boolean ticket = true; //比對的門票
			
			//檢查使用者輸入的獎號有沒有重複數字
			for(int i=0; i<6; i++) {
				for(int j=0; j<i; j++) {
					if(useLotto[i].equals(useLotto[j])) {
						System.out.println("數值重複，取消交易");
						ticket = false; //有問題，取消門票
					}
				}
			}
			
			int bonusCheck = 0; //確認符合的中獎數(大樂透規則需至少3個數值要符合)	
			ArrayList<String> bonusNumber = new ArrayList<String>(); //裝入有中獎的號碼
			
			if(ticket) { //沒有重複才能進行比對(True)
				for(int i=0; i<7; i++) {
					for(int j=0; j<6; j++) {
						if(ansLotto[i].equals(useLotto[j])) {
							bonusCheck+=1; //計算符合的獎號數量
//							System.out.print(useLotto[j]+" 獎號符合！");
							bonusNumber.add(useLotto[j]);
//							System.out.println("累積 "+bonusCheck+" 個");
						}
					}
				}
				if(bonusCheck>=3) {
					ansData.put(key, bonusNumber.toString()); // 只裝入中獎的號碼
					bonusAll+=1; // 中獎的總數
//					ansData.put("中獎總數", String.valueOf(bonusAll));

				}else {
//					System.out.println(key);
//					System.out.println("可惜！沒有中獎，下去領500");
				}
			}
			
			}
//			System.out.println("中獎 - 獎號: "+ansData);
//			System.out.println("中獎 - 總數: "+bonusAll);
			return ansData;
			
		}
		
//	    public static void main(String[] args) {
//			String nar[] = {"7","30","32","44","48","49"};
//			lotto649_MySQL a1 = new lotto649_MySQL(nar);
//			a1.detect();
//	    }
		
		
}
