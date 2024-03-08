import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        int maxFreq = 0;
        for (int f : freq.values())
            if (f > maxFreq)
                maxFreq = f;

        int res = 0;
        for (int f : freq.values())
            if (f == maxFreq)
                res += f;

        return res;
    }
}