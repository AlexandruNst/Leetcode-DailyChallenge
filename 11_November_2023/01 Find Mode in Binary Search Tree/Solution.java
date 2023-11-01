import java.util.*;

class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        calcFreq(root, freq);

        int max = 0;
        for (int i : freq.values())
            max = Math.max(max, i);

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max)
                modes.add(entry.getKey());
        }

        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }

        return res;
    }

    private void calcFreq(TreeNode root, Map<Integer, Integer> freq) {
        if (root != null) {
            freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
            calcFreq(root.left, freq);
            calcFreq(root.right, freq);
        }
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