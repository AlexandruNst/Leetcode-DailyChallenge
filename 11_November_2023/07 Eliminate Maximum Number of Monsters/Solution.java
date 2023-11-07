import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] steps = new int[n];
        for (int i = 0; i < n; i++)
            steps[i] = (dist[i] + speed[i] - 1) / speed[i]; // this is integer division round up instead of down

        Arrays.sort(steps);
        int round = 1;
        int res = 0;
        for (int step : steps) {
            if (step >= round) {
                res++;
                round++;
            } else {
                break;
            }
        }

        return res;
    }
}