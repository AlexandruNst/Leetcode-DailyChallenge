import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] freqs = new int[freq.size()];
        int i = 0;
        for (int f : freq.values()) {
            freqs[i++] = f;
        }

        Arrays.sort(freqs);

        i = 0;
        while (i < freqs.length && k >= 0) {
            k -= freqs[i++];
        }

        if (k < 0)
            return freq.size() - i + 1;
        else
            return freq.size() - i;
    }
}