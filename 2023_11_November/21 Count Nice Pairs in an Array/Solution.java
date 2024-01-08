import java.util.*;

class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();

        for (int num : nums) {
            map.put(num - rev(num), map.getOrDefault(num - rev(num), (long) 0) + 1);
        }

        long ans = 0;

        for (long v : map.values()) {
            ans += (v * (v - 1)) / 2;
        }

        return (int) (ans % 1000000007);
    }

    private int rev(int n) {
        int rev = 0;
        int rem;

        while (n > 0) {
            rem = n % 10;
            rev = (rev * 10) + rem;
            n = n / 10;
        }

        return rev;
    }
}