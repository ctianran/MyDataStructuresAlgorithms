package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class ReverseDoublyLinkedList {
	public ListNode revereRecursive(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = revereRecursive(head.next);
		newHead.next = head;
		head.next = null;
		head.prev = newHead;
		newHead.prev = null;
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
			cur.prev = next;
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
		n2.prev = n1;
		n2.next = n3;
		n3.prev = n2;
		n3.next = n4;
		n4.prev = n3;

		ListNode cur = n1;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = n4;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.prev;
		}
		System.out.println();

		ReverseDoublyLinkedList sol = new ReverseDoublyLinkedList();
		ListNode res = sol.reverseIterative(n1);

		cur = res;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}

		System.out.println();
	}
}
