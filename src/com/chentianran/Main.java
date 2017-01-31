package com.chentianran;

/**
 * Created by Tianran on 1/8/2017.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello");
		int[] arr = new int[]{4, 6, 3, 7};
		String[] input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		int[] temp = new int[] {3, 2, 1, 0, 4};


		//System.out.println(res);
		TreeNodeX n1 = new TreeNodeX(5);
		TreeNodeX n2 = new TreeNodeX(3);
		TreeNodeX n3 = new TreeNodeX(8);
		TreeNodeX n4 = new TreeNodeX(1);
		TreeNodeX n5 = new TreeNodeX(4);
		TreeNodeX n6 = new TreeNodeX(7);
		TreeNodeX n7 = new TreeNodeX(9);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;


		TestOne sol = new TestOne();
		int num = sol.count(n1, 1, 4);
		System.out.println(num);

	}
}
