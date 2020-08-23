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
	        	   lottoData.put("\n���O: "+rs.getInt("���O")+"\n",rs.getInt("����1")+","+
	        	   rs.getInt("����2")+","+rs.getInt("����3")+","+rs.getInt("����4")+","+
	        	   rs.getInt("����5")+","+rs.getInt("����6")+","+rs.getInt("�S�O��"));
	        	   
//	        	   System.out.println("���� :"+rs.getInt("����1")+" "+rs.getInt("����2")+" "+rs.getInt("����3")
//	        	   						+" "+rs.getInt("����4")+" "+rs.getInt("����5")+"\n�S�O��:["+rs.getInt("�S�O��")+"]");
	        	   
	           }
	        }catch(Exception e) {
	        	System.err.println(e);
	        }
	        
	        // todo.. �ϥΪ̪��ֳz���X
			String ansLotto[] = new String[7];
			int bonus = 0;

	        
	        for(String key : lottoData.keySet()){
	        	String value = lottoData.get(key);
//				System.out.println(key+value);
//	        	System.out.println(value);
	        	ansLotto = value.split(","); // �ন�}�C
	        
		        boolean ticket = true; // �������
	    		for(int i=0; i<6; i++){
	    			for(int j=0; j<i; j++){
	    				if(userLotto[i].equals(userLotto[j])){
	    					System.out.println("���ˬd���Ƹ��X: "+userLotto[i]+"�A�Э��s�]�w");
	    					ticket = false; // �����ƭȴN�S������
	    					break; // �פ���
	    				}
	    			}
	    		}
	
	    		if(ticket){ // ������ true �Y�ŦX������
	    			System.out.println("�ŦX���A�i�����I");
	    		}
		        
	    		int checkbonus = 0;
				for(int i=0; i<7; i++){
					for(int j=0; j<6; j++){
						if(userLotto[j].equals(ansLotto[i])){
							checkbonus+=1;
							System.out.println(userLotto[j] + " ���X�ŦX! �ثe�ֿn " + checkbonus + " �Ӹ��X����\n");
						}
					}
				}

				if(checkbonus>=3){
					bonus += 1;
					ansData.put(key, value);
					System.out.println("���ߤ���! " +key+ "\n���� "+value+" �@�ŦX" + checkbonus + "�Ӹ��X\n");
				}else{
					System.out.println("�i���I�S�������A�U�h��500\n");
				}
	        }
	        System.out.println(year+"���� - ����: "+ansData);
	        System.out.println(year+"���� - �`��: "+bonus);
		}
	    public static void main(String[] args) {
	    	String nar[] = {"22","31","34","9","12","15"};
	    	lotto649_Sqlite a1 = new lotto649_Sqlite(nar);
	    	a1.detect();
	        
	    }
}

