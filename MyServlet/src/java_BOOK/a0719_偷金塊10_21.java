package java_BOOK;

class goldClass implements Runnable{
	String name; //屬性名稱
	boolean grabGold = true; //搶金塊門票
	static int Gold_All;

	goldClass(String name){ //建構式
		this.name = name; //屬性名稱
	}
	
	public int gold = 0; //搶奪金塊數
	public static int totalGold = 200000; //金塊總數
	
	public void run() { //執行緒
//		方法1
//		while(totalGold>0) {
//			totalGold--;
//			gold++;
//		}
//		方法2
		while(grabGold() == true) {
			totalGold--;
			gold++;
		}
		System.out.println(name+" 挖掘了 "+gold+" 個金塊！");
		Gold_All += gold;
	}
	
	static int total;
	public synchronized static boolean grabGold() {
		if(totalGold>0) {
			totalGold--;
			total++;
//			if(totalGold<=5) {
//				System.out.println("剩餘的金塊:"+totalGold);
//			}
			if(totalGold==0) {
				System.out.println("最終挖掘的金塊:"+total);	
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
		System.out.println(t.getName()+" 挖掘了 "+gold+" 個金塊！");
		Gold_All += gold;
		
	}
}

public class a0719_偷金塊10_21 {

	public static void main(String[] args) {
		Thread a = new Thread(new goldClass("A小隊"));
		Thread b = new Thread(new goldClass("B小隊"));
		Thread c = new Thread(new goldClass("C小隊"));
//		a.start();
//		b.start();
//		c.start();
		gold_b a1 = new gold_b("a1小隊");
		gold_b b1 = new gold_b("b1小隊");
		gold_b c1 = new gold_b("c1小隊");
	}

}
