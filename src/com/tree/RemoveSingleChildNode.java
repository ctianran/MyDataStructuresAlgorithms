package com.tree;

/**
 * Created by Tianran on 1/30/2017.
 */
public class RemoveSingleChildNode {
	public TreeNode removeSingle(TreeNode root) {
		if(root == null) {
			return null;
		}
		root.left = removeSingle(root.left);
		root.right = removeSingle(root.right);

		if(root.left == null && root.right == null) {
			return root;
		}

		if(root.left == null) {
			return root.right;
		}

		if(root.right == null) {
			return root.left;
		}

		return root;
	}
}
