package java_BOOK;

import java.lang.reflect.Array;
import java.util.Arrays;

public class a0720_�Ʋ߰}�C_�x�����X���� {
		
	public static void main(String[] args) {
		String[] title = {"�ѦW�s��","����","�w�s�q"};
		int [][]booksShop = {{1,2,3},
							{500,800,650},
							{5,8,14}};

		for(int i=0;i<title.length;i++) {
			System.out.print(title[i]+"\t");
			for(int j=0;j<booksShop.length;j++) {
				System.out.print(booksShop[i][j]+"\t");
			}
			System.out.println();
		}
		
		int[][] price2 = {{1,2,3},
						  {4,5,6},
				    	  {7,8,9}};
		
		for(int[] s:price2) {
			for(int ss:s) {
				System.out.print(ss+" ");
			}
			System.out.println();
		}
	
			
	
		for(int[] p:price2) {
			for(int ps:p) {
				System.out.print(ps+" ");
			}
			System.out.println();
		}
		
		System.out.println("===========================================");
		//forEach:�m��Ū����
		int price[][] = new int[2][6];
		for(int[] p:price) {
			for(int s:p) {
			System.out.print(s+" ");
			}
			System.out.println();
		}
		
		System.out.println("===========================================");
		System.out.println();
		String[][][] ar = {{{"�T��1"},{"�T��2"}},{{"�T��3"},{"�T��4"}}};
		for(String[][] r:ar) {
			for(String[] rs:r) {
				for(String s:rs) {
				System.out.println(s);
				}
			}
		}
		
		//forEachŪ���ܤT��}�C����
		String[][][] arr = new String[3][4][3];
		for(String[][] r:arr) {
			for(String[] rs:r) {
				for(String s:rs) {
					s = "�˶�";
				System.out.println("arr:"+s);
				}
			}
		}
		
		//forEach:�ק�@���}�C����
		int[] x = {1,5,10,20};
		for(int s:x) {
			for(int i=0;i<1;i++) {
				s *= 5;
			}
			System.out.println(s);
		}
		
		//for�j��:�ק�@���}�C����
		for(int i=0;i<x.length;i++) {
			x[i] = x[i]*5;
			System.out.println(x[i]);
		}
		
		//�}�C �������� ���᪺��C�]�w[3][3]
		//�}�C�Ƨ�
		int[][] ns = new int[2][6];
		for(int i=0;i<ns.length;i++) {
			for(int j=0;j<ns[i].length;j++) {
				int ans = (int)(Math.random()*101+(1));
				ns[i][j] = ans;
				System.out.print(ns[i][j]+" ");
			}
		}
		System.out.println("\n �h���Ƨ� ==========================");
		Arrays.sort(ns[0]);
		for(int i=0;i<ns.length;i++) {
			for(int j=0;j<ns[i].length;j++) {
				System.out.print(ns[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n �򥻱Ƨ� ==========================");
		int cnt[][] = {{100,50,75}};
//		Arrays.sort(cnt[0]);
		for(int i=0;i<cnt[0].length;i++) {
			System.out.print(cnt[0][i]+" ");
		}
		System.out.println("===============");
		int ssr[][] = {{20,30,60,10}};
		Arrays.sort(ssr[0]);
		for(int i=0;i<ssr.length;i++) {
			for(int j=0;j<ssr[i].length;j++) {
			System.out.print(ssr[i][j]+" ");
			}
		}
		int il1 = Arrays.binarySearch(ssr[0], 160); //10,20,30,60
		System.out.println("�j�M���G: "+il1);
		
		
		System.out.println("===============");
		int nn[][] = {{50,20,60}};
		Arrays.sort(nn[0]);
		//�j�M�r�� �Y�L�h�t��� & �j�M�e��:�ݱƧǤ~�i�ϥ�
		int il = Arrays.binarySearch(nn[0], 50); //20,50,60
		System.out.println("�j�M���G: "+il);
		
		System.out.println("\n �}�C�ƻs ==========================");
		int cnt1[] = {100,50,75};
		Arrays.sort(cnt1);
		int []cnt2 = new int [cnt1.length];
		
//		cnt2 = cnt1; //�ᤩ �ѦҦ�m
		System.arraycopy(cnt1, 0, cnt2, 0, cnt1.length); // �ᤩ �s���O�����m
		for(int i=0;i<cnt1.length;i++) {
			cnt1[i] *= 2;
			System.out.print(cnt1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<cnt2.length;i++) {
			System.out.print(cnt2[i]+" ");
		}
		
	}
}
