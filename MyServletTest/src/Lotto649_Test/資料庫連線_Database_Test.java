package Lotto649_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeMap;

public class ��Ʈw�s�u_Database_Test {
	String s;
	
    TreeMap<String, String> ansLotto = new TreeMap<>();
    
	��Ʈw�s�u_Database_Test(String s){
		this.s = s;
	}

	public TreeMap<String, String> DataTest() {

		try {
	           Connection conn = DriverManager.getConnection(
//	        		   "jdbc:mysql://localhost:3307/mdb?serverTimezone=UTC","root","root");
	        		   "jdbc:mysql://localhost:3307/lotto649?serverTimezone=UTC","root","root");
	           
//	           ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM emp");
	           PreparedStatement ps = conn.prepareStatement("select * from lotto649_2014 where ���O=?");

           String y = "103000";
           while ((y+s).length()!=9) {
				y += "0";
			}
           y += s;
           System.out.println("���O:"+ y);
   			
           	ps.setString(1, y);
   	    	ResultSet rs = ps.executeQuery();
   	    	
            while(rs.next()) {
            	System.out.println("�����G[ "+rs.getString(7)+" "+rs.getString(8)+
			            			" "+rs.getString(9)+" "+rs.getString(4)+
			            			" "+rs.getString(5)+" "+rs.getString(6)+
			            			" ] �S�O���G"+rs.getString(2)); //console���
            	
            	ansLotto.put("���O",rs.getString(17)); //�g�i�r��
            	ansLotto.put("�}�����",rs.getString(1));
            	ansLotto.put("����1",rs.getString(7));
            	ansLotto.put("����2",rs.getString(8));
            	ansLotto.put("����3",rs.getString(9));
            	ansLotto.put("����4",rs.getString(4));
            	ansLotto.put("����5",rs.getString(5));
            	ansLotto.put("����6",rs.getString(6));
            	ansLotto.put("�S�O��",rs.getString(2));
            }
		} catch (Exception e) {
			System.out.println("��Ʈw�s�u���~! "+e);
		}
		System.out.println("��Ƹ��J�G"+ansLotto);
		return ansLotto;
	}
//	public static void main(String[] args) {
//		��Ʈw�s�u_Database_Test dd = new ��Ʈw�s�u_Database_Test("50");
//		dd.DataTest();
//	}
}
