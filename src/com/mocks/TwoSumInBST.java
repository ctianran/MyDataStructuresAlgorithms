package com.mocks;

import com.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 1/28/2017.
 */
public class TwoSumInBST {
	public boolean twoSumI(TreeNode root, int target) {
		if(root == null) {
			return false;
		}
		TreeNode[] prev = new TreeNode[] {null};
		TreeNode[] head = new TreeNode[] {null};
		helper(root, prev, head);
		TreeNode left = head[0];
		TreeNode right = left;
		while(right.right != null) {
			right = right.right;
		}

		while(left != right) {
			int sum = left.val + right.val;
			if(sum == target) {
				return true;
			} else if (sum < target) {
				left = left.right;
			} else {
				right = right.left;
			}
		}
		return false;
	}

	public boolean twoSumII(TreeNode root, int target) {
		if(root == null) {
			return false;
		}
		Deque<TreeNode> leftStack = new LinkedList<>();
		Deque<TreeNode> rightStack = new LinkedList<>();

		boolean done1 = false;
		boolean done2 = false;
		int value1 = 0;
		int value2 = 2;

		TreeNode cur1 = root;
		TreeNode cur2 = root;

		while(true) {
			while(done1 == false) {
				if(cur1 != null) {
					leftStack.offerFirst(cur1);
					cur1 = cur1.left;
				} else {
					if(leftStack.isEmpty()) {
						done1 = true;
					} else {
						cur1 = leftStack.pollFirst();
						value1 = cur1.val;
						cur1 = cur1.right;
						done1 = true;
					}
				}
			}

			while(done2 == false) {
				if(cur2 != null) {
					rightStack.offerFirst(cur2);
					cur2 = cur2.right;
				} else {
					if(rightStack.isEmpty()) {
						done2 = true;
					} else {
						cur2 = rightStack.pollFirst();
						value2 = cur2.val;
						cur2 = cur2.left;
						done2 = true;
					}
				}
			}

			if((value1 != value2) && (value1 + value2) == target) {
				return true;
			} else if((value1 + value2) < target) {
				done1 = false;
			} else if ((value1 + value2) > target) {
				done2 = false;
			}

			if(value1 >= value2) {
				return false;
			}
		}
	}

	private void helper(TreeNode root, TreeNode[] prev, TreeNode[] head) {
		if(root == null) {
			return;
		}
		helper(root.left, prev, head);
		if(prev[0] == null) {
			head[0] = root;
		} else {
			prev[0].right = root;
			root.left = prev[0];
		}
		prev[0] = root;
		helper(root.right, prev, head);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);

		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;

		TwoSumInBST sol = new TwoSumInBST();
		boolean res = sol.twoSumII(root, 12);
		System.out.println(res);
	}
}
