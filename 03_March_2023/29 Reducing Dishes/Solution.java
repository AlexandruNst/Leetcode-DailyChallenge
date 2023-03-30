import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int agg = 0;
        int answer = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            agg += satisfaction[i];
            if (agg < 0)
                break; // no point continuing, from this point on, answer will only decrease
            answer += agg;
        }

        return answer;
    }
}