package leetcode.n203;

import leetcode.ListNode;

public class Solution {

	public static void main(String[] args) {
		ListNode head = ListNode.build(new int[] { 1, 2, 3, 4, 5, 6 });
		// System.out.println(new Solution().removeElements(head, 1));
		// head = ListNode.build(new int[] { 1, 2, 3, 6, 4, 5, 6 });
		// System.out.println(new Solution().removeElements(head, 6));
		// head = ListNode.build(new int[] { 1, 2, 3, 4, 5, 6 });
		// System.out.println(new Solution().removeElements(head, 4));
		head = ListNode.build(new int[] { 1, 2, 2, 1 });
		System.out.println(new Solution().removeElements(head, 2));

	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		while (node != null && node.val == val) {
			node = node.next;
			head = node;
		}
		if (head == null) {
			return null;
		}
		while (node != null && node.next != null) {
			if (node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}

}
