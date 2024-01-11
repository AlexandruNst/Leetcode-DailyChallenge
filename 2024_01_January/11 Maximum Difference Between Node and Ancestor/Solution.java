import Structures.TreeNode;

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(diff(root.left, root.val, root.val), diff(root.right, root.val, root.val));
    }

    private int diff(TreeNode root, int min, int max) {
        if (root == null)
            return max - min;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return Math.max(diff(root.left, min, max), diff(root.right, min, max));
    }
}