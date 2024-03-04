import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int res = 0;
        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l++];
                score++;
                res = Math.max(res, score);
            } else if (score > 0) {
                score--;
                power += tokens[r--];
            } else
                break;
        }
        return res;
    }
}