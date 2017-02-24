package com.chentianran;

import com.tree.TreeNode;

import java.util.*;

/**
 * Created by Tianran on 1/8/2017.
 */
public class Main {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;

		List<Integer> res = getValue(n1);
		System.out.println(res);

		String s = "abc";
		System.out.println(s.substring(1, 3));

		int[] arr = new int[] {1, 3, 2};
		Integer[] intArr = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());
		System.out.println(minHeap.poll());

	}

	private static List<Integer> getValue(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result);
		return result;
	}

	private static void helper(TreeNode root, List<Integer> result) {
		if(root == null || result.size() >= 2) {
			return;
		}
		helper(root.right, result);
		result.add(root.val);
		helper(root.left, result);
	}

}
