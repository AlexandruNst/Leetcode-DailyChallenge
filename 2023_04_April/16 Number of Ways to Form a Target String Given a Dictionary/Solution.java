class Solution {
    public int numWays(String[] words, String target) {
        long[][] dp = new long[words[0].length()][target.length()];
        boolean[][] dpVisited = new boolean[words[0].length()][target.length()];

        return (int) (rec(dp, dpVisited, words, target, 0, 0) % 1000000007);
    }

    private long rec(long[][] dp, boolean[][] dpVisited, String[] words, String target, int index, int targetIndex) {
        if (targetIndex == target.length())
            return 1;
        if (target.length() - targetIndex > words[0].length() - index)
            return 0;
        if (dpVisited[index][targetIndex])
            return dp[index][targetIndex];

        dpVisited[index][targetIndex] = true;

        for (String word : words) {
            if (word.charAt(index) == target.charAt(targetIndex)) {
                dp[index][targetIndex] += rec(dp, dpVisited, words, target, index + 1, targetIndex + 1) % 1000000007;
            }
        }
        dp[index][targetIndex] += rec(dp, dpVisited, words, target, index + 1, targetIndex) % 1000000007;

        return dp[index][targetIndex];
    }
}

// Approach

// We store a dp 2D array where each element [i, j] corresponds to how many
// solutions we've found where we look at current index i of a word in the
// dictionary and we've matched j characters from target.

// We then recursively loop over the words and each time we find a matching
// character at index index in words and targetIndex in target, we recursively
// call for index + 1 and targetIndex + 1. After that, we also call for index
// and targetIndex + 1 outside the for loop, for the case where at position
// index in words, none of the characters match the current character in target.

// Base cases are:

// when targetIndex reached the length of target i.e. we matched all characters
// of target, we return 1
// when the amount of characters left in target is grater than the amount of
// indexes left to check in words, we return 0
// when we have visited the problem before, hence return the dp solution of the
// subproblem

// Also, make sure to add % 10^9 + 7 for each modification of the dp array, and
// also make the dp array long to avoid overflows. Also make sure to cast the
// result back to int.