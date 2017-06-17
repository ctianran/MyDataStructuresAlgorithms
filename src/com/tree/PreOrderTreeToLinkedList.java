package com.tree;

/**
 * Created by Tianran on 6/6/2017.
 */
public class PreOrderTreeToLinkedList {
	public TreeNode convert(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode cur = root;
		TreeNode[] prev = new TreeNode[] {null};
		helper(cur, prev);
		return root;
	}

	private void helper(TreeNode cur, TreeNode[] prev) {
		if(cur == null) {
			return;
		}
		TreeNode left = cur.left;
		TreeNode right = cur.right;

		if(prev[0] != null) {
			prev[0].right = cur;
			cur.left = prev[0];
		} else {
			cur.left = null;
		}
		prev[0] = cur;

		helper(left, prev);
		helper(right, prev);

	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);

		n1.left = n2;
		n2.left = n3;
		n1.right = n4;

		PreOrderTreeToLinkedList sol = new PreOrderTreeToLinkedList();
		TreeNode res = sol.convert(n1);

		while(res.right != null) {
			System.out.println(res.val);
			res = res.right;
		}

		while(res != null) {
			System.out.println(res.val);
			res = res.left;
		}

	}
}
