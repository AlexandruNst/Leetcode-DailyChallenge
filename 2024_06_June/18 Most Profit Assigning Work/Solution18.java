import java.util.Comparator;
import java.util.PriorityQueue;

class Solution18 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparing(j -> -j.profit));
        PriorityQueue<Integer> wpq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int w : worker)
            wpq.add(w);

        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= wpq.peek())
                pq.add(new Job(difficulty[i], profit[i]));
        }

        int res = 0;
        int k = 0;
        while (!pq.isEmpty() && k < worker.length) {
            Job j = pq.poll();
            int d = j.difficulty;
            int p = j.profit;
            while (!wpq.isEmpty() && wpq.peek() >= d) {
                wpq.poll();
                k++;
                res += p;
            }
        }

        return res;
    }

    class Job {
        int difficulty, profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}