package Lotto649_Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class lotto649_MySQL {
		public static String []useLotto;
		public static TreeMap<String,String> ansData;
		public static TreeMap<String,String> ansAjax;
		int bonusAll; //���e�ݮe�� �u��ܲŦX���X
		private String Year; //�~���]�w
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
    			     "���O" + rs.getInt("���O") ,
    				 "����" + rs.getInt("����1") +","+ rs.getInt("����2") +","+
    						rs.getInt("����3") +","+ rs.getInt("����4") +","+
    						rs.getInt("����5") +","+ rs.getInt("����6") +","+ 
    						rs.getInt("�S�O��"));
	        	   
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
	        
			

			//�C�@����ﳣ�|�q�o�}�l (forEach)
			for(String key : lottoData.keySet()){
				String value = lottoData.get(key);

				ansLotto = value.split(",");
				
			boolean ticket = true; //��諸����
			
			//�ˬd�ϥΪ̿�J���������S�����ƼƦr
			for(int i=0; i<6; i++) {
				for(int j=0; j<i; j++) {
					if(useLotto[i].equals(useLotto[j])) {
						System.out.println("�ƭȭ��ơA�������");
						ticket = false; //�����D�A��������
					}
				}
			}
			
			int bonusCheck = 0; //�T�{�ŦX��������(�j�ֳz�W�h�ݦܤ�3�Ӽƭȭn�ŦX)	
			ArrayList<String> bonusNumber = new ArrayList<String>(); //�ˤJ�����������X
			
			if(ticket) { //�S�����Ƥ~��i����(True)
				for(int i=0; i<7; i++) {
					for(int j=0; j<6; j++) {
						if(ansLotto[i].equals(useLotto[j])) {
							bonusCheck+=1; //�p��ŦX�������ƶq
//							System.out.print(useLotto[j]+" �����ŦX�I");
							bonusNumber.add(useLotto[j]);
//							System.out.println("�ֿn "+bonusCheck+" ��");
						}
					}
				}
				if(bonusCheck>=3) {
					ansData.put(key, bonusNumber.toString()); // �u�ˤJ���������X
					bonusAll+=1; // �������`��
//					ansData.put("�����`��", String.valueOf(bonusAll));

				}else {
//					System.out.println(key);
//					System.out.println("�i���I�S�������A�U�h��500");
				}
			}
			
			}
//			System.out.println("���� - ����: "+ansData);
//			System.out.println("���� - �`��: "+bonusAll);
			return ansData;
			
		}
		
//	    public static void main(String[] args) {
//			String nar[] = {"7","30","32","44","48","49"};
//			lotto649_MySQL a1 = new lotto649_MySQL(nar);
//			a1.detect();
//	    }
		
		
}
