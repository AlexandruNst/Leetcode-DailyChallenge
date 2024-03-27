class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int l = 0;
        int prod = 1;
        for(int r = 0; r < nums.length; r++){
            prod *= nums[r];
            while(prod >= k && l <= r) prod /= nums[l++];
            res += (r - l + 1);
        }

        return res;
    }
}