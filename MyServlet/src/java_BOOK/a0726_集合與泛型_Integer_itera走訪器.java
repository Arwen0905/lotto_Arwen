package java_BOOK;

import java.util.Iterator;
import java.util.TreeSet;

public class a0726_集合與泛型_Integer_itera走訪器 {

	public static void main(String[] args) {
		TreeSet<Integer> test = new TreeSet<>();
		System.out.println("將1~40 的整數存入 test 集合物件中");
		for(int i=1;i<=40;i++) {
		test.add(i);
		}
		System.out.println(test);
		System.out.println("非質數排除中...");
		//建立走訪器
		Iterator<Integer> itera = test.iterator();
		
		itera.next();
		itera.remove(); //先處理一筆 1 << 非質數
		System.out.println("先處理 1 非質數，查看結果: "+test);
		
		while(itera.hasNext()) {
//			System.out.println("解開運行會報錯喔:"+itera.next()); // ※ 注意不能解開!輸出也會算一次擷取"下一筆"
			int num = itera.next(); //"下一筆"為:2 (設定給一個變數，較好閱讀)
			for(int j=2;j<num;j++) {
//			System.out.println("觀察 num: "+num); //第一次:3
				if(num % j == 0) {
					itera.remove();
					break; //因為比對值已移除，如不離開(break)，則會發生運算錯誤，因為沒有值可以比對了(已經remove)
				}
			}
		}
		
		System.out.println("非質數排除完畢！");
		System.out.println("處理結果為: "+test);
		
	}

}
