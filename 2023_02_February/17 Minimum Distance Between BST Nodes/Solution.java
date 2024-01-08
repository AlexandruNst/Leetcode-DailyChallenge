class Solution {
    int answer = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return answer;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);

        if (prev != null) {
            answer = Math.min(answer, root.val - prev.val);
        }
        prev = root;

        inOrder(root.right);
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