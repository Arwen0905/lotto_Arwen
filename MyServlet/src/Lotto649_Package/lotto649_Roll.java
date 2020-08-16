package Lotto649_Package;

import java.util.*;

public class lotto649_Roll {

	public static void main(String[] args) {
		int specialNum; //特別碼
		Set<Integer> lottoSet = new LinkedHashSet<Integer>(); //set集合不重複
		List<Integer> lottoSort = new ArrayList<Integer>(); //list集合轉排序用
		
		while(true){ //進while迴圈，轉出6碼+1特別碼
			int n = (int)(Math.random()*49)+1; //隨機的1~49號碼
			lottoSet.add(n); //轉出來就裝進集合裡
			if(lottoSet.size()==7) { //set值不會重複，直到轉出7碼為止，才做結束動作
				specialNum = n; //將最後一碼放進 特別碼變數
				lottoSet.remove(n); //最後一碼取得後即可刪除
				break; //取得 6+1 碼的任務結束，退出迴圈
			}
		}
		System.out.println("大樂透 獎號\n");
		System.out.println("開出順序 "+lottoSet+" 特別碼 "+specialNum);
		
		for(Integer s:lottoSet)lottoSort.add(s); //將set不重複集合放進，可排序的集合陣列
		Collections.sort(lottoSort); //使用排序指令
		System.out.println("大小順序 "+lottoSort+" 特別碼 "+specialNum);
		
//		========================================================================
		List<Integer> userLotto = new ArrayList<>();
		while(true){ //進while迴圈，轉出6碼+1特別碼
			int n = (int)(Math.random()*49)+1; //隨機的1~49號碼
			userLotto.add(n); //轉出來就裝進集合裡
			if(userLotto.size()==6) { //set值不會重複，直到轉出7碼為止，才做結束動作
				break; //取得 6 碼任務結束，退出迴圈
			}
		}
		userLotto = lottoSort;
		System.out.println(userLotto);
        Iterator lot1 = lottoSort.iterator();
        Iterator use2 = userLotto.iterator();
        
        while (lot1.hasNext()) {
        	Object n1 = lot1.next();
        	use2 = userLotto.iterator();
        	while (use2.hasNext()) {
        		Object n2 = use2.next();
        		if(n1.equals(n2)) {
        			System.out.println(n2+" 中了!");
        		}
        	}
        }
        System.out.println(userLotto);
        
//        測試跨頁面使用方法
//        lotto649_Predict dump = new lotto649_Predict();
//        dump.get_x4(8,6);
//        dump.rollLotto(5);
		
	
	}

}

