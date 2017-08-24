package com.companies.ixl;

/**
 * Created by Tianran on 8/18/2017.
 */
public class RandomFourDigitNumber {
	public int randomFourWithDiffNeighbor() {
		int cur = 1 + (int)(Math.random() * 9);
		int res = cur;
		int prev = cur;
		for(int i = 1; i < 4; i++) {
			cur = (int)(Math.random() * 10);
			while(cur == prev) {
				cur = (int) (Math.random() * 10);
			}
			res = res * 10 + cur;
			prev = cur;
		}
		return res;
	}

	public int randomFourWithEven() {
		int cur = 1 + (int)(Math.random() * 9);
		int res = cur;
		for(int i = 1; i < 4; i++) {
			cur = (int)(Math.random() * 10);
			if(i == 3) {
				while(cur % 2 == 1) {
					cur = (int)(Math.random() * 10);
				}
			}
			res = res * 10 + cur;
		}
		return res;
	}

	public static void main(String[] args) {
		RandomFourDigitNumber sol = new RandomFourDigitNumber();
		int res = sol.randomFourWithDiffNeighbor();
		int res2 = sol.randomFourWithEven();
		System.out.println(res);
		System.out.println(res2);
	}
}
