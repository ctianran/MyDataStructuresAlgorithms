package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class ReverseLinkedListWithinRange {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null || m == n) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode slow = head;
		ListNode fast = head;

		while(m > 1) {
			slow = slow.next;
			prev = prev.next;
			m--;
		}
		while(n > 1) {
			fast = fast.next;
			n--;
		}

		ListNode next = fast.next;
		fast.next = null;
		prev.next = null;

		ListNode newHead = reverse(slow);
		prev.next = newHead;
		slow.next = next;

		return dummy.next;

	}

	private ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode prev =null;
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
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ReverseLinkedListWithinRange sol = new ReverseLinkedListWithinRange();
		ListNode res = sol.reverseBetween(n1, 1, 4);

		ListNode cur = res;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
