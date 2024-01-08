import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1)
            return new TreeNode(inorder[0]);
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = buildTreeRec(inorderMap, 0, inorder.length, postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTreeRec(Map<Integer, Integer> inorderMap, int inorderStart, int inorderEnd, int[] postorder,
            int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int rootInorderPos = inorderMap.get(root.val);
        int nodesInLeftSubtree = rootInorderPos - inorderStart;
        root.left = buildTreeRec(inorderMap, inorderStart, rootInorderPos, postorder, postorderStart,
                postorderStart + nodesInLeftSubtree - 1);
        root.right = buildTreeRec(inorderMap, rootInorderPos + 1, inorderEnd, postorder,
                postorderStart + nodesInLeftSubtree, postorderEnd - 1);

        return root;
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