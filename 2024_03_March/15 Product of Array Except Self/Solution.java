class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroes = 0;
        for (int n : nums) {
            if (n != 0)
                prod *= n;
            else
                zeroes++;
        }

        int[] res = new int[nums.length]; // this is initialised as all 0's
        if (zeroes == 0) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = prod / nums[i];
            }
        } else if (zeroes == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0)
                    res[i] = 0;
                else
                    res[i] = prod;
            }
        }
        return res;
    }
}