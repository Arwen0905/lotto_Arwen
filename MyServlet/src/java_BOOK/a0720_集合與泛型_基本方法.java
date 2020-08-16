package java_BOOK;

import java.util.*;

public class a0720_集合與泛型_基本方法 {

	public static void main(String[] args) {
//		var hset = new HashSet<>(); //var貌似是 java10 版本才出的宣告修飾詞，8版無法使用
		Collection<String> hset = new HashSet<>();
		HashSet<Integer> hset1 = new HashSet<>();
		hset.add("白虎");
		String[]ar = new String[] {"青龍","朱雀","玄武"};

		System.out.println(hset);
		for(String s:ar) {
			hset.add(s);
		}
		String myAni = "饕餮";
		hset.add(myAni);
		System.out.println("中國神獸:"+hset);

		  
	}

}
