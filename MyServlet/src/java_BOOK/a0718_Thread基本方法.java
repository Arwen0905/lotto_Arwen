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
			System.out.println("內部run方法: "+name); //AA
			if(i%10==0) { //10 20 30
				notify();
				try {
					wait(); //第一次在這裡等等 二呼叫
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
				System.out.println("內部run方法: "+name); //BB
				if(i%10==0) { //10 20 30
					notify();
					try {
						wait(); //第一次卡在這 二等等
					} catch (Exception e) {}
				}
			}

	 
}
}
class aa extends Thread{
	ex aaa;
	String name; //宣告屬性
	public aa(String name,ex aaa) { //建構式
		this.name = name;
		this.aaa = aaa;
//		start();
	}
	public void run() {
//		try {
//			Thread.sleep(1); //睡了一瞬間
//		} catch (Exception e) {}
		aaa.eAA("A小姐");
		
	}
}
class bb extends aa implements Runnable{ //繼承aa 並實作run介面
	public bb(String name,ex aaa) { //bb的建構式
		super(name,aaa); //使用aa的建構子
	}
	public void run() {
		aaa.eBB("B先生");
	}
}

public class a0718_Thread基本方法 {

	public static void main(String[] args) {
		ex aaa = new ex();
		Thread aa = new aa("A先生 ",aaa);
		Thread bb = new Thread(new bb("B小姐",aaa));
	
		bb.start();
		aa.start();
		
	}

}
