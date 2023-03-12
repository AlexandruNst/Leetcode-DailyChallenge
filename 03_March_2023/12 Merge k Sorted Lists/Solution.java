import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode listHead : lists) {
            if (listHead != null)
                pq.add(listHead);
        }

        ListNode mergedList = new ListNode();
        ListNode mergedListHead = mergedList;
        while (!pq.isEmpty()) {
            ListNode orderedNode = pq.poll();
            mergedList.next = orderedNode;
            if (orderedNode.next != null)
                pq.add(orderedNode.next);
            mergedList = mergedList.next;
        }

        return mergedListHead.next;

    }

    // Definition for singly-linked list.
    class ListNode {
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