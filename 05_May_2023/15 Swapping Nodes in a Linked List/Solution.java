class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode res = head;
        ListNode aheadP = head;
        ListNode behindP = head;

        for (int i = 1; i < k; i++) {
            aheadP = aheadP.next;
        }
        ListNode frontNode = aheadP;
        int frontVal = frontNode.val;

        while (aheadP.next != null) {
            aheadP = aheadP.next;
            behindP = behindP.next;
        }

        ListNode endNode = behindP;
        int endVal = endNode.val;

        endNode.val = frontVal;
        frontNode.val = endVal;

        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}