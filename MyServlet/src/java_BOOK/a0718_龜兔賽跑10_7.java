package java_BOOK;

class win{
	public static boolean victory = false;
	String name;
	public static void win(String n,boolean v) {
		victory = v;
		while(true) {			
			System.out.println(n+" 觸發勝利條件，恭喜["+n+"]獲勝!");
			return;
		}
	}
}

class tortoise extends Thread{
	public void run() {
		for(int i=1;i<=30;i++) {
			if(i>=20) {
				System.out.println("烏龜跑到終點了!");
				win.win("烏龜先生",true);
				break;
			}
				if(win.victory) {
					System.out.println("烏龜輸了..停下腳步");
					break;
				}
				if(Math.random()>0.3) {
					int n = (int)(Math.random()*3)+(2);
					int ans = i+=n;
					System.out.println("烏龜忽然滾了"+(n+1)+"圈！！！烏龜跑了"+ans+"步");
				}else {
					System.out.println("烏龜跑了"+i+"步");
				}
		}
	}
}
class rabbit implements Runnable{
	public void run() {
		for(int i=1;i<30;i+=4) {
			if(i>=20) {
				System.out.println("兔子跑到終點了!");
				win.win("兔兔小姐",true);
				break;
			}
			if(i>2 && Math.random()>0.3) {
				i-=2;
				System.out.println("兔子玩樂一下..跑了"+i+"步");
			}else {
				System.out.println("兔子跑了"+i+"步");
			}
			
			if(win.victory) {
				System.out.println("兔子輸了..停下腳步");
				break;
			}
		
		}
	}
	
}
public class a0718_龜兔賽跑10_7 {

	public static void main(String[] args) {

		Thread tt = new tortoise();
		Thread bb = new Thread(new rabbit());
		bb.start();
		tt.start();
		    
	}

}
