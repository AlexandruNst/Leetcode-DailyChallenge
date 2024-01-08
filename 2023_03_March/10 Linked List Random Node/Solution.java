class Solution {
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int scope = 1;
        int val = 0;
        ListNode curr = head;
        while (curr != null) {
            // Math.random() generates numbers from
            // 0.0 to 1.0 with equal probability

            // 0.0 to 0.5 with 50% probability
            // 0.0 to 0.8 with 80% probability

            // therefore

            // 0.0 to 1/scope is scope% probability.

            // Basically at every step, we say that it has scope% probability to be chosen,
            // and 1 - scope% probability for the previous one to remain chosen.
            if (Math.random() < 1.0 / scope)
                val = curr.val;
            scope++;
            curr = curr.next;
        }

        return val;
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