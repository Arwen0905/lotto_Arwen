package java_BOOK;

class Baseball{ //�]�w"�βy"�����ݩʩM��k
	private boolean isThrow = false; //���� �βy�B�ʬ����ʩʡA�@��@��
// �� �y �� �k ===============================================================	
//		wait�����󭭨�: �����g�b synchronized �ԭz�ϡA�èϥ�try-catch �����ҥ~�Awhile ����J�����קK������������
	synchronized void pBall(int n) { //��y����k
  //��k1
		//���F�I�� "�르�`��"�A�B�Ρuwait()���ݡBnotify()�I�s�v
//		while(isThrow) { //�Q��while���ت������ 1.�����j��ݨD 2.��JĲ�o����
//			try { //wait()�����˦btry�Bcatch�����̭�
//				wait(); //������
//			} catch (Exception e) {}
//		}
  //��k2
//		����while�j�骺�覡�A�]�르���Ʒ|��run()��kĲ�o�A�ҥH�C���i�Ө��]�u�ݭn�� ��B�� �`�� ���P�_/����ԭz
		if(isThrow == true) { //���\��y���O:�ǳƤU�@�B
			try {
				wait(); //������wait���O�A�i�J�uWait pool�v(���ݦ�)�ݭn���@��! ���� notify�q���~�i�i��U�@�B
			} catch (Exception e) {}
		}
		isThrow = true; //���\��y
		System.out.println("��X��"+n+"�y�I"); //��X��X��n�y
		notify(); //�I�s����:�I�s�t�@�Ӱ����
	}
	
// �� �� �� �k ===============================================================
//	������k(hBall)���� �P�W�z��y(pBall)
	synchronized void hBall(int n) { //��������k
  //��k1
//		while(!isThrow) {
//			try {
//				wait();
//			} catch (Exception e) {}
//		}
  //��k2
		if(isThrow != true) {
			try {
				wait();
			} catch (Exception e) {}
		}
		System.out.println("��"+n+"�����ΡI");
		isThrow = false;
		notify(); //����n�� �����A�N�q���t�@�Ӱ����(��y��k) pBall()
	}
}
// �� �@ �� �� ===============================================================
// �����:������
class hit implements Runnable{
	Baseball baseball; //�ѫإ߮ɤޤJ��(�βy�ݩʻP��k)
	hit(Baseball baseball){ //�غc�l�]�w
		this.baseball = baseball; //�ޤJ�ѼƳ]�w
	}
	
	public void run() { //�����:�Ұ�
		for(int i=1;i<=5;i++) {
			baseball.hBall(i); //�`�N!�P��⪺������|�@�_�Ұ�
			System.out.println("run��k: �[���: "+i);
		}
	}
}
//�����:���
class pitching implements Runnable{
	Baseball ee; //�ѫإ߮ɤޤJ��(�βy�ݩʻP��k)

	pitching(Baseball baseball){ //�غc�l�]�w
		this.ee = baseball; //�ޤJ�ѼƳ]�w
	}
	
	public void run(){ //�����:�Ұ�
		for(int i=1;i<=5;i++) {			
			ee.pBall(i);//�`�N!�P�����⪺������|�@�_�Ұ�
			System.out.println("run��k: �[���X: "+i);
		}
	}
}
public class a0720_���βy10_28 {
	public static void main(String[] args) {
		Baseball ff = new Baseball(); //�Ы� ���O���� "�βy"
		Thread pitching = new Thread(new pitching(ff));//�Ыا���k(�βy�ݩʻP��k)
		Thread hit = new Thread(new hit(ff)); //�Ыإ����k(�غc��:��J�βy�ݩʻP��k)
		
		hit.start(); 	  //������:�}�l�ʧ@
		pitching.start(); //���:�}�l�ʧ@
	}
}
