import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long total = 0;
        if (k == costs.length) {
            for (int c : costs)
                total += c;
            return total;
        }

        if (2 * candidates >= costs.length) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++)
                total += costs[i];
            return total;
        }
        int chosen = 0;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++)
            left.add(costs[i]);
        for (int i = 0; i < candidates; i++)
            right.add(costs[costs.length - i - 1]);
        int indexLeft = candidates;
        int indexRight = costs.length - candidates - 1;

        while (chosen < k) {
            if (2 * candidates == costs.length - chosen) {
                for (int i = 0; i < k - chosen; i++) {
                    if (left.isEmpty()) {
                        total += right.poll();
                        continue;
                    }
                    if (right.isEmpty()) {
                        total += left.poll();
                        continue;
                    }
                    if (left.peek() <= right.peek()) {
                        total += left.poll();
                    } else {
                        total += right.poll();
                    }
                }
                return total;
            } else {
                if (left.peek() <= right.peek()) {
                    total += left.poll();
                    left.add(costs[indexLeft++]);
                } else {
                    total += right.poll();
                    right.add(costs[indexRight--]);
                }
                chosen++;
            }
        }
        return total;
    }
}