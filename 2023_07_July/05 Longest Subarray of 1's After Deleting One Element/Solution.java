import java.util.*;

class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> ones = new ArrayList<>();
        int onesLength = 0;
        for (int num : nums) {
            if (num == 1)
                onesLength++;
            else {
                ones.add(onesLength);
                if (onesLength != 0) {
                    onesLength = 0;
                }
            }
        }

        if (onesLength != 0)
            ones.add(onesLength);

        if (ones.size() == 0)
            return 0;
        if (ones.size() == 1)
            return ones.get(0) - 1;

        int max = 0;
        for (int i = 0; i < ones.size() - 1; i++) {
            max = Math.max(max, ones.get(i) + ones.get(i + 1));
        }
        return max;
    }
}