package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 6/19/2017.
 */
public class AllIntegersWithKOneBits {
	public List<Integer> kOneBits(int k) {
		List<Integer> res = new ArrayList<>();
		if(k < 0) {
			return res;
		}
		helper(0, 0, 0, k, res);
		return res;
	}

	private void helper(int curVal, int index, int countOnes, int k, List<Integer> res) {
		if(countOnes == k) {
			res.add(curVal);
			return;
		}
		if(index == 32) {

			return;
		}

		helper(curVal | (1 << index), index + 1, countOnes + 1, k, res);
		helper(curVal, index + 1, countOnes, k, res);
	}

	public List<Integer> kOneBitsII(int k) {
		List<Integer> res = new ArrayList<>();
		if(k < 0) {
			return res;
		}
		helperii(0, 0, 0, k, res);
		return res;
	}

	private void helperii(int curVal, int index, int countOnes, int k, List<Integer> res) {
		if(countOnes == k) {
			res.add(curVal);
			return;
		}
		for(int i = index; i < 32; i++) {
			helperii(curVal | (1 << i), i + 1, countOnes + 1, k, res);
		}
	}

	public static void main(String[] args) {
		AllIntegersWithKOneBits sol = new AllIntegersWithKOneBits();
		List<Integer> res = sol.kOneBits(2);
		List<Integer> resii = sol.kOneBits(2);
		System.out.println(res);
		System.out.println(resii);
	}
}
