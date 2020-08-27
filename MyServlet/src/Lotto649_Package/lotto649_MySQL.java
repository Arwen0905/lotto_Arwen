package Lotto649_Package;

import java.sql.*;

import java.util.TreeMap;
public class lotto649_MySQL {
		public static String []useLotto;
		public static TreeMap<String,String> ansData;
		
		public lotto649_MySQL(String ar[]){
			useLotto = ar;
		}
		public void detect() {
			TreeMap<String,String> lottoData = new TreeMap<>();

	        try {
	           Connection conn = DriverManager.getConnection(
	        		   "jdbc:mysql://localhost:3307/lotto649?serverTimezone=UTC","root","root");
	           String query = "SELECT * FROM lotto649_2019";
	           
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
	        // 樂透獎號 ansLotto
	        String ansLotto[] = new String[7];
//	        TreeMap<String,String> ansData = new TreeMap<>();
	        ansData = new TreeMap<>();
	        
			int bonusAll = 0;

			//每一期比對都會從這開始
			for(String key : lottoData.keySet()){
				String value = lottoData.get(key);

				ansLotto = value.split(",");
				
			boolean ticket = true;
			
			//先檢查玩家輸入的獎號有沒有重複
			for(int i=0; i<6; i++) {
				for(int j=0; j<i; j++) {
					if(useLotto[i].equals(useLotto[j])) {
						System.out.println("數值重複，取消交易");
						ticket = false;
					}
				}
			}
			int bonusCheck = 0;	
			//沒有重複才會進行比對資格 否則下一組
			if(ticket) {
				for(int i=0; i<7; i++) {
					for(int j=0; j<6; j++) {
						if(ansLotto[i].equals(useLotto[j])) {
							bonusCheck+=1;
							System.out.print(useLotto[j]+" 獎號符合！");
							System.out.println("累積 "+bonusCheck+" 個");
						}
					}
				}
				if(bonusCheck>=3) {
					ansData.put(key, value);
					bonusAll+=1;
				}else {
					System.out.println(key);
					System.out.println("可惜！沒有中獎，下去領500");
				}
			}
			
			}

			System.out.println("中獎 - 獎號: "+ansData);
			System.out.println("中獎 - 總數: "+bonusAll);
			this.ansData = ansData;
		}
//	    public static void main(String[] args) {
//			String nar[] = {"7","30","32","44","48","49"};
//			lotto649_MySQL a1 = new lotto649_MySQL(nar);
//			a1.detect();
//	    }
}
