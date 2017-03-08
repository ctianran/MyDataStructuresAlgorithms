package com.sorting;

import com.chentianran.ListNode;

/**
 * Created by Tianran on 3/6/2017.
 */
public class InsertionSortLinkedList {
	public ListNode insertionSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode end = head;
		while (end.next != null) {
			ListNode next = end.next;
			if (next.value < end.value) {
				ListNode cur = dummy;
				while (cur.next != null && cur.next.value < next.value) {
						cur = cur.next;
				}
				ListNode temp = cur.next;
				cur.next = next;
				end.next = next.next;
				next.next = temp;
			} else {
				end = end.next;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		InsertionSortLinkedList sol = new InsertionSortLinkedList();
		ListNode res = sol.insertionSort(n1);
		while(res != null) {
			System.out.print(res.value + " ");
			res = res.next;
		}
	}
}
