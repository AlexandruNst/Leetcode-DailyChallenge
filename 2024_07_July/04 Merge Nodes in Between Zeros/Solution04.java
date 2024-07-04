import Structures.ListNode;

class Solution04 {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode newHead = new ListNode();
        ListNode res = newHead;
        while (head != null) {
            if (head.val == 0) {
                newHead.next = new ListNode(sum);
                sum = 0;
                newHead = newHead.next;
            } else
                sum += head.val;
            head = head.next;
        }
        return res.next.next;
    }
}