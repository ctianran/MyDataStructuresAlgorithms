package com.dfs;

/**
 * Created by Tianran on 6/21/2017.
 */
public class PasswordCombination {
	public String getPassword(int n) {
		String res = "";
		int num = n;
		int factor = 0;
		while(num > 0) {
			num /= 10;
			factor++;
		}
		int len = n + factor - 1;
		boolean[] used = new boolean[n];
		StringBuilder sb = new StringBuilder();
		helper(sb, 0, len, used, factor);
		return sb.toString();
	}

	private void helper(StringBuilder sb, int index, int len, boolean[] used, int factor){
		if(index == len) {
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(sb.length() <= factor) {
				sb.append(i);
				if(sb.length() == factor) {
					used[Integer.parseInt(sb.toString())] = true;
				}
			} else {
				StringBuilder temp = new StringBuilder();
				for(int j = sb.length() - factor + 1; j < sb.length(); j++) {
					temp.append(sb.charAt(j));
				}
				temp.append(i);
				if(!used[Integer.parseInt(temp.toString())]) {
					sb.append(i);
				}
			}
			helper(sb, index + 1, len, used, factor);
		}
	}
}
