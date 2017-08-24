package com.companies.ixl;

/**
 * Created by Tianran on 8/13/2017.
 */
public class StrStr {
	//Time: O(m * n)
	public int strStr(String s, String p) {
		//assume two strings are not null
		if(p.length() > s.length()) {
			return -1;
		}
		for(int i = 0; i <= s.length() - p.length(); i++) {
			if(isMatch(s, p, i)) {
				return i;
			}
		}
		return - 1;
	}

	private boolean isMatch(String s, String p, int start) {
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) != s.charAt(i + start)) {
				return false;
			}
		}
		return true;
	}

	//Robin-Karp
	//Time: O(n)
	public int strStrII(String s, String p) {
		long hashP = 0;
		for(int i = 0; i < p.length(); i++) {
			hashP = hashP * 26 + (long)(p.charAt(i) - 'a');
		}
		long hashS = 0;
		for(int i = 0; i < p.length(); i++) {
			hashS = hashS * 26 + (long)(s.charAt(i) - 'a');
		}
		if(hashS == hashP) {
			return 0;
		}
		for(int i = p.length(); i < s.length(); i++) {
			hashS = hashS % (long)Math.pow(26, p.length() - 1) * 26 + (long)(s.charAt(i) - 'a');
			if(hashS == hashP) {
				return i - p.length() + 1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		String s = "abcd";
		String p = "cd";
		StrStr sol = new StrStr();
		int res = sol.strStr(s, p);
		int res2 = sol.strStrII(s, p);
		System.out.println(res);
		System.out.println(res2);
	}
}
