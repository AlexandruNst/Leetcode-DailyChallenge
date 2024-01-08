class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersRec(root, 0);
    }

    private int sumNumbersRec(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        } else if (isLeaf(root)) {
            sum += root.val;
            return sum;
        } else {
            sum += root.val;
            sum *= 10;
            return sumNumbersRec(root.left, sum) + sumNumbersRec(root.right, sum);
        }

    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
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