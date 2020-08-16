package java_BOOK;

import java.util.*;

public class a0726_���X�P�x��_LinkedList��C {

	public static void main(String[] args) {
		List<String> place = Arrays.asList("ī�G", "����", "����", "�_���G", "�ݼ�");
		List<String> night = new ArrayList<>();
		for(String p:place) {
			night.add(p);
		}
		
		System.out.println("��C�����e�ᶶ��:");
		for(int i=0;i<night.size();i++) {
			System.out.println("��"+(i+1)+"��: "+night.get(i));
		}
		
		LinkedList<String> queue = new LinkedList<>(night);
		System.out.println("\n���X�覡(��C): ���i���X getFirst()");
		for(int i=0;i<night.size();i++) {
			System.out.print(queue.getFirst()+" ");
			queue.removeFirst(); // LinkedList���w�Y����X�A����R���Ӷ��ءA�a�j��̧ǿ�X�C�@��
		}
		
		LinkedList<String> stack = new LinkedList<>(night);
		System.out.println("\n���X�覡(���|): ��i���X getLast()");
		while(true) {//�L���P�_���ת��j��覡�A�����U�h�X����A�_�h���j��
			System.out.print(stack.getLast()+" ");
			stack.removeLast();
			if(stack.isEmpty()) break; //isEmpty�i�P�_�O�_�ŭȤF�A�O�h�h�X
		}
		
	}

}
