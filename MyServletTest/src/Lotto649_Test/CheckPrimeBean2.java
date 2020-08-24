package Lotto649_Test;

public class CheckPrimeBean2 {
    private int number;

    public String getNumber() {
        return Integer.toString(this.number);     //整數轉成字串
    }
    public void setNumber(String s) {
        try {
            number = Integer.parseInt(s);    //字串轉成整數
        }
        catch (NumberFormatException e) {
            number = -1;
        }
    }

    public boolean isValidNumber() {     //檢查輸入的數字是否合法
        if ((number < 2) || (number > 10000)) {
        	return false;        	
        }else {
        return true;}
    }

    public boolean isPrimeNumber() {     //判斷是否為質數
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
//    		System.out.println(pp.number+"是質數");
//    	}else {
//    		System.out.println(pp.number+"不是質數");
//    	}
// 
//    }
}