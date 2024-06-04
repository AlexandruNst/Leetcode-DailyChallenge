import java.util.HashMap;
import java.util.Map;

class Solution4 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int length = 0;

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int oddAdded = 0;
        for (int val : freq.values()) {
            if (val % 2 == 0)
                length += val;
            else {
                length += val - 1;
                oddAdded = 1;
            }
        }

        return length + oddAdded;
    }
}