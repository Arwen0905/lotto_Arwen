package java_BOOK;
class ex {
	boolean tick = false;
	String name;
	synchronized void eAA(String name) {
		if(tick==true) {
			try {
				wait();
			} catch (Exception e) {}
			
		}
		for(int i=0;i<=30;i++) {
			System.out.println("����run��k: "+name); //AA
			if(i%10==0) { //10 20 30
				notify();
				try {
					wait(); //�Ĥ@���b�o�̵��� �G�I�s
				} catch (Exception e) {}
			}
	}
//		tick = true;
		notify();
		
	}
	 
	synchronized void eBB(String name) {
		 if(tick!=true) {
				try {
					wait();
				} catch (Exception e) {}
				
			}
			for(int i=0;i<=30;i++) {
				System.out.println("����run��k: "+name); //BB
				if(i%10==0) { //10 20 30
					notify();
					try {
						wait(); //�Ĥ@���d�b�o �G����
					} catch (Exception e) {}
				}
			}

	 
}
}
class aa extends Thread{
	ex aaa;
	String name; //�ŧi�ݩ�
	public aa(String name,ex aaa) { //�غc��
		this.name = name;
		this.aaa = aaa;
//		start();
	}
	public void run() {
//		try {
//			Thread.sleep(1); //�ΤF�@����
//		} catch (Exception e) {}
		aaa.eAA("A�p�j");
		
	}
}
class bb extends aa implements Runnable{ //�~��aa �ù�@run����
	public bb(String name,ex aaa) { //bb���غc��
		super(name,aaa); //�ϥ�aa���غc�l
	}
	public void run() {
		aaa.eBB("B����");
	}
}

public class a0718_Thread�򥻤�k {

	public static void main(String[] args) {
		ex aaa = new ex();
		Thread aa = new aa("A���� ",aaa);
		Thread bb = new Thread(new bb("B�p�j",aaa));
	
		bb.start();
		aa.start();
		
	}

}
