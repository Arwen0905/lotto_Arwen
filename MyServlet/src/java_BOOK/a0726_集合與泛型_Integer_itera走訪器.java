package java_BOOK;

import java.util.Iterator;
import java.util.TreeSet;

public class a0726_���X�P�x��_Integer_itera���X�� {

	public static void main(String[] args) {
		TreeSet<Integer> test = new TreeSet<>();
		System.out.println("�N1~40 ����Ʀs�J test ���X����");
		for(int i=1;i<=40;i++) {
		test.add(i);
		}
		System.out.println(test);
		System.out.println("�D��Ʊư���...");
		//�إߨ��X��
		Iterator<Integer> itera = test.iterator();
		
		itera.next();
		itera.remove(); //���B�z�@�� 1 << �D���
		System.out.println("���B�z 1 �D��ơA�d�ݵ��G: "+test);
		
		while(itera.hasNext()) {
//			System.out.println("�Ѷ}�B��|������:"+itera.next()); // �� �`�N����Ѷ}!��X�]�|��@���^��"�U�@��"
			int num = itera.next(); //"�U�@��"��:2 (�]�w���@���ܼơA���n�\Ū)
			for(int j=2;j<num;j++) {
//			System.out.println("�[�� num: "+num); //�Ĥ@��:3
				if(num % j == 0) {
					itera.remove();
					break; //�]�����Ȥw�����A�p�����}(break)�A�h�|�o�͹B����~�A�]���S���ȥi�H���F(�w�gremove)
				}
			}
		}
		
		System.out.println("�D��Ʊư������I");
		System.out.println("�B�z���G��: "+test);
		
	}

}
