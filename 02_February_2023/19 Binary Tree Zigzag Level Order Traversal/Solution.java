import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> answer = new ArrayList<>();
        Stack<TreeNode> stackLeftToRight = new Stack<>();
        Stack<TreeNode> stackRightToLeft = new Stack<>();
        boolean leftToRight = true;
        stackLeftToRight.push(root);

        while (!stackLeftToRight.isEmpty() || !stackRightToLeft.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            if (leftToRight) {
                while (!stackLeftToRight.isEmpty()) {
                    TreeNode node = stackLeftToRight.pop();
                    row.add(node.val);
                    if (node.left != null)
                        stackRightToLeft.push(node.left);
                    if (node.right != null)
                        stackRightToLeft.push(node.right);
                }
            } else {
                while (!stackRightToLeft.isEmpty()) {
                    TreeNode node = stackRightToLeft.pop();
                    row.add(node.val);
                    if (node.right != null)
                        stackLeftToRight.push(node.right);
                    if (node.left != null)
                        stackLeftToRight.push(node.left);
                }
            }
            answer.add(row);
            leftToRight = !leftToRight;
        }

        return answer;
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