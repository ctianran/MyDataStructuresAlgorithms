package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class ReverseKNodes {
	public ListNode reverse(ListNode head, int k) {
		if(head == null || head.next == null || k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		int count = k;
		while(cur != null) {
			if(count == 1) {
				ListNode temp = prev.next;
				ListNode next = cur.next;
				prev.next = null;
				cur.next = null;

				ListNode newHead = reverse(temp);
				prev.next = newHead;
				temp.next = next;

				prev = temp;
				cur = next;
				count = k;
			} else {
				count--;
				cur = cur.next;
			}
		}
		return dummy.next;
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

		ReverseKNodes sol = new ReverseKNodes();
		ListNode res = sol.reverse(n1, 5);

		ListNode cur = res;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
