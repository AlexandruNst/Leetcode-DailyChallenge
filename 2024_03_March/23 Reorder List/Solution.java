import Structures.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        ListNode reordered = head;
        while (!stack.isEmpty()) {
            ListNode next = reordered.next;
            ListNode stackNext = stack.pop();
            reordered.next = stackNext;
            stackNext.next = next;
            reordered = next;
        }

        reordered.next = null;
    }
}