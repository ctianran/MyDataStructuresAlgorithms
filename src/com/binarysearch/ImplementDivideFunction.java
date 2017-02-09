package com.binarysearch;

/**
 * Created by Tianran on 2/7/2017.
 */
public class ImplementDivideFunction {
	public int divideI(int dividend, int divisor) {
		if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if(divisor == 1) {
			return dividend;
		}
		int count = 1;
		while(divisor * count < dividend) {
			count++;
		}
		return divisor * count == dividend ? count : count - 1;
	}

	public int divideII(int dividend, int divisor) {
		if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if(divisor == 1) {
			return dividend;
		}
		int left = 1;
		int right = 1;
		while(right * divisor < dividend) {
			right = right * 2;
		}
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(mid * divisor >= dividend) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return divisor * right <= dividend ? right : left;
	}

	public int divideIII(int dividend, int divisor) {
		if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if(divisor == 1) {
			return dividend;
		}
		int temp = divisor;
		int result = 0;
		int cur = 1;
		while(temp <= dividend) {
			temp <<= 1;
			cur <<= 1;
		}
		temp >>= 1;
		cur >>= 1;
		while(dividend >= divisor) {
			if(dividend >= temp) {
				dividend -= temp;
				result |= cur;
			}
			temp >>= 1;
			cur >>= 1;
		}
		return result;
	}

	public static void main(String[] args) {
		ImplementDivideFunction sol = new ImplementDivideFunction();
		System.out.println(sol.divideIII(8, 5));
	}
}
