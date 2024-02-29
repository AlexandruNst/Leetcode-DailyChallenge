import java.util.LinkedList;
import java.util.Queue;

import Structures.TreeNode;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int queuesize = 1;
        boolean even = true;
        while (!q.isEmpty()) {
            int prev;
            if (even)
                prev = Integer.MIN_VALUE;
            else
                prev = Integer.MAX_VALUE;
            for (int i = 0; i < queuesize; i++) {
                TreeNode node = q.poll();
                if (even) {
                    if (node.val <= prev)
                        return false;
                    if (node.val % 2 == 0)
                        return false;
                } else {
                    if (node.val >= prev)
                        return false;
                    if (node.val % 2 != 0)
                        return false;
                }
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                prev = node.val;
            }

            even = !even;
            queuesize = q.size();
        }

        return true;
    }
}