class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    }

    private int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        return lcsRec(s1, s2, dp, 0, 0);
    }

    private int lcsRec(String s1, String s2, int[][] dp, int i, int j) {
        if (i >= dp.length || j >= dp[0].length)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            dp[i][j] = 1 + lcsRec(s1, s2, dp, i + 1, j + 1);
        else
            dp[i][j] = Math.max(lcsRec(s1, s2, dp, i, j + 1), lcsRec(s1, s2, dp, i + 1, j));
        return dp[i][j];
    }
}