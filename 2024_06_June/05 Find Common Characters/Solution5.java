import java.util.*;

class Solution5 {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> freqWord = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                freqWord.put(c, freqWord.getOrDefault(c, 0) + 1);
            }

            Set<Character> toBeRemoved = new HashSet<>();
            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                char c = entry.getKey();
                int v = entry.getValue();
                if (!freqWord.containsKey(c))
                    toBeRemoved.add(c);
                else
                    freq.put(c, Math.min(v, freqWord.get(c)));
            }
            for (char c : toBeRemoved)
                freq.remove(c);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++)
                res.add(Character.toString(entry.getKey()));
        }

        return res;
    }
}