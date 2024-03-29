import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int curr = 0;
        int min = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                curr++;
            res += curr;
        }

        return res;
    }
}