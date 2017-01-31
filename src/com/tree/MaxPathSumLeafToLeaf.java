package com.tree;

/**
 * Created by Tianran on 1/30/2017.
 */
public class MaxPathSumLeafToLeaf {
	public int maxPathSum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] result = new int[] {Integer.MIN_VALUE};
		helper(root, result);
		return result[0];
	}

	private int helper(TreeNode root, int[] result) {
		if(root == null) {
			return 0;
		}
		int left = helper(root.left, result);
		int right = helper(root.right, result);

		if(root.left != null && root.right != null) {
			result[0] = Math.max(result[0], left + right + root.val);
			return Math.max(left, right) + root.val;
		}
		return root.left == null ? right + root.val : left + root.val;
	}


}
