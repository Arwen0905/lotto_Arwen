package java_BOOK;

import java.util.Map.Entry;
import java.util.TreeMap;

public class a0726_集合與泛型_TreeMap郵遞區號 {

	public static void main(String[] args) {
		TreeMap<Integer,String> tmap = new TreeMap<>();
		tmap.put(260, "宜蘭");
		tmap.put(970, "花蓮");
		tmap.put(500, "彰化");
		tmap.put(900, "屏東");
		tmap.put(600, "嘉義");
		System.out.println("tmap 的集合內容:"+tmap);
		System.out.println("tmap 的集合個數:"+tmap.size());
		
		System.out.println("tmap 集合的指定數值天花板:"+tmap.ceilingKey(300)+"\n");
		System.out.println("tmap 集合的第一個郵遞區號:"+tmap.firstKey());
		System.out.println("tmap 集合的第一個區域:"+tmap.get(tmap.firstKey()));
		System.out.println("tmap 集合的最後一個郵遞區號:"+tmap.lastKey());
		System.out.println("tmap 集合的第一個區域:"+tmap.get(tmap.lastKey()));
		System.out.println("郵遞區號大於等於 600 的元素集合:"+tmap.tailMap(600)); //比較方法 tailMap() 取得部分元素
		System.out.println("郵遞區號大於等於 600 的元素集合:"+tmap.subMap(tmap.firstKey(), tmap.lastKey())); //比較方法 tailMap() 取得部分元素
		
		//以迴圈輸出:第一種方式		
		for(Entry<Integer, String> t:tmap.entrySet()){
			t.getKey();
			t.getValue();
			System.out.println(t.getKey()+"  "+t.getValue());
		}
		
		//測試:map型態為<字串,字串>，則可用此方式輸出
		TreeMap<String,String> tmap2 = new TreeMap<>();
		tmap2.put("QQ", "第一個");
		tmap2.put("TT", "第二個");
		//以迴圈輸出:第二種方式	
		for(String key : tmap2.keySet()){
			String value = tmap2.get(key);
			System.out.println(key+"  "+value);
		}
		
	}

}
