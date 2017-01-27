package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class RemoveKthNodeFromTail {
	public ListNode remove(ListNode head, int k) {
		if(head == null || k == 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode fast = head;

		while(k > 0 && fast != null) {
			fast = fast.next;
			k--;
		}
		//check k > list size
		if(k > 0) {
			return head;
		}

		ListNode prev = dummy;
		ListNode slow = head;
		while(fast != null) {
			fast = fast.next;
			prev = prev.next;
			slow = slow.next;
		}

		prev.next = slow.next;
		slow.next = null;

		return dummy.next;
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

		RemoveKthNodeFromTail sol = new RemoveKthNodeFromTail();
		ListNode res = sol.remove(n1, 1);

		ListNode cur = res;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
