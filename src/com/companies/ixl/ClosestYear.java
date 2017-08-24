package com.companies.ixl;

/**
 * Created by Tianran on 8/14/2017.
 */
public class ClosestYear {
	public int closest(int num, int curYear) {
		int year1 = (curYear - curYear % 100) + num;
		int year2 = year1 > curYear ? year1 - 100 : year1 + 100;
		if(Math.abs(year1 - curYear) < Math.abs(year2 - curYear)) {
			return year1;
		}
		return year2;
	}

	public static void main(String[] args) {
		ClosestYear sol = new ClosestYear();
		int res = sol.closest(18, 2017);
		System.out.println(res);
	}
}
