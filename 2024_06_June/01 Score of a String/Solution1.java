class Solution1 {
    public int scoreOfString(String s) {
        int prev = s.charAt(0);
        int score = 0;
        for (char c : s.toCharArray()) {
            score += Math.abs(c - prev);
            prev = c;
        }

        return score;
    }
}