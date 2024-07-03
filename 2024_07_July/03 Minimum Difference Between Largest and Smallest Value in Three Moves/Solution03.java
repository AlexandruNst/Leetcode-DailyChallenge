import java.util.Arrays;

class Solution03 {
    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;

        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[nums.length - 1 - i] - nums[3 - i]);
        }

        return res;
    }
}