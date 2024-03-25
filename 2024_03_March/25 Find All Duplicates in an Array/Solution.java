import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            int pos = Math.abs(n) - 1;
            if (nums[pos] < 0)
                res.add(pos + 1);
            else
                nums[pos] = -nums[pos];
        }

        return res;
    }
}