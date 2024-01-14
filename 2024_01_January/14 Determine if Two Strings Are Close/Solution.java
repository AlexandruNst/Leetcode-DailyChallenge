import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] w1 = new int[26];
        int[] w2 = new int[26];
        Set<Character> set = new HashSet<>();

        for (char c : word1.toCharArray()) {
            w1[c - 'a']++;
            set.add(c);
        }
        for (char c : word2.toCharArray()) {
            w2[c - 'a']++;
            set.remove(c);
        }

        Arrays.sort(w1);
        Arrays.sort(w2);

        return Arrays.equals(w1, w2) && set.isEmpty();
    }
}