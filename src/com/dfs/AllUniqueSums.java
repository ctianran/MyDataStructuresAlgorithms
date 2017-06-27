package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 6/20/2017.
 */
public class AllUniqueSums {
	public List<List<Integer>> uniqueSums(int num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num <= 0) {
			return res;
		}
		List<Integer> cur = new ArrayList<>();
		helper(1, num, cur, res);
		return res;
	}

	private void helper(int curNum, int target, List<Integer> cur, List<List<Integer>> res) {
		if(target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i = curNum; i <= target; i++) {
			cur.add(i);
			helper(i, target - i, cur, res);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		AllUniqueSums sol = new AllUniqueSums();
		List<List<Integer>> res = sol.uniqueSums(4);
		System.out.println(res);
	}
}
