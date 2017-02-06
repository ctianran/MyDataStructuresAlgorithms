package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/4/2017.
 */
public class ValidIfBlocks {
	public void validIfBlocks(int n) {
		List<String> result = new ArrayList<>();
		if(n <= 0) {
			return;
		}
		helper(n, n, result);
	}

	private void helper(int left, int right, List<String> result) {
		if(left == 0 && right == 0) {
			for(String s : result) {
				System.out.println(s);
			}
			System.out.println("=======================");
			return;
		}
		StringBuilder sb = new StringBuilder();
		if(left > 0) {
			for(int i = 0; i < right - left; i++) {
				sb.append("  ");
			}
			result.add(sb.append("if {").toString());
			helper(left - 1, right, result);
			result.remove(result.size() - 1);
		}
		sb.setLength(0);
		if(right > left) {
			for(int i = 0; i < right - left; i++) {
				sb.append("  ");
			}
			result.add(sb.append("}").toString());
			helper(left, right - 1, result);
			result.remove(result.size() - 1);
		}
	}

	public static void main(String[] args) {
		ValidIfBlocks sol = new ValidIfBlocks();
		sol.validIfBlocks(3);

	}
}
