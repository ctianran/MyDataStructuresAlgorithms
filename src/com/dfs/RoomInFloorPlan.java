package com.dfs;

/**
 * Created by Tianran on 2/5/2017.
 */
public class RoomInFloorPlan {
	private static int[][] DIR = {{1, 0},{0, 1}, {-1, 0}, {0, -1}};

	public int maxRoomCapacity(char[][] board) {
		if(board == null || board.length == 0) {
			return 0;
		}
		int result = 0;
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(board[i][j] == '.' && !visited[i][j]) {
					int[] curSize = new int[1];
					maxRoomCapacityDFS(i, j, board, visited, curSize);
					result = Math.max(result, curSize[0]);
				}
			}
		}
		return result;
	}

	private void maxRoomCapacityDFS(int x, int y, char[][] board, boolean[][] visited, int[] curSize) {
		visited[x][y] = true;
		curSize[0]++;

		for(int i = 0; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];
			if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || visited[newX][newY]) {
				continue;
			}
			if(board[newX][newY] == '.') {
				maxRoomCapacityDFS(newX, newY, board, visited, curSize);
			}
		}
	}

	public int numRooms(char[][] board) {
		if(board == null || board.length == 0) {
			return 0;
		}
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int[] result = new int[1];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(board[i][j] == '.' && !visited[i][j]) {
					numRoomsDFS(i, j, board, visited, result);
				}
			}
		}
		return result[0];
	}

	private void numRoomsDFS(int x, int y, char[][] board, boolean[][] visited, int[] result) {
		visited[x][y] = true;
		result[0]++;

		for(int i = 0; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];
			if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || visited[newX][newY]) {
				continue;
			}
			if(board[newX][newY] == '.') {
				numRoomsDFS(newX, newY, board, visited, result);
			}
		}
	}

	public char[][] paintRoom(char[][] board) {
		if(board == null || board.length == 0) {
			return board;
		}
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		int color = 0 + 'A';
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(board[i][j] == '.' && !visited[i][j]) {
					paintRoomDFS(i, j, board, visited, color);
					color++;
				}
			}
		}
		return board;
	}

	private void paintRoomDFS(int x, int y, char[][] board, boolean[][] visited, int color) {
		visited[x][y] = true;
		board[x][y] = (char)(color);

		for(int i = 0; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];
			if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || visited[newX][newY]) {
				continue;
			}
			if(board[newX][newY] == '.') {
				paintRoomDFS(newX, newY, board, visited, color);
			}
		}
	}

	public static void printBoard(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[][] board = {{'.', '#', '.', '.', '#'},
											{'.', '#', '.', '#', '#'},
											{'.', '#', '.', '#', '.'},
											{'#', '#', '.', '#', '.'},
											{'#', '#', '#', '#', '#'}};

		printBoard(board);
		RoomInFloorPlan sol = new RoomInFloorPlan();
		int res1 = sol.maxRoomCapacity(board);
	  int res2 = sol.numRooms(board);
	 	char[][] res3 = sol.paintRoom(board);
		System.out.println(res1);
		System.out.println(res2);
		printBoard(res3);

	}
}
