package com.companies.ixl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 8/17/2017.
 */
public class CountTheDerangement {
	//BF, permutate all the derangement and count
	public int countDerangement(int n) {
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = i + 1;
			System.out.println(nums[i]);
		}
		int[] res = new int[1];
		return 0;
	}

	public List<List<Integer>> allDerangement(int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		boolean[] used = new boolean[n];
		helper(n, 0, used, cur, res);
		return res;
	}

	private void helper(int n , int index, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
		if(index == n) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i = 0; i < n; i++) {
			if(i != index && !used[i]) {
				cur.add(i + 1);
				used[i] = true;
				helper(n, index + 1, used, cur, res);
				used[i] = false;
				cur.remove(cur.size() - 1);
			}
		}
	}


	public int countAllDerangement(int n) {
		int[] res = new int[1];
		List<Integer> cur = new ArrayList<>();
		boolean[] used = new boolean[n];
		helperII(n, 0, used, cur, res);
		return res[0];
	}

	private void helperII(int n , int index, boolean[] used, List<Integer> cur, int[] res) {
		if(index == n) {
			res[0]++;
			return;
		}
		for(int i = 0; i < n; i++) {
			if(i != index && !used[i]) {
				cur.add(i + 1);
				used[i] = true;
				helperII(n, index + 1, used, cur, res);
				used[i] = false;
				cur.remove(cur.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		CountTheDerangement sol = new CountTheDerangement();
		List<List<Integer>> res = sol.allDerangement(4);
		System.out.println(res);
		int res2 = sol.countAllDerangement(4);
		System.out.println(res2);
	}
}
