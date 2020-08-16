package java_BOOK;

class GoldClass2 implements Runnable{
	int grabed; //已偷到的金塊
	static int total;
	static int totalGold = 2000000; //金塊總數
	Thread t; //以執行緒類別 宣告物件 t
//	t.setName(name); //這根本不用了
	GoldClass2(String name){ //建構式
		grabed = 0; //每次新建物件，初始化 持有金塊
		t = new Thread(this,name); //建立名稱
		t.start(); //執行緒啟動
	}
	public void run(){
		while(grabGold() == true) {
			grabed++;
		}
		System.out.println(t.getName()+"偷到了"+grabed);
		System.out.println(t.getName()+"途中累積的金塊數由: "+total+" + "+grabed+" = "+(total+=grabed));
	}
	public static synchronized boolean grabGold() { //要放進 while 或 if 判斷時，需宣告布林型態;
		if(totalGold>0) {
			totalGold--;
			if(totalGold<5) {				
				System.out.println("金塊餘數: "+totalGold);
			}
			if(totalGold==0) {
//				total+=grabed;
				System.out.println("最終挖到的金塊總數: "+total);
			}
			return true;
		}else {
			return false;
		}
	}
}
public class a0719_正規講義_挖金塊 {

	public static void main(String[] args) {
		System.out.println("共有"+GoldClass2.totalGold+"金塊!");
		GoldClass2 a1 = new GoldClass2("A小隊");
		GoldClass2 b2 = new GoldClass2("B小隊");
		GoldClass2 c3 = new GoldClass2("C小隊");

	}

}
