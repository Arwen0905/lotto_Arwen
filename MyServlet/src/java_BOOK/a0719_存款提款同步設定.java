package java_BOOK;

class ATM implements Runnable{
	Account account; //�~�����O > �إߪ���: �b��
	long money; // �ŧi�ݩ�: ����
	
	public ATM(Account ac,long m){ //�غc��
		account = ac; //�n�J���b��
		money = m; //�B�z�����B
	}
	
	public void run() { //�����
		System.out.println("�b��:�y"+account.name+"�z��J���B"+money+" �s�x��"); //��X�ثe���A 
		account.deposit(money); // �~�����O �� �����k (���B�ާ@)
	}
}

class Account {
	String name; //�ŧi ��W
	long balance; //�ŧi �b��l�B
	Account(long balance,String name){ //�غc�l
		this.balance = balance; //�]�w �b��l�B
		this.name = name; //�]�w ��W
	}
	public synchronized void deposit(long amount) { //���B�ާ@
		long d_balance = this.balance; //�N�]�w��"�b��l�B" �]�w��  �ϰ��ܼ� d_balance �@�Ȧs�óB�z
		System.out.println("�|���l�B: "+d_balance); //���: �B�z�b�᪺ �l�B
		if(amount>=0) { //�̾ڿ�J�� ���t�ƭ� �P�_�ϥΪ̱��u�s�� or ���ڡv?
			System.out.println("�s�� :"+amount); //���� ATM��ܰT�� 
		}else {
			System.out.println("���� :"+amount);
		}
		System.out.println("����B�z��...");
		try { //�����B�z
			for(int i=1;i<=( (int)(Math.random()*4)+(1) );i++) { //�üƨM�w1~3���j��
				Thread.sleep(1000); //�C���^��1�����
				System.out.printf("�B�z�ɶ� %d��%n",i); //��X�B�z�ɶ�
			}
		} catch (Exception e) {}
		
		d_balance+=amount; //��²�檺 �N��J�ƭ� �[�`�� �b��l�B 
		if(d_balance>=0) { //�P�_ �D�t�ȫh ������`
			// �U�C�˰Q:�_��ϥ� += �o�y���Y�����~: �|�N�C���h������l�B ���Ʋֿn
			this.balance = d_balance; //������\�N��Ȧs�B�z���ƭȡA��^�����`�b�ᰵ��s
			System.out.println("������\�I"+name+" �b��l�B: "+d_balance+" �s�x��");
		}else { //�_�h�������
			System.out.println("������ѡA��]: �Τ�l�B����\n");		
		}
		
	}
}

public class a0719_�s�ڴ��ڦP�B�]�w {

	public static void main(String[] args) {
		Account Awen = new Account(24000,"����"); //�إ�: �b��B�s���B
		Account Ader = new Account(88000,"���w"); //�إ�: �b��B�s���B
		
		Thread A1 = new Thread(new ATM(Awen,-5000)); //�إ߾ާ@ATM�������:
		Thread B1 = new Thread(new ATM(Ader,-922)); //�إ߾ާ@ATM�������:
		Thread B2 = new Thread(new ATM(Ader,-7000)); //�إ߾ާ@ATM�������:
		Thread A2 = new Thread(new ATM(Awen,-8000)); //�إ߾ާ@ATM�������:
		Thread A3 = new Thread(new ATM(Awen,-20000)); //�إ߾ާ@ATM�������:
		Thread B3 = new Thread(new ATM(Ader,-80000)); //�إ߾ާ@ATM�������:
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
