class Solution {
    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        rec(root, 0);
        return res;
    }

    private int[] rec(TreeNode root, int numberOfNodes) {
        if (root == null)
            return new int[] { 0, 0 };

        int[] left = rec(root.left, numberOfNodes + 1);
        int[] right = rec(root.right, numberOfNodes + 1);

        int number = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + root.val;
        int avg = sum / number;

        if (root.val == avg)
            res++;

        return new int[] { number, sum };
    }

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