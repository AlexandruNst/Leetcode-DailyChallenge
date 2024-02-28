import java.util.LinkedList;
import java.util.Queue;

import Structures.TreeNode;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int queueSize = 1;
        int leftmost = -1;
        while (!q.isEmpty()) {
            leftmost = q.peek().val;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            queueSize = q.size();
        }

        return leftmost;
    }
}