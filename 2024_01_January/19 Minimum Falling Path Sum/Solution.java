class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        boolean[][] dpDone = new boolean[n][n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, rec(matrix, 0, i, dp, dpDone));
        }

        return res;
    }

    private int rec(int[][] matrix, int r, int c, int[][] dp, boolean[][] dpDone) {
        if (dpDone[r][c])
            return dp[r][c];
        if (r == matrix.length - 1)
            return matrix[r][c];
        int left = Integer.MAX_VALUE;
        int below = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (c - 1 >= 0)
            left = rec(matrix, r + 1, c - 1, dp, dpDone);
        below = rec(matrix, r + 1, c, dp, dpDone);
        if (c + 1 < matrix[0].length)
            right = rec(matrix, r + 1, c + 1, dp, dpDone);
        dp[r][c] = matrix[r][c] + Math.min(Math.min(left, below), right);
        dpDone[r][c] = true;
        return dp[r][c];
    }
}