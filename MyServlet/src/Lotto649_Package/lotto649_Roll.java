package Lotto649_Package;

import java.util.*;

public class lotto649_Roll {

	public static void main(String[] args) {
		int specialNum; //�S�O�X
		Set<Integer> lottoSet = new LinkedHashSet<Integer>(); //set���X������
		List<Integer> lottoSort = new ArrayList<Integer>(); //list���X��Ƨǥ�
		
		while(true){ //�iwhile�j��A��X6�X+1�S�O�X
			int n = (int)(Math.random()*49)+1; //�H����1~49���X
			lottoSet.add(n); //��X�ӴN�˶i���X��
			if(lottoSet.size()==7) { //set�Ȥ��|���ơA������X7�X����A�~�������ʧ@
				specialNum = n; //�N�̫�@�X��i �S�O�X�ܼ�
				lottoSet.remove(n); //�̫�@�X���o��Y�i�R��
				break; //���o 6+1 �X�����ȵ����A�h�X�j��
			}
		}
		System.out.println("�j�ֳz ����\n");
		System.out.println("�}�X���� "+lottoSet+" �S�O�X "+specialNum);
		
		for(Integer s:lottoSet)lottoSort.add(s); //�Nset�����ƶ��X��i�A�i�ƧǪ����X�}�C
		Collections.sort(lottoSort); //�ϥαƧǫ��O
		System.out.println("�j�p���� "+lottoSort+" �S�O�X "+specialNum);
		
//		========================================================================
		List<Integer> userLotto = new ArrayList<>();
		while(true){ //�iwhile�j��A��X6�X+1�S�O�X
			int n = (int)(Math.random()*49)+1; //�H����1~49���X
			userLotto.add(n); //��X�ӴN�˶i���X��
			if(userLotto.size()==6) { //set�Ȥ��|���ơA������X7�X����A�~�������ʧ@
				break; //���o 6 �X���ȵ����A�h�X�j��
			}
		}
		userLotto = lottoSort;
		System.out.println(userLotto);
        Iterator lot1 = lottoSort.iterator();
        Iterator use2 = userLotto.iterator();
        
        while (lot1.hasNext()) {
        	Object n1 = lot1.next();
        	use2 = userLotto.iterator();
        	while (use2.hasNext()) {
        		Object n2 = use2.next();
        		if(n1.equals(n2)) {
        			System.out.println(n2+" ���F!");
        		}
        	}
        }
        System.out.println(userLotto);
        
//        ���ո󭶭��ϥΤ�k
//        lotto649_Predict dump = new lotto649_Predict();
//        dump.get_x4(8,6);
//        dump.rollLotto(5);
		
	
	}

}

