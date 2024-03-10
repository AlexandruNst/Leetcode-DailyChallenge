import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1)
            set.add(n);
        Set<Integer> resSet = new HashSet<>();
        for (int n : nums2)
            if (set.contains(n))
                resSet.add(n);
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int n : resSet)
            res[i++] = n;
        return res;
    }
}