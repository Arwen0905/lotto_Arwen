package java_BOOK;

import java.util.*;

public class a0720_���X�P�x��_�򥻤�k {

	public static void main(String[] args) {
//		var hset = new HashSet<>(); //var�����O java10 �����~�X���ŧi�׹����A8���L�k�ϥ�
		Collection<String> hset = new HashSet<>();
		HashSet<Integer> hset1 = new HashSet<>();
		hset.add("�ժ�");
		String[]ar = new String[] {"�C�s","����","�ȪZ"};

		System.out.println(hset);
		for(String s:ar) {
			hset.add(s);
		}
		String myAni = "Ź�K";
		hset.add(myAni);
		System.out.println("���꯫�~:"+hset);

		  
	}

}
