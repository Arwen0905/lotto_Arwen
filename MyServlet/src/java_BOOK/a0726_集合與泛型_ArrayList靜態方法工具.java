package java_BOOK;

import java.util.ArrayList;
import java.util.Collections;

public class a0726_���X�P�x��_ArrayList�R�A��k�u�� {

	public static void main(String[] args) {
		ArrayList<String> alist = new ArrayList<>();
		String [] bb = {"EEE","CCC","BBB","DDD","AAA"}; 
		for(String b:bb) {
			alist.add(b);
		}
		System.out.println("���alist�����X���󤸯�: "+alist);
		Collections.sort(alist);
		System.out.println("�Ƨǫ�: "+alist);
		Collections.reverse(alist);
		System.out.println("�ϱƧ�: "+alist);

	}

}
