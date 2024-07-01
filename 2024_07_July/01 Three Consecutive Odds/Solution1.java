class Solution1 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odds = 0;
        for (int num : arr) {
            if (num % 2 != 0)
                odds++;
            else
                odds = 0;
            if (odds == 3)
                return true;
        }
        return false;
    }
}