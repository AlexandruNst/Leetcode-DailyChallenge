import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int n = nums.length;

        int l = 0;
        int r = 0;
        int res = 0;

        for (; r < n; r++) {
            while (!max.isEmpty() && max.peekLast() < nums[r])
                max.pollLast();
            while (!min.isEmpty() && min.peekLast() > nums[r])
                min.pollLast();
            max.offerLast(nums[r]);
            min.offerLast(nums[r]);

            while (max.peek() - min.peek() > limit && l <= r) {
                if (nums[l] == max.peek())
                    max.poll();
                if (nums[l] == min.peek())
                    min.poll();
                l++;
            }

            res = Math.max(res, r - l + 1);

        }

        return res;

    }
}