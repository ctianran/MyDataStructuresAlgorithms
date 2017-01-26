package com.chentianran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 1/18/2017.
 */
public class ArrayPermutations {
	public List<List<Integer>> permuNoDup(int[] input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(input == null || input.length == 0) {
			return result;
		}
		helperNoDup(input, 0, result);
		return result;
	}

	public List<List<Integer>> permuDup(int[] input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(input == null || input.length == 0) {
			return result;
		}
		helperDup(input, 0, result);
		return result;
	}



	private void helperNoDup(int[] input, int index, List<List<Integer>> result) {
		if(index == input.length) {
			List<Integer> cur = new ArrayList<Integer>();
			for(int num : input) {
				cur.add(num);
			}
			result.add(cur);
			return;
		}
		for(int i = index; i < input.length; i++) {
			swap(input, i, index);
			helperNoDup(input, index + 1, result);
			swap(input, i, index);
		}
	}

	private void helperDup(int[] input, int index, List<List<Integer>> result) {
		if(index == input.length) {
			List<Integer> cur = new ArrayList<Integer>();
			for(int num : input) {
				cur.add(num);
			}
			result.add(cur);
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i = index; i < input.length; i++) {
			if(set.add(input[i])) {
				swap(input, i, index);
				helperDup(input, index + 1, result);
				swap(input, i, index);
			}
		}
	}

	private void swap(int[] input, int a, int b) {
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
}
