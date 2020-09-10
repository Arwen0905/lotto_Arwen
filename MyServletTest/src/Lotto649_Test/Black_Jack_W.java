package Lotto649_Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Black_Jack_W {

	public static void main(String[] args) {
		
		ArrayList<Integer> handCards = new ArrayList<Integer>();
		ArrayList<Integer> sign = new ArrayList<Integer>();
		
		String reuse;
		String leave;
		int count = 0; 
		int score = 0;
		
		HashMap<Integer, String> suit = new HashMap<Integer, String>();
		
		int over21 = 0;

		suit.put(4, "♠");
		suit.put(3, "♥");
		suit.put(2, "♦");
		suit.put(1, "♣");
		handCards.add((int) ((Math.random() * 10) + 1));
		sign.add((int) ((Math.random() * 4) + 1));
		
		System.out.println("抽牌:"  + suit.get(sign.get(count))+ handCards.get(count));
		System.out.print("手牌:" + "");
		
		for (int i = 0; i < handCards.size(); i++) {
			over21 += handCards.get(i);
			System.out.print(suit.get(sign.get(i))+ "" + handCards.get(i)  +" ");
		}
		
		
	}
}
