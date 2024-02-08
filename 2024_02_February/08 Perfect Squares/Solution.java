import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int i = 1;
        while (i * i <= n) {
            int sq = i * i;
            for (int j = sq; j <= n; j++) {
                dp[j] = Math.min(dp[j - sq] + 1, dp[j]);
            }
            i++;
        }
        return dp[n];
    }
}