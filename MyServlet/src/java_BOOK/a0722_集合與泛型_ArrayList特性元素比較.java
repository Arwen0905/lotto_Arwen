package java_BOOK;

import java.util.ArrayList;

public class a0722_���X�P�x��_ArrayList�S�ʤ������ {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		//���q�ɥR:
		//ArrayList �O�ʺA���X�A���פ����A��ƥi����
		//SortedSet �O�إ߱Ƨǩʪ����X����A��ƥѤp��j�Ƨ�
		//List �O�إߴ`���ʪ����X����AList�]�i�H�إߡu�R�A���X�v�Ӥ��e���O�� Object�A�i����!
			
		System.out.println("��F���ȹC�]�J�W����");
		String []ar = {"�y��","�Ὤ","�Ѳ�","�Ὤ","�x�F"};
		for (String r:ar) {
			arr.add(r);
		}
		System.out.println("����W���]�J�Ѽ�:");
		System.out.println(arr);
		arr.add("���W");
		arr.add(4,"����"); //���w��m�[�J
			
		System.out.println(arr);
		System.out.print("�]�J�Ѳ��b�ĴX��: ");
		System.out.println(arr.indexOf("�Ѳ�")+1); //indexOf �j�M�ӭȡA���ު��
		System.out.println("�R���Ὤ�Ĥ@�ө]�J");
		arr.remove(arr.indexOf("�Ὤ"));
		System.out.println(arr);
		System.out.println("�T�w�Ѽ�: ");
		System.out.println(arr.size());
		int count = 0;
		for(String r:arr) {
			count++;
			System.out.println("�� "+count+"�ѩ]�J�a�I:"+r );
		}
		

	}

}
