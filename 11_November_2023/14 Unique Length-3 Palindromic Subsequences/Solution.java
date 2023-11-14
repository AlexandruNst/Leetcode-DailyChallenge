import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> done = new HashSet<>();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (!done.contains(chars[i])) {
                int last = 0;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        last = j;
                    }
                }
                if (last != 0) {
                    Set<Character> set = new HashSet<>();
                    for (int k = i + 1; k < last; k++) {
                        set.add(chars[k]);
                    }
                    res += set.size();
                    done.add(chars[i]);
                }
            }
        }

        return res;
    }
}