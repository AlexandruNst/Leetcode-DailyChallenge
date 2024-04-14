import Structures.TreeNode;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root.left, true) + helper(root.right, false);
    }

    private int helper(TreeNode node, boolean isLeft) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null && isLeft)
            return node.val;
        else
            return helper(node.left, true) + helper(node.right, false);
    }
}