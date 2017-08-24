package com.companies.ixl;

/**
 * Created by Tianran on 8/2/2017.
 */
public class RangeAdditionII {
	public int maxCount(int m, int n, int[][] ops) {
		int row = m;
		int col = n;
		for(int[] cur : ops) {
			//get the min value for both row and col for the overlapping region
			row = Math.min(row, cur[0]);
			col = Math.min(col, cur[1]);
		}
		//the smallest row number * col number includes all the overlapping region
		return row * col;
	}
}
