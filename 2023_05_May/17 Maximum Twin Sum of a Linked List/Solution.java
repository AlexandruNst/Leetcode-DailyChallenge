class Solution {
    public int pairSum(ListNode head) {
        // Stack<Integer> stack = new Stack<>();
        // ListNode slowP = head;
        // ListNode fastP = head;

        // while(fastP != null){
        // stack.add(slowP.val);
        // slowP = slowP.next;
        // fastP = fastP.next.next;
        // }

        // int maxSum = 0;
        // while(slowP != null){
        // int currSum = slowP.val + stack.pop();
        // maxSum = Math.max(maxSum, currSum);
        // slowP = slowP.next;
        // }

        // return maxSum;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = null;
        ListNode prev = null;

        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int maxSum = 0;
        ListNode start = head;
        while (prev != null) {
            int currSum = prev.val + start.val;
            maxSum = Math.max(maxSum, currSum);

            start = start.next;
            prev = prev.next;
        }

        return maxSum;
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