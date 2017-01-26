package com.chentianran;

/**
 * Created by Tianran on 1/8/2017.
 *  base case:	 M[0][0] = input[0][0]   start with red
 *  M[0][1] = input[0][1]   start with blue
 *  M[0][2] = input[0][2]   start with green
 *  M[i][0] represents by start with red, the min cost for paint from 0th house to ith (including ith) house
 *  M[i][1] represents by start with blue, the min cost for paint from 0th house to ith (including ith) house
 *  M[i][2] represents by start with green, the min cost for paint from 0th house to ith (including ith) house
 * Induction Rule: M[i][0] = cost[i][0] + min(M[i-1][1], M[i-1][2])
 * M[i][1] = cost[i][1] + min(M[i-1][0], M[i-1][2])
 * M[i][2] = cost[i][2] + min(M[i-1][0], M[i-1][1])
 * return  min(M[i][0], M[i][1], M[i][2])
 *
 */
public class PaintHouse {
	//Time: O(n)
  //Space: O(3 * n);
	public int minCostI(int[][] costs) {

		if(costs == null || costs.length == 0) {
			return 0;
		}
		int rows = costs.length;
		int[][] sum = new int[rows][3];

		//initialize
		sum[0][0] = costs[0][0];
		sum[0][1] = costs[0][1];
		sum[0][2] = costs[0][2];

		for(int i = 1; i < rows; i++) {
			sum[i][0] = costs[i][0] + Math.min(sum[i-1][1], sum[i-1][2]);
			sum[i][1] = costs[i][1] + Math.min(sum[i-1][0], sum[i-1][2]);
			sum[i][2] = costs[i][2] + Math.min(sum[i-1][0], sum[i-1][1]);
		}
		return Math.min(Math.min(sum[rows-1][0], sum[rows-1][1]), sum[rows-1][2]);
	}

	//Time: O(n)
	//Space: O(1);
	public int minCostII(int[][] costs) {
		if(costs == null || costs.length == 0) {
			return 0;
		}
		int rows = costs.length;
		//initialize
		int red = costs[0][0];
		int blue = costs[0][1];
		int green = costs[0][2];

		for(int i = 1; i < rows; i++) {
			int redTemp = costs[i][0] + Math.min(blue, green);
			int blueTemp = costs[i][1] + Math.min(red, green);
			int greenTemp = costs[i][2] + Math.min(red, blue);
			red = redTemp;
			blue = blueTemp;
			green = greenTemp;
		}
		return Math.min(Math.min(red, blue), green);
	}

	//Time: O(n)
	//Space: O(1)
	public int minCostIII(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int rows = costs.length;
		for (int i = 0; i < rows - 1; i++) {
			costs[i + 1][0] += Math.min(costs[i][1], costs[i][2]);
			costs[i + 1][1] += Math.min(costs[i][0], costs[i][2]);
			costs[i + 1][2] += Math.min(costs[i][0], costs[i][1]);
		}
		return Math.min(Math.min(costs[rows - 1][0], costs[rows - 1][1]), costs[rows - 1][2]);
	}
}
