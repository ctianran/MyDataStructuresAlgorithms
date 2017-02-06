package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/4/2017.
 */
public class AllSubSetsWithSizeK {
	public List<List<Integer>> subsets(int[] input, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(input == null ) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		helper(input, 0, k, cur, result);
		return result;
	}

	private void helper(int[] input, int index, int k, List<Integer> cur, List<List<Integer>> result) {
		if(index == input.length) {
			if (cur.size() == k) {
				result.add(new ArrayList<Integer>(cur));
			}
			return;
		}
		cur.add(input[index]);
		helper(input, index + 1, k, cur, result);
		cur.remove(cur.size()- 1);

		while(index + 1 < input.length && input[index] == input[index+1]) {
			index++;
		}
		helper(input, index + 1, k , cur, result);
	}

	private void helperII(int[] input, int index, int k, List<Integer> cur, List<List<Integer>> result) {
		if(cur.size() == k) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i = index; i < input.length; i++) {
			cur.add(input[i]);
			helperII(input, i + 1, k, cur, result);
			while(i + 1 < input.length && input[i] == input[i+1]) {
				i++;
			}
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] input = new int[]{1, 2, 2, 2, 3};
		AllSubSetsWithSizeK sol = new AllSubSetsWithSizeK();
		List<List<Integer>> res = sol.subsets(input, 2);
		System.out.println(res);
	}
}
