package Lotto649_Test;

public class Black_Jack3 {
	static java.util.Scanner sc = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		int count = 0, score = 0;
		String reuse, leave;
		int[] cards = new int[52];

		String[] poker = new String[52];
		String[] flower = { "♣", "♦", "♥", "♠" };
		String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		do {
			for (int i = 0; i < 52; i++) {
				poker[i] = "";
				poker[i] += flower[i % 4];
				poker[i] += number[i / 4];

			}

			for (int i = 0; i < 52; i++) {
				cards[i] = i;
			}

			for (int i = 0; i < 52; i++) {
				int random = (int) (Math.random() * 52);

				if (cards[i] != cards[random]) {
					int box = 0;
					box = cards[i];
					cards[i] = cards[random];
					cards[random] = box;

				}

			}

			do {
				int over21 = 0;
				System.out.println("抽牌:" + poker[cards[count]]);
				System.out.print("手牌:");
				for (int i = 0; i <= count; i++) {
					System.out.print(poker[cards[i]] + " ");
					calculate c = new calculate();
					over21=c.calculate1(poker[cards[i]], over21);
					
				}

				if (over21 == 21) {
					System.out.println("恭喜21點，分數21乘2");
					score += over21 * 2;
					break;
				} else if (over21 > 21) {
					System.out.println("超過21點");
					break;
				}
				System.out.println("總合:" + over21 + "點");
				System.out.print("再抽一張?(y/n):");
				reuse = sc.next();
				count++;
				if (reuse.equalsIgnoreCase("n")) {
					if (over21 >= 17 && over21 <= 21) {
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
		} while (leave.equalsIgnoreCase("y"));

	}
}


class calculate{
	
	public int calculate1(String sign,int number) {
		
		if (sign.equals("♣A") || sign.equals("♦A")
				|| sign.equals("♥A") || sign.equals("♠A")) {
			number += 1;
		}
		if (sign.equals("♣2") || sign.equals("♦2")
				|| sign.equals("♥2") || sign.equals("♠2")) {
			number += 2;
		}
		if (sign.equals("♣3") || sign.equals("♦3")
				|| sign.equals("♥3") || sign.equals("♠3")) {
			number += 3;
		}
		if (sign.equals("♣4") || sign.equals("♦4")
				|| sign.equals("♥4") || sign.equals("♠4")) {
			number += 4;
		}
		if (sign.equals("♣5") || sign.equals("♦5")
				|| sign.equals("♥5") || sign.equals("♠5")) {
			number += 5;
		}
		if (sign.equals("♣6") || sign.equals("♦6")
				|| sign.equals("♥6") || sign.equals("♠6")) {
			number += 6;
		}
		if (sign.equals("♣7") || sign.equals("♦7")
				|| sign.equals("♥7") || sign.equals("♠7")) {
			number += 7;
		}
		if (sign.equals("♣8") || sign.equals("♦8")
				|| sign.equals("♥8") || sign.equals("♠8")) {
			number += 8;
		}
		if (sign.equals("♣9") || sign.equals("♦9")
				|| sign.equals("♥9") || sign.equals("♠9")) {
			number += 9;
		}
		if (sign.equals("♣10") || sign.equals("♦10")
				|| sign.equals("♥10") || sign.equals("♠10")) {
			number += 10;
		}
		if (sign.equals("♣J") || sign.equals("♦J")
				|| sign.equals("♥J") || sign.equals("♠J")) {
			number += 10;
		}
		if (sign.equals("♣Q") || sign.equals("♦Q")
				|| sign.equals("♥Q") || sign.equals("♠Q")) {
			number += 10;
		}
		if (sign.equals("♣K") || sign.equals("♦K")
				|| sign.equals("♥K") || sign.equals("♠K")) {
			number += 10;
		}
		
		return number;
	}
	
}
