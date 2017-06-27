package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 6/20/2017.
 */
public class AllIntegerWithoutOneBitsNextToEachOther {
	public List<Integer> getAll() {
		List<Integer> res = new ArrayList<>();
		helper(0, 0, res);
		return res;
	}

	private void helper(int prevVal, int index, List<Integer> res) {
		if(index == 32) {
			res.add(prevVal);
			return;
		}
		//if previous digit is 0, we can pick bit 1 for current level
		if(index == 0 || (prevVal & (1 << (index - 1))) == 0) {
			helper(prevVal | (1 << index), index + 1, res);
		}
		//can pick bit 0 anyway
		helper(prevVal, index + 1, res);

	}

	public List<Integer> getAllii() {
		List<Integer> res = new ArrayList<>();
		helperii(0, 0, res);
		return res;
	}

	private void helperii(int curVal, int index, List<Integer> res) {
		if(index >= 32) {
			res.add(curVal);
			return;
		}
		for(int i = index; i < 32; i++) {
			helperii(curVal | (1 << i), i + 2, res);
		}
	}
	public static void main(String[] args) {
		AllIntegerWithoutOneBitsNextToEachOther sol = new AllIntegerWithoutOneBitsNextToEachOther();
		//List<Integer> res = sol.getAll();
		List<Integer> resii = sol.getAllii();
		//System.out.println(res);
		System.out.println(resii);
	}
}
