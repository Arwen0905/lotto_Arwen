package java_BOOK;

class goldClass implements Runnable{
	String name; //�ݩʦW��
	boolean grabGold = true; //�m��������
	static int Gold_All;

	goldClass(String name){ //�غc��
		this.name = name; //�ݩʦW��
	}
	
	public int gold = 0; //�m�ܪ�����
	public static int totalGold = 200000; //�����`��
	
	public void run() { //�����
//		��k1
//		while(totalGold>0) {
//			totalGold--;
//			gold++;
//		}
//		��k2
		while(grabGold() == true) {
			totalGold--;
			gold++;
		}
		System.out.println(name+" �����F "+gold+" �Ӫ����I");
		Gold_All += gold;
	}
	
	static int total;
	public synchronized static boolean grabGold() {
		if(totalGold>0) {
			totalGold--;
			total++;
//			if(totalGold<=5) {
//				System.out.println("�Ѿl������:"+totalGold);
//			}
			if(totalGold==0) {
				System.out.println("�̲׫���������:"+total);	
			}
			return true;
		}else {
			return false;
		}
	}

}

class gold_b extends goldClass implements Runnable{
	Thread t;
	gold_b(String name){
		super(name);
		t = new Thread(this,name);
		t.start();
	}
	public void run(){
		while(grabGold() == true) {
			gold++;
		}
		System.out.println(t.getName()+" �����F "+gold+" �Ӫ����I");
		Gold_All += gold;
		
	}
}

public class a0719_������10_21 {

	public static void main(String[] args) {
		Thread a = new Thread(new goldClass("A�p��"));
		Thread b = new Thread(new goldClass("B�p��"));
		Thread c = new Thread(new goldClass("C�p��"));
//		a.start();
//		b.start();
//		c.start();
		gold_b a1 = new gold_b("a1�p��");
		gold_b b1 = new gold_b("b1�p��");
		gold_b c1 = new gold_b("c1�p��");
	}

}
