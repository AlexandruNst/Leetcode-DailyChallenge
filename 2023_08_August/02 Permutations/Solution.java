import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return perms(nums, 0);
    }

    private List<List<Integer>> perms(int[] nums, int n) {
        if (n == nums.length - 1) {
            List<Integer> p = new ArrayList<>();
            p.add(nums[n]);
            List<List<Integer>> res = new ArrayList<>();
            res.add(p);
            return res;
        } else {
            int num = nums[n];
            List<List<Integer>> ps = perms(nums, n + 1);
            List<List<Integer>> res = new ArrayList<>();
            for (List<Integer> p : ps) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> newPerm = new ArrayList<>(p);
                    newPerm.add(i, num);
                    res.add(newPerm);
                }
            }
            return res;
        }
    }
}