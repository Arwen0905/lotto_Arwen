package java_BOOK;

class ATM implements Runnable{
	Account account; //外部類別 > 建立物件: 帳戶
	long money; // 宣告屬性: 金錢
	
	public ATM(Account ac,long m){ //建構式
		account = ac; //登入的帳戶
		money = m; //處理的金額
	}
	
	public void run() { //執行緒
		System.out.println("帳戶:『"+account.name+"』輸入金額"+money+" 新台幣"); //輸出目前狀態 
		account.deposit(money); // 外部類別 的 物件方法 (金額操作)
	}
}

class Account {
	String name; //宣告 戶名
	long balance; //宣告 帳戶餘額
	Account(long balance,String name){ //建構子
		this.balance = balance; //設定 帳戶餘額
		this.name = name; //設定 戶名
	}
	public synchronized void deposit(long amount) { //金額操作
		long d_balance = this.balance; //將設定的"帳戶餘額" 設定給  區域變數 d_balance 作暫存並處理
		System.out.println("尚有餘額: "+d_balance); //顯示: 處理帳戶的 餘額
		if(amount>=0) { //依據輸入的 正負數值 判斷使用者欲「存款 or 提款」?
			System.out.println("存款 :"+amount); //模擬 ATM顯示訊息 
		}else {
			System.out.println("提款 :"+amount);
		}
		System.out.println("交易處理中...");
		try { //模擬處理
			for(int i=1;i<=( (int)(Math.random()*4)+(1) );i++) { //亂數決定1~3次迴圈
				Thread.sleep(1000); //每次回圈1秒為單位
				System.out.printf("處理時間 %d秒%n",i); //輸出處理時間
			}
		} catch (Exception e) {}
		
		d_balance+=amount; //很簡單的 將輸入數值 加總至 帳戶餘額 
		if(d_balance>=0) { //判斷 非負值則 交易正常
			// 下列檢討:起初使用 += 這造成嚴重錯誤: 會將每次多執行緒餘額 重複累積
			this.balance = d_balance; //交易成功就把暫存處理的數值，返回給正常帳戶做更新
			System.out.println("交易成功！"+name+" 帳戶餘額: "+d_balance+" 新台幣");
		}else { //否則交易失敗
			System.out.println("交易失敗，原因: 用戶餘額不足\n");		
		}
		
	}
}

public class a0719_存款提款同步設定 {

	public static void main(String[] args) {
		Account Awen = new Account(24000,"阿文"); //建立: 帳戶、存款額
		Account Ader = new Account(88000,"阿德"); //建立: 帳戶、存款額
		
		Thread A1 = new Thread(new ATM(Awen,-5000)); //建立操作ATM的執行緒:
		Thread B1 = new Thread(new ATM(Ader,-922)); //建立操作ATM的執行緒:
		Thread B2 = new Thread(new ATM(Ader,-7000)); //建立操作ATM的執行緒:
		Thread A2 = new Thread(new ATM(Awen,-8000)); //建立操作ATM的執行緒:
		Thread A3 = new Thread(new ATM(Awen,-20000)); //建立操作ATM的執行緒:
		Thread B3 = new Thread(new ATM(Ader,-80000)); //建立操作ATM的執行緒:
		try {
			A1.start();
			A1.join();
			B1.start();
			B1.join();
			B2.start();
			B2.join();
			A2.start();
			A2.join();
			A3.start();
			A3.join();
			B3.start();
			B3.join();
		} catch (Exception e) {}
	}

}
