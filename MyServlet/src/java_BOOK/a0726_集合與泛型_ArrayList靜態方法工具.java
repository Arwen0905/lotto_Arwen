package java_BOOK;

import java.util.ArrayList;
import java.util.Collections;

public class a0726_集合與泛型_ArrayList靜態方法工具 {

	public static void main(String[] args) {
		ArrayList<String> alist = new ArrayList<>();
		String [] bb = {"EEE","CCC","BBB","DDD","AAA"}; 
		for(String b:bb) {
			alist.add(b);
		}
		System.out.println("顯示alist的集合物件元素: "+alist);
		Collections.sort(alist);
		System.out.println("排序後: "+alist);
		Collections.reverse(alist);
		System.out.println("反排序: "+alist);

	}

}
