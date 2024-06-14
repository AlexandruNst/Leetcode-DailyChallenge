import java.util.Arrays;

class Solution14 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int min = 0;
        for (int n : nums) {
            if (n > min)
                min = n;
            else
                res += min - n;
            min++;
        }
        return res;
    }
}