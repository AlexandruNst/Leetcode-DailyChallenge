import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return new int[0][0];
        Arrays.sort(nums);
        for (int i = 2; i < n; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new int[0][0];
            }
        }
        int[][] res = new int[n / 3][3];
        for (int i = 0; i < n / 3; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = nums[i * 3 + j];
            }
        }

        return res;
    }
}