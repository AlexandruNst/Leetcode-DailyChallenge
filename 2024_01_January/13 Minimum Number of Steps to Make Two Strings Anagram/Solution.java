import java.util.*;

class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqS.put(c, freqS.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (char c : t.toCharArray()) {
            if (!freqS.containsKey(c) || freqS.get(c) == 0)
                res++;
            else
                freqS.put(c, freqS.get(c) - 1);
        }

        return res;
    }
}