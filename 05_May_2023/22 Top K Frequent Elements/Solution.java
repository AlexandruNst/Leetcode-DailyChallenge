import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int freq = entry.getValue();
            Pair<Integer, Integer> pair = new Pair<>(val, freq);

            pq.add(pair);
            if (pq.size() > k)
                pq.remove();
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.remove();
            res[i++] = pair.getKey();
        }

        return res;
    }

    public class Pair<T1, T2> {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        int getKey() {
            return this.val;
        }

        int getValue() {
            return this.freq;
        }
    }

}