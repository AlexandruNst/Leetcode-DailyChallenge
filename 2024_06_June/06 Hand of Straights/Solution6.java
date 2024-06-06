import java.util.*;

class Solution6 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int c : hand)
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        List<Integer> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique);

        for (int c : unique) {
            while (freq.get(c) > 0) {
                for (int i = 1; i < groupSize; i++) {
                    if (freq.containsKey(c + i) && freq.get(c + i) > 0)
                        freq.put(c + i, freq.get(c + i) - 1);
                    else
                        return false;
                }
                freq.put(c, freq.get(c) - 1);
            }
        }

        return true;
    }
}