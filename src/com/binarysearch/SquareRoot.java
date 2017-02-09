package com.binarysearch;

/**
 * Created by Tianran on 2/7/2017.
 */
public class SquareRoot {
	public int sqrt(int num) {
		if(num <= 1) {
			return num;
		}
		int left = 1;
		int right = num / 2;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(mid * mid >= num) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right * right <= num ? right : left;
	}

	public double sqrtDouble(double num, double epsilon) {
		if(num == 0 || num == 1) {
			return num;
		}
		//num < 1, left = num, right = 1
		//num > 1, left = 1, right = num
		double left = num < 1 ? num : 1;
		double right = num < 1 ? 1 : num;
		while(left <= right) {
			double mid = left + (right - left) / 2;
			if(Math.abs(mid * mid - num) / num < epsilon) {
				return mid;
			} else if (mid * mid < num) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		SquareRoot sol = new SquareRoot();
		System.out.println(sol.sqrt(9));
		System.out.println(sol.sqrtDouble(2.0, 0.000001));
	}
}
