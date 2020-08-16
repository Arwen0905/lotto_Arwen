package java_BOOK;

import java.util.*;

public class a0726_集合與泛型_LinkedList佇列 {

	public static void main(String[] args) {
		List<String> place = Arrays.asList("蘋果", "水梨", "香蕉", "奇異果", "芭樂");
		List<String> night = new ArrayList<>();
		for(String p:place) {
			night.add(p);
		}
		
		System.out.println("串列元素前後順序:");
		for(int i=0;i<night.size();i++) {
			System.out.println("第"+(i+1)+"個: "+night.get(i));
		}
		
		LinkedList<String> queue = new LinkedList<>(night);
		System.out.println("\n取出方式(佇列): 先進先出 getFirst()");
		for(int i=0;i<night.size();i++) {
			System.out.print(queue.getFirst()+" ");
			queue.removeFirst(); // LinkedList指定頭尾輸出，之後刪除該項目，靠迴圈依序輸出每一筆
		}
		
		LinkedList<String> stack = new LinkedList<>(night);
		System.out.println("\n取出方式(堆疊): 後進先出 getLast()");
		while(true) {//無須判斷長度的迴圈方式，但須下退出條件，否則死迴圈
			System.out.print(stack.getLast()+" ");
			stack.removeLast();
			if(stack.isEmpty()) break; //isEmpty可判斷是否空值了，是則退出
		}
		
	}

}
