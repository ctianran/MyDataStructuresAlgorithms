package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/14/2017.
 */
public class InsertSpacesInStringPermutations {
	public List<String> permutation(String input) {
		List<String> result = new ArrayList<>();
		if(input == null) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		helper(input, 0, sb, result);
		return result;
	}

	private void helper(String input, int index, StringBuilder sb, List<String> result) {
		if(index == input.length() - 1) {
			sb.append(input.charAt(index));
			result.add(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
			return;
		}
		sb.append(input.charAt(index));
		sb.append(' ');
		helper(input, index + 1, sb, result);
		sb.deleteCharAt(sb.length() - 1);

		helper(input, index + 1, sb, result);

	}

	public static void main(String[] args) {
		String s = "ABC";
		InsertSpacesInStringPermutations sol = new InsertSpacesInStringPermutations();
		List<String> res = sol.permutation(s);
		System.out.println(res);
	}
}
