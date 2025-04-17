package io.dsa.neetcode150.Advanced;

import io.dsa.neetcode150.ListNode;

public class LC_25_ReverseNodes {

    private static ListNode Solution(ListNode head, int k) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        if (len < k) {
            return head;
        }
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (next != null) {
            head.next = Solution(next, k);
        }

        return prev;
    }
}
