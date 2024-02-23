class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n];
        int[] trusted = new int[n];

        for (int[] t : trust) {
            trusts[t[0] - 1]++;
            trusted[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (trusts[i] == 0 && trusted[i] == n - 1)
                return i + 1;
        }

        return -1;
    }
}