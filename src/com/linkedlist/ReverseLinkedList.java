package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class ReverseLinkedList {
	public ListNode reverseRecursive(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	public ListNode reverseIterative(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		 ListNode n1 = new ListNode(1);
		 ListNode n2 = new ListNode(2);
		 ListNode n3 = new ListNode(3);
		 ListNode n4 = new ListNode(4);

		 n1.next = n2;
		 n2.next = n3;
		 n3.next = n4;


		ListNode cur = n1;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();

		ReverseLinkedList sol = new ReverseLinkedList();
		ListNode out1 = sol.reverseRecursive(n1);

		cur = out1;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();

		ListNode out2 = sol.reverseIterative(out1);

		cur = out2;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();

	}
}
