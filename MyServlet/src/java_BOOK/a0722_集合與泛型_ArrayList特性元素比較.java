package java_BOOK;

import java.util.ArrayList;

public class a0722_集合與泛型_ArrayList特性元素比較 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		//講義補充:
		//ArrayList 是動態集合，長度不限，資料可重複
		//SortedSet 是建立排序性的集合物件，資料由小到大排序
		//List 是建立循環性的集合物件，List也可以建立「靜態集合」該內容型別為 Object，可重複!
			
		System.out.println("～東部旅遊夜宿規劃～");
		String []ar = {"宜蘭","花蓮","天祥","花蓮","台東"};
		for (String r:ar) {
			arr.add(r);
		}
		System.out.println("初期規劃夜宿天數:");
		System.out.println(arr);
		arr.add("池上");
		arr.add(4,"知本"); //指定位置加入
			
		System.out.println(arr);
		System.out.print("夜宿天祥在第幾天: ");
		System.out.println(arr.indexOf("天祥")+1); //indexOf 搜尋該值，索引表示
		System.out.println("刪除花蓮第一個夜宿");
		arr.remove(arr.indexOf("花蓮"));
		System.out.println(arr);
		System.out.println("確定天數: ");
		System.out.println(arr.size());
		int count = 0;
		for(String r:arr) {
			count++;
			System.out.println("第 "+count+"天夜宿地點:"+r );
		}
		

	}

}
