package java_BOOK;

import java.util.ArrayList;
import java.util.ListIterator;

public class a0726_���X�P�x��_listIterator�s�RŪ�g {

	public static void main(String[] args) {
		System.out.println("�إ�alist���X����");
		ArrayList<String> alist = new ArrayList<>();
		String[] ar = {"�y��","�Ὤ","�Ѳ�","�x�F","����"};
		for(String a:ar) {
			alist.add(a);
		}
		System.out.println("��� alisr ���X���󪺪�l����: "+alist);
		
		System.out.println("�ק� alist ���X���󤸯�");
		//�Ы� �W�Ũ��X���I ListIterator
		ListIterator<String> litera = alist.listIterator();
		while(litera.hasNext()) { //���N�M�����
			litera.next();
			if(litera.nextIndex()==3) { //�Y�J��3�A�h�ᤩ�s������
				litera.set("���J"); // �� set �Y�O�N �쥻���� �קאּ �s�ȡA�G�� �Ѳ� �Q�ק令 ���J �F�I
			}
		}
		System.out.println("��� alisr ���X���󪺪�l����: "+alist);
		
		System.out.println("�ϦV���X alist ���X���󤸯�");
		while(litera.hasPrevious()) { // �]���W�z���Фw��̫�@�Ӥ����A�ݭn�ϦV���N�A�e�@�ӡB�e�@��..
			System.out.println(litera.previous()); //�G�ϥ�previous()��k�ϦV��X
		}
		
		System.out.println("�s�W alist ���X���󤸯�");
		litera = alist.listIterator(3); // listIterator(���w���ޭ�)�A�ᤩ�^�h "�W�Ũ��X��"���ܼ�
		litera.add("���W");				// add �h�O�s�W�@�ӷs����
		
		System.out.println("��� alist ���X����̲פ���: "+alist);
		
	}

}
