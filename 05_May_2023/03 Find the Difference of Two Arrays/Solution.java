import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = setify(nums1);
        Set<Integer> set2 = setify(nums2);

        List<Integer> nums1NotInNums2 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num))
                nums1NotInNums2.add(num);
        }

        List<Integer> nums2NotInNums1 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num))
                nums2NotInNums1.add(num);
        }

        List<List<Integer>> res = new ArrayList<>(2);
        res.add(nums1NotInNums2);
        res.add(nums2NotInNums1);

        return res;
    }

    private Set<Integer> setify(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return set;
    }
}