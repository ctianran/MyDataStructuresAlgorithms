package com.dfs;

/**
 * Created by Tianran on 2/16/2017.
 */
public class MineGame {
	private static final int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public int countEntries(int[][] matrix, int x, int y) {
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int[] result = new int[1];
		if(matrix[x][y] == 0) {
			helper(x, y, matrix, visited, result);
		} else {
			return 1;
		}
		return result[0];
	}

	private void helper(int x, int y, int[][] matrix, boolean[][] visited, int[] result) {
		 result[0]++;
		 visited[x][y] = true;

		 //explore four neighbors
		for(int i = 0 ; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];
			if(newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length || visited[newX][newY]) {
				continue;
			}
			if(matrix[newX][newY] == 0) {
				helper(newX, newY, matrix, visited, result);
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {{-1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, -1}};
		MineGame sol = new MineGame();
		int res = sol.countEntries(input, 2, 0);
		System.out.println(res);
	}
}
