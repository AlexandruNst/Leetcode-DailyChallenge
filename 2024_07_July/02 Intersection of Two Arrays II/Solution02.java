import java.util.*;

class Solution02 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                intersection.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = intersection.get(i);
        return res;
    }
}