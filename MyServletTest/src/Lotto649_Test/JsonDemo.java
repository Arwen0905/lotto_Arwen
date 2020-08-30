package Lotto649_Test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class JsonDemo {
	public static void main(String[] args) throws JSONException  {
		// �Q��bean�Ӳ��ͤ@�ӹ�����JSONObject
		PeopleBean may = new PeopleBean("may", 27, false);
		JSONObject jsonObjectMay = new JSONObject(may);
		System.out.println("1.json�򥻫غc:"+jsonObjectMay);
		
		// �Q��map����ӨӲ���JSONObject
		Map<Object,Object> jacky = new HashMap<>();
		jacky.put("name", "jacky");
		jacky.put("age", 30);
		jacky.put("gender", true);
		System.out.println("2.�x���r��"+jacky);
		JSONObject jsonObjectJacky = new JSONObject(jacky);
		System.out.println("3"+jsonObjectJacky);
		
		// �C��JSONObject����Q��JSONObject.put(key, value)�ӼW�[�ݩ�
		jsonObjectJacky.put("height", 170);
		System.out.println("4.���O put�[�J:"+jsonObjectJacky);
		
		// �Q�� JSON ���r�겣�� JSONObject
		String toJacky = jsonObjectJacky.toString(); //��r���u�|���� Key
		JSONObject forJacky = new JSONObject(toJacky);
		System.out.println("5.�r�겣�ͪ�json���:"+forJacky);
		
		// JSONObject.get(key) �i���o JSONObject����������
		// �䤣�쪺�ܷ|��X org.json.JSONException�p�U�����ѱ�����
		System.out.println("6.���O get����:"+forJacky.get("name"));
		
		// �� JSONArray.names()���^ names��JSONArray
		JSONArray jsonArrayNames = jsonObjectJacky.names();
		System.out.println("7.���O .names()��Key:"+jsonArrayNames);
		
		// JSONArray �i�ǥ� JSONArray.put(value)�ӼW�[Array����
		jsonArrayNames.put("Weight");
		System.out.println("8.JSONArray�]�i�H ���O put�[�J:"+jsonArrayNames);
			
		
	}
}	
