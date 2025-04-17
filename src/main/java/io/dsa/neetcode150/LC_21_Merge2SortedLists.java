package io.dsa.neetcode150;

public class LC_21_Merge2SortedLists {
    public static void main(String[] args) {

    }

    private static ListNode Solution(ListNode l1, ListNode l2) {
        /*
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]
         */
        ListNode dummy = new ListNode(); // it is always pointing to the head of the list
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
        }

        curr.next
                = (l1 != null) ? l1 : l2;

        return dummy.next;

    }
}
