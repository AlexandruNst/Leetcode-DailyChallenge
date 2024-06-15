import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Project> ppq = new PriorityQueue<>(Comparator.comparing(p -> p.capital));
        for (int i = 0; i < capital.length; i++) {
            ppq.offer(new Project(profits[i], capital[i]));
        }

        if (w < ppq.peek().capital)
            return 0;

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            while (!ppq.isEmpty() && ppq.peek().capital <= w)
                pq.offer(ppq.poll().profit);
            if (pq.isEmpty())
                break;
            w += pq.poll();
        }

        return w;
    }

    class Project {
        int profit, capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}