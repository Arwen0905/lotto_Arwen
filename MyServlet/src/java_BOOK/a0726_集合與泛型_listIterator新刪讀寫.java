package java_BOOK;

import java.util.ArrayList;
import java.util.ListIterator;

public class a0726_集合與泛型_listIterator新刪讀寫 {

	public static void main(String[] args) {
		System.out.println("建立alist集合物件");
		ArrayList<String> alist = new ArrayList<>();
		String[] ar = {"宜蘭","花蓮","天祥","台東","知本"};
		for(String a:ar) {
			alist.add(a);
		}
		System.out.println("顯示 alisr 集合物件的初始元素: "+alist);
		
		System.out.println("修改 alist 集合物件元素");
		//創建 超級走訪器！ ListIterator
		ListIterator<String> litera = alist.listIterator();
		while(litera.hasNext()) { //迭代尋找索引
			litera.next();
			if(litera.nextIndex()==3) { //若遇到3，則賦予新的元素
				litera.set("瑞穗"); // 用 set 即是將 原本元素 修改為 新值，故原 天祥 被修改成 瑞穗 了！
			}
		}
		System.out.println("顯示 alisr 集合物件的初始元素: "+alist);
		
		System.out.println("反向走訪 alist 集合物件元素");
		while(litera.hasPrevious()) { // 因為上述指標已到最後一個元素，需要反向迭代，前一個、前一個..
			System.out.println(litera.previous()); //故使用previous()方法反向輸出
		}
		
		System.out.println("新增 alist 集合物件元素");
		litera = alist.listIterator(3); // listIterator(指定索引值)，賦予回去 "超級走訪器"的變數
		litera.add("池上");				// add 則是新增一個新元素
		
		System.out.println("顯示 alist 集合物件最終元素: "+alist);
		
	}

}
