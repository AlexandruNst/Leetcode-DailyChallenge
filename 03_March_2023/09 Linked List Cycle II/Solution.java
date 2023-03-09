// T: O(n)
// S: O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow_p = head;
        ListNode fast_p = head;

        while (fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            if (slow_p == fast_p)
                break;
        }

        if (fast_p == null || fast_p.next == null)
            return null;

        ListNode first_p = head;
        ListNode second_p = fast_p;

        while (first_p != second_p) {
            first_p = first_p.next;
            second_p = second_p.next;
        }

        return first_p;
    }

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}