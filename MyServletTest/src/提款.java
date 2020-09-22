


public class 提款 {

	public static void main(String[] args) {

		Account acct =new Account(10000);
		DepositTask r1 = new DepositTask("tzen", acct, 5000);
		WithdrawTask r2 = new WithdrawTask("Eric", acct, 2000);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
	}

}

class Account {
	private int balance;

	public Account(int initbal) {
		this.balance = initbal;

	}

	public void deposit(int amt) {
		int b = balance;
			b += amt;
			balance = b;

	}

	public void withdraw(int amt) {
		int b = balance;
			b -= amt;
			balance = b;

	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}

class WithdrawTask implements Runnable {
	private String name;
	private Account acct;
	private int amount;

	public WithdrawTask(String name, Account acct, int amount) {
		this.name = name;
		this.acct = acct;
		this.amount = amount;
	}

	@Override
	public void run() {
		System.out.println(name + "要存入" + amount);
		System.out.println("存入前餘額" + acct.getBalance());
		acct.deposit(amount);
		System.out.println("存入後餘額" + acct.getBalance());
	}

}

class DepositTask implements Runnable {
	private String name;
	private Account acct;
	private int amount;

	public DepositTask(String name, Account acct, int amount) {
		this.name = name;
		this.acct = acct;
		this.amount = amount;
	}

	@Override
	public void run() {
		System.out.println(name + "要提款" + amount);
		System.out.println("提款前餘額" + acct.getBalance());
		acct.withdraw(amount);
		System.out.println("提款後餘額" + acct.getBalance());
	}

}