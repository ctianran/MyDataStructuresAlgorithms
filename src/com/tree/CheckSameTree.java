package com.tree;

/**
 * Created by Tianran on 1/30/2017.
 */
public class CheckSameTree {
	public boolean isSame(TreeNode one, TreeNode two) {
		if(one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.val != two.val) {
			return false;
		}
		return isSame(one.left, two.left) && isSame(one.right, two.right);
	}
}
