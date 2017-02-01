package com.tree;

/**
 * Created by Tianran on 1/31/2017.
 */
public class ConstructBSTwithPreOrder {
	public TreeNode construct(int[] pre) {
		if(pre == null || pre.length == 0) {
			return null;
		}
		int[] index = new int[1];
		return helper(pre, index, Integer.MAX_VALUE);
	}

	private TreeNode helper(int[] pre, int[] index, int max) {
		if(index[0] >= pre.length || pre[index[0]] > max) {
			return null;
		}
		TreeNode root = new TreeNode(pre[index[0]++]);
		root.left = helper(pre, index, root.val);
		root.right = helper(pre, index, max);
		return root;
	}
}
