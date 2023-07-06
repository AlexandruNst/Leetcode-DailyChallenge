class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end++];

            while (sum >= target) {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }

        if (min == Integer.MAX_VALUE)
            return 0;
        else
            return min;
    }
}