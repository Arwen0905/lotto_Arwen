package java_BOOK;

class GoldClass2 implements Runnable{
	int grabed; //�w���쪺����
	static int total;
	static int totalGold = 2000000; //�����`��
	Thread t; //�H��������O �ŧi���� t
//	t.setName(name); //�o�ڥ����ΤF
	GoldClass2(String name){ //�غc��
		grabed = 0; //�C���s�ت���A��l�� ��������
		t = new Thread(this,name); //�إߦW��
		t.start(); //������Ұ�
	}
	public void run(){
		while(grabGold() == true) {
			grabed++;
		}
		System.out.println(t.getName()+"����F"+grabed);
		System.out.println(t.getName()+"�~���ֿn�������ƥ�: "+total+" + "+grabed+" = "+(total+=grabed));
	}
	public static synchronized boolean grabGold() { //�n��i while �� if �P�_�ɡA�ݫŧi���L���A;
		if(totalGold>0) {
			totalGold--;
			if(totalGold<5) {				
				System.out.println("�����l��: "+totalGold);
			}
			if(totalGold==0) {
//				total+=grabed;
				System.out.println("�̲׫��쪺�����`��: "+total);
			}
			return true;
		}else {
			return false;
		}
	}
}
public class a0719_���W���q_������ {

	public static void main(String[] args) {
		System.out.println("�@��"+GoldClass2.totalGold+"����!");
		GoldClass2 a1 = new GoldClass2("A�p��");
		GoldClass2 b2 = new GoldClass2("B�p��");
		GoldClass2 c3 = new GoldClass2("C�p��");

	}

}
