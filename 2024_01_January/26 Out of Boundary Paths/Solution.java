class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        long res = rec(m, n, startRow, startColumn, dp, maxMove);
        return (int) (res % 1000000007);
    }

    private long rec(int m, int n, int r, int c, long[][][] dp, int moves) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return 1;
        if (moves <= 0)
            return 0;
        if (moves <= r && moves <= c && r + moves < m && c + moves < n)
            return 0;
        if (dp[r][c][moves] != 0)
            return dp[r][c][moves];
        dp[r][c][moves] = (rec(m, n, r - 1, c, dp, moves - 1) % 1000000007 +
                rec(m, n, r + 1, c, dp, moves - 1) % 1000000007 +
                rec(m, n, r, c - 1, dp, moves - 1) % 1000000007 +
                rec(m, n, r, c + 1, dp, moves - 1) % 1000000007);
        return dp[r][c][moves];
    }
}