package java_BOOK;

import java.util.*; //���X���O�����ޤJ���禡�w

public class a0722_���X�P�x��_Set�S�ʤ������ {

	public static void main(String[] args) {

		TreeSet<Integer> test = new TreeSet<>(); //TreeSet �S��:�۵M���ǡA�Ѥp��j�i��Ƨ�
		Integer number[] = {23,45,9,-6,18,93,100,100,76,54,66,89,34,0,-55,-27,61}; //�]�m�}�C�ƭ�
		for(int n:number) {
			test.add(n); //�[�J���X��
		}
		System.out.println("�������e��:");
		System.out.print(test);
		
		System.out.println();
		System.out.print("�Ĥ@�Ӥ������e��: ");
		System.out.print(test.first()); //���Ĥ@�Ӥ���
		System.out.println();
		
		System.out.print("�̫�@�Ӥ������e��: "); //���̫�@�Ӥ���
		System.out.print(test.last());
		System.out.println();
		java.util.Scanner input = new java.util.Scanner(System.in);
		int n;
		System.out.println("�п�J�@�Ӿ��:");
		while(true) {
			try {
				n = Integer.parseInt(input.nextLine()); // !!��b���X�������OObject�A���૬�~����
				break;
			} catch (Exception e) {
				System.out.println("�Э��s��J��ƭ�!");
			}
		}
		if (n >=test.first() && test.last() >= n) { //�]�w�ܼ� �������
			System.out.print("�������e�p�󵥩� "+n+" ��:");
		}else {
			System.out.println("�d����~�I");
		}
		
		
		System.out.print(test.headSet(n));
		System.out.print("\n�������e�j�󵥩� "+n+" ��:");
		
		System.out.print(test.tailSet(n)); // tailSet �����X  ����Ӥ��e�����j��ӭ�(n)
		
		//�}�C�Ʋ�.. ���D:�W���d�ĤG�B�ĥ|�ƭȬ����ޡA���Y�ܧ�1�h�|����
		int [] arr1 = {1,2,3,4,5,6,7,8};
		int [] arr2 = new int[8];
		//System.arraycopy(�ӷ�, �_�l����, �ت�, �_�l����, �ƻs����)
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		for(int i : arr2){
			System.out.print(i + " ");
		}
	}

}
