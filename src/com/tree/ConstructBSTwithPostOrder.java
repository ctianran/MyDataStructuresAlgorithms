package com.tree;

/**
 * Created by Tianran on 1/31/2017.
 */
public class ConstructBSTwithPostOrder {
	public TreeNode construct(int[] post) {
		if(post == null || post.length == 0) {
			return null;
		}
		int[] index = new int[] {post.length - 1};
		return helper(post, index, Integer.MIN_VALUE);
	}

	private TreeNode helper(int[] post, int[] index, int min) {
		if(index[0] < 0 || post[index[0]] < min) {
			return null;
		}
		TreeNode root = new TreeNode(post[index[0]--]);
		root.right = helper(post, index, root.val);
		root.left = helper(post, index, min);
		return root;
	}
}
