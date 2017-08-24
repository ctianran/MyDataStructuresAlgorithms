package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/4/2017.
 */
public class CombinationOfFactorsOfAnInteger {
	public List<List<Integer>> combination(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		List<Integer> factors = new ArrayList<>();
		cur.add(1);
		cur.add(n);
		result.add(cur);
		if(n % 2 != 0) {
			return result;
		}
		for(int i = 2; i <= n / 2; i++) {
			if(n % i == 0) {
				factors.add(n / i);
			}
		}
		cur = new ArrayList<>();
		helper(n, 0, factors, cur, result);
		return result;
	}

	private void helper(int target, int index, List<Integer>factors, List<Integer> cur, List<List<Integer>> result) {
		if(index == factors.size() - 1) {
			if(target % factors.get(index) == 0) {
				cur.add(target);
				result.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
			}
			return;
		}
		int factor = factors.get(index);
		for(int i = 0; i <= target / factor; i++) {
			cur.add(i * factor);
			int temp = target;
			if(i == 0) {
				temp = target;
			} else {
				temp = target / (i * factor);
			}
			helper(temp, index + 1, factors, cur, result);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationOfFactorsOfAnInteger sol = new CombinationOfFactorsOfAnInteger();
		List<List<Integer>> res = sol.combination(12);
		System.out.println(res);
	}
}
