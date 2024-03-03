import Structures.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null; // if only one element, returnn null;

        ListNode behind = head;
        ListNode ahead = head;
        for (int i = 0; i < n; i++) { // advance the ahead pointer n steps
            ahead = ahead.next;
        }

        if (ahead == null)
            return head.next; // if we reached the end, it means we are eliminating first element

        while (ahead.next != null) { // reach the end, and skip the removed element
            ahead = ahead.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;

        return head;
    }
}