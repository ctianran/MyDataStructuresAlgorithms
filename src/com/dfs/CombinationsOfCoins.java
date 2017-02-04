package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/3/2017.
 */
public class CombinationsOfCoins {
	public List<List<Integer>> combination(int[] values, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(target == 0) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		helper(target, values, 0, cur, result);
		return result;
	}

	private void helper(int target, int[] values, int index, List<Integer> cur, List<List<Integer>> result) {
		if(index == values.length - 1) {
			if(target % values[index] == 0) {
				cur.add(target / values[index]);
				result.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
			}
			return;
		}

		for(int i = 0; i <= target / values[index]; i++) {
			cur.add(i);
			helper(target - i * values[index], values, index + 1, cur, result);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		int values[] = new int[] {1, 10, 5, 25};
		int target = 99;
		CombinationsOfCoins sol = new CombinationsOfCoins();
		List<List<Integer>> res = sol.combination(values, target);
		System.out.println(res);
	}
}
