package com.companies.ixl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 8/2/2017.
 */
public class FractionAdditionAndSubtraction {
	public String fractionAddition(String expression) {
		List<String> nums = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(j <= expression.length()) {
			if(j == expression.length() || j != i && (expression.charAt(j) == '+') || expression.charAt(j) == '-') {
				if(expression.charAt(i) == '+') {
					nums.add(expression.substring(i + 1, j));
				} else {
					nums.add(expression.substring(i, j));
				}
				i = j;
			}
			j++;
		}
		String res = "0/1";
		for(String num : nums) {
			res = add(res, num);
		}
		return res;
	}

	private String add(String s1, String s2) {
		String[] divs1 = s1.split("/");
		String[] divs2 = s2.split("/");
		int num1 = Integer.parseInt(divs1[0]);
		int deno1 = Integer.parseInt(divs1[1]);
		int num2 = Integer.parseInt(divs2[0]);
		int deno2 = Integer.parseInt(divs2[1]);

		int num = num1 * deno2 + num2 * deno1;
		int deno = deno1 * deno2;

		boolean isNegative = num * deno < 0;
		num = Math.abs(num);
		deno = Math.abs(deno);

		int gcd = getGCD(num, deno);

		StringBuilder sb = new StringBuilder();
		sb.append(isNegative ? "-" : "");
		sb.append(num / gcd);
		sb.append("/");
		sb.append(deno / gcd);

		return sb.toString();
	}

	private int getGCD(int a, int b) {
		if(a == 0 || b == 0) {
			return a + b;
		}
		return getGCD(b, a % b);
	}

	public static void main(String[] args) {
		FractionAdditionAndSubtraction sol = new FractionAdditionAndSubtraction();
		String res = sol.fractionAddition("-1/2+1/2+1/3");
		System.out.println(res);
	}
}
