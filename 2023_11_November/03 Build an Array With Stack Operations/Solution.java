import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;
        if (target[index] > 1) {
            for (int i = 0; i < target[0] - 1; i++) {
                res.add("Push");
                res.add("Pop");
            }
        }

        res.add("Push");

        while (index < target.length - 1) {
            if (target[index + 1] - target[index] > 1) {
                for (int i = 0; i < target[index + 1] - target[index] - 1; i++) {
                    res.add("Push");
                    res.add("Pop");
                }
            }

            res.add("Push");

            index++;
        }

        return res;
    }
}