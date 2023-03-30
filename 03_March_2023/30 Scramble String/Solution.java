import java.util.*;

class Solution {
    Map<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int n = s1.length(); // necessary to not have TLE
        // sanity checks
        if (n != s2.length())
            return false;
        if (s1.equals(s2))
            return true;

        // base case
        if (n == 1)
            return false;

        // meat
        String key = s1 + " " + s2;
        if (dp.containsKey(key))
            return dp.get(key);

        for (int i = 1; i < n; i++) {
            boolean withoutSwap = isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i));
            if (withoutSwap) {
                dp.put(key, true);
                return true;
            }

            boolean withSwap = isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i));

            if (withSwap) {
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;

    }
}
