import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;

        boolean answer;
        // RECURSIVE SOLUTION
        answer = isSymmetricHelperRec(root.left, root.right);

        // ITERATIVE SOLUTION
        answer = isSymmetricHelperItr(root);

        return answer;
    }

    private boolean isSymmetricHelperRec(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true; // if both null, then it's symmetrical
        else if (left == null || right == null)
            return false; // if only one is null, not symmetrical
        else if (left.val != right.val)
            return false; // if both are not null but have different vals, not symmetrical
        return isSymmetricHelperRec(left.left, right.right) && isSymmetricHelperRec(left.right, right.left);
    }

    private boolean isSymmetricHelperItr(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null)
                continue; // if both null, continue
            else if (left == null || right == null)
                return false; // if only one is null, not symmetrical
            else if (left.val != right.val)
                return false; // if both are not null but have different vals, not symmetrical

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}