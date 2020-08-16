package java_BOOK;

import java.util.*; //集合類別必須引入的函式庫

public class a0722_集合與泛型_Set特性元素比較 {

	public static void main(String[] args) {

		TreeSet<Integer> test = new TreeSet<>(); //TreeSet 特性:自然順序，由小到大進行排序
		Integer number[] = {23,45,9,-6,18,93,100,100,76,54,66,89,34,0,-55,-27,61}; //設置陣列數值
		for(int n:number) {
			test.add(n); //加入集合裡
		}
		System.out.println("元素內容為:");
		System.out.print(test);
		
		System.out.println();
		System.out.print("第一個元素內容為: ");
		System.out.print(test.first()); //取第一個元素
		System.out.println();
		
		System.out.print("最後一個元素內容為: "); //取最後一個元素
		System.out.print(test.last());
		System.out.println();
		java.util.Scanner input = new java.util.Scanner(System.in);
		int n;
		System.out.println("請輸入一個整數:");
		while(true) {
			try {
				n = Integer.parseInt(input.nextLine()); // !!放在集合的元素是Object，需轉型才能比較
				break;
			} catch (Exception e) {
				System.out.println("請重新輸入整數值!");
			}
		}
		if (n >=test.first() && test.last() >= n) { //設定變數 為比較值
			System.out.print("元素內容小於等於 "+n+" 者:");
		}else {
			System.out.println("範圍錯誤！");
		}
		
		
		System.out.print(test.headSet(n));
		System.out.print("\n元素內容大於等於 "+n+" 者:");
		
		System.out.print(test.tailSet(n)); // tailSet 為取出  比較該內容元素大於該值(n)
		
		//陣列複習.. 問題:上網查第二、第四數值為索引，但若變更1則會報錯
		int [] arr1 = {1,2,3,4,5,6,7,8};
		int [] arr2 = new int[8];
		//System.arraycopy(來源, 起始索引, 目的, 起始索引, 複製長度)
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		for(int i : arr2){
			System.out.print(i + " ");
		}
	}

}
