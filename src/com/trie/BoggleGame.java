package com.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/5/2017.
 */
public class BoggleGame {
	static final int[][] DIRS = {{-1, 0},{1, 0},{0, -1},{0, 1}};

	public List<String> findWordsOneByOne(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		for(String word : words) {
			if(exist(board, word)) {
				result.add(word);
			}
		}
		return result;
	}

	private boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(helper(i, j, board, word,0, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(int x, int y, char[][] board, String word, int index, boolean[][] visited) {
		if(board[x][y] != word.charAt(index)) {
			return false;
		}
		if(index == word.length() - 1) {
			return true;
		}
		visited[x][y] = true;

		for(int i = 0; i < 4; i++) {
			int newX = x + DIRS[i][0];
			int newY = y + DIRS[i][1];

			if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || visited[newX][newY]) {
				continue;
			}

			if(helper(newX, newY, board, word, index + 1, visited)) {
				return true;
			}
		}
		visited[x][y] = false;

		return false;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] {{'A', 'P','P','D'},{'P', 'P','L','G'},{'O', 'G','E','I'},{'D', 'K','L','M'}};
		String[] words = new String[] {"AT", "APP", "APPLE", "CAP", "CAT", "CATHY", "DOG"};

		BoggleGame sol = new BoggleGame();
		List<String> res = sol.findWordsOneByOne(board, words);
		System.out.println(res);
	}
}
