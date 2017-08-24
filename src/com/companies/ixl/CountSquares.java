package com.companies.ixl;

/**
 * Created by Tianran on 8/13/2017.
 */
public class CountSquares {
	public int countSquares(int n) {
		if(n <= 0) {
			return 0;
		}
		int res = 0;
		for(int i = 1; i <= n; i++) {
			res += i * i;
		}
		return res;
	}

	public int countSquaresII(int n) {
		if(n <= 0) {
			return 0;
		}
		return n * (n + 1) * (2 * n + 1) / 6;
	}

	//assume m <= n
	public int countSquaresIII(int m, int n) {
		return m*(m + 1)*(2*m + 1)/6 + (n-m)*m*(m+1)/2;
	}

	public static void main(String[] args) {
		CountSquares sol = new CountSquares();
		int res = sol.countSquares(3);
		System.out.println(res);
		int res2 = sol.countSquaresII(3);
		System.out.println(res2);
	}
}
