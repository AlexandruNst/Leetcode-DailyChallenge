import java.util.*;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 1;
        for (int elem : arr) {
            int newLen = dp.getOrDefault(elem - difference, 0) + 1;
            dp.put(elem, newLen);
            max = Math.max(max, newLen);
        }

        return max;
    }
}