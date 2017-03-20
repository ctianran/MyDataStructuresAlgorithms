package com.dfs;

/**
 * Created by Tianran on 3/15/2017.
 */
public class LongestConsecutiveSequenceInMatrix {
	private static int[][] DIR = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
	public int longestPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] res = new int[1];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dfsHelper(i, j, 1, res, matrix);
			}
		}
		return res[0];
	}

	private void dfsHelper(int x, int y, int cur, int[] res, int[][] matrix) {
		res[0] = Math.max(res[0], cur);

		for(int i = 0; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];

			if(newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length) {
				continue;
			}
			if(matrix[newX][newY] == matrix[x][y] + 1) {
				dfsHelper(newX, newY, cur + 1, res, matrix);
			}
		}
	}


		int finLongestOverAllII(int[][] mat)
		{
			int result = 1;
			int[][] dp = new int[mat.length][mat[0].length];
			for( int i=0; i<dp.length; i++ ){
				for( int j=0; j<dp[0].length; j++){
					dp[i][j] = -1;
				}
			}
			for (int i=0; i<mat.length; i++)
			{
				for (int j=0; j<mat[0].length; j++)
				{
					if (dp[i][j] == -1)
						findLongest(i, j, mat, dp);
					result = Math.max(result, dp[i][j]);
				}
			}

			return result;
		}
		int findLongest( int i, int j, int[][] mat, int[][] dp){
			if (i<0 || i>=mat.length || j<0 || j>=mat[0].length)
				return 0;

			if (dp[i][j] != -1)
				return dp[i][j];
			if (j<mat.length-1 && ((mat[i][j] +1) == mat[i][j+1]))
				return dp[i][j] = 1 + findLongest(i,j+1,mat,dp);

			if (j>0 && (mat[i][j] +1 == mat[i][j-1]))
				return dp[i][j] = 1 + findLongest(i,j-1,mat,dp);

			if (i>0 && (mat[i][j] +1 == mat[i-1][j]))
				return dp[i][j] = 1 + findLongest(i-1,j,mat,dp);

			if (i<mat.length-1 && (mat[i][j] +1 == mat[i+1][j]))
				return dp[i][j] = 1 + findLongest(i+1,j,mat,dp);

			return dp[i][j] = 1;
		}


	public static void main(String[] args) {
		int[][] matrix = new int[][] {{4, 3, 6},
																	{3, 2, 3},
																	};
		LongestConsecutiveSequenceInMatrix sol = new LongestConsecutiveSequenceInMatrix();
		int res = sol.longestPath(matrix);

		int res2 = sol.finLongestOverAllII(matrix);
		System.out.println(res);
		System.out.println(res2);
	}

}
