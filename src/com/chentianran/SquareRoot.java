package com.chentianran;

/**
 * Created by Tianran on 1/17/2017.
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
			if(mid * mid == num) {
				return mid;
			} else if (mid * mid < num) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return right * right <= num ? right : left;
	}

	public int sqrtOpti(int num) {
		if(num <= 1) {
			return num;
		}
		int left = 1;
		int right = 1;
		while(right * right < num) {
			right *= 2;
		}
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(mid * mid == num) {
				return mid;
			} else if (mid * mid < num) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return right * right <= num ? right : left;
	}
}
