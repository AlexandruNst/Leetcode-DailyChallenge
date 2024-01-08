class Solution {
    public int countHomogenous(String s) {
        long streak = 1;
        long res = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                res += streak;
                streak++;
            } else {
                res += streak;
                streak = 1;
            }
        }
        res += streak;
        return (int) (res % 1000000007);
    }
}