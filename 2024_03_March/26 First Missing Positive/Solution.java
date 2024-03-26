class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0) nums[i] = 0;
        }

        for(int n : nums){
            int pos = Math.abs(n) - 1;
            if(pos  >= 0 && pos <= nums.length - 1){
                if(nums[pos] > 0) nums[pos] = -nums[pos];
                else if(nums[pos] == 0) nums[pos] = -(nums.length + 1);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0) return i + 1;
        }

        return nums.length + 1;
    }
}