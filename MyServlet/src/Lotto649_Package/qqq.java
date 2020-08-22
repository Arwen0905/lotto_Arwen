package Lotto649_Package;

public class qqq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

      String []nar = {"2","8","27","40","41","47"};
//      lotto649_MySQL lottoGo = new lotto649_MySQL(nar);
      lotto649_Sqlite lottoGo = new lotto649_Sqlite(nar);
      lottoGo.detect();
	}

}
