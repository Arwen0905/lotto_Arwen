package Lotto649_Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Black_Jack2 {
	static java.util.Scanner sc = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> handcards = new ArrayList<Integer>();
		ArrayList<Integer> sign = new ArrayList<Integer>();

		String reuse, leave;
		int count = 0, score = 0;

		do {
			do {

				int over21 = 0;

				Hashtable suit = new Hashtable();
				suit.put(4, "♠");
				suit.put(3, "♥");
				suit.put(2, "♦");
				suit.put(1, "♣");
				handcards.add((int) ((Math.random() * 10) + 1));
				sign.add((int) ((Math.random() * 4) + 1));

				System.out.println("抽牌:"  + suit.get(sign.get(count))+ handcards.get(count));
				System.out.print("手牌:");
				
				for (int i = 0; i < handcards.size(); i++) {
					over21 += handcards.get(i);
					System.out.print(suit.get(sign.get(i))+ "" + handcards.get(i)  +" ");
					
				}
				
				
				if (over21 == 21) {
					System.out.println("恭喜21點，分數21乘2");
					score += over21 * 2;
					break;
				} else if (over21 > 21) {
					System.out.println("超過21點");
					break;
				}
				System.out.println("總合:" + over21+"點");
				count++;
				System.out.print("再抽一張?(y/n):");
				System.out.println();
				reuse = sc.next();
				
				if (reuse.equalsIgnoreCase("n")) {
					if (over21 >= 16 && over21 <= 21) {
						score += over21;
						break;
					}
					break;
				}
			} while (reuse.equalsIgnoreCase("y"));

			System.out.println("你的分數是:" + score);
			System.out.println("還要再玩一次?(y/n):");
			leave = sc.next();
			count = 0;
			handcards.clear();
			sign.clear();
		} while (leave.equalsIgnoreCase("y"));

	}

}
