package com.tree;

/**
 * Created by Tianran on 1/30/2017.
 */
public class MaxSubPathSumRootToLeaf {
	public int subPathSum(TreeNode root) {
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

		int max = Math.max(left, right);
		int cur = Math.max(0, max) + root.val;
		result[0] = Math.max(result[0], cur);
		return cur;
	}
}
