import java.util.*;

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        return backtrack(n, dp);
    }

    private List<TreeNode> backtrack(int n, Map<Integer, List<TreeNode>> dp) {
        if (n == 0)
            return new ArrayList<>();
        if (n == 1) {
            List<TreeNode> l = new ArrayList<>();
            l.add(new TreeNode(0));
            return l;
        }
        if (dp.containsKey(n))
            return dp.get(n);

        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n - l - 1;
            List<TreeNode> leftTrees = backtrack(l, dp);
            List<TreeNode> rightTrees = backtrack(r, dp);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    res.add(new TreeNode(0, leftTree, rightTree));
                }
            }
        }

        dp.put(n, res);
        return res;
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