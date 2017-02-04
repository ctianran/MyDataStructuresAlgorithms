package com.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tianran on 2/3/2017.
 */
public class AllPermutations {
	public List<String> permute(String input) {
		List<String> result = new ArrayList<>();
		if(input == null) {
			return result;
		}
		char[] array = input.toCharArray();
		helperII(array, 0, result);
		return result;
	}

	private void helperI(char[] array, int index, List<String> result) {
		if(index == array.length) {
			result.add(new String(array));
			return;
		}
		for(int i = index; i < array.length; i++) {
			swap(array, i, index);
			helperI(array, index + 1, result);
			swap(array, i, index);
		}
	}

	private void helperII(char[] array, int index, List<String> result) {
		if(index == array.length) {
			result.add(new String(array));
			return;
		}
		Set<Character> set = new HashSet<>();
		for(int i = index; i < array.length; i++) {
			if(set.add(array[i])) {
				swap(array, i, index);
				helperII(array, index + 1, result);
				swap(array, i, index);
			}
		}
	}

	private void swap(char[] array, int a, int b) {
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		String input = "aac";
		AllPermutations sol = new AllPermutations();
		List<String> res = sol.permute(input);
		System.out.println(res);
	}
}
