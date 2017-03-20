package com.dynamicprogramming;

/**
 * Created by Tianran on 3/18/2017.
 */
public class CountWaysOfDollarCombination {
	public int countWays(int target, int number) {
		if(target <= 0 || number <= 0) {
			return 0;
		}
		int[] result = new int[1];
		helper(target, number, result);
		return result[0];
	}

	private void helper(int target, int number, int[] result) {
		if(number == 1) {
			result[0]++;
			return;
		}
		for(int i = 1; i <= target - number; i++) {
			helper(target - i, number - 1, result);
		}
	}


	public static void main(String[] args) {
		CountWaysOfDollarCombination sol = new CountWaysOfDollarCombination();
		int res = sol.countWays(5, 3);
		System.out.println(res);
	}
}
