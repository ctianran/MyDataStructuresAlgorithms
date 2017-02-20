package com.tree;

/**
 * Created by Tianran on 2/16/2017.
 */
public class SplitBST {
	public TreeNode[] split(TreeNode root, int pivot) {
		TreeNode[] res = new TreeNode[2];
		if(root != null) {
			if(root.val <= pivot) {
				TreeNode[] rightTrees = split(root.right, pivot);
				res[0] = root;
				root.right = rightTrees[0];
				res[1] = rightTrees[1];
			} else {
				TreeNode[] leftTrees = split(root.left, pivot);
				res[0] = leftTrees[0];
				root.left = leftTrees[1];
				res[1] = root;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n3.left = n5;
		n3.right = n6;

		SplitBST sol = new SplitBST();

		TreeNode[] res = sol.split(n1, 2);

		InOrderTraversal inorder = new InOrderTraversal();
		inorder.inorderRecursive(res[0]);
		System.out.println();
		inorder.inorderRecursive(res[1]);

		//System.out.println(res[1].val);
	}
}
