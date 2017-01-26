package com.chentianran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 1/16/2017.
 */
public class StringPermutations {
	public List<String> permuNoDup(String input) {
		List<String> result = new ArrayList<String>();
		if (input == null || input.isEmpty()) {
			return result;
		}
		char[] array = input.toCharArray();
		helper(array, 0, result);
		return result;
	}

	public List<String> permuDup(String input) {
		List<String> result = new ArrayList<String>();
		if (input == null || input.isEmpty()) {
			return result;
		}
		char[] array = input.toCharArray();
		dupHelper(array, 0, result);
		return result;
	}

	private void helper(char[] array, int index, List<String> result) {
		if (index == array.length) {
			result.add(new String(array));
			return;
		}
		for (int i = index; i < array.length; i++) {
			swap(array, i, index);
			helper(array, index + 1, result);
			swap(array, i, index);
		}
	}

	private void dupHelper(char[] array, int index, List<String> result) {
		if (index == array.length) {
			result.add(new String(array));
			return;
		}
		Set<Character> set = new HashSet<Character>();
		for (int i = index; i < array.length; i++) {
			if (set.add(array[i])) {
				swap(array, i, index);
				dupHelper(array, index + 1, result);
				swap(array, i, index);
			}
		}
	}

	private void swap(char[] array, int a, int b) {
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
