package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/3/2017.
 */
public class FindAllSubsets {
	public List<String> subSet(String input) {
		List<String> result = new ArrayList<>();
		if(input == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helperDedup(input, sb, 0, result);
		return result;
	}

	private void helper(String input, StringBuilder sb, int index, List<String> result) {
		if(index == input.length()) {
			result.add(sb.toString());
			return;
		}
		sb.append(input.charAt(index));
		helper(input, sb, index + 1, result);
		sb.deleteCharAt(sb.length() - 1);

		helper(input, sb, index + 1, result);
	}

	private void helperII(String input, StringBuilder sb, int index, List<String> result) {
		result.add(sb.toString());
		for(int i = index; i < input.length(); i++) {
			sb.append(input.charAt(index));
			helperII(input, sb, i + 1, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private void helperDedup(String input, StringBuilder sb, int index, List<String> result) {
		if(index == input.length()) {
			result.add(sb.toString());
			return;
		}
		sb.append(input.charAt(index));
		helperDedup(input, sb, index + 1, result);
		sb.deleteCharAt(sb.length() - 1);

		while(index + 1 < input.length() && input.charAt(index) == input.charAt(index + 1)) {
			index++;
		}
		helperDedup(input, sb, index + 1, result);
	}

	public static void main(String[] args) {
		String input = "abbbc";
		FindAllSubsets sol = new FindAllSubsets();
		List<String> res = sol.subSet(input);
		System.out.println(res);
	}
}
