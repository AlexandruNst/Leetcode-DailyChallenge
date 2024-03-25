class Solution {
    public int findDuplicate(int[] nums) {
        for(int n : nums){
            int pos = Math.abs(n) - 1;
            if(nums[pos] < 0) return pos + 1;
            else nums[pos] = -nums[pos];
        }

        return -1;
    }
}