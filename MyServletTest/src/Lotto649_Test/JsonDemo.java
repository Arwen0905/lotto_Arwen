package Lotto649_Test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class JsonDemo {
	public static void main(String[] args) throws JSONException  {
		// 利用bean來產生一個對應的JSONObject
		PeopleBean may = new PeopleBean("may", 27, false);
		JSONObject jsonObjectMay = new JSONObject(may);
		System.out.println("1.json基本建構:"+jsonObjectMay);
		
		// 利用map的對照來產生JSONObject
		Map<Object,Object> jacky = new HashMap<>();
		jacky.put("name", "jacky");
		jacky.put("age", 30);
		jacky.put("gender", true);
		System.out.println("2.泛型字典"+jacky);
		JSONObject jsonObjectJacky = new JSONObject(jacky);
		System.out.println("3"+jsonObjectJacky);
		
		// 每個JSONObject都能利用JSONObject.put(key, value)來增加屬性
		jsonObjectJacky.put("height", 170);
		System.out.println("4.指令 put加入:"+jsonObjectJacky);
		
		// 利用 JSON 的字串產生 JSONObject
		String toJacky = jsonObjectJacky.toString(); //轉字串後只會取到 Key
		JSONObject forJacky = new JSONObject(toJacky);
		System.out.println("5.字串產生的json資料:"+forJacky);
		
		// JSONObject.get(key) 可取得 JSONObject中對應的值
		// 找不到的話會丟出 org.json.JSONException如下面註解掉那行
		System.out.println("6.指令 get取值:"+forJacky.get("name"));
		
		// 由 JSONArray.names()取回 names的JSONArray
		JSONArray jsonArrayNames = jsonObjectJacky.names();
		System.out.println("7.指令 .names()取Key:"+jsonArrayNames);
		
		// JSONArray 可藉由 JSONArray.put(value)來增加Array的值
		jsonArrayNames.put("Weight");
		System.out.println("8.JSONArray也可以 指令 put加入:"+jsonArrayNames);
			
		
	}
}	
