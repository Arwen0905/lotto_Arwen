package Lotto649_Test;

public class CheckPrimeBean2 {
    private int number;

    public String getNumber() {
        return Integer.toString(this.number);     //����ন�r��
    }
    public void setNumber(String s) {
        try {
            number = Integer.parseInt(s);    //�r���ন���
        }
        catch (NumberFormatException e) {
            number = -1;
        }
    }

    public boolean isValidNumber() {     //�ˬd��J���Ʀr�O�_�X�k
        if ((number < 2) || (number > 10000)) {
        	return false;        	
        }else {
        return true;}
    }

    public boolean isPrimeNumber() {     //�P�_�O�_�����
        for (int i = 2; i <= number/2; i++) {
            if (number % 2 == 0)
                return false;
        }
        return true;
    }
//    public static void main(String[] arg) {
//    	CheckPrimeBean pp = new CheckPrimeBean();
//    	pp.setNumber("4");
//    	if(pp.isPrimeNumber()) {
//    		System.out.println(pp.number+"�O���");
//    	}else {
//    		System.out.println(pp.number+"���O���");
//    	}
// 
//    }
}