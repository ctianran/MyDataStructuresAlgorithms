package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class PalindromeLinkedList {
	public boolean isPalRecursive(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		ListNode[] left = new ListNode[] {head};
		return helper(left, head);
	}

	private boolean helper(ListNode[] left, ListNode head) {
		if(head == null) {
			return true;
		}
		boolean res = helper(left, head.next) && left[0].ch == head.ch;
		left[0] = left[0].next;
		return res;
	}

	public boolean isPalIterative(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		ListNode mid = getMid(head);
		ListNode h2 = mid.next;
		mid.next = null;

		h2 = reverse(h2);
		ListNode h1 = head;

		while(h1 != null && h2 != null) {
			if(h1.ch == h2.ch) {
				h1 = h1.next;
				h2 = h2.next;
			} else {
				return false;
			}
		}
		return true;
	}

	private ListNode getMid(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head) {
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
		 ListNode n1 = new ListNode('a');
		 ListNode n2 = new ListNode('b');
		 ListNode n3 = new ListNode('a');

		 n1.next = n2;
		 n2.next = n3;

		PalindromeLinkedList sol = new PalindromeLinkedList();
		boolean res = sol.isPalIterative(n1);
		System.out.println(res);
	}

}
