package io.dsa.neetcode150;

public class LC_9_RemoveNthNode {
    public static void main(String[] args) {

    }

    private static ListNode Solution(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast.next == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next
                = slow.next.next;
        return head;
    }
}
