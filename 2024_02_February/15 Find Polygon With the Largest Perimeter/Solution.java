import java.util.*;

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int longSideI = nums.length - 1;
        while (longSideI > 1) {
            long head = nums[longSideI];
            long tail = 0;
            for (int i = 0; i < longSideI; i++) {
                tail += nums[i];
            }
            if (head - tail < 0)
                return head + tail;
            else
                longSideI--;
        }

        return -1;
    }
}