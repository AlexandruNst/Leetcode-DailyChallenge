class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 1; i < nums.length; i++)
            sum += nums[i] - nums[0];
        result[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            sum -= (nums[i] - nums[i - 1]) * (nums.length - 1 - i);
            sum += (nums[i] - nums[i - 1]) * (i - 1);
            result[i] = sum;
        }

        return result;
    }
}