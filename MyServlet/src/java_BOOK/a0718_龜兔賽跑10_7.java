package java_BOOK;

class win{
	public static boolean victory = false;
	String name;
	public static void win(String n,boolean v) {
		victory = v;
		while(true) {			
			System.out.println(n+" Ĳ�o�ӧQ����A����["+n+"]���!");
			return;
		}
	}
}

class tortoise extends Thread{
	public void run() {
		for(int i=1;i<=30;i++) {
			if(i>=20) {
				System.out.println("�Q�t�]����I�F!");
				win.win("�Q�t����",true);
				break;
			}
				if(win.victory) {
					System.out.println("�Q�t��F..���U�}�B");
					break;
				}
				if(Math.random()>0.3) {
					int n = (int)(Math.random()*3)+(2);
					int ans = i+=n;
					System.out.println("�Q�t���M�u�F"+(n+1)+"��I�I�I�Q�t�]�F"+ans+"�B");
				}else {
					System.out.println("�Q�t�]�F"+i+"�B");
				}
		}
	}
}
class rabbit implements Runnable{
	public void run() {
		for(int i=1;i<30;i+=4) {
			if(i>=20) {
				System.out.println("�ߤl�]����I�F!");
				win.win("�ߨߤp�j",true);
				break;
			}
			if(i>2 && Math.random()>0.3) {
				i-=2;
				System.out.println("�ߤl���֤@�U..�]�F"+i+"�B");
			}else {
				System.out.println("�ߤl�]�F"+i+"�B");
			}
			
			if(win.victory) {
				System.out.println("�ߤl��F..���U�}�B");
				break;
			}
		
		}
	}
	
}
public class a0718_�t���ɶ]10_7 {

	public static void main(String[] args) {

		Thread tt = new tortoise();
		Thread bb = new Thread(new rabbit());
		bb.start();
		tt.start();
		    
	}

}
