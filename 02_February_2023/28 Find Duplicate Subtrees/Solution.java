import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<String> visited = new HashSet<>();
        Map<String, TreeNode> map = new HashMap<>();
        List<TreeNode> answer = new ArrayList<>();
        traversal(root, visited, map);
        for (TreeNode node : map.values()) {
            answer.add(node);
        }

        return answer;
    }

    private String traversal(TreeNode root, Set<String> visited, Map<String, TreeNode> map) {
        StringBuilder sb = new StringBuilder();

        if (root == null)
            return "X"; // X for null

        String left = traversal(root.left, visited, map);
        String right = traversal(root.right, visited, map);

        sb.append(root.val);
        sb.append(",");
        sb.append(left);
        sb.append(",");
        sb.append(right);
        sb.append(",");

        String subTree = sb.toString();
        if (visited.contains(subTree)) {
            map.put(subTree, root);
        } else {
            visited.add(subTree);
        }

        return subTree;
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