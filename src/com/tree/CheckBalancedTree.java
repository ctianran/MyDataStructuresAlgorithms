package com.tree;

/**
 * Created by Tianran on 1/29/2017.
 */
public class CheckBalancedTree {
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		return getHeight(root) != -1;
	}

	private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);

		if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		CheckBalancedTree sol = new CheckBalancedTree();
		System.out.println(sol.isBalanced(n1));
	}
}
