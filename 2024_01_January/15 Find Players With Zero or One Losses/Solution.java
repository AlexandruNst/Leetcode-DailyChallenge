import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap<>();
        List<Integer> neverLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        for (int[] match : matches) {
            losses.put(match[0], losses.getOrDefault(match[0], 0));
            losses.put(match[1], losses.getOrDefault(match[1], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : losses.entrySet()) {
            if (entry.getValue() == 0)
                neverLost.add(entry.getKey());
            if (entry.getValue() == 1)
                lostOnce.add(entry.getKey());
        }

        Collections.sort(neverLost);
        Collections.sort(lostOnce);

        return new ArrayList<>(Arrays.asList(neverLost, lostOnce));
    }
}