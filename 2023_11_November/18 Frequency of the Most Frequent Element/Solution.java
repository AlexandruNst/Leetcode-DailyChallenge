import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int curr = 0;
        int res = 0;
        int left = 0;

        for (int right = 1; right < nums.length; right++) {
            curr += (nums[right] - nums[right - 1]) * right;

            while (curr > k) {
                curr -= (nums[left + 1] - nums[left]) * (left + 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}