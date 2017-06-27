package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/4/2017.
 */
public class TwoSubSetsWithEqualSum {
	public List<List<Integer>> subset(int[] input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(input == null || input.length <= 1)  {
			return result;
		}
		int sum = 0;
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		if(sum % 2 != 0) {
			return result;
		}
		int target = sum / 2;
		List<Integer> cur = new ArrayList<>();
		helper(target, 0, input, cur, result);
		return result;
	}

	private void helper(int target, int index, int[] input, List<Integer> cur, List<List<Integer>> result) {
		if(index == input.length) {
			if(target == 0) {
				result.add(new ArrayList<Integer>(cur));
			}
			return;
		}

		cur.add(input[index]);
		helper(target - input[index], index + 1, input, cur, result);
		cur.remove(cur.size() - 1);

		helper(target, index + 1, input, cur, result);
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 2, 3, 4, 4};
		TwoSubSetsWithEqualSum sol = new TwoSubSetsWithEqualSum();
		List<List<Integer>> res = sol.subset(input);
		System.out.println(res);
	}
}
