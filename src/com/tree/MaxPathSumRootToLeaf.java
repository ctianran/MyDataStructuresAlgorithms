package com.tree;

/**
 * Created by Tianran on 1/30/2017.
 */
public class MaxPathSumRootToLeaf {
	public int maxPathSumI(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] result = new int[1];
		helperI(root, result, 0);
		return result[0];
	}

	private void helperI(TreeNode root, int[] result, int prefixSum) {
		if(root == null) {
			return;
		}
		prefixSum += root.val;
		if(root.left == null && root.right == null) {
			result[0] = Math.max(result[0], prefixSum);
		}
		helperI(root.left, result, prefixSum);
		helperI(root.right, result, prefixSum);
	}

	public int maxPathSumII(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = maxPathSumII(root.left);
		int right = maxPathSumII(root.right);

		if(root.left == null && root.right == null) {
			return root.val;
		}
		if(root.left == null) {
			return right + root.val;
		}
		if(root.right == null) {
			return left + root.val;
		}
		return Math.max(left, right) + root.val;
	}

}
