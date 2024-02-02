import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int lowN = String.valueOf(low).length();
        int highN = String.valueOf(high).length();
        List<Integer> res = new ArrayList<>();

        String longNum = "123456789";
        for (int n = lowN; n <= highN; n++) {
            int left = 0;
            int right = n;
            while (right <= longNum.length()) {
                int num = Integer.valueOf(longNum.substring(left, right));
                if (num > high)
                    return res;
                if (num >= low) {
                    res.add(num);
                }
                left++;
                right++;
            }
        }

        return res;
    }
}