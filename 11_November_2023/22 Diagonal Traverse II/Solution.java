import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, Stack<Integer>> diagonals = new HashMap<>();
        int n = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int diag = i + j;
                Stack<Integer> stack = diagonals.getOrDefault(diag, new Stack<>());
                stack.push(nums.get(i).get(j));
                diagonals.put(diag, stack);
                n++;
            }
        }

        int[] ans = new int[n];
        int index = 0;

        for (int i = 0; i < diagonals.keySet().size(); i++) {
            Stack<Integer> stack = diagonals.get(i);
            while (!stack.isEmpty())
                ans[index++] = stack.pop();
        }

        return ans;
    }
}