package com.tree;

/**
 * Created by Tianran on 1/29/2017.
 */
public class CheckBST {
	public boolean isBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean helper(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.val <= min || root.val >= max) {
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(8);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		CheckBST sol = new CheckBST();
		System.out.println(sol.isBST(n1));
	}
}
