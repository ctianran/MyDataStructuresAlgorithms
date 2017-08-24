package com.companies.ixl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 8/2/2017.
 */
public class CountHoles {
	public int countHoles(int n) {
		int[] pattern = new int[] {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};
		if(n == 0) {
			return 1;
		}
		n = Math.abs(n);  //handle negative numbers
		int res = 0;
		while(n != 0) {
			int digit = n % 10;   //check each digit, and sum the holes
			res += pattern[digit];
			n /= 10;
		}
		return res;
	}

	public List<Integer> getAllHoles(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int cur = countHoles(nums[i]);
			res.add(cur);
		}
		return res;
	}

	public static void main(String[] args) {
		CountHoles sol = new CountHoles();
		int res = sol.countHoles(-1002);
		System.out.println(res);
		System.out.println(-2 % 10);
	}
}
