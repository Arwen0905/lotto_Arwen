package java_BOOK;

import java.util.HashSet;

public class a0720_���X�P�x��_�^�y�r�� {
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		HashSet<String> hset = new HashSet<String>();
		String t;
		int order = 1;
		while(order<=4) {
			System.out.println("�п�J���[�J����r(�@�|��)");
			t = input.nextLine();
			if(hset.add(t)) {
				System.out.println(t+"�[�J���\�I");
				order++;
			}else {
				System.out.println(t+"���Ƴ�r�A�Э��s��J!");
			}
		}
		System.out.println("�|�ӳ�r��:"+hset);
		System.out.println("�п�J���d�ߪ���r");
		t = input.nextLine();
		if(hset.contains(t)) {
			System.out.println(t+"���s�b��r�夤");
		}else {
			System.out.println(t+"���s�b��r�夤");
		}
		System.out.println("�п�J���R������r");
		t = input.nextLine();
		if(hset.remove(t)) {
			System.out.println(t+"�w�R�����\");
		}else {
			System.out.println(t+"�R������");
		}
		System.out.println("�ƶq:"+hset.size());
		System.out.println("�ثe���X���󪺤����ӼƬ�:"+hset);
	}

}
