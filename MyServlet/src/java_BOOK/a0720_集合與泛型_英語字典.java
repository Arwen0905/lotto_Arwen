package java_BOOK;

import java.util.HashSet;

public class a0720_集合與泛型_英語字典 {
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		HashSet<String> hset = new HashSet<String>();
		String t;
		int order = 1;
		while(order<=4) {
			System.out.println("請輸入欲加入的單字(共四筆)");
			t = input.nextLine();
			if(hset.add(t)) {
				System.out.println(t+"加入成功！");
				order++;
			}else {
				System.out.println(t+"重複單字，請重新輸入!");
			}
		}
		System.out.println("四個單字為:"+hset);
		System.out.println("請輸入欲查詢的單字");
		t = input.nextLine();
		if(hset.contains(t)) {
			System.out.println(t+"有存在於字典中");
		}else {
			System.out.println(t+"不存在於字典中");
		}
		System.out.println("請輸入欲刪除的單字");
		t = input.nextLine();
		if(hset.remove(t)) {
			System.out.println(t+"已刪除成功");
		}else {
			System.out.println(t+"刪除失敗");
		}
		System.out.println("數量:"+hset.size());
		System.out.println("目前集合物件的元素個數為:"+hset);
	}

}
