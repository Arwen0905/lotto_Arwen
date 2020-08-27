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
	        	   lottoData.put("\n���O:"+rs.getInt("���O")+"\n",rs.getInt("����1")+","+
	        	   rs.getInt("����2")+","+rs.getInt("����3")+","+rs.getInt("����4")+","+
	        	   rs.getInt("����5")+","+rs.getInt("����6")+","+rs.getInt("�S�O��"));
	        	   
//	        	   System.out.println("���� :"+rs.getInt("����1")+" "+rs.getInt("����2")+" "+rs.getInt("����3")
//	        	   						+" "+rs.getInt("����4")+" "+rs.getInt("����5")+"\n�S�O��:["+rs.getInt("�S�O��")+"]");
	        	   
	           }
	        }catch(Exception e) {
	        	System.err.println(e);
	        }
	        // �ֳz���� ansLotto
	        String ansLotto[] = new String[7];
//	        TreeMap<String,String> ansData = new TreeMap<>();
	        ansData = new TreeMap<>();
	        
			int bonusAll = 0;

			//�C�@����ﳣ�|�q�o�}�l
			for(String key : lottoData.keySet()){
				String value = lottoData.get(key);

				ansLotto = value.split(",");
				
			boolean ticket = true;
			
			//���ˬd���a��J���������S������
			for(int i=0; i<6; i++) {
				for(int j=0; j<i; j++) {
					if(useLotto[i].equals(useLotto[j])) {
						System.out.println("�ƭȭ��ơA�������");
						ticket = false;
					}
				}
			}
			int bonusCheck = 0;	
			//�S�����Ƥ~�|�i������ �_�h�U�@��
			if(ticket) {
				for(int i=0; i<7; i++) {
					for(int j=0; j<6; j++) {
						if(ansLotto[i].equals(useLotto[j])) {
							bonusCheck+=1;
							System.out.print(useLotto[j]+" �����ŦX�I");
							System.out.println("�ֿn "+bonusCheck+" ��");
						}
					}
				}
				if(bonusCheck>=3) {
					ansData.put(key, value);
					bonusAll+=1;
				}else {
					System.out.println(key);
					System.out.println("�i���I�S�������A�U�h��500");
				}
			}
			
			}

			System.out.println("���� - ����: "+ansData);
			System.out.println("���� - �`��: "+bonusAll);
			this.ansData = ansData;
		}
//	    public static void main(String[] args) {
//			String nar[] = {"7","30","32","44","48","49"};
//			lotto649_MySQL a1 = new lotto649_MySQL(nar);
//			a1.detect();
//	    }
}
