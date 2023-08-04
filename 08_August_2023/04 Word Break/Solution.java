import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        dp[dp.length - 1] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                String subString = s.substring(i, Math.min(i + word.length(), s.length()));
                if (subString.equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }
}