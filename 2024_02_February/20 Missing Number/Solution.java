class Solution {
    public int missingNumber(int[] nums) {

        // Sane people's version

        // Arrays.sort(nums);
        // if(nums[0] != 0) return 0;
        // for(int i = 0; i < nums.length - 1; i++){
        //     if(nums[i + 1] != nums[i] + 1) return nums[i] + 1;
        // }
        // return nums.length;

        // Leetcode people's version

        int actualSum = 0;
        for(int num : nums) actualSum += num;
        int sum = nums.length * (nums.length + 1) / 2;
        return sum - actualSum;
    }
}