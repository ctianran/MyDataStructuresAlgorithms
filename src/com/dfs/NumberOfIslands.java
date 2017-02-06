package com.dfs;

/**
 * Created by Tianran on 2/4/2017.
 */
public class NumberOfIslands {
	final static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public int search(int[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		int result = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					result++;
					helper(i, j, board, visited);
				}
			}
		}
		return result;
	}

	private void helper(int x, int y, int[][] board, boolean[][] visited) {
		visited[x][y] = true;

		for(int i = 0; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];

			if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || visited[newX][newY]) {
				continue;
			}
			if(board[newX][newY] == 1) {
				helper(newX, newY, board, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
		NumberOfIslands sol = new NumberOfIslands();
		int res = sol.search(input);
		System.out.println(res);
	}
}
