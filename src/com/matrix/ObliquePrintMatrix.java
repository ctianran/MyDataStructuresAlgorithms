package com.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 3/7/2017.
 */
public class ObliquePrintMatrix {
	public List<Integer> print(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix == null || matrix.length == 0) {
			return result;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i < rows; i++) {
			int row = i;
			int col = 0;
			while(row >= 0 && col < cols) {
				result.add(matrix[row--][col++]);
			}
		}
		for(int j = 1; j < cols; j++) {
			int row = rows - 1;
			int col = j;
			while(row >= 0 && col < cols) {
				result.add(matrix[row--][col++]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		ObliquePrintMatrix sol = new ObliquePrintMatrix();
		List<Integer> res = sol.print(matrix);
		System.out.println(res);
	}
}
