import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            int elem = nums[r];
            freq.put(elem, freq.getOrDefault(elem, 0) + 1);
            while (freq.get(elem) > k && l <= r) {
                freq.put(nums[l], freq.getOrDefault(nums[l], 0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}