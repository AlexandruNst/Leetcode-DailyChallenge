import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        while (!freq.isEmpty()) {
            char c = '0';
            int max = 0;
            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                if (entry.getValue() > max) {
                    c = entry.getKey();
                    max = entry.getValue();
                }
            }
            for (int i = 0; i < max; i++) {
                res.append(c);
            }
            freq.remove(c);
        }

        return res.toString();
    }
}