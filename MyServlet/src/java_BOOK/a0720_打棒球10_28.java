package java_BOOK;

class Baseball{ //設定"棒球"物件的屬性和方法
	private boolean isThrow = false; //模擬 棒球運動為互動性，一投一打
// 投 球 方 法 ===============================================================	
//		wait的條件限制: 必須寫在 synchronized 敘述區，並使用try-catch 捕捉例外，while 為放入條件避免喚醒錯的執行緒
	synchronized void pBall(int n) { //投球的方法
  //方法1
		//為了呼應 "投打節奏"，運用「wait()等待、notify()呼叫」
//		while(isThrow) { //利用while的目的有兩種 1.滿足迴圈需求 2.放入觸發條件
//			try { //wait()必須裝在try、catch公式裡面
//				wait(); //先等等
//			} catch (Exception e) {}
//		}
  //方法2
//		不用while迴圈的方式，因投打次數會由run()方法觸發，所以每次進來其實也只需要做 投、打 節奏 的判斷/執行敘述
		if(isThrow == true) { //允許投球指令:準備下一步
			try {
				wait(); //接受到wait指令，進入「Wait pool」(等待池)需要等一等! 等待 notify通知才可進行下一步
			} catch (Exception e) {}
		}
		isThrow = true; //允許投球
		System.out.println("投出第"+n+"球！"); //輸出投出第n球
		notify(); //呼叫打擊:呼叫另一個執行緒
	}
	
// 打 擊 方 法 ===============================================================
//	打擊方法(hBall)註解 同上述投球(pBall)
	synchronized void hBall(int n) { //打擊的方法
  //方法1
//		while(!isThrow) {
//			try {
//				wait();
//			} catch (Exception e) {}
//		}
  //方法2
		if(isThrow != true) {
			try {
				wait();
			} catch (Exception e) {}
		}
		System.out.println("第"+n+"次揮棒！");
		isThrow = false;
		notify(); //打擊n次 完畢，就通知另一個執行緒(投球方法) pBall()
	}
}
// 實 作 介 面 ===============================================================
// 執行緒:打擊手
class hit implements Runnable{
	Baseball baseball; //由建立時引入的(棒球屬性與方法)
	hit(Baseball baseball){ //建構子設定
		this.baseball = baseball; //引入參數設定
	}
	
	public void run() { //執行緒:啟動
		for(int i=1;i<=5;i++) {
			baseball.hBall(i); //注意!與投手的執行緒會一起啟動
			System.out.println("run方法: 觀察揮棒: "+i);
		}
	}
}
//執行緒:投手
class pitching implements Runnable{
	Baseball ee; //由建立時引入的(棒球屬性與方法)

	pitching(Baseball baseball){ //建構子設定
		this.ee = baseball; //引入參數設定
	}
	
	public void run(){ //執行緒:啟動
		for(int i=1;i<=5;i++) {			
			ee.pBall(i);//注意!與打擊手的執行緒會一起啟動
			System.out.println("run方法: 觀察投出: "+i);
		}
	}
}
public class a0720_打棒球10_28 {
	public static void main(String[] args) {
		Baseball ff = new Baseball(); //創建 類別物件 "棒球"
		Thread pitching = new Thread(new pitching(ff));//創建投手方法(棒球屬性與方法)
		Thread hit = new Thread(new hit(ff)); //創建打手方法(建構式:填入棒球屬性與方法)
		
		hit.start(); 	  //打擊手:開始動作
		pitching.start(); //投手:開始動作
	}
}
