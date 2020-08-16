package java_BOOK;

import java.util.Map.Entry;
import java.util.TreeMap;

public class a0726_���X�P�x��_TreeMap�l���ϸ� {

	public static void main(String[] args) {
		TreeMap<Integer,String> tmap = new TreeMap<>();
		tmap.put(260, "�y��");
		tmap.put(970, "�Ὤ");
		tmap.put(500, "����");
		tmap.put(900, "�̪F");
		tmap.put(600, "�Ÿq");
		System.out.println("tmap �����X���e:"+tmap);
		System.out.println("tmap �����X�Ӽ�:"+tmap.size());
		
		System.out.println("tmap ���X�����w�ƭȤѪ�O:"+tmap.ceilingKey(300)+"\n");
		System.out.println("tmap ���X���Ĥ@�Ӷl���ϸ�:"+tmap.firstKey());
		System.out.println("tmap ���X���Ĥ@�Ӱϰ�:"+tmap.get(tmap.firstKey()));
		System.out.println("tmap ���X���̫�@�Ӷl���ϸ�:"+tmap.lastKey());
		System.out.println("tmap ���X���Ĥ@�Ӱϰ�:"+tmap.get(tmap.lastKey()));
		System.out.println("�l���ϸ��j�󵥩� 600 ���������X:"+tmap.tailMap(600)); //�����k tailMap() ���o��������
		System.out.println("�l���ϸ��j�󵥩� 600 ���������X:"+tmap.subMap(tmap.firstKey(), tmap.lastKey())); //�����k tailMap() ���o��������
		
		//�H�j���X:�Ĥ@�ؤ覡		
		for(Entry<Integer, String> t:tmap.entrySet()){
			t.getKey();
			t.getValue();
			System.out.println(t.getKey()+"  "+t.getValue());
		}
		
		//����:map���A��<�r��,�r��>�A�h�i�Φ��覡��X
		TreeMap<String,String> tmap2 = new TreeMap<>();
		tmap2.put("QQ", "�Ĥ@��");
		tmap2.put("TT", "�ĤG��");
		//�H�j���X:�ĤG�ؤ覡	
		for(String key : tmap2.keySet()){
			String value = tmap2.get(key);
			System.out.println(key+"  "+value);
		}
		
	}

}
