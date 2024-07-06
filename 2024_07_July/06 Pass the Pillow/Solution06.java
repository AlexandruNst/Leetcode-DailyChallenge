class Solution06 {
    public int passThePillow(int n, int time) {
        int mod = time % (n - 1);
        int div = time / (n - 1);

        if (div % 2 == 0) {
            return 1 + mod;
        } else {
            return n - mod;
        }
    }
}