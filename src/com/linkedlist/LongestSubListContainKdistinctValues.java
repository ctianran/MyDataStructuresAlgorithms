package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 2/11/2017.
 */
public class LongestSubListContainKdistinctValues {
	public int longest(ListNode head, int k) {
		if(head == null) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		ListNode slow = head;
		ListNode fast = head;
		int result = 0;
		int count = 0;
		while(fast != null) {
			Integer cur = map.get(fast.val);
			if(cur == null) {
				map.put(fast.val, 1);
				while(map.size() > k) {
					int num = map.get(slow.val);
					if(num == 1) {
						map.remove(slow.val);
					} else {
						map.put(slow.val, num - 1);
					}
					count--;
					slow = slow.next;
				}
			} else {
				map.put(fast.val, count + 1);
			}
			count++;
			fast = fast.next;
			result = Math.max(result, count);
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		LongestSubListContainKdistinctValues sol = new LongestSubListContainKdistinctValues();
		int res = sol.longest(n1, 3);
		System.out.println(res);
	}
}
