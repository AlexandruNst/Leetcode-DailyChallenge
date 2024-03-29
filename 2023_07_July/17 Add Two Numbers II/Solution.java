import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode tail = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int val = 0;
            if (!s1.isEmpty())
                val += s1.pop();
            if (!s2.isEmpty())
                val += s2.pop();
            val += carry;
            if (val >= 10) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode head = new ListNode(val, tail);
            tail = head;
        }

        if (carry == 1) {
            return new ListNode(1, tail);
        } else {
            return tail;
        }

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