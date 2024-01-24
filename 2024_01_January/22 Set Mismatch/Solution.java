import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int repeating = 0;
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                repeating = nums[i];
            actualSum += nums[i];
        }
        actualSum += nums[nums.length - 1];

        int missing = expectedSum + repeating - actualSum;

        return new int[] { repeating, missing };
    }
}