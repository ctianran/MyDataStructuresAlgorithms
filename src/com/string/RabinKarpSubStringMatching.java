package com.string;

import java.math.BigInteger;

/**
 * Created by Tianran on 2/19/2017.
 */
public class RabinKarpSubStringMatching {
	public int strStr(String large, String small) {
		if(large.length() < small.length()) {
			return -1;
		}
		if(small.isEmpty()) {
			return 0;
		}
		//hash the small String to a hash value
		BigInteger smallHash = BigInteger.ZERO;
		BigInteger largeHash = BigInteger.ZERO;
		BigInteger base = BigInteger.valueOf(256);
		for(int i = 0; i < small.length(); i++) {
			//smallHash = smallHash * 26 + (long) (small.charAt(i) - 'a' + 1);
			BigInteger nextValue = BigInteger.valueOf((long)(small.charAt(i)));
			smallHash = smallHash.multiply(base).add(nextValue);
		}

		for(int i = 0; i < large.length(); i++) {
			BigInteger nextValue = BigInteger.valueOf((long)(large.charAt(i)));
			if(i < small.length()) {
				//largeHash = largeHash * 26 + (long) (large.charAt(i) - 'a' + 1);
				largeHash = largeHash.multiply(base).add(nextValue);
			} else {
				//largeHash = largeHash % (long)(Math.pow(26, small.length() - 1)) * 26 + (long)(large.charAt(i) - 'a' + 1);

				largeHash = largeHash.remainder(base.pow(small.length() - 1)).multiply(base).add(nextValue);
			}
			if(largeHash.equals(smallHash)) {
				return i - small.length() + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String s1 = "aabbaabbaabbccaabbaabbaabbaabbcc";
		String s2 = "aabbaabbaabbaabbcc";
		String s3 = "AppleOrangePEA";
		String s4 = "rangePE";
		RabinKarpSubStringMatching sol = new RabinKarpSubStringMatching();
		int res = sol.strStr(s1, s2);
		int res2 = sol.strStr(s3, s4);
		System.out.println(res);
		System.out.println(res2);
	}
}
