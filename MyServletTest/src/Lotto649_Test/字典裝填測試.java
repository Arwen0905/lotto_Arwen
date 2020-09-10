package Lotto649_Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ¦r¨å¸Ë¶ñ´ú¸Õ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> tt = new TreeMap<String, String>();
		tt.put("´ú¸Õ", "QQQ");
		System.out.println(tt);
		
		TreeSet<Integer> nn = new TreeSet<Integer>();
		while(nn.size()!=6) {
			nn.add((int)(Math.random()*49)+1);
		}
		
		String aa[] = new String[6];
		int i=0;
		for(int s:nn) {
			aa[i] = String.valueOf(s);
			i++;
		}
		System.out.println(nn+" << nn");
		System.out.println(aa+" << aa");
        lotto649_MySQL lottoGo = new lotto649_MySQL(aa);
        Map<String, String> ansData = new TreeMap<>();
        ansData = lottoGo.detect();
        ansData.put("Q", "Q"); 
        System.out.println(ansData);
        
	}

}
